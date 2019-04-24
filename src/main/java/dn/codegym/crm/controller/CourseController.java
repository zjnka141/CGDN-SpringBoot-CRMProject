package dn.codegym.crm.controller;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("course/create");
        modelAndView.addObject("course", new CourseDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCourse(@ModelAttribute("course") CourseDTO courseDTO, RedirectAttributes redirect) {
        courseService.create(courseDTO);
        redirect.addFlashAttribute("message", "New course created successfully!");
        return "redirect:/courses/list";
    }

    @GetMapping("/list")
    public ModelAndView listCourses() {
        ModelAndView modelAndView = new ModelAndView("course/list");
        modelAndView.addObject("courses", courseService.findAllByDeletedIsFalse());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        CourseDTO courseDTO = courseService.findById(id);
        if (courseDTO != null) {
            ModelAndView modelAndView = new ModelAndView("course/edit");
            modelAndView.addObject("course", courseDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/edit")
    public String updateCourse(@ModelAttribute("course") CourseDTO courseDTO, RedirectAttributes redirect) {
        courseService.update(courseDTO);
        redirect.addFlashAttribute("message", "Course updated successfully!");
        return "redirect:/courses/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        CourseDTO courseDTO = courseService.findById(id);
        if (courseDTO != null) {
            ModelAndView modelAndView = new ModelAndView("course/delete");
            modelAndView.addObject("course", courseDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/delete")
    public String deleteCourse(@ModelAttribute("course") CourseDTO courseDTO, RedirectAttributes redirect) {
        courseService.delete(courseDTO.getId());
        redirect.addFlashAttribute("message", "Course deleted successfully!");
        return "redirect:/courses/list";
    }
}
