package com.springboot.restful.service;

import com.springboot.restful.entities.Account;
import com.springboot.restful.repository.AccountRepository;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(accountRepository.findAll());
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Account account = accountRepository.findById(id).orElse(null);
        result.setData(account);
        return result;
    }

    public ServiceResult  create(Account account){
        ServiceResult result = new ServiceResult();
        result.setData(accountRepository.save(account));
        return result;
    }

    public ServiceResult  update(Account account){
        ServiceResult result = new ServiceResult();
        if (!accountRepository.findById(account.getAccountId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
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
            result.setMessage("Customer Not Found");
        } else {
            accountRepository.delete(account);
            result.setMessage("success");
        }

        return result;
    }
}
