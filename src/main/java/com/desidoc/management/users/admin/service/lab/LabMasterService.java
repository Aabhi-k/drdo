package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;

public interface LabMasterService {

	// -------- Find Methods ---------------------------
	LabMaster findLabMasterById(Integer id);

	List<LabMasterProjection> findAllLabMaster();

	List<LabMasterDTO> findAllLabMasterByDeleted();

	// -------- Search Methods ---------------------------
	List<LabMasterProjection> searchLabMaster(String search);

	// -------- Update Methods --------------------
	String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception;

	String updateViewingOrder(Integer id, Integer order) throws Exception;

	// -------- Create Methods --------------------
	String createLabMaster(LabMasterDTO labMaster) throws Exception;

	// -------- Delete Method ---------------------------
	String deleteLabMaster(Integer id) throws Exception;

}
