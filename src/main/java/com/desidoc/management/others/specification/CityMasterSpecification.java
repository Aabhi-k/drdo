package com.desidoc.management.others.specification;

import org.springframework.data.jpa.domain.Specification;

import com.desidoc.management.others.city.CityMaster;

import jakarta.persistence.criteria.Predicate;

public class CityMasterSpecification {

	public static Specification<CityMaster> searchCityMaster(String search) {
		return(root, query, builder) ->{
			String searchPattern = "%" + search.toLowerCase() + "%";
			
			Predicate cityShortNamePredicate = builder.like(builder.lower(root.get("cityShortName")), searchPattern);
			Predicate cityFullNamePredicate = builder.like(builder.lower(root.get("cityFullName")), searchPattern);
			
			Predicate searchPredicate = builder.or(cityShortNamePredicate, cityFullNamePredicate);
			return searchPredicate;
		};
	}

}
