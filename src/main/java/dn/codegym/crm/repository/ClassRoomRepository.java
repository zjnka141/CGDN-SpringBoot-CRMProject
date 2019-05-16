package dn.codegym.crm.repository;

import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, String> {
    Page<ClassRoom> findAllByDeletedIsFalse(Pageable pageable);

    List<ClassRoom> findAllByDeletedIsFalse();

    Page<ClassRoom> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);

    Page<ClassRoom> findAllByDeletedIsFalseAndCourse(Product course, Pageable pageable);

}
