package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    Iterable<Course> findAllByDeletedIsFalse();
}
