package com.desidoc.management.users.admin.service.dropdown;

import com.desidoc.management.employee.repository.EmpDesignationRepository;
import com.desidoc.management.employee.repository.EmpRoleRepository;
import com.desidoc.management.employee.specifications.EmpDesignationSpecification;
import com.desidoc.management.employee.specifications.EmpRoleSpecification;
import com.desidoc.management.lab.repository.LabCategoryRepository;
import com.desidoc.management.lab.repository.LabClusterRepository;
import com.desidoc.management.lab.repository.LabMasterRepository;
import com.desidoc.management.lab.specifications.LabCategorySpecification;
import com.desidoc.management.lab.specifications.LabClusterSpecification;
import com.desidoc.management.lab.specifications.LabMasterSpecification;
import com.desidoc.management.others.city.CityMasterRepository;
import com.desidoc.management.others.city.ZipcodeMasterRepository;
import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.others.specification.CityMasterSpecification;
import com.desidoc.management.others.specification.ZipcodeMasterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DropdownServiceImpl implements DropdownService {

    private LabMasterRepository labMasterRepository;
    private LabCategoryRepository labCategoryRepository;
    private LabClusterRepository labClusterRepository;
    private CityMasterRepository cityMasterRepository;
    private EmpDesignationRepository empDesignationRepository;
    private EmpRoleRepository empRoleRepository;
    private ZipcodeMasterRepository zipcodeRepository;

    @Autowired
    public DropdownServiceImpl(LabMasterRepository labMasterRepository, LabCategoryRepository labCategoryRepository,
                               LabClusterRepository labClusterRepository, CityMasterRepository cityMasterRepository,
                               EmpDesignationRepository empDesignationRepository, EmpRoleRepository empRoleRepository, ZipcodeMasterRepository zipcodeRepository) {
        super();
        this.labMasterRepository = labMasterRepository;
        this.labCategoryRepository = labCategoryRepository;
        this.labClusterRepository = labClusterRepository;
        this.cityMasterRepository = cityMasterRepository;
        this.empDesignationRepository = empDesignationRepository;
        this.empRoleRepository = empRoleRepository;
        this.zipcodeRepository = zipcodeRepository;
    }

    @Override
    public Page<DropdownProjection> searchLabMaster(String query, Pageable pageable) {
        return labMasterRepository
                .findAll(LabMasterSpecification.searchLabMaster(query), pageable)
                .map(lab -> new DropdownProjection() {
                    @Override
                    public Integer getId() {
                        return lab.getId();
                    }

                    @Override
                    public String getName() {
                        return lab.getLabFullName();
                    }
                });
    }

    @Override
    public Page<DropdownProjection> searchLabCategory(String query, Pageable pageable) {
        return labCategoryRepository
                .findAll(LabCategorySpecification.seachLabCategory(query), pageable)
                .map(category -> new DropdownProjection() {

                    @Override
                    public Integer getId() {
                        return category.getId();
                    }

                    @Override
                    public String getName() {
                        return category.getCatFullName();
                    }

                });
    }

    @Override
    public Page<DropdownProjection> searchLabCluster(String query, Pageable pageable) {
        return labClusterRepository
                .findAll(LabClusterSpecification.searchLabCluster(query), pageable)
                .map(cluster -> new DropdownProjection() {

                    @Override
                    public Integer getId() {
                        return cluster.getId();
                    }

                    @Override
                    public String getName() {
                        return cluster.getClusterFullName();
                    }
                });
    }

    @Override
    public Page<DropdownProjection> searchCity(String query, Pageable pageable) {
        return cityMasterRepository
                .findAll(CityMasterSpecification.searchCityMaster(query), pageable)
                .map(city -> new DropdownProjection() {

                    @Override
                    public Integer getId() {
                        return city.getId();
                    }

                    @Override
                    public String getName() {
                        return city.getCityFullName();
                    }

                });
    }

    @Override
    public Page<DropdownProjection> searchEmpDesignation(String query, Pageable pageable) {
        return empDesignationRepository.findAll(EmpDesignationSpecification.searchEmpDesignation(query), pageable)
                .map(designation -> new DropdownProjection() {
                    @Override
                    public Integer getId() {
                        return designation.getId();
                    }

                    @Override
                    public String getName() {
                        return designation.getDesignFullName();
                    }
                });
    }

    @Override
    public Page<DropdownProjection> searchEmpRole(String query, Pageable pageable) {
        return empRoleRepository
                .findAll(EmpRoleSpecification.searchEmpRole(query), pageable)
                .map(role -> new DropdownProjection() {

                    @Override
                    public Integer getId() {
                        return role.getId();
                    }

                    @Override
                    public String getName() {
                        return role.getRoleFullName();
                    }

                });
    }

    @Override
    public Page<DropdownProjection> searchZipcode(String query, Pageable pageable) {
        return zipcodeRepository.findAll(ZipcodeMasterSpecification.searchZipcodeMaster(query), pageable)
                .map(zipcode -> new DropdownProjection() {

                    @Override
                    public Integer getId() {
                        return zipcode.getId();
                    }

                    @Override
                    public String getName() {
                        return zipcode.getZipcode();
                    }

                });
    }

}
