package dn.codegym.crm.service;

import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAllByDeletedIsFalse(Pageable pageable);
    void save(StudentDTO studentDTO);
    StudentDTO findById(String id);
    void update(StudentDTO studentDTO);
    void delete(String id);
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByNameContaining(String name,Pageable pageable);
}
