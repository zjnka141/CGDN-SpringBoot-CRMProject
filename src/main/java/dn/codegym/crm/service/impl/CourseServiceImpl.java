package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.repository.CourseRepository;
import dn.codegym.crm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(CourseDTO courseDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDate = LocalDate.parse(courseDto.getStartDay(), formatter);
        LocalDate endDate = LocalDate.parse(courseDto.getEndDay(), formatter);

        Course course = new Course();
        course.setName(courseDto.getName());
        course.setStartDay(startDate);
        course.setEndDay(endDate);
        course.setDeleted(Boolean.FALSE);

        courseRepository.save(course);
    }

    @Override
    public Iterable<Course> findAllByDeletedIsFalse() {
        return courseRepository.findAllByDeletedIsFalse();
    }
}
