package dn.codegym.crm.service;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LeadService {
    Page<Lead> findAllByDeletedIsFalse(Pageable pageable);

    Page<Lead> findAllByDeletedIsFalseAndStatusContaining(String status, Pageable pageable);

    Page<Lead> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);

    void create(LeadDTO leadDTO);

    void update(LeadDTO leadDTO);

    LeadDTO findById(String id);

    void delete(String id);

    Page<Lead> findAllByDeletedIsFalseAndCampaignNull(Pageable pageable);

    Page<Lead> findAllByCampaignId(String campaignId, Pageable pageable);
}
