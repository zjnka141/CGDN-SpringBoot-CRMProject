package dn.codegym.crm.service;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> findAllByDeletedIsFalseAndClassRoom(String classId, Pageable pageable);

    Page<Student> findAllByDeletedIsFalse(Pageable pageable);
    Page<Student> findAllByDeletedIsFalseAndNameContaining(String name,Pageable pageable);

    List<Student> findAllByDeletedIsFalse();

    void save(StudentDTO studentDTO);

    StudentDTO findById(String id);

    void update(StudentDTO studentDTO);

    void delete(String id);

    StudentDTO moveLeadToStudent(LeadDTO leadDTO);

}
