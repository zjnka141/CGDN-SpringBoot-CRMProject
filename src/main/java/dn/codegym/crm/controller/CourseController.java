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
        ModelAndView modelAndView = new ModelAndView("courses/create");
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCourse(@ModelAttribute("course") CourseDTO course, RedirectAttributes redirect) {
        courseService.save(course);
        redirect.addFlashAttribute("message", "New course created successfully!");
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView listCourses() {
        ModelAndView modelAndView = new ModelAndView("courses/list");
        modelAndView.addObject("courses", courseService.findAllByDeletedIsFalse());
        return modelAndView;
    }
}
