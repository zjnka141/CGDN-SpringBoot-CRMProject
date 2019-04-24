package dn.codegym.crm.service;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;

public interface CampaignService {
    Iterable<Campaign> findAllByDeletedIsFalse();

    void create(CampaignDTO campaignDTO);

    void update(CampaignDTO campaignDTO);

    void delete(String id);

    CampaignDTO findById(String id);
}
