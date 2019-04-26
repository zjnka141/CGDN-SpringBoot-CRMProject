package dn.codegym.crm.repository;

import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    Page<Course> findAllByDeletedIsFalse(Pageable pageable);
    Page<Course> findAllByNameContaining(String name, Pageable pageable);
}
