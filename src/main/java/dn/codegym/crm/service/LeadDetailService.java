package dn.codegym.crm.service;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.LeadDetailDTO;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.entity.LeadDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LeadDetailService {
    void create(LeadDetailDTO leadDetailDTO,String leadId);

    void update(LeadDetailDTO leadDetailDTO);

    LeadDetailDTO findById(String id);

    void delete(String id);
    Page<LeadDetail> findAllByLeadId(String leadId, Pageable pageable);
}
