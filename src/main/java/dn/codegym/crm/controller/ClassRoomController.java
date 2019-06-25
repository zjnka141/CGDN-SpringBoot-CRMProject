package dn.codegym.crm.controller;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Product;
import dn.codegym.crm.entity.Student;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.ProductService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("classes")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StudentService studentService;

    @ModelAttribute("course")
    public Page<Product> courses(Pageable pageable) {
        return productService.findAllByDeletedIsFalse(pageable);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("class/create");
        modelAndView.addObject("classes", new ClassRoomDTO());
        modelAndView.addObject("message", "Congratulation you to created new class");
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveClassRoom(@Valid @ModelAttribute("classes") ClassRoomDTO classRoomDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "class/create";
        } else {
            classRoomService.save(classRoomDTO);
            redirectAttributes.addFlashAttribute("message", "New Class created successfully!");
            return "redirect:/classes/list";
        }
    }

    @GetMapping("/list")
    public ModelAndView listClassRoomPage(@RequestParam("name") Optional<String> name, Pageable pageable) {
        Page<ClassRoom> classRooms;
        ModelAndView modelAndView = new ModelAndView("class/list");
        // TODO : START -- Please move all code in here to Service
        if (name.isPresent()) {
            classRooms = classRoomService.findAllByDeletedIsFalseAndNameContaining(name.get(), pageable);
            modelAndView.addObject("name", name.get());
            if (classRooms.getTotalElements() == 0) {
                modelAndView.addObject("message", "Class is not found!");
            }
        } else {
                classRooms = classRoomService.findAllByDeletedIsFalse(pageable);
        }
        // TODO: END
        modelAndView.addObject("classes", classRooms);
        List<Integer> range = IntStream.rangeClosed(1,classRooms.getTotalPages()).boxed().collect(Collectors.toList());
        modelAndView.addObject("totalPage",range );
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
    public String editClass(@ Valid @ModelAttribute("classes") ClassRoomDTO classRoomDTO, RedirectAttributes redirect, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "class/edit";
        }else{
        classRoomService.update(classRoomDTO);
        redirect.addFlashAttribute("message", "updated is successful!!");
        return "redirect:/classes/list";
    }
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
    public ModelAndView viewStudentOfClass(@PathVariable("id") String id, Pageable pageable) {
        Page<Student> students = studentService.findAllByDeletedIsFalseAndClassRoom(id, pageable);
        return new ModelAndView("class/class-students", "students", students);
    }

}
