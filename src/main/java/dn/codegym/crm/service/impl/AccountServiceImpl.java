package dn.codegym.crm.service.impl;

import dn.codegym.crm.dto.AccountDTO;
import dn.codegym.crm.entity.Account;
import dn.codegym.crm.repository.AccountRepository;
import dn.codegym.crm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void create(AccountDTO accountDTO) {
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setRole(accountDTO.getRole());
        accountRepository.save(account);
    }

    @Override
    public Iterable<Account> getListAccounts() {
        return accountRepository.findAll();
    }
}
