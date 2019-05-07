package dn.codegym.crm.service;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CampaignService {
    Page<Campaign> findAllByDeletedIsFalse(Pageable pageable);

    List<Campaign> findAllByDeletedIsFalse();

    Campaign findAllByDeletedIsFalseAndNameIs(String name);

    Page<Campaign> searchName(String name,Pageable pageable);

    void create(CampaignDTO campaignDTO);

    void update(CampaignDTO campaignDTO);

    void delete(String id,Pageable pageable);

    CampaignDTO findById(String id);

    Campaign findByCampaignId(String id);
}
