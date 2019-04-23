package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    Iterable<Course> findAllByDeletedIsFalse();
}
