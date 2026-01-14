package io.upinmcSE.repository;

import io.upinmcSE.repository.dto.VerifySessionReq;
import io.upinmcSE.repository.dto.VerifySessionRes;
import io.upinmcSE.pojo.CommonResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@Component
public interface IdentityClient {
    @PostExchange(url = "/auth/verify", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<CommonResult<VerifySessionRes>> introspect(@RequestBody VerifySessionReq request);
}
