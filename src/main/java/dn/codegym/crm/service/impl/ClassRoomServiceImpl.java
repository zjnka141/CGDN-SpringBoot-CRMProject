package dn.codegym.crm.service.impl;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.repository.ClassRoomRepository;
import dn.codegym.crm.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;

    @Override
    public Iterable<ClassRoom> findAllByDeletedIsFalse() {
        return classRoomRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName(classRoomDTO.getName());
        classRoom.setIdCourse(classRoomDTO.getIdCourse());
        classRoom.setDeleted(Boolean.FALSE);
        classRoomRepository.save(classRoom);
    }

    @Override
    public void update(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = classRoomRepository.findById(classRoomDTO.getId()).orElse(null);
    }

    @Override
    public ClassRoomDTO findById(String id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        ClassRoomDTO classRoomDTO = new ClassRoomDTO();
        classRoomDTO.setId(classRoom.getId());
        classRoomDTO.setName(classRoom.getName());
        classRoomDTO.setIdCourse(classRoom.getIdCourse());
        classRoomDTO.setDeleted(classRoom.isDeleted());
        return classRoomDTO;
    }

    @Override
    public void delete(String id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.setDeleted(TRUE);
        classRoomRepository.save(classRoom);
    }

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }
}
