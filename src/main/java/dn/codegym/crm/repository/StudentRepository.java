package dn.codegym.crm.repository;

import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, String> {
    Page<Student> findAllByDeletedIsFalse(Pageable pageable);

    Page<Student> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);

    Page<Student> findAllByDeletedIsFalseAndClassRoom(ClassRoom classRoom, Pageable pageable);

    List<Student> findAllByDeletedIsFalse();

    Long countByClassRoom(ClassRoom classRoom);
}
