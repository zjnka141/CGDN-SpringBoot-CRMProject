package dn.codegym.crm.repository;

import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom,String> {
    Page<ClassRoom> findAllByDeletedIsFalse( Pageable pageable);
    Page<ClassRoom>findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
    Page<ClassRoom> findAllByDeletedIsFalseAndCourse(Course course, Pageable pageable);
}
