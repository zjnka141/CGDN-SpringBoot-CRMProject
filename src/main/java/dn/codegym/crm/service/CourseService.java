package dn.codegym.crm.service;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<Course> findAllByDeletedIsFalse(Pageable pageable);
    Page<Course> findAllByNameContaining(String name, Pageable pageable);
    void create(CourseDTO courseDTO);
    void update(CourseDTO courseDTO);
    CourseDTO findById(String id);
    void delete(String id);
}
