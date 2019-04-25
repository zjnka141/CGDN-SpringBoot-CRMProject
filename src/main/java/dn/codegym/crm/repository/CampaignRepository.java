package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,String> {
    Iterable<Campaign> findAllByDeletedIsFalse();
    List<Campaign> findAllByNameContaining(String name);
}
