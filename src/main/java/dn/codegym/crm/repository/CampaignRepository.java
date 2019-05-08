package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
    Page<Campaign> findAllByDeletedIsFalse(Pageable pageable);

    List<Campaign> findAllByDeletedIsFalse();

    Campaign findAllByDeletedIsFalseAndNameIs(String name);

    Page<Campaign> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);



}
