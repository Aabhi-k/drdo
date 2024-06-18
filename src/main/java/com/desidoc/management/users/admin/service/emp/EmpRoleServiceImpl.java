package com.desidoc.management.users.admin.service.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.model.EmpRole;
import com.desidoc.management.employee.repository.EmpRoleRepository;
import com.desidoc.management.employee.specifications.EmpRoleSpecification;
import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.projection.DropDownProjection;

@Service
public class EmpRoleServiceImpl implements EmpRoleService{
	
	@Autowired
	EmpRoleRepository repository;
	
	private DropDownProjection convertToDropDown(EmpRole empRole) {
        return new DropDownProjection() {

			@Override
			public Integer getId() {
				return empRole.getId();
			}

			@Override
			public String getName() {
				return empRole.getRoleFullName();
			}
        	
        };
    }

	@Override
	public EmpRole findEmpRoleById(Integer id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee Role not found"));
	}

	@Override
	public Page<DropDownProjection> searchDropDownMenu(String query, Pageable page) {
		Specification<EmpRole> sp = EmpRoleSpecification.searchEmpRole(query);
		return repository.findAll(sp, page).map(this::convertToDropDown);
		
	}

	
}
