package dn.codegym.crm.controller;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        modelAndView.addObject("lead", new LeadDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveLead(@ModelAttribute("lead") LeadDTO lead, RedirectAttributes redirect) {
        leadService.create(lead);
        redirect.addFlashAttribute("message", "New lead created successfully!");
        return "redirect:/leads/list";
    }

    @GetMapping("/list")
    public ModelAndView listLeads() {
        ModelAndView modelAndView = new ModelAndView("lead/list");
        modelAndView.addObject("leads", leadService.findAllByDeletedIsFalse());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        LeadDTO leadDTO = leadService.findById(id);
        if (leadDTO != null) {
            ModelAndView modelAndView = new ModelAndView("lead/edit");
            modelAndView.addObject("lead", leadDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error 404");
        }
    }

    @PostMapping("/edit")
    public String updateLead(@ModelAttribute("lead") LeadDTO leadDTO, RedirectAttributes redirect) {
        leadService.update(leadDTO);
        redirect.addFlashAttribute("message", "Lead updated successfully!");
        return "redirect:/leads/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        LeadDTO leadDTO = leadService.findById(id);
        if (leadDTO != null) {
            ModelAndView modelAndView = new ModelAndView("lead/delete");
            modelAndView.addObject("lead", leadDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error 404");
        }
    }

    @PostMapping("/delete")
    public String deleteLead(@ModelAttribute("lead") LeadDTO leadDTO, RedirectAttributes redirect) {
        leadService.delete(leadDTO.getId());
        redirect.addFlashAttribute("message", "Lead deleted successfully!");
        return "redirect:/leads/list";
    }

    @GetMapping("/status/{status}")
    public ModelAndView listLeadsByStatus(@PathVariable String status) {
        ModelAndView modelAndView = new ModelAndView("lead/list");
        modelAndView.addObject("leads", leadService.findAllByStatusContaining(status));
        return modelAndView;
    }
}