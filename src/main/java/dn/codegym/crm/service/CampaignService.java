package dn.codegym.crm.service;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;

import java.util.List;

public interface CampaignService {
    Iterable<Campaign> findAllByDeletedIsFalse();

    List<Campaign> searchName(String name);

    void create(CampaignDTO campaignDTO);

    void update(CampaignDTO campaignDTO);

    void delete(String id);

    CampaignDTO findById(String id);
}
