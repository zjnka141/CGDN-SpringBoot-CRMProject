package dn.codegym.crm.controller;

import dn.codegym.crm.dto.AccountDTO;
import dn.codegym.crm.service.AccountService;
import dn.codegym.crm.validator.AccountDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDTOValidator accountDTOValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == AccountDTO.class) {
            dataBinder.setValidator(accountDTOValidator);
        }
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("account/create");
        modelAndView.addObject("account", new AccountDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveAccount(@Valid @ModelAttribute("account") AccountDTO accountDTO,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "account/create";
        }
        accountService.create(accountDTO);
        return "account/create";
    }
}
