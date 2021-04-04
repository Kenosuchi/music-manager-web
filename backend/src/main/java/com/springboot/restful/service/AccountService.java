package com.springboot.restful.service;

import com.springboot.restful.dto.AccountDTO;
import com.springboot.restful.entities.Account;
import com.springboot.restful.entities.Role;
import com.springboot.restful.repository.AccountRepository;
import com.springboot.restful.utilities.ConvertDaoAndDto;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements ConvertDaoAndDto<Account, AccountDTO> {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleService roleService;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = convertEntitiesToDTOs(accounts);
        result.setData(accountDTOS);
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Account account = accountRepository.findById(id).orElse(null);
        assert account != null;
        AccountDTO accountDTO = new AccountDTO(account);
        result.setData(accountDTO);
        return result;
    }
    public ServiceResult checkUsername(String username){
        ServiceResult result = new ServiceResult();
        List<Account> listAccount = accountRepository.findAll();
        for (Account userExist : listAccount) {
            if (username.equals(userExist.getAccountUsername())){
                return result;
            }
        }
        result.setStatus(ServiceResult.Status.FAILED);
        return result;
    }
    public ServiceResult loadAccountByAccountName(String username){
        ServiceResult result = new ServiceResult();
        List<Account> listAccount = accountRepository.findAll();
        for (Account user : listAccount) {
            if (user.getAccountUsername().equals(username)) {
                result.setData(user);
                return result;
            }
        }
        result.setStatus(ServiceResult.Status.FAILED);
        return result;
    }
    public ServiceResult  create(AccountDTO accountDTO){
        ServiceResult result = new ServiceResult();
        Account account = convertDTOtoEntity(accountDTO);
        result.setData(accountRepository.save(account));
        return result;
    }

    public ServiceResult  update(AccountDTO accountDTO){
        ServiceResult result = new ServiceResult();
        Account account = convertDTOtoEntity(accountDTO);
        if (!accountRepository.findById(account.getAccountId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Account Not Found");
        } else {
            result.setData(accountRepository.save(account));
        }
        return result;
    }

    public ServiceResult  delete(int id){
        ServiceResult result = new ServiceResult();
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Account Not Found");
        } else {
            accountRepository.delete(account);
            result.setMessage("success");
        }

        return result;
    }

    @Override
    public Account convertDTOtoEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAccountUsername(accountDTO.getAccountUsername());
        account.setAccountPassword(accountDTO.getAccountPassword());
        Role role = (Role) roleService.findRoleByName(accountDTO.getRole()).getData();
        if(role==null)
            role = new Role(accountDTO.getRole());
        account.setAccountRole(role);
        return account;
    }

    @Override
    public List<AccountDTO> convertEntitiesToDTOs(List<Account> entity) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for(Account account: entity){
            accountDTOS.add(new AccountDTO(account));
        }
        return accountDTOS;
    }
}
