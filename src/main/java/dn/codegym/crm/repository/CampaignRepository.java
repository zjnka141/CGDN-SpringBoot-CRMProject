package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
    Page<Campaign> findAllByDeletedIsFalse(Pageable pageable);

    List<Campaign> findAllByDeletedIsFalse();

    Page<Campaign> findAllByDeletedIsFalseAndNameContainingAndNameIsNot(String name,String nameNull, Pageable pageable);

    Page<Campaign> findAllByDeletedIsFalseAndNameIsNot(String name, Pageable pageable);
}
