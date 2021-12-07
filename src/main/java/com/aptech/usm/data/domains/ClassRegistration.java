package com.aptech.usm.data.domains;

import com.aptech.usm.utils.enums.ClassRegistrationStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
public class ClassRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant registrationTime;
    private ClassRegistrationStatusEnum status = ClassRegistrationStatusEnum.ACTIVE;

    private Long classroomId;
    private Long studentId;
}
