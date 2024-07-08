package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.model.LabAddressMaster;

public interface LabAddressService {

    LabAddressMaster findLabAddressById(Integer labId);
}
