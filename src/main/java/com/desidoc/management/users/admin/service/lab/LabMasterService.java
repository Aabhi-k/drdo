package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface LabMasterService {

    // -------- Find Methods ---------------------------
    LabMaster findLabMasterById(Integer id);

    Page<LabMasterProjection> findAllLabMaster(Map<String, String> filters, Pageable pageable);

    List<LabMasterDTO> findAllLabMasterByDeleted();

    // -------- Search Methods ---------------------------
    Page<LabMasterProjection> searchLabMaster(String search, Map<String, String> filters, Pageable page);

    // -------- Update Methods --------------------
    String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception;

    String updateViewingOrder(Integer id, Integer order) throws Exception;

    // -------- Create Methods --------------------
    Integer createLabMaster(LabMasterDTO labMaster) ;

    // -------- Delete Method ---------------------------
    String deleteLabMaster(Integer id) throws Exception;
}
