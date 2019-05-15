package dn.codegym.crm.controller;

import dn.codegym.crm.dto.LeadDTO;
import dn.codegym.crm.dto.LeadDetailDTO;
import dn.codegym.crm.dto.StudentDTO;
import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.ClassRoom;
import dn.codegym.crm.entity.Lead;
import dn.codegym.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private LeadDetailService leadDetailService;


    @ModelAttribute("classes")
    public Page<ClassRoom> classRooms(Pageable pageable) {
        return classRoomService.findAllByDeletedIsFalse(pageable);
    }

    @ModelAttribute("campaigns")
    public Iterable<Campaign> campaigns() {
        return campaignService.findAllByDeletedIsFalse();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("lead/create");
        modelAndView.addObject("lead", new LeadDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveLead(@Valid @ModelAttribute("lead") LeadDTO lead, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/lead/create";
        } else {
            leadService.create(lead);
            redirect.addFlashAttribute("message", "New lead created successfully!");
            return "redirect:/leads/list";
        }
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
    public String updateLead(@Valid @ModelAttribute("lead") LeadDTO leadDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "lead/edit";
        } else {
            leadService.update(leadDTO);
            redirect.addFlashAttribute("message", "Lead updated successfully!");
            return "redirect:/leads/list";
        }
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

    @GetMapping("/consulting/{leadId}")
    public ModelAndView leadDetail(@PathVariable String leadId, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("lead/consulting");
        modelAndView.addObject("leadDetails", leadDetailService.findAllByLeadId(leadId, pageable));
        modelAndView.addObject("lead", leadService.findById(leadId));
        return modelAndView;
    }

    @GetMapping("consulting/create/{leadId}")
    public ModelAndView createConsulting(@PathVariable String leadId) {
        ModelAndView modelAndView = new ModelAndView("lead/create-lead-detail");
        modelAndView.addObject("leadDetail", new LeadDetailDTO());
        modelAndView.addObject("lead", leadService.findById(leadId));
        return modelAndView;
    }

    @PostMapping("/consulting/create/{leadId}")
    public String saveConsulting(@PathVariable String leadId, @ModelAttribute("leadDetail") LeadDetailDTO leadDetail, RedirectAttributes redirect) {
        leadDetailService.create(leadDetail, leadId);
        return "redirect:/leads/consulting/{leadId}";
    }

    @GetMapping("/consulting/edit/{leadDetailId}")
    public ModelAndView showEditLeadDetailForm(@PathVariable String leadDetailId) {
        LeadDetailDTO leadDetailDTO = leadDetailService.findById(leadDetailId);
        if (leadDetailDTO != null) {
            ModelAndView modelAndView = new ModelAndView("lead/edit-lead-detail");
            modelAndView.addObject("leadDetail", leadDetailDTO);
            return modelAndView;
        } else {
            return new ModelAndView("error 404");
        }
    }

    @GetMapping("/move/{lead_id}")
    public ModelAndView moveLeadToStudent(@PathVariable("lead_id") String leadId, Model model) {
        LeadDTO leadDTO = leadService.findById(leadId);
        StudentDTO studentDTO;
        if (leadDTO == null) {
            return null;
        } else {
            studentDTO = studentService.moveLeadToStudent(leadDTO);
            model.addAttribute("lead", leadDTO);
            model.addAttribute("student", studentDTO);
            return new ModelAndView("lead/move");
        }
    }
    @PostMapping("/move")
    public String moveLeadToStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult,
                                    RedirectAttributes redirect, Model model) {
        if (bindingResult.hasFieldErrors()) {
            LeadDTO leadDTO = leadService.findById(studentDTO.getId());
            model.addAttribute("lead", leadDTO);
            model.addAttribute("student", studentDTO);
            return "/lead/move";
        } else {
            studentService.save(studentDTO);
            leadService.delete(studentDTO.getId());
            return "redirect:/leads/list";
        }
    }
}