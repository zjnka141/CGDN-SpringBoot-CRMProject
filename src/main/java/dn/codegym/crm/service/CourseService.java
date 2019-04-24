package dn.codegym.crm.service;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;

public interface CourseService {
    Iterable<Course> findAllByDeletedIsFalse();
    void save(CourseDTO courseDTO);
    void update(CourseDTO courseDTO);
    CourseDTO findById(String id);
    void delete(String id);
}
