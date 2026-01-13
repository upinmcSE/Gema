package io.upinmcSE.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifySessionReq {
    private String token;
}
