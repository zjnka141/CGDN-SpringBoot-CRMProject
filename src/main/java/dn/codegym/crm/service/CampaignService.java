package dn.codegym.crm.service;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CampaignService {
    Page<Campaign> findAllByDeletedIsFalse(Pageable pageable);

    Page<Campaign> searchName(String name,Pageable pageable);

    Page<Campaign> findAllByDeletedIsFalseAndNameIsNot(String name, Pageable pageable);

    void create(CampaignDTO campaignDTO);

    void update(CampaignDTO campaignDTO);

    void delete(String id);

    CampaignDTO findById(String id);
}
