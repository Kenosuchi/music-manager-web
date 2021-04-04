package com.springboot.restful.dto;

import com.springboot.restful.entities.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private int accountId;
    private String accountUsername;
    private String accountPassword;
    private String role;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.accountUsername = account.getAccountUsername();
        this.accountPassword = account.getAccountPassword();
        role = account.getAccountRole().getRoleName();
    }
}
