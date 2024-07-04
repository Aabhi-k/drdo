package com.desidoc.management.lab.specifications;

import com.desidoc.management.lab.model.LabCategory;
import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.others.city.CityMaster;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class LabMasterSpecification {

    public static Specification<LabMaster> searchLabMaster(String search, Map<String, String> filters) {

        return (Root<LabMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            Join<LabMaster, LabCluster> clusterJoin = root.join("labClusterId", JoinType.LEFT);
            Join<LabMaster, LabCategory> categoryJoin = root.join("labCatId", JoinType.LEFT);
            Join<LabMaster, CityMaster> cityJoin = root.join("labCityId", JoinType.LEFT);

            String searchPattern = "%" + search.toLowerCase() + "%";

            Predicate notDeleted = builder.equal(root.get("deleted"), "0");

            Predicate labAuthNamePredicate = builder.like(builder.lower(root.get("labAuthName")), searchPattern);
            Predicate labShortNamePredicate = builder.like(builder.lower(root.get("labShortName")), searchPattern);
            Predicate labFullNamePredicate = builder.like(builder.lower(root.get("labFullName")), searchPattern);

            Predicate labClusterPredicate = builder.like(builder.lower(clusterJoin.get("clusterFullName")), searchPattern);
            Predicate labCategoryPredicate = builder.like(builder.lower(categoryJoin.get("catFullName")), searchPattern);
            Predicate labCityPredicate = builder.like(builder.lower(cityJoin.get("cityFullName")), searchPattern);


            Predicate searchPredicate = builder.or(labAuthNamePredicate, labShortNamePredicate, labFullNamePredicate
                    , labClusterPredicate, labCategoryPredicate, labCityPredicate);

            Predicate finalPredicate = builder.and(searchPredicate, notDeleted);

            if (filters.isEmpty())
                return finalPredicate;

            finalPredicate = filterData(filters, finalPredicate, builder, root);


            return finalPredicate;
        };

    }

    public static Specification<LabMaster> searchLabMaster(String search) {
        return (Root<LabMaster> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {

            Join<LabMaster, LabCluster> clusterJoin = root.join("labClusterId", JoinType.LEFT);
            Join<LabMaster, LabCategory> categoryJoin = root.join("labCatId", JoinType.LEFT);
            Join<LabMaster, CityMaster> cityJoin = root.join("labCityId", JoinType.LEFT);

            String searchPattern = "%" + search.toLowerCase() + "%";

            Predicate notDeleted = builder.equal(root.get("deleted"), "0");

            Predicate labAuthNamePredicate = builder.like(builder.lower(root.get("labAuthName")), searchPattern);
            Predicate labShortNamePredicate = builder.like(builder.lower(root.get("labShortName")), searchPattern);
            Predicate labFullNamePredicate = builder.like(builder.lower(root.get("labFullName")), searchPattern);

            Predicate labClusterPredicate = builder.like(builder.lower(clusterJoin.get("clusterFullName")), searchPattern);
            Predicate labCategoryPredicate = builder.like(builder.lower(categoryJoin.get("catFullName")), searchPattern);
            Predicate labCityPredicate = builder.like(builder.lower(cityJoin.get("cityFullName")), searchPattern);


            Predicate searchPredicate = builder.or(labAuthNamePredicate, labShortNamePredicate, labFullNamePredicate
                    , labClusterPredicate, labCategoryPredicate, labCityPredicate);

            Predicate finalPredicate = builder.and(searchPredicate, notDeleted);

            return finalPredicate;
        };
    }


    public static Specification<LabMaster> getAllLabMaster(Map<String, String> filters) {
        return (root, query, builder) -> {
            Predicate notDeleted = builder.equal(root.get("deleted"), "0");
            Predicate finalPredicate = builder.and(notDeleted);

            finalPredicate = filterData(filters, finalPredicate, builder, root);

            return finalPredicate;
        };
    }

    private static Predicate filterData(Map<String, String> filters, Predicate finalPredicate, CriteriaBuilder builder, Root<LabMaster> root) {
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue();

            if (key.equals("Cluster")) {
                Predicate clusterPredicate = builder.equal(root.get("labClusterId").get("id"), Integer.parseInt(value));
                finalPredicate = builder.and(finalPredicate, clusterPredicate);

            } else if (key.equals("Category")) {
                Predicate CategoryPredicate = builder.equal(root.get("labCatId").get("id"), Integer.parseInt(value));
                finalPredicate = builder.and(finalPredicate, CategoryPredicate);

            } else if (key.equals("City")) {
                Predicate cityPredicate = builder.equal(root.get("labCityId").get("id"), Integer.parseInt(value));
                finalPredicate = builder.and(finalPredicate, cityPredicate);
            }

        }

        return finalPredicate;

    }
}
