package dn.codegym.crm.service.impl;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.repository.ClassRoomRepository;
import dn.codegym.crm.repository.CourseRepository;
import dn.codegym.crm.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(ClassRoomDTO classRoom) {
        ClassRoom classes = new ClassRoom();
        classes.setName(classRoom.getName());
        classes.setCourse(classRoom.getId_course());
        classes.setDeleted(Boolean.FALSE);
        classRoomRepository.save(classes);
    }

    @Override
    public void update(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = classRoomRepository.findById(classRoomDTO.getId()).orElse(null);
        classRoom.setName(classRoomDTO.getName());
        classRoom.setCourse(classRoomDTO.getId_course());
        classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoomDTO findById(String id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        if(classRoom != null){
            ClassRoomDTO classRoomDTO = new ClassRoomDTO();
            classRoomDTO.setId(classRoom.getId());
            classRoomDTO.setId_course(classRoom.getCourse());
            classRoomDTO.setName(classRoom.getName());
            return classRoomDTO;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.setDeleted(TRUE);
        classRoomRepository.save(classRoom);
    }
    @Override
    public Page<ClassRoom> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return classRoomRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Page<ClassRoom> findAllByNameContaining(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name"));
        return classRoomRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Page<ClassRoom> findAllByDeletedIsFalseAndIdCourse(Course course, Pageable pageable) {
        return classRoomRepository.findAllByDeletedIsFalseAndCourse(course, pageable);
    }
}
