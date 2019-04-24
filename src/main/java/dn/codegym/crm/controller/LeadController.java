package dn.codegym.crm.controller;

import dn.codegym.crm.dto.CourseDTO;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("lead/create");
        modelAndView.addObject("lead", new Lead());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveLead(@ModelAttribute("lead") Lead lead, RedirectAttributes redirect) {
        leadService.save(lead);
        redirect.addFlashAttribute("message", "New course created successfully!");
        return "redirect:/leads/list";
    }

    @GetMapping("/list")
    public ModelAndView listLeads() {
        ModelAndView modelAndView = new ModelAndView("lead/list");
        modelAndView.addObject("leads", leadService.findAllByDeletedIsFalse());
        return modelAndView;

    }
}