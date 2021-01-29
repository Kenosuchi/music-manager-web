package com.springboot.restful.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_account")
public class Account {
    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name="account_username")
    private String accountUsername;

    @Column(name="account_password")
    private String accountPassword;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "account_role")
    private Role accountRole;

}
