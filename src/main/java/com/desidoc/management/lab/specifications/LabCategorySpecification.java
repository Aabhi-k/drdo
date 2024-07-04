package com.desidoc.management.lab.specifications;

import com.desidoc.management.lab.model.LabCategory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class LabCategorySpecification {

    public static Specification<LabCategory> seachLabCategory(String search) {
        return (root, query, builder) -> {
            String searchPattern = "%" + search.toLowerCase() + "%";
            Predicate categoryShortNamePredicate = builder.like(builder.lower(root.get("catShortName")), searchPattern);
            Predicate categoryFullNamePredicate = builder.like(builder.lower(root.get("catFullName")), searchPattern);

            Predicate searchPredicate = builder.or(categoryShortNamePredicate, categoryFullNamePredicate);
            return searchPredicate;

        };
    }

}
