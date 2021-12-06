package com.aptech.usm.data.domains;

import com.aptech.usm.utils.enums.AccountRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private AccountRoleEnum role;
}
