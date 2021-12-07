package com.aptech.usm.dto.account;

import com.aptech.usm.utils.enums.AccountRoleEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateDTO {
    private String username;
    private String password;
    private AccountRoleEnum role;
}
