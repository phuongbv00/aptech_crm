package com.aptech.crm.dto.account;

import com.aptech.crm.utils.enums.AccountRoleEnum;
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
