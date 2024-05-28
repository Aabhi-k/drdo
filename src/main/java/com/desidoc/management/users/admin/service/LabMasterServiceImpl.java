package com.desidoc.management.users.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabCategory;
import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.repository.LabMasterRepository;
import com.desidoc.management.others.city.CityMaster;

@Service
public class LabMasterServiceImpl implements LabMasterService {

	@Autowired
	LabMasterRepository repository;

	// ---------- Helper Functions ----------

	// Converting DTOs to Entities
	private LabMaster convertToEntity(LabMasterDTO dto, LabMaster lab) {
		if (dto.getLabAuthName() != null && dto.getLabAuthName().equals(lab.getLabAuthName())) {
			lab.setLabAuthName(dto.getLabAuthName());
		}
		if (dto.getLabShortName() != null && dto.getLabShortName().equals(lab.getLabShortName())) {
			lab.setLabShortName(dto.getLabShortName());
		}
		if (dto.getLabFullName() != null && dto.getLabFullName().equals(lab.getLabFullName())) {
			lab.setLabFullName(dto.getLabFullName());
		}
		if (dto.getLabCatId() != null && dto.getLabCatId().equals(lab.getLabCatId())) {
			LabCategory labCategory = new LabCategory();
			labCategory.setId(dto.getLabCatId());
			lab.setLabCatId(labCategory);
		}
		if (dto.getLabCityId() != null && dto.getLabCityId().equals(lab.getLabCityId())) {
			CityMaster city = new CityMaster();
			city.setId(dto.getLabCityId());
			lab.setLabCityId(city);
		}
		if (dto.getLabClusterId() != null && dto.getLabClusterId().equals(lab.getLabClusterId())) {
			LabCluster cluster = new LabCluster();
			cluster.setId(dto.getLabClusterId());
			lab.setLabClusterId(cluster);
		}

		if (dto.getOtherGroup() != null && dto.getOtherGroup().equals(lab.getOtherGroup())) {
			lab.setOtherGroup(dto.getOtherGroup());
		}

		if (dto.getLastUpdated() != null && dto.getLastUpdated().equals(lab.getLastUpdated())) {
			lab.setLastUpdated(LocalDateTime.now());
		}
		if (dto.getDeleted() != null && dto.getDeleted().equals(lab.getDeleted())) {
			lab.setDeleted(dto.getDeleted());
		}
		if (dto.getViewingOrder() != null && dto.getViewingOrder().equals(lab.getViewingOrder())) {
			lab.setViewingOrder(dto.getViewingOrder());
		}

		return lab;
	}

	// Converting Entities to DTOs
	private LabMasterDTO convertToDTO(LabMaster lab) {
		LabMasterDTO dto = new LabMasterDTO();

		dto.setLabAuthName(lab.getLabAuthName());
		dto.setLabShortName(lab.getLabShortName());
		dto.setLabFullName(lab.getLabFullName());
		dto.setLabCatId(lab.getLabCatId().getId());
		dto.setLabCityId(lab.getLabCityId().getId());
		dto.setLabClusterId(lab.getLabClusterId().getId());
		dto.setOtherGroup(lab.getOtherGroup());
		dto.setLastUpdated(LocalDateTime.now());

		return dto;
	}

	@Override
	public List<LabMasterDTO> findAllLabMaster() {

		return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());

	}

	@Override
	public List<LabMasterDTO> searchLabMaster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabMasterDTO> findAllLabMasterByDeleted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLabMaster(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LabMaster findLabMasterById(Integer id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab not found"));
	}

	@Override
	public String createLabMaster(LabMasterDTO labMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateViewingOrder(Integer id, String order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
