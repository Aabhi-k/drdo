package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;

public interface LabMasterService {

	List<LabMasterProjection> findAllLabMaster();

	List<LabMasterDTO> searchLabMaster(String search);

	List<LabMasterDTO> findAllLabMasterByDeleted();

	String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception;

	String deleteLabMaster(Integer id) throws Exception;

	LabMaster findLabMasterById(Integer id) throws Exception;

	String createLabMaster(LabMasterDTO labMaster) throws Exception;

	String updateViewingOrder(Integer id, Integer order) throws Exception;

}
