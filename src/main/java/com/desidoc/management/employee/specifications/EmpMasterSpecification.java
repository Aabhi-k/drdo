package com.desidoc.management.employee.specifications;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.lab.model.LabMaster;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmpMasterSpecification {

	public static Specification<EmpMaster> searchEmpMaster(String search, Map<String, String> filters) {
		return (root, query, builder) -> {

			Join<EmpMaster, LabMaster> labJoin = root.join("labId", JoinType.LEFT);
			Join<EmpMaster, EmpDesignation> designationJoin = root.join("empDesignId", JoinType.LEFT);

			// Convert the search string to lowerCase and add wildCard characters for LIKE
			// query
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

			// Creating a predicate for labName (case insensitive)
			Predicate labNamePredicate = builder.like(builder.lower(labJoin.get("labFullName")), searchPattern);

			// Creating a predicate for empDesignation (case insensitive)
			Predicate empDesignationPredicate = builder.like(builder.lower(designationJoin.get("designFullName")),
					searchPattern);

			// Combining the searchPredicate
			Predicate searchPredicate = builder.or(empTitlePredicate, empFirstNamePredicate, empMiddleNamePredicate,
					empLastNamePredicate, labNamePredicate, empDesignationPredicate);
			Predicate finalPredicate = builder.and(searchPredicate, notDeleted);

			finalPredicate = filterData(filters, finalPredicate, builder, root);

			return finalPredicate;

		};
	}

	public static Specification<EmpMaster> getAllEmpMaster(Map<String, String> filters) {
		return (root, query, builder) -> {
			Predicate notDeleted = builder.equal(root.get("deleted"), "0");

			Predicate finalPredicate = builder.and(notDeleted);

			finalPredicate = filterData(filters, finalPredicate, builder, root);

			return finalPredicate;
		};
	}

	private static Predicate filterData(Map<String, String> filters, Predicate finalPredicate, CriteriaBuilder builder,
			Root<EmpMaster> root) {

		for (Map.Entry<String, String> filter : filters.entrySet()) {
			String key = filter.getKey();
			String value = filter.getValue();

			if (key.equals("Lab")) {
				Predicate labPredicate = builder.equal(root.get("labId").get("Id"), Integer.parseInt(value));
				finalPredicate = builder.and(finalPredicate, labPredicate);
			} else if (key.equals("Designation")) {
				Predicate designationPredicate = builder.equal(root.get("empDesignId").get("Id"),
						Integer.parseInt(value));
				finalPredicate = builder.and(finalPredicate, designationPredicate);
			}
		}

		return finalPredicate;
	}

}
