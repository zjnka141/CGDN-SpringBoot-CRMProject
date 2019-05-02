package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.repository.CampaignRepository;
import dn.codegym.crm.repository.LeadRepository;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("leadService")
public class LeadServiceImpl implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Page<Lead> findAllByDeletedIsFalse(Pageable pageable) {
        pageable= PageRequest.of(pageable.getPageNumber(),10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageble) {
        pageble= PageRequest.of(pageble.getPageNumber(),10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalseAndNameContaining(name, pageble);
    }

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndStatusContaining(String status, Pageable pageable) {
        pageable= PageRequest.of(pageable.getPageNumber(),10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalseAndStatusContaining(status, pageable);
    }

    @Override
    public List<Lead> findAllByCampaignId(String campaignId) {
        Campaign campaign=campaignRepository.findById(campaignId).orElse(null);
        List<Lead> leads =leadRepository.findAllByCampaignAndDeletedIsFalse(campaign);
        return leads;
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
        lead.setCampaign(leadDTO.getCampaign());
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
        lead.setCampaign(leadDTO.getCampaign());
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
            leadDTO.setCampaign(lead.getCampaign());
            leadDTO.setDeleted(lead.isDeleted());

            return leadDTO;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Lead lead = leadRepository.findById(id).orElse(null);
        lead.setDeleted(true);
        leadRepository.save(lead);
    }


}
