package dn.codegym.crm.controller;

import dn.codegym.crm.constants.AppConsts;
import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.repository.CampaignRepository;
import dn.codegym.crm.service.CampaignService;
import dn.codegym.crm.service.ClassRoomService;
import dn.codegym.crm.service.LeadService;
import dn.codegym.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @Autowired
    private LeadService leadService;

    @GetMapping("/list")
    public ModelAndView listCampaign(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("campaign/list");
        Page<Campaign> campaigns = campaignService.findAllByDeletedIsFalse(pageable);
        modelAndView.addObject("campaigns", campaigns);
        modelAndView.addObject("campaign", new CampaignDTO());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("campaign/create");
        modelAndView.addObject("campaign", new CampaignDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCampaign(@Valid @ModelAttribute("campaign") CampaignDTO campaign, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "campaign/create";
        } else {
            campaignService.create(campaign);
            redirect.addFlashAttribute("message", "New campaign created successfully!");
            return "redirect:/campaigns/list";
        }
    }

    @GetMapping("/searchName")
    public ModelAndView findAllByName(@ModelAttribute("name") String name, Pageable pageable) {
        Page<Campaign> campaigns = campaignService.searchName(name, pageable);
        return new ModelAndView("campaign/list", "campaigns", campaigns);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        CampaignDTO campaignDTO = campaignService.findById(id);
        if (campaignDTO != null) {
            ModelAndView modelAndView = new ModelAndView("campaign/edit");
            modelAndView.addObject("campaign", campaignDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/edit")
    public String updateCourse(@Valid @ModelAttribute("campaign") CampaignDTO campaignDTO, BindingResult bindingResult,
                               RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "campaign/edit";
        }
        campaignService.update(campaignDTO);
        redirect.addFlashAttribute("message", "Campaign updated successfully!");
        return "redirect:/campaigns/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id, RedirectAttributes redirect, Pageable pageable) {
        CampaignDTO campaignDTO = campaignService.findById(id);
        campaignService.delete(campaignDTO.getId(), pageable);
        redirect.addFlashAttribute("message", "Campaign deleted successfully!");
        return "redirect:/campaigns/list";
    }

    @GetMapping("/addLead/{campaignId}")
    public ModelAndView viewAddLeads(@PathVariable String campaignId, Model model, Pageable pageable) {
        Page<Lead> leads = leadService.findAllByDeletedIsFalseAndCampaignNull(pageable);
        model.addAttribute("campaign", campaignService.findById(campaignId));
        return new ModelAndView("campaign/addLeads", "leads", leads);
    }

    @GetMapping("/addLeads/{campaignId}/{leadId}")
    public String addLeads(@PathVariable("leadId") String leadId, @PathVariable("campaignId") String campaignId, RedirectAttributes redirect) {
        LeadDTO leadDTO = leadService.findById(leadId);
        CampaignDTO campaignDTO = campaignService.findById(campaignId);
        leadDTO.setCampaign(campaignService.findByCampaignId(campaignDTO.getId()));
        leadService.update(leadDTO);
        redirect.addFlashAttribute("message", "Add lead into campaign successfully!");
        return "redirect:/campaigns/addLead/{campaignId}";
    }

    @GetMapping("/viewLeads/{campaignId}")
    public ModelAndView viewLeadsOfCampaign(@PathVariable String campaignId, Model model, Pageable pageable) {
        Page<Lead> leads = leadService.findAllByCampaignId(campaignId, pageable);
        model.addAttribute("campaign", campaignService.findById(campaignId));
        return new ModelAndView("campaign/viewLeads", "leads", leads);
    }
}