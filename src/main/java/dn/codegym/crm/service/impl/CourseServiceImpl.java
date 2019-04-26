package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.repository.CourseRepository;
import dn.codegym.crm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void create(CourseDTO courseDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(courseDTO.getStartDay(), formatter);
        LocalDate endDay = LocalDate.parse(courseDTO.getEndDay(), formatter);

        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setStartDay(startDay);
        course.setEndDay(endDay);

        courseRepository.save(course);
    }

    @Override
    public void update(CourseDTO courseDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(courseDTO.getStartDay(), formatter);
        LocalDate endDay = LocalDate.parse(courseDTO.getEndDay(), formatter);

        Course course = courseRepository.findById(courseDTO.getId()).orElse(null);
        course.setName(courseDTO.getName());
        course.setStartDay(startDay);
        course.setEndDay(endDay);

        courseRepository.save(course);
    }

    @Override
    public CourseDTO findById(String id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String startDay = course.getStartDay().format(formatter);
            String endDay = course.getEndDay().format(formatter);

            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());
            courseDTO.setStartDay(startDay);
            courseDTO.setEndDay(endDay);
            courseDTO.setDeleted(course.isDeleted());

            return courseDTO;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Course course = courseRepository.findById(id).orElse(null);
        course.setDeleted(true);
        courseRepository.save(course);
    }

    @Override
    public Page<Course> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return courseRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<Course> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return courseRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
    }
}
