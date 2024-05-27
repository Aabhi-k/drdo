package com.desidoc.management.users.admin.service;

import java.util.List;

import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabMaster;

public interface LabMasterService {

	List<LabMasterDTO> findAllLabMaster();

	List<LabMasterDTO> searchLabMaster();

	List<LabMasterDTO> findAllLabMasterByDeleted();

	String updateLabMaster(LabMasterDTO labMaster, Integer id) throws Exception;

	String deleteLabMaster(Integer id) throws Exception;

	LabMaster findLabMasterById(Integer id) throws Exception;

	String createLabMaster(LabMasterDTO labMaster);

	String updateViewingOrder(Integer id, String order) throws Exception;

}
