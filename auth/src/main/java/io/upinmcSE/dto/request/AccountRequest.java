package io.upinmcSE.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String accountName;
    private String password;
}
