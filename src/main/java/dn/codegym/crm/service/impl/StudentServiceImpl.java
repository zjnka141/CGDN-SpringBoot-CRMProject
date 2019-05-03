package dn.codegym.crm.service.impl;

import dn.codegym.crm.constants.AppConsts;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.repository.StudentRepository;
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

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(StudentDTO studentDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate birthday = LocalDate.parse(studentDTO.getBirthday(), formatter);

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setBirthday(birthday);
        student.setClassRoom(studentDTO.getIdClass());
        student.setGender(studentDTO.getGender());
        student.setDeleted(Boolean.FALSE);
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("name").ascending());
        return studentRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public List<Student> findAllByDeletedIsFalse() {
        return studentRepository.findAllByDeletedIsFalse();
    }

    @Override
    public StudentDTO findById(String id) {


        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String birthday = student.getBirthday().format(formatter);

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setBirthday(birthday);
            studentDTO.setGender(student.getGender());
            studentDTO.setIdClass(student.getClassRoom());
            studentDTO.setDeleted(student.isDeleted());
            studentDTO.setEmail(student.getEmail());
            studentDTO.setPhoneNumber(student.getPhoneNumber());
            return studentDTO;
        }
        return null;
    }

    @Override
    public void update(StudentDTO studentDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate birthday = LocalDate.parse(studentDTO.getBirthday(), formatter);
        Student student = studentRepository.findById(studentDTO.getId()).orElse(null);
        student.setName(studentDTO.getName());
        student.setGender(studentDTO.getGender());
        student.setBirthday(birthday);
        student.setClassRoom(studentDTO.getIdClass());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        studentRepository.save(student);
    }

    @Override
    public void delete(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setDeleted(true);
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        pageable = PageRequest.of(0, 10, Sort.by("name"));
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAllByNameContaining(String name, Pageable pageable) {
        studentRepository.findAllByDeletedIsFalse(pageable);
        return studentRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
    }

    @Override
    public StudentDTO moveLeadToStudent(LeadDTO leadDTO) {
        StudentDTO studentDTO = findById(leadDTO.getId());
        if (studentDTO != null) {
            return null;
        } else {
            studentDTO=new StudentDTO();
            studentDTO.setId(leadDTO.getId());
            studentDTO.setName(leadDTO.getName());
            studentDTO.setEmail(leadDTO.getEmail());
            studentDTO.setPhoneNumber(leadDTO.getPhoneNumber());
            studentDTO.setDeleted(Boolean.FALSE);
            return studentDTO;
        }

    }
}
