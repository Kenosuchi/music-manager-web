package com.springboot.restful.repository;

import com.springboot.restful.entities.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenerRepository extends JpaRepository<Listener,Integer> {

}
