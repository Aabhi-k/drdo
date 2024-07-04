package com.desidoc.management.others.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailCategoryRepository extends JpaRepository<MailCategory, Integer> {

}
