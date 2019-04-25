package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, String> {
    Iterable<Lead> findAllByDeletedIsFalse();
    Iterable<Lead> findAllByStatusContaining(String status);
}
