package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, String> {
    Page<Lead> findAllByDeletedIsFalse(Pageable pageable);

    Page<Lead> findAllByDeletedIsFalseAndStatusContaining(String status, Pageable pageable);

    Page<Lead> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageble);

    Page<Lead> findAllByCampaignAndDeletedIsFalse(Campaign campaign, Pageable pageable);

    Page<Lead> findAllByDeletedIsFalseAndCampaignNull(Pageable pageable);

}
