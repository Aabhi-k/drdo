package com.desidoc.management.employee.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;

@Repository
public interface EmpMasterRepository extends JpaRepository<EmpMaster, Integer>, JpaSpecificationExecutor<EmpMaster> {

	List<EmpMaster> findAllByLabId_Id(Integer id);
	
	// Finding all the employees even if they are deleted
	List<EmpMaster> findAllByOrderByViewingOrderDesc();

	// Finding all employees using the deleted column
	List<EmpMaster> findAllByDeletedOrderByViewingOrderDesc(String deleted);


	@Query("SELECT e.empFirstName as empFirstName, " 
			+ "e.empLastName as empLastName, " 
			+ "e.empTitle as empTitle, "
			+ "e.officeRoomNo as officeRoomNo, " 
			+ "e.addlDesign as addlDesign, " 
			+ "l.labFullName as labFullName, "
			+ "d.designShortName as designShortName " 
			+ "FROM EmpMaster e " 
			+ "JOIN e.labId l "
			+ "JOIN e.empDesignId d " 
			+ "WHERE e.deleted = '0' " 
			+ "ORDER BY e.viewingOrder DESC ")
	Page<EmpMasterProjection> findAllEmpMasterProjection(Pageable page);

}
