package com.springboot.restful.service;

import com.springboot.restful.entities.Role;
import com.springboot.restful.repository.RoleRepository;
import com.springboot.restful.utilities.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public ServiceResult findAll(){
        ServiceResult result = new ServiceResult();
        result.setData(roleRepository.findAll());
        return result;
    }
    public ServiceResult  findById(int id){
        ServiceResult result = new ServiceResult();
        Role role = roleRepository.findById(id).orElse(null);
        result.setData(role);
        return result;
    }

    public ServiceResult  create(Role role){
        ServiceResult result = new ServiceResult();
        result.setData(roleRepository.save(role));
        return result;
    }

    public ServiceResult  update(Role role){
        ServiceResult result = new ServiceResult();
        if (!roleRepository.findById(role.getRoleId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            result.setData(roleRepository.save(role));
        }
        return result;
    }

    public ServiceResult  delete(int id){
        ServiceResult result = new ServiceResult();
        Role role = roleRepository.findById(id).orElse(null);
        if (role == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer Not Found");
        } else {
            roleRepository.delete(role);
            result.setMessage("success");
        }

        return result;
    }
}
