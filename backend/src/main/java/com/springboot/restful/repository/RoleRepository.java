package com.springboot.restful.repository;

import com.springboot.restful.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select * from role r where r.role_name = :name",nativeQuery = true)
    Role findRoleByName(@Param("name") String name);
}
