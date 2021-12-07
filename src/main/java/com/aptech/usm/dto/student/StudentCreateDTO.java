package com.aptech.usm.dto.student;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDTO {
    private String username;
    private String password;

    private String fullName;
    private String identityCard;
    private LocalDate birthday;
    private String phone;
    private String email;
}
