package dn.codegym.crm.service;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Iterable<Course> findAllByDeletedIsFalse();
    void save(CourseDTO course);
}
