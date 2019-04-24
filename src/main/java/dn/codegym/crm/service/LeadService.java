package dn.codegym.crm.service;

import dn.codegym.crm.entity.Lead;

public interface LeadService {
    Iterable<Lead> findAllByDeletedIsFalse();
    Lead findById(String id);
    void save(Lead lead);
    void remove(String id);
}
