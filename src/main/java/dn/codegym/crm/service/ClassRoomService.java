package dn.codegym.crm.service;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;


public interface ClassRoomService {
    Iterable<ClassRoom> findAllByDeletedIsFalse();
    void save(ClassRoomDTO classRoomDTO);
    void update(ClassRoomDTO classRoomDTO);
    ClassRoomDTO findById(String id);
    void delete(String id);
    Iterable<ClassRoom> findAll();
}
