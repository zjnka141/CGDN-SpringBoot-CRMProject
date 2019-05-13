package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.LeadDetailDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.entity.LeadDetail;
import dn.codegym.crm.repository.LeadDetailRepository;
import dn.codegym.crm.repository.LeadRepository;
import dn.codegym.crm.service.LeadDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service("leadDetailService")
public class LeadDetailServiceImpl implements LeadDetailService {
    @Autowired
    LeadDetailRepository leadDetailRepository;
    @Autowired
    LeadRepository leadRepository;

    @Override
    public void create(LeadDetailDTO leadDetailDTO,String leadId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate lastUpdateLeadDetailDate = LocalDate.parse(leadDetailDTO.getlastUpdateLeadDetailDate(), formatter);

        LeadDetail leadDetail = new LeadDetail();
        leadDetail.setStatus(leadDetailDTO.getStatus());
        leadDetail.setContent(leadDetailDTO.getContent());
        leadDetail.setCreatedBy(leadDetailDTO.getCreateBy());
        leadDetail.setLastUpdateLeadDetailDate(lastUpdateLeadDetailDate);
        leadDetail.setLead(leadRepository.findById(leadId).orElse(null));
        leadDetailRepository.save(leadDetail);
    }

    @Override
    public void update(LeadDetailDTO leadDetailDTO) {
        LeadDetail leadDetail = leadDetailRepository.findById(leadDetailDTO.getId()).orElse(null);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate lastUpdateLeadDetailDate = LocalDate.parse(leadDetailDTO.getlastUpdateLeadDetailDate(), formatter);

        leadDetail.setStatus(leadDetailDTO.getStatus());
        leadDetail.setContent(leadDetailDTO.getContent());
        leadDetail.setCreatedBy(leadDetailDTO.getCreateBy());
        leadDetail.setLastUpdateLeadDetailDate(lastUpdateLeadDetailDate);
        leadDetailRepository.save(leadDetail);
    }

    @Override
    public LeadDetailDTO findById(String id) {
        LeadDetail leadDetail = leadDetailRepository.findById(id).orElse(null);
        if (leadDetail != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String lastUpdateLeadDetailDate= leadDetail.getLastUpdateLeadDetailDate().format(formatter);
            LeadDetailDTO leadDetailDTO = new LeadDetailDTO();
            leadDetailDTO.setStatus(leadDetail.getStatus());
            leadDetailDTO.setLastUpdateLeadDetailDate(lastUpdateLeadDetailDate);
            leadDetailDTO.setContent(leadDetail.getContent());
            leadDetailDTO.setCreateBy(leadDetail.getCreatedBy());
            return leadDetailDTO;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        LeadDetail leadDetail = leadDetailRepository.findById(id).orElse(null);
        if (leadDetail != null) {
            leadDetailRepository.delete(leadDetail);
        }
    }

    @Override
    public Page<LeadDetail> findAllByLeadId(String leadId, Pageable pageable) {
        pageable= PageRequest.of(pageable.getPageNumber(),10, Sort.by("createdDate").ascending());
       Lead lead=leadRepository.findById(leadId).orElse(null);
        Page<LeadDetail> leadDetails =leadDetailRepository.findAllByLead(lead, pageable);
        return leadDetails;
    }
}
