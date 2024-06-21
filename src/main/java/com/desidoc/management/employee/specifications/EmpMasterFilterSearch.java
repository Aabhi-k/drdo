package com.desidoc.management.employee.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.employee.model.EmpMaster;

public class EmpMasterFilterSearch {
	
	public static Specification<EmpMaster> filterSpec(){
		return (root, query, cb) -> {
            return cb.equal(root.get("empId"), "1");
        };
	}

}
