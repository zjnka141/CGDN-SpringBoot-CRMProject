package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.repository.LeadRepository;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("leadService")
public class LeadServiceImpl implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public Iterable<Lead> findAllByDeletedIsFalse() {
        return leadRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Iterable<Lead> findAllByStatusContaining(String status) {
        return leadRepository.findAllByStatusContaining(status);
    }

    @Override
    public void create(LeadDTO leadDTO) {
        Lead lead = new Lead();
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setPhoneNumber(leadDTO.getPhoneNumber());
        lead.setSource(leadDTO.getSource());
        lead.setStatus(leadDTO.getStatus());
        lead.setDeleted(Boolean.FALSE);
        leadRepository.save(lead);
    }
    @Override
    public void update(LeadDTO leadDTO) {
        Lead lead = leadRepository.findById(leadDTO.getId()).orElse(null);
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setPhoneNumber(leadDTO.getPhoneNumber());
        lead.setSource(leadDTO.getSource());
        lead.setStatus(leadDTO.getStatus());
        leadRepository.save(lead);
    }

    @Override
    public LeadDTO findById(String id) {
        Lead lead = leadRepository.findById(id).orElse(null);
        if (lead != null) {

            LeadDTO leadDTO = new LeadDTO();
            leadDTO.setId(lead.getId());
            leadDTO.setName(lead.getName());
            leadDTO.setEmail(lead.getEmail());
            leadDTO.setPhoneNumber(lead.getPhoneNumber());
            leadDTO.setSource(lead.getSource());
            leadDTO.setStatus(lead.getStatus());
            leadDTO.setDeleted(lead.isDeleted());

            return leadDTO;
        }
        return null;
    }

        @Override
        public void delete (String id){
            Lead lead = leadRepository.findById(id).orElse(null);
            lead.setDeleted(true);
            leadRepository.save(lead);
        }



}

