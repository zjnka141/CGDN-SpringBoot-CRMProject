package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.repository.CampaignRepository;
import dn.codegym.crm.repository.LeadRepository;
import dn.codegym.crm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public Page<Campaign> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return campaignRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public List<Campaign> findAllByDeletedIsFalse() {
        return campaignRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Campaign findAllByDeletedIsFalseAndNameIs(String name) {
        return campaignRepository.findAllByDeletedIsFalseAndNameIs(name);
    }

    @Override
    public Page<Campaign> searchName(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return campaignRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
    }

    @Override
    public void create(CampaignDTO campaignDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(campaignDTO.getStartDay(), formatter);
        LocalDate endDay = LocalDate.parse(campaignDTO.getEndDay(), formatter);
        Campaign campaign = new Campaign();
        campaign.setName(campaignDTO.getName());
        campaign.setDescription(campaignDTO.getDescription());
        campaign.setEndDay(endDay);
        campaign.setStartDay(startDay);
        campaign.setPhoneNumber(campaignDTO.getPhoneNumber());
        campaign.setDeleted(Boolean.FALSE);

        campaignRepository.save(campaign);
    }

    @Override
    public void update(CampaignDTO campaignDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(campaignDTO.getStartDay(), formatter);
        LocalDate endDay = LocalDate.parse(campaignDTO.getEndDay(), formatter);

        Campaign campaign = campaignRepository.findById(campaignDTO.getId()).orElse(null);
        campaign.setName(campaignDTO.getName());
        campaign.setPhoneNumber(campaignDTO.getPhoneNumber());
        campaign.setDescription(campaignDTO.getDescription());
        campaign.setStartDay(startDay);
        campaign.setEndDay(endDay);

        campaignRepository.save(campaign);
    }

    @Override
    public void delete(String id,Pageable pageable) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        campaign.setDeleted(true);
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        Page<Lead> leads = leadRepository.findAllByCampaignAndDeletedIsFalse(campaign,pageable);
        for (Lead lead : leads) {
            lead.setCampaign(null);
        }
        campaignRepository.save(campaign);
    }

    @Override
    public CampaignDTO findById(String id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if (campaign != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String startDay = campaign.getStartDay().format(formatter);
            String endDay = campaign.getEndDay().format(formatter);

            CampaignDTO campaignDTO = new CampaignDTO();
            campaignDTO.setId(campaign.getId());
            campaignDTO.setName(campaign.getName());
            campaignDTO.setStartDay(startDay);
            campaignDTO.setEndDay(endDay);
            campaignDTO.setPhoneNumber(campaign.getPhoneNumber());
            campaignDTO.setDescription(campaign.getDescription());
            campaignDTO.setDeleted(campaign.isDeleted());

            return campaignDTO;
        }
        return null;
    }

    @Override
    public Campaign findByCampaignId(String id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        if(campaign!=null) {
            return campaign;
        } else {
            return null;
        }
    }
}
