package io.upinmcSE.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateAccountResponse {
    private long accountId;
}
