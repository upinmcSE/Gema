package io.upinmcSE.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VerifySessionReq {
    private String token;
}
