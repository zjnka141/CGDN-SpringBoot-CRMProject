package dn.codegym.crm.controller;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @Autowired
    private LeadService leadService;

    @Autowired
    private ReadFromExcelFileService readFromExcelFileService;

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
        ModelAndView modelAndView = new ModelAndView("campaign/list", "campaigns", campaigns);
        if (campaigns.getTotalElements() == 0) {
            modelAndView.addObject("message", "No results were found");
            return modelAndView;
        } else {
            return modelAndView;
        }
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
    public String updateCampaign(@Valid @ModelAttribute("campaign") CampaignDTO campaignDTO, BindingResult bindingResult,
                                 RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "campaign/edit";
        }
        campaignService.update(campaignDTO);
        redirect.addFlashAttribute("message", "Campaign updated successfully!");
        return "redirect:/campaigns/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCampaign(@PathVariable String id, RedirectAttributes redirect, Pageable pageable) {
        campaignService.delete(id, pageable);
        redirect.addFlashAttribute("message", "Campaign deleted successfully!");
        return "redirect:/campaigns/list";
    }

    @GetMapping("/viewLeads/{campaignId}")
    public ModelAndView viewLeadsOfCampaign(@PathVariable String campaignId, Model model, Pageable pageable) {
        Page<Lead> leads = leadService.findAllByCampaignId(campaignId, pageable);
        model.addAttribute("campaign", campaignService.findById(campaignId));
        return new ModelAndView("campaign/viewLeads", "leads", leads);
    }

    @GetMapping("/{campaignId}/createLeadCampaign")
    public ModelAndView createLeadOfCampaign(@PathVariable String campaignId) {
        ModelAndView modelAndView = new ModelAndView("campaign/createLeadCampaign", "campaignId", campaignId);
        modelAndView.addObject("lead", new LeadDTO());
        return modelAndView;
    }

    @PostMapping("/{campaignId}/createLeadCampaign")
    public String saveLeadCampaign(@PathVariable("campaignId") String campaignId, @Valid @ModelAttribute("lead") LeadDTO lead, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/campaign/createLeadCampaign";
        } else {
            leadService.createLeadOfCampaign(lead, campaignId);
            redirect.addFlashAttribute("message", "New lead campaign created successfully!");
            return "redirect:/campaigns/viewLeads/{campaignId}";
        }
    }

    @GetMapping("/viewLeads/edit/{leadId}")
    public ModelAndView showEditFormOfLeadCampaign(@PathVariable("leadId") String id) {
        LeadDTO leadDTO = leadService.findById(id);
        if (leadDTO != null) {
            ModelAndView modelAndView = new ModelAndView("campaign/editLeadCampaign");
            modelAndView.addObject("lead", leadDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error 404");
        }
    }

    @PostMapping("/viewLeads/{campaignId}/edit")
    public String updateLead(@Valid @ModelAttribute("lead") LeadDTO leadDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        System.out.print("abc "+ leadDTO.getId()+"   "+leadDTO.getCampaign().getId());
        if (bindingResult.hasErrors()) {
            return "campaign/editLeadCampaign";
        } else {
            leadService.updateLeadOfCampaign(leadDTO);
            redirect.addFlashAttribute("message", "Lead updated successfully!");
            return "redirect:/campaigns/viewLeads/{campaignId}";
        }
    }

    @GetMapping("/viewLeads/delete/{campaignId}/{leadId}")
    public String deleteLeadCampaign(@PathVariable("leadId") String leadId, RedirectAttributes redirect) {
        leadService.delete(leadId);
        redirect.addFlashAttribute("message", "Lead Campaign deleted successfully!");
        return "redirect:/campaigns/viewLeads/{campaignId}";
    }

    @GetMapping("/viewLeads/{campaignId}/searchName")
    public ModelAndView searchLeadOfCampaign(@PathVariable("campaignId") String campaignId, @ModelAttribute("name") String name, Pageable pageable) {
        Page<Lead> leads = leadService.findAllByDeletedIsFalseAndNameContainingAndCampaignNotNull(name, pageable);
        ModelAndView modelAndView = new ModelAndView("campaign/viewLeads", "campaign", campaignService.findById(campaignId));
        modelAndView.addObject("leads", leads);
        if (leads.getTotalElements() == 0) {
            modelAndView.addObject("message", "No results were found");
            return modelAndView;
        } else {
            return modelAndView;
        }
    }

    @GetMapping("/viewLeads/move/{campaignId}/{leadId}")
    public String moveLeadOfCampaignToLeadCenter(@PathVariable("leadId") String leadId, RedirectAttributes redirect) {
        leadService.moveLeadCampaignToLeadCenter(leadId);
        redirect.addFlashAttribute("message", "Move Lead of campaign to Lead Of Center successfully!");
        return "redirect:/campaigns/viewLeads/{campaignId}";
    }

    @GetMapping("/viewLeads/{campaignId}/link")
    public String importExcel(@RequestParam("file") File file, @PathVariable("campaignId") String campaignId, RedirectAttributes redirect) throws IOException {
        List<LeadDTO> leadDTOS = readFromExcelFileService.readBooksFromExcelFile(file.getAbsolutePath());
        for (int i = 0; i < leadDTOS.size(); i++) {
            LeadDTO leadDTO = new LeadDTO();
            leadDTO = leadDTOS.get(i);
            leadService.createLeadOfCampaign(leadDTO, campaignId);
        }
        return "redirect:/campaigns/viewLeads/{campaignId}";
    }
}