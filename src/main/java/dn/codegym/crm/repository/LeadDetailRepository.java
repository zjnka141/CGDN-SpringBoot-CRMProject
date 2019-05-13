package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.entity.LeadDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadDetailRepository extends JpaRepository<LeadDetail, String> {

    Page<LeadDetail> findAllByLead(Lead lead, Pageable pageable);
}
