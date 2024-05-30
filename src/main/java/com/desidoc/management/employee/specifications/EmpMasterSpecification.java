package com.desidoc.management.employee.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.employee.model.EmpMaster;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmpMasterSpecification {
	
	public static Specification<EmpMaster> searchEmpMaster(String search){
		return (Root<EmpMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
			
			// Convert the search string to lowerCase and add wildCard characters for LIKE query
			String searchPattern = "%" + search.toLowerCase() + "%";
			
			// Checking if the value is not deleted
			Predicate notDeleted = builder.equal(root.get("deleted"), "0");
			
			// Creating a predicate for empTitle (case insensitive)
			Predicate empTitlePredicate = builder.like(builder.lower(root.get("empTitle")), searchPattern);
			
			// Creating a predicate for empFirstName (case insensitive)
			Predicate empFirstNamePredicate = builder.like(builder.lower(root.get("empFirstName")), searchPattern);
			
			// Creating a predicate for empMiddleName (case insensitive)
			Predicate empMiddleNamePredicate = builder.like(builder.lower(root.get("empMiddleName")), searchPattern);
			
			// Creating a predicate for empLastName (case insensitive)
			Predicate empLastNamePredicate = builder.like(builder.lower(root.get("empLastName")), searchPattern);
			
			// Combining the predicate using OR
			return builder.and( builder.or(empTitlePredicate, empFirstNamePredicate, empMiddleNamePredicate, empLastNamePredicate), notDeleted);
			
		};
	}

}
