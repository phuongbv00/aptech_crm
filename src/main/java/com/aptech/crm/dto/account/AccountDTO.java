package com.aptech.crm.dto.account;

import com.aptech.crm.utils.enums.AccountRoleEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String username;
    private AccountRoleEnum role;
}
