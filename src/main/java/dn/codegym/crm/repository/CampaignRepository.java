package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,String> {
    List<Campaign> findAllByDeletedIsFalse();
    List<Campaign> findAllByNameContainingAndDeletedIsFalse(String name);
}
