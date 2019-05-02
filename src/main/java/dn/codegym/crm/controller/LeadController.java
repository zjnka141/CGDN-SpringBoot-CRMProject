package dn.codegym.crm.controller;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.service.CampaignService;
import dn.codegym.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @Autowired
    private CampaignService campaignService;

    @ModelAttribute("campaigns")
    public Iterable<Campaign> campaigns(Pageable pageable){
        return campaignService.findAllByDeletedIsFalse(pageable);
    }

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
    public ModelAndView listLeads(@RequestParam("name") Optional<String> name, Pageable pageable) {
        Page<Lead> leads;
        ModelAndView modelAndView = new ModelAndView("lead/list");
        if (name.isPresent()) {
            leads = leadService.findAllByDeletedIsFalseAndNameContaining(name.get(), pageable);
            modelAndView.addObject("name", name.get());
            if (leads.getTotalElements() == 0) {
                modelAndView.addObject("message", "Lead name not found!");
            }
        } else {
            leads = leadService.findAllByDeletedIsFalse(pageable);
        }
        modelAndView.addObject("leads", leads);
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
    public ModelAndView listLeadsByStatus(@PathVariable String status, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("lead/list");
        modelAndView.addObject("leads", leadService.findAllByDeletedIsFalseAndStatusContaining(status, pageable));
        return modelAndView;
    }
}