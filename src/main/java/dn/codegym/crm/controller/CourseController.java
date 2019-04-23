package dn.codegym.crm.controller;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Course;
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
    public String saveCourse(@ModelAttribute("course") CourseDTO course, RedirectAttributes redirect) {
        courseService.save(course);
        redirect.addFlashAttribute("message", "New course created successfully!");
        return "redirect:/courses/list";
    }

    @GetMapping("/list")
    public ModelAndView listCourses() {
        ModelAndView modelAndView = new ModelAndView("course/list");
        modelAndView.addObject("courses", courseService.findAllByDeletedIsFalse());
        return modelAndView;
    }
}
