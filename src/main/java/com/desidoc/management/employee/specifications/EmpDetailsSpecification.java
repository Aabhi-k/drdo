package com.desidoc.management.employee.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.employee.model.EmpMaster;

import jakarta.persistence.criteria.JoinType;

public class EmpDetailsSpecification {

	public static Specification<EmpMaster> getEmpDetails(Integer empId) {
		return (root, query, builder) -> {

			var addressJoin = root.join("EmpResidentialAddress", JoinType.LEFT);

			query.multiselect(root.get("id"), root.get("empTitle").alias("empTitle"),
					root.get("empFirstName").alias("empFirstName"), root.get("empMiddleName").alias("empMiddleName"),
					root.get("empLastName").alias("empLastName"), root.get("officeRoomNo").alias("officeRoomNo"),
					addressJoin.get("addressLine1").alias("addressLine1"),
					addressJoin.get("addressLine2").alias("addressLine2"),
					addressJoin.get("addressLine3").alias("addressLine3"), addressJoin.get("cityId").alias("cityId"),
					addressJoin.get("zipcodeId").alias("zipcodeId"));

			return builder.equal(root.get("id"), empId);
		};

	}
}
