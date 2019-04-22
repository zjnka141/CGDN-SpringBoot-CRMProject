package dn.codegym.crm.service.impl;

import dn.codegym.crm.entity.Course;
import dn.codegym.crm.repository.CourseRepository;
import dn.codegym.crm.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Page<Course> getCourses(Pageable pageable) {
        return courseRepository.findAllByFlagIsFalse(pageable);
    }
}
