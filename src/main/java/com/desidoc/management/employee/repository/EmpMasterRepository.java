package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMasterRepository extends JpaRepository<EmpMaster, Integer>, JpaSpecificationExecutor<EmpMaster> {

    List<EmpMaster> findAllByLabId_Id(Integer id);

    // Finding all the employees even if they are deleted
    List<EmpMaster> findAllByOrderByViewingOrderDesc();

    // Finding all employees using the deleted column
    List<EmpMaster> findAllByDeletedOrderByViewingOrderDesc(String deleted);


    // Finding employee Details  using the deleted column
//    @Query("SELECT e.id as empId, " +
//            "e.empTitle as empTitle, " +
//            "e.empFirstName as empFirstName, " +
//            "e.empMiddleName as empMiddleName, " +
//            "e.empLastName as empLastName, " +
//            "d.designFullName as empDesignation, " +
//            "e.officeRoomNo as officeRoomNo, " +
//            "a.addressLine1 as addressLine1, " +
//            "a.addressLine2 as addressLine2, " +
//            "a.addressLine3 as addressLine3, " +
//            "c.cityFullName as cityFullName, " +
//            "z.zipcode as zipcode, " +
//            "l.labFullName as labFullName, " +
//            "t.teleCatName as telephoneCategory, " +
//            "tel.telephoneNumber as telephoneNumber " +
//            "FROM EmpMaster e " +
//            "JOIN e.empDesignId d " +
//            "JOIN e.labId l " +
//            "JOIN EmpResidentialAddress a ON e.id = a.empId.id " +
//            "JOIN a.cityId c " +
//            "JOIN a.zipcodeId z " +
//            "JOIN EmpTelephoneMaster tel ON e.id = tel.empId.id " +
//            "LEFT JOIN tel.teleCatId t " +
//            "WHERE e.deleted = '0' AND e.id = :empId")
//    EmployeeDetailsProjection findEmployeeDetailsByEmpId(@Param("empId") Integer empId);


}
