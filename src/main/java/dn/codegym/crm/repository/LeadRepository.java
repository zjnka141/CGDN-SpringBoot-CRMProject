package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, String> {
    Iterable<Lead> findAllByDeletedIsFalse();

    Iterable<Lead> findAllByStatusContaining(String status);

    List<Lead> findAllByCampaignAndDeletedIsFalse(Campaign campaign);
}
