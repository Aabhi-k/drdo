package com.desidoc.management.lab.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.lab.model.LabMaster;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LabMasterSpecification {
	
	public static Specification<LabMaster> searchLabMaster(String search){
		
		return (Root<LabMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder)->{
			
			String searchPattern = "%" + search.toLowerCase() + "%";
			
			Predicate notDeleted = builder.equal(root.get("deleted"), "0");
			
			Predicate labAuthNamePredicate = builder.like(builder.lower(root.get("labAuthName")), searchPattern);
			Predicate labShortNamePredicate = builder.like(builder.lower(root.get("labShortName")), searchPattern);
			Predicate labFullNamePredicate = builder.like(builder.lower(root.get("labFullName")), searchPattern);
			
			
			return builder.and(builder.or(labAuthNamePredicate,labShortNamePredicate, labFullNamePredicate), notDeleted);
			
		};
		
	}

}
