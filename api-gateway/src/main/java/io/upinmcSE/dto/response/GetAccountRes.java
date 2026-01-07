package io.upinmcSE.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetAccountRes {
    private long accountId;
    private String accountName;
}
