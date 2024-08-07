package com.desidoc.management.users.admin.service.others.mail;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.mail.MailCategory;
import com.desidoc.management.others.mail.MailCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailCategoryServiceImpl implements MailCategoryService {

    @Autowired
    private MailCategoryRepository repository;

    @Override
    public MailCategory getMailById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mail category not found"));
    }

}
