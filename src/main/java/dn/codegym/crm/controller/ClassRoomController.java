package dn.codegym.crm.controller;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Course;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.CourseService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("classes")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @ModelAttribute("course")
    public Page<Course> courses(Pageable pageable) {
        return courseService.findAllByDeletedIsFalse(pageable);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("class/create");
        modelAndView.addObject("classes", new ClassRoomDTO());
        modelAndView.addObject("message", "congratulation you to created new class");
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveClassRoom(@ModelAttribute("classes") ClassRoomDTO classRoomDTO, RedirectAttributes redirect) {
        classRoomService.save(classRoomDTO);
        redirect.addFlashAttribute("message", "New Class created successfully!");
        return "redirect:/classes/list";
    }

    @GetMapping("/list")
    public ModelAndView listClassRoomPage(@ModelAttribute("name") String name, Pageable pageable) {
        Page<ClassRoom> classRooms;
        ModelAndView modelAndView = new ModelAndView("class/list");
        if (!name.isEmpty()) {
            classRooms = classRoomService.findAllByDeletedIsFalseAndNameContaining(name, pageable);
            modelAndView.addObject("classes", classRooms);
        } else {
            modelAndView.addObject("classes", classRoomService.findAllByDeletedIsFalse(pageable));
        }
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditClassPage(@PathVariable String id) {
        ClassRoomDTO classRoomDTO = classRoomService.findById(id);
        if (classRoomDTO != null) {
            ModelAndView modelAndView = new ModelAndView("class/edit");
            modelAndView.addObject("classes", classRoomDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/edit")
    public String editClass(@ModelAttribute("classes") ClassRoomDTO classRoomDTO, RedirectAttributes redirect) {
        classRoomService.update(classRoomDTO);
        redirect.addFlashAttribute("message", "updated is successful!!");
        return "redirect:/classes/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteClassPage(@PathVariable String id) {
        ClassRoomDTO classRoomDTO = classRoomService.findById(id);
        if (classRoomDTO != null) {
            ModelAndView modelAndView = new ModelAndView("class/delete");
            modelAndView.addObject("classes", classRoomDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("classes") ClassRoomDTO classRoomDTO, RedirectAttributes redirect) {
        classRoomService.delete(classRoomDTO.getId());
        redirect.addFlashAttribute("message", "delete is successfully");
        return "redirect:/classes/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewClassesPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("class/view");
        modelAndView.addObject("classes", classRoomService.findById(id));
        return modelAndView;
    }
    @GetMapping("/{id}/students")
    public ModelAndView viewStudentOfClass(@PathVariable("id") String id,Pageable pageable) {
        Page<Student> students=studentService.findAllByDeletedIsFalseAndClassRoom(id,pageable);
        return new ModelAndView("class/class-students","studens",students);
    }

}
