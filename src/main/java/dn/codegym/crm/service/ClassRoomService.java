package dn.codegym.crm.service;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ClassRoomService {
    Page<ClassRoom> findAllByDeletedIsFalse(Pageable pageable);

    Page<ClassRoom> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);

    void save(ClassRoomDTO classRoomDTO);

    void update(ClassRoomDTO classRoomDTO);

    ClassRoomDTO findById(String id);

    void delete(String id);

    List<ClassRoom> findAllByDeletedIsFalse();

    Page<ClassRoom> findAllByDeletedIsFalseAndIdCourse(Product course, Pageable pageable);

}
