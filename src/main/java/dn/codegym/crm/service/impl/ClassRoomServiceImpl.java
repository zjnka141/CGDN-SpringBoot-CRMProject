package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Product;
import dn.codegym.crm.repository.ClassRoomRepository;
import dn.codegym.crm.repository.ProductRepository;
import dn.codegym.crm.repository.StudentRepository;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Autowired
    private StudentService studentService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(ClassRoomDTO classRoom) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(classRoom.getStartDay(), dateTimeFormatter);
        LocalDate endDay = LocalDate.parse(classRoom.getEndDay(), dateTimeFormatter);

        ClassRoom classes = new ClassRoom();
        classes.setName(classRoom.getName());
        classes.setCourse(classRoom.getCourse());
        classes.setLearningStatus(classRoom.getLearningStatus());
        classes.setStartDay(startDay);
        classes.setEndDay(endDay);
        classes.setDeleted(Boolean.FALSE);
        classRoomRepository.save(classes);
    }

    @Override
    public void update(ClassRoomDTO classRoomDTO) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate startDay = LocalDate.parse(classRoomDTO.getStartDay(), dateTimeFormatter);
        LocalDate endDay = LocalDate.parse(classRoomDTO.getEndDay(), dateTimeFormatter);
        ClassRoom classRoom = classRoomRepository.findById(classRoomDTO.getId()).orElse(null);
        classRoom.setStartDay(startDay);
        classRoom.setEndDay(endDay);
        classRoom.setName(classRoomDTO.getName());
        classRoom.setCourse(classRoomDTO.getCourse());
        classRoom.setLearningStatus(classRoomDTO.getLearningStatus());

        classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoomDTO findById(String id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);

        if (classRoom != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String startDay = classRoom.getStartDay().format(dateTimeFormatter);
            String endDay = classRoom.getEndDay().format(dateTimeFormatter);

            ClassRoomDTO classRoomDTO = new ClassRoomDTO();
            classRoomDTO.setId(classRoom.getId());
            classRoomDTO.setCourse(classRoom.getCourse());
            classRoomDTO.setName(classRoom.getName());
            classRoomDTO.setLearningStatus(classRoom.getLearningStatus());
            classRoomDTO.setStartDay(startDay);
            classRoomDTO.setEndDay(endDay);

            Long totalStudent = studentRepository.countByClassRoom(classRoom);
            classRoomDTO.setTotalStudent(totalStudent.intValue());

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
    public List<ClassRoom> findAllByDeletedIsFalse() {
        return classRoomRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Page<ClassRoom> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        Page<ClassRoom> classRooms = classRoomRepository.findAllByDeletedIsFalse(pageable);
        classRooms.forEach(classRoom -> {
            Long totalStudent = studentRepository.countByClassRoom(classRoom);
            classRoom.setTotalStudent(totalStudent.intValue());
        });
        return classRooms;
    }

    @Override
    public Page<ClassRoom> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        Page<ClassRoom> classRooms = classRoomRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
        classRooms.forEach(classRoom -> {
            Long totalStudent = studentRepository.countByClassRoom(classRoom);
            classRoom.setTotalStudent(totalStudent.intValue());
        });
        return classRooms;
    }

    @Override
    public Page<ClassRoom> findAllByDeletedIsFalseAndIdCourse(Product course, Pageable pageable) {
        return classRoomRepository.findAllByDeletedIsFalseAndCourse(course, pageable);
    }
}