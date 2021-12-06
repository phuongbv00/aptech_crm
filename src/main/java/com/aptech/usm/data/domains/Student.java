package com.aptech.usm.data.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String identityCard;
    private Instant birthday;
    private String phone;
    private String email;

    private Long accountId;
}
