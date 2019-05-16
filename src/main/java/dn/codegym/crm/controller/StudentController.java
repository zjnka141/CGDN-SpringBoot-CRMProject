package dn.codegym.crm.controller;

import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.repository.StudentRepository;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;

    @ModelAttribute("classes")
    public List<ClassRoom> classRooms() {
        return classRoomService.findAllByDeletedIsFalse();
    }
    @GetMapping("/create")
    public ModelAndView createStudent() {
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student",new StudentDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        if(bindingResult.hasFieldErrors()) {
            return  "/student/create";
        }else {
            studentService.save(studentDTO);
            redirect.addFlashAttribute("message", "New student created successfully!");
            return "redirect:/students/list";
        }
    }
    @GetMapping("/list")
    public ModelAndView listCourses(@RequestParam("name") Optional<String> name, Pageable pageable) {
        Page<Student> students;
        ModelAndView modelAndView = new ModelAndView("student/list");
        if (name.isPresent()) {
            students = studentService.findAllByDeletedIsFalseAndNameContaining(name.get(), pageable);
            modelAndView.addObject("name", name.get());
            if (students.getTotalElements() == 0) {
                modelAndView.addObject("message", "Student name not found!");
            }
        } else {
            students = studentService.findAllByDeletedIsFalse(pageable);
        }
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewStudentPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("student/view");
        modelAndView.addObject("student",studentService.findById(id));
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
    public String editStudent(@Valid @ModelAttribute("students") StudentDTO studentDTO,BindingResult bindingResult,RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/student/edit";
        } else {
            studentService.update(studentDTO);
            redirect.addFlashAttribute("message", "updated succesfully!!");
            return "redirect:/students/list";
        }
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteStudentPage(@PathVariable String id) {
       StudentDTO studentDTO =studentService.findById(id);
       if(studentDTO!=null) {
           ModelAndView modelAndView = new ModelAndView("student/delete");
           modelAndView.addObject("student",studentDTO);
           return modelAndView;
       }
       return new ModelAndView("error404");
    }
    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("student") StudentDTO studentDTO,RedirectAttributes redirect) {
        studentService.delete(studentDTO.getId());
        redirect.addFlashAttribute("message", "delete successfully");
        return "redirect:/students/list";
    }
    @GetMapping("/{id}/classes/student")
    public ModelAndView showStudentFromClassList(@PathVariable String id, Pageable pageable) {
        Page<Student> students = null;//studentService.findAllByDeletedIsFalseAndIdClass(,pageable);
        if (students != null) {
            ModelAndView modelAndView = new ModelAndView("product/studentListView");
            modelAndView.addObject("students", students);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }
}
