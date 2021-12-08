package com.aptech.crm.services;

import com.aptech.crm.data.domains.Account;
import com.aptech.crm.data.domains.Student;
import com.aptech.crm.data.repositories.AccountRepository;
import com.aptech.crm.data.repositories.StudentRepository;
import com.aptech.crm.dto.student.StudentCreateDTO;
import com.aptech.crm.utils.enums.AccountRoleEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(PasswordEncoder passwordEncoder, AccountRepository accountRepository, StudentRepository studentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void create(StudentCreateDTO dto) {
        var acc = Account.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(AccountRoleEnum.STUDENT)
                .build();
        acc = accountRepository.save(acc);
        var std = Student.builder()
                .fullName(dto.getFullName())
                .identityCard(dto.getIdentityCard())
                .birthday(dto.getBirthday())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .accountId(acc.getId())
                .build();
        studentRepository.save(std);
    }
}
