package dn.codegym.crm.service;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClassRoomService {
    Page<ClassRoom>findAllByDeletedIsFalse(Pageable pageable);
    Page<ClassRoom>findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
    void save(ClassRoomDTO classRoomDTO);
    void update(ClassRoomDTO classRoomDTO);
    ClassRoomDTO findById(String id);
    void delete(String id);
    Iterable<ClassRoom> findAll();
    Page<ClassRoom> findAllByDeletedIsFalseAndIdCourse(Course course, Pageable pageable);
}
