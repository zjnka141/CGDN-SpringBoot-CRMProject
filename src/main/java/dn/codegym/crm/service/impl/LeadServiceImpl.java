package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Campaign;
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

@Service("leadService")
public class LeadServiceImpl implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Page<Lead> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        System.out.printf("");
        return leadRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndNameContainingAndCampaignNull(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalseAndNameContainingAndCampaignNull(name, pageable);
    }

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndNameContainingAndCampaignNotNull(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalseAndNameContainingAndCampaignNotNull(name, pageable);
    }

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndStatusContaining(String status, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        return leadRepository.findAllByDeletedIsFalseAndStatusContaining(status, pageable);
    }

    @Override
    public void create(LeadDTO leadDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate lastUpdateStatusDate = LocalDate.parse(leadDTO.getLastUpdateStatusDate(), formatter);
        LocalDate admissionDate = LocalDate.parse(leadDTO.getAdmissionDate(), formatter);
        Lead lead = new Lead();
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setPhoneNumber(leadDTO.getPhoneNumber());
        lead.setSource(leadDTO.getSource());
        lead.setStatus(leadDTO.getStatus());
        lead.setGender(leadDTO.getGender());
        lead.setJob(leadDTO.getJob());
        lead.setAdmissionDate(admissionDate);
        lead.setLastUpdateStatusDate(lastUpdateStatusDate);
        lead.setProduct(leadDTO.getProduct());
        lead.setDeleted(Boolean.FALSE);
        lead.setCampaign(leadDTO.getCampaign());
        leadRepository.save(lead);
    }

    @Override
    public void createLeadOfCampaign(LeadDTO leadDTO, String campaignId) {
        leadDTO.setCampaign(campaignRepository.findById(campaignId).orElse(null));
        leadDTO.setStatus("G0");
        System.out.println(leadDTO.getAdmissionDate());
        create(leadDTO);

    }

    @Override
    public void update(LeadDTO leadDTO) {
        Lead lead = leadRepository.findById(leadDTO.getId()).orElse(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate lastUpdateStatusDate = LocalDate.parse(leadDTO.getLastUpdateStatusDate(), formatter);
        LocalDate admissionDate = LocalDate.parse(leadDTO.getAdmissionDate(), formatter);
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setPhoneNumber(leadDTO.getPhoneNumber());
        lead.setSource(leadDTO.getSource());
        lead.setStatus(leadDTO.getStatus());
        lead.setGender(leadDTO.getGender());
        lead.setJob(leadDTO.getJob());
        lead.setAdmissionDate(admissionDate);
        lead.setLastUpdateStatusDate(lastUpdateStatusDate);
        lead.setProduct(leadDTO.getProduct());
        lead.setCampaign(leadDTO.getCampaign());
        leadRepository.save(lead);
    }

    @Override
    public void updateLeadOfCampaign(LeadDTO leadDTO) {
        LeadDTO leadDTOOfCampaign = findById(leadDTO.getId());
        leadDTOOfCampaign.setName(leadDTO.getName());
        leadDTOOfCampaign.setGender(leadDTO.getGender());
        leadDTOOfCampaign.setProduct(leadDTO.getProduct());
        leadDTOOfCampaign.setEmail(leadDTO.getEmail());
        leadDTOOfCampaign.setPhoneNumber(leadDTO.getPhoneNumber());
        leadDTOOfCampaign.setJob(leadDTO.getJob());
        leadDTOOfCampaign.setSource(leadDTO.getSource());
        leadDTOOfCampaign.setAdmissionDate(leadDTOOfCampaign.getAdmissionDate());
        update(leadDTOOfCampaign);
    }

    @Override
    public LeadDTO findById(String id) {
        Lead lead = leadRepository.findById(id).orElse(null);
        if (lead != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String lastUpdateStatusDate = lead.getLastUpdateStatusDate().format(formatter);
            String admissionDate = lead.getAdmissionDate().format(formatter);
            LeadDTO leadDTO = new LeadDTO();
            leadDTO.setId(lead.getId());
            leadDTO.setName(lead.getName());
            leadDTO.setEmail(lead.getEmail());
            leadDTO.setPhoneNumber(lead.getPhoneNumber());
            leadDTO.setSource(lead.getSource());
            leadDTO.setStatus(lead.getStatus());
            leadDTO.setGender(lead.getGender());
            leadDTO.setJob(lead.getJob());
            leadDTO.setAdmissionDate(admissionDate);
            leadDTO.setLastUpdateStatusDate(lastUpdateStatusDate);
            leadDTO.setProduct(lead.getProduct());
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

    @Override
    public Page<Lead> findAllByDeletedIsFalseAndCampaignNull(Pageable pageable) {
        return leadRepository.findAllByDeletedIsFalseAndCampaignNull(pageable);
    }

    @Override
    public Page<Lead> findAllByCampaignId(String campaignId, Pageable pageable) {
        Campaign campaign = campaignRepository.findById(campaignId).orElse(null);
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        Page<Lead> leads = leadRepository.findAllByCampaignAndDeletedIsFalse(campaign, pageable);
        return leads;
    }

    @Override
    public void moveLeadCampaignToLeadCenter(String leadId) {
        Lead lead = leadRepository.findById(leadId).orElse(null);
        lead.setSource(lead.getCampaign().getName());
        lead.setCampaign(null);
        lead.setStatus("G1");
        lead.setLastUpdateStatusDate(LocalDate.now());
        leadRepository.save(lead);
    }

}

