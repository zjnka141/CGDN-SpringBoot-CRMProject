package dn.codegym.crm.service.impl;

import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.repository.LeadRepository;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("leadService")
public class LeadServiceImpl implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public Iterable<Lead> findAllByDeletedIsFalse() {
        return leadRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Lead findById(String id) {
        return leadRepository.getOne(id);
    }

    @Override
    public void save(Lead lead) {
        leadRepository.save(lead);
    }

    @Override
    public void remove(String id) {
        leadRepository.deleteById(id);
    }
}
