package com.desidoc.management.others.specification;

import com.desidoc.management.others.telephone.TelephoneCategory;
import org.springframework.data.jpa.domain.Specification;

public class TelephoneCategorySpecification {
    public static Specification<TelephoneCategory> searchTelephoneCategory(String query) {
        return (root, query1, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("teleCatName")), "%" + query.toLowerCase() + "%");

    }
}
