package dn.codegym.crm.controller;

import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @ModelAttribute("classes")
    public Page<ClassRoom> classRooms(Pageable pageable) {
        return classRoomService.findAllByDeletedIsFalse(pageable);
    }
    @GetMapping("/create")
    public ModelAndView createStudent() {
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("students",new Student());
        return modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView listStudentsPage(@ModelAttribute("student") String name, Pageable pageable) {
        Page<Student> students;
        ModelAndView modelAndView = new ModelAndView("student/list");
        if (!name.isEmpty()) {
            students = studentService.findAllByNameContaining(name,pageable);
            modelAndView.addObject("students", students);
        } else {
            modelAndView.addObject("students", studentService.findAllByDeletedIsFalse(pageable));
        }
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveStudent(@Validated @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        if(bindingResult.hasFieldErrors()) {
            redirect.addFlashAttribute("message","have some thing wrong!!");
            return  "redirect:/students/create";
        }

        studentService.save(studentDTO);
        redirect.addFlashAttribute("message", "New student created successfully!");
        return "redirect:/students/list";
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewStudentPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("student/view");
        modelAndView.addObject("students",studentService.findById(id));
        return modelAndView;

    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditStudentPage(@PathVariable String id) {
        StudentDTO studentDTO = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("student/edit");
        modelAndView.addObject("students",studentDTO);
        return modelAndView;
    }
    @PostMapping("/update")
    public String editStudent(@ModelAttribute("students") StudentDTO studentDTO,RedirectAttributes redirect) {
        studentService.update(studentDTO);
        redirect.addFlashAttribute("message","updated succesful!!");
        return "redirect:/students/list";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteStudentPage(@PathVariable String id) {
       StudentDTO studentDTO =studentService.findById(id);
       if(studentDTO!=null) {
           ModelAndView modelAndView = new ModelAndView("student/delete");
           modelAndView.addObject("students",studentDTO);
           return modelAndView;
       }
       return new ModelAndView("error404");
    }
    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("students") StudentDTO studentDTO,RedirectAttributes redirect) {
        studentService.delete(studentDTO.getId());
        redirect.addFlashAttribute("message", "delete successfull");
        return "redirect:/students/list";
    }
}
