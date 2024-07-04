package com.desidoc.management.others.specification;

import com.desidoc.management.others.city.ZipcodeMaster;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ZipcodeMasterSpecification {

    public static Specification<ZipcodeMaster> searchZipcodeMaster(String search) {

        return (root, query, builder) -> {
            String searchPattern = "%" + search.toLowerCase() + "%";

            Predicate zipcodePredicate = builder.like(builder.lower(root.get("zipcode")), searchPattern);

            return zipcodePredicate;
        };
    }
}
