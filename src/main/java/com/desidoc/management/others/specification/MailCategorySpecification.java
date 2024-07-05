package com.desidoc.management.others.specification;

import com.desidoc.management.others.mail.MailCategory;
import org.springframework.data.jpa.domain.Specification;

public class MailCategorySpecification {
    public static Specification<MailCategory> searchMailCategory(String mailCatName) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("mailCatName")), "%" + mailCatName.toLowerCase() + "%");
    }
}
