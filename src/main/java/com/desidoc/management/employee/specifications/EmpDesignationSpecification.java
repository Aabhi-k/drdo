package com.desidoc.management.employee.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.employee.model.EmpDesignation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmpDesignationSpecification {
	
	public static Specification<EmpDesignation> searchEmpDesignation(String search){
		return (Root<EmpDesignation> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->{
			
			// Convert the search string to lowerCase and add wildCard characters for LIKE query
			String searchPattern = "%" + search.toLowerCase() + "%";
			
			 // Create a predicate for the designShortName field (matching case-insensitively)
			Predicate designShortNamePredicate = builder.like(builder.lower(root.get("designShortName")), searchPattern);
			
			// Create a predicate for the designFullName field (matching case-insensitively)
			Predicate designFullNamePredicate = builder.like(builder.lower(root.get("designFullName")), searchPattern);
			
			// Combine the two predicates with an OR condition
			return builder.or(designShortNamePredicate, designFullNamePredicate);
		};
	}

}
