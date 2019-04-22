package dn.codegym.crm.service;

import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICourseService {
    void createCourse(Course course);
    Page<Course> getCourses(Pageable pageable);

}
