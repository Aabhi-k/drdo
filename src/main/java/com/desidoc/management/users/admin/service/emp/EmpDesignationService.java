package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpDesignationService {

    // Find Methods
    EmpDesignation findEmpDesignationById(Integer id);

    List<EmpDesignationDTO> findAllEmpDesignationByOrderNo();

    Page<EmpDesignProjection> findAllEmpDesignProjection(Pageable page);

    // Search
    Page<EmpDesignProjection> searchEmpDesignation(String search, Pageable page);

    // Update Method
    String updateEmpDesignation(EmpDesignationDTO designation, Integer id) throws Exception;

    String updateOrderNo(Integer id, Integer newOrderNo) throws Exception;

    // Create Method
    String createEmpDesignation(EmpDesignationDTO designation);

    // Delete Method
    String deleteEmpDesignation(Integer id);

    EmpDesignationDTO getEmpDesignationDTOById(Integer id);
}
