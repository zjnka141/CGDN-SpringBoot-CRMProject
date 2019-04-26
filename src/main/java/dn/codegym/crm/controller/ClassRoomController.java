package dn.codegym.crm.controller;

import dn.codegym.crm.dto.ClassRoomDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("classes")
public class ClassRoomController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/create")
    public ModelAndView createClassRoom() {
        ModelAndView modelAndView = new ModelAndView("class/create");
        modelAndView.addObject("classes",new ClassRoom());
        modelAndView.addObject("message","congratulation you to created new class");
        return modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView listClassesPage() {
        ModelAndView modelAndView = new ModelAndView("class/list");
        modelAndView.addObject("classes", classRoomService.findAllByDeletedIsFalse());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveClass(@ModelAttribute("classes")ClassRoomDTO classRoomDTO, RedirectAttributes redirect) {
        classRoomService.save(classRoomDTO);
        redirect.addFlashAttribute("message", "New Class created successfully!");
        return "redirect:/classes/list";
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewClassPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("class/view");
        modelAndView.addObject("classes",classRoomService.findById(id));
        return modelAndView;

    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditClassPage(@PathVariable String id) {
        ClassRoomDTO classRoomDTO = classRoomService.findById(id);
        ModelAndView modelAndView = new ModelAndView("class/edit");
        modelAndView.addObject("classes",classRoomDTO);
        return modelAndView;
    }
    @PostMapping("/update")
    public String editClass(@ModelAttribute("classes") ClassRoomDTO classRoomDTO,RedirectAttributes redirect) {
        classRoomService.update(classRoomDTO);
        redirect.addFlashAttribute("message","updated succesful!!");
        return "redirect:/classes/list";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteClassPage(@PathVariable String id) {
        ClassRoomDTO classRoomDTO =classRoomService.findById(id);
        if(classRoomDTO!=null) {
            ModelAndView modelAndView = new ModelAndView("class/delete");
            modelAndView.addObject("classes",classRoomDTO);
            return modelAndView;
        }
        return new ModelAndView("error404");
    }
    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("classes") ClassRoomDTO classRoomDTO,RedirectAttributes redirect) {
        studentService.delete(classRoomDTO.getId());
        redirect.addFlashAttribute("message", "delete successfull");
        return "redirect:/classes/list";
    }
}
