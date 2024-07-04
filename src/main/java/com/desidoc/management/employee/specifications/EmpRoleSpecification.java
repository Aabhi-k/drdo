package com.desidoc.management.employee.specifications;

import com.desidoc.management.employee.model.EmpRole;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EmpRoleSpecification {
    public static Specification<EmpRole> searchEmpRole(String search) {
        return (Root<EmpRole> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            String searchPattern = "%" + search.toLowerCase() + "%";

            Predicate roleShortNamePredicate = builder.like(builder.lower(root.get("roleShortName")), searchPattern);

            Predicate roleFullNamePredicate = builder.like(builder.lower(root.get("roleFullName")), searchPattern);

            return builder.or(roleShortNamePredicate, roleFullNamePredicate);
        };
    }
}
