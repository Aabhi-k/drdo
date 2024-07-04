package com.desidoc.management.lab.specifications;

import com.desidoc.management.lab.model.LabCluster;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class LabClusterSpecification {

    public static Specification<LabCluster> searchLabCluster(String search) {
        return (Root<LabCluster> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            String searchPattern = "%" + search.toLowerCase() + "%";

            Predicate notDeleted = builder.equal(root.get("deleted"), "0");

            Predicate clusterFullNamePredicate = builder.like(builder.lower(root.get("clusterFullName")), searchPattern);
            Predicate clusterCategoryPredicate = builder.like(builder.lower(root.get("clusterCategory")), searchPattern);

            Predicate searchPredicate = builder.or(clusterFullNamePredicate, clusterCategoryPredicate);
            Predicate finalPredicate = builder.and(searchPredicate, notDeleted);

            return finalPredicate;

        };
    }
}
