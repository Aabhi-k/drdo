package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;
import com.desidoc.management.lab.repository.LabMasterRepository;
import com.desidoc.management.lab.specifications.LabMasterSpecification;
import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.users.admin.service.others.city.CityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LabMasterServiceImpl implements LabMasterService {

    @Autowired
    LabMasterRepository repository;

    @Autowired
    LabCategoryService labCategoryService;
    @Autowired
    LabClusterService labClusterService;
    @Autowired
    CityMasterService cityMasterService;

    // ---------- Helper Functions ----------

    // Converting DTOs to Entities
    private LabMaster convertToEntity(LabMasterDTO dto, LabMaster lab)  {
        if (dto.getLabAuthName() != null && !dto.getLabAuthName().equals(lab.getLabAuthName())) {
            lab.setLabAuthName(dto.getLabAuthName());
        }
        if (dto.getLabShortName() != null && !dto.getLabShortName().equals(lab.getLabShortName())) {
            lab.setLabShortName(dto.getLabShortName());
        }
        if (dto.getLabFullName() != null && !dto.getLabFullName().equals(lab.getLabFullName())) {
            lab.setLabFullName(dto.getLabFullName());
        }
        if (dto.getLabCatId() != null) {
            if (lab.getLabCatId() == null || !dto.getLabCatId().equals(lab.getLabCatId().getId())) {
                lab.setLabCatId(labCategoryService.findLabCategoryById(dto.getLabCatId()));
            }
        }
        if (dto.getLabCityId() != null) {
            if (lab.getLabCityId() == null || !dto.getLabCityId().equals(lab.getLabCityId().getId())) {

                CityMaster city = cityMasterService.findCityById(dto.getLabCityId());
                lab.setLabCityId(city);
            }
        }
        if (dto.getLabClusterId() != null) {
            if (lab.getLabClusterId() == null || !dto.getLabClusterId().equals(lab.getLabClusterId().getId())) {

                LabCluster cluster = labClusterService.findLabClusterById(dto.getLabClusterId());
                lab.setLabClusterId(cluster);
            }
        }

        if (dto.getOtherGroup() != null && !dto.getOtherGroup().equals(lab.getOtherGroup())) {
            lab.setOtherGroup(dto.getOtherGroup());
        }

        lab.setLastUpdated(LocalDateTime.now());

        if (dto.getDeleted() != null && !dto.getDeleted().equals(lab.getDeleted())) {
            lab.setDeleted(dto.getDeleted());
        }
        if (dto.getViewingOrder() != null && !dto.getViewingOrder().equals(lab.getViewingOrder())) {
            lab.setViewingOrder(dto.getViewingOrder());
        }

        return lab;
    }

    // Converting Entities to DTOs
    private LabMasterDTO convertToDTO(LabMaster lab) {
        LabMasterDTO dto = new LabMasterDTO();

        dto.setId(lab.getId());
        dto.setLabAuthName(lab.getLabAuthName());
        dto.setLabShortName(lab.getLabShortName());
        dto.setLabFullName(lab.getLabFullName());
        dto.setLabCatId(lab.getLabCatId().getId());
        dto.setLabCityId(lab.getLabCityId().getId());
        dto.setLabClusterId(lab.getLabClusterId().getId());
        dto.setOtherGroup(lab.getOtherGroup());
        dto.setLastUpdated(lab.getLastUpdated());

        return dto;
    }

    // Convert DTO to Projection
    private LabMasterProjection convertToProjection(LabMasterDTO dto) {
        return new LabMasterProjection() {

            @Override
            public Integer getId() {
                return dto.getId();
            }

            @Override
            public String getLabAuthName() {
                return dto.getLabAuthName();
            }

            @Override
            public String getLabShortName() {
                return dto.getLabShortName();
            }

            @Override
            public String getLabFullName() {
                return dto.getLabFullName();
            }

            @Override
            public String getCatFullName() {
                return labCategoryService.findLabCategoryById(dto.getLabCatId()).getCatFullName();
            }

            @Override
            public String getClusterFullName() {
                return labClusterService.findLabClusterById(dto.getLabClusterId()).getClusterFullName();
            }

            @Override
            public String getCityFullName() {
                return cityMasterService.findCityById(dto.getLabCityId()).getCityFullName();
            }

            @Override
            public String getOtherGroup() {
                return dto.getOtherGroup();
            }

        };
    }

    // -------- Find Methods ---------------------------
    // finding by id
    @Override
    public LabMaster findLabMasterById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab not found"));
    }

    @Override
    public Page<LabMasterProjection> findAllLabMaster(Map<String, String> filters, Pageable page) {
        Specification<LabMaster> sp = LabMasterSpecification.getAllLabMaster(filters);
        return repository.findAll(sp, page).map(this::convertToDTO).map(this::convertToProjection);
    }

    @Override
    public List<LabMasterDTO> findAllLabMasterByDeleted() {
        return repository.findAllByDeleted("0").stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // -------- Search Methods ---------------------------
    @Override
    public Page<LabMasterProjection> searchLabMaster(String search, Map<String, String> filters, Pageable page) {
        Specification<LabMaster> sp = LabMasterSpecification.searchLabMaster(search, filters);
        return repository.findAll(sp, page).map(this::convertToDTO).map(this::convertToProjection);
    }

    // -------- Update Methods --------------------
    @Override
    public String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception {
        LabMaster lab = this.findLabMasterById(id);
        repository.save(this.convertToEntity(labMaster, lab));
        return "updated lab";
    }

    @Override
    public String updateViewingOrder(Integer id, Integer order) throws Exception {
        LabMaster lab = this.findLabMasterById(id);
        lab.setViewingOrder(order);
        repository.save(lab);
        return "updated order";
    }

    // -------- Create Methods --------------------
    @Override
    public Integer createLabMaster(LabMasterDTO labMaster) {
        LabMaster lab = new LabMaster();
        repository.save(this.convertToEntity(labMaster, lab));
        return lab.getId();
    }

    // -------- Delete Method ---------------------------

    @Override
    public String deleteLabMaster(Integer id) throws Exception {
        LabMaster lab = this.findLabMasterById(id);
        lab.setDeleted("1");
        repository.save(lab);
        return "deleted lab";
    }

}
