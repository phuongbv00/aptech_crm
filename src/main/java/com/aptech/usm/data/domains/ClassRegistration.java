package com.aptech.usm.data.domains;

import com.aptech.usm.utils.enums.ClassRegistrationStatusEnum;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant registrationTime;

    @Builder.Default
    private ClassRegistrationStatusEnum status = ClassRegistrationStatusEnum.ACTIVE;

    private Long classroomId;
    private Long studentId;
}
