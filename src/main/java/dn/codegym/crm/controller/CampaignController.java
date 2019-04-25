package dn.codegym.crm.controller;

import dn.codegym.crm.dto.CampaignDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/list")
    public ModelAndView listCampaign() {
        ModelAndView modelAndView = new ModelAndView("campaign/list");
        modelAndView.addObject("campaigns", campaignService.findAllByDeletedIsFalse());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCampaign(@PathVariable String id) {
        CampaignDTO campaignDTO = campaignService.findById(id);
        if (campaignDTO != null) {
            ModelAndView modelAndView = new ModelAndView("campaign/view");
            modelAndView.addObject("campaign", campaignDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("campaign/create");
        modelAndView.addObject("campaign", new CampaignDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCampaign(@ModelAttribute("campaign") CampaignDTO campaign, RedirectAttributes redirect) {
        campaignService.create(campaign);
        redirect.addFlashAttribute("message", "New campaign created successfully!");
        return "redirect:/campaigns/list";
    }
    @GetMapping("/searchName")
    public ModelAndView findAllByName(@ModelAttribute("name")String name){
        return new ModelAndView("campaign/list","campaigns",campaignService.searchName(name));
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
    public String updateCourse(@ModelAttribute("campaign") CampaignDTO campaignDTO, RedirectAttributes redirect) {
        campaignService.update(campaignDTO);
        redirect.addFlashAttribute("message", "Campaign updated successfully!");
        return "redirect:/campaigns/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable String id) {
        CampaignDTO campaignDTO = campaignService.findById(id);
        if (campaignDTO != null) {
            ModelAndView modelAndView = new ModelAndView("campaign/delete");
            modelAndView.addObject("campaign", campaignDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/delete")
    public String deleteCourse(@ModelAttribute("campaign") CampaignDTO campaignDTO, RedirectAttributes redirect) {
        campaignService.delete(campaignDTO.getId());
        redirect.addFlashAttribute("message", "Campaign deleted successfully!");
        return "redirect:/campaigns/list";
    }
}
