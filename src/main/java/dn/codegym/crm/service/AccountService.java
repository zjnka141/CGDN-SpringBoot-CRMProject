package dn.codegym.crm.service;

import dn.codegym.crm.dto.AccountDTO;
import dn.codegym.crm.entity.Account;

public interface AccountService {
    void create(AccountDTO accountDTO);
    Iterable<Account> getListAccounts();
}
