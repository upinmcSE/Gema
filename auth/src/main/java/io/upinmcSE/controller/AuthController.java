package io.upinmcSE.controller;

import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.request.VerifySessionReq;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.dto.response.CreateSessionResponse;
import io.upinmcSE.dto.response.VerifySessionRes;
import io.upinmcSE.pojo.CommonResult;
import io.upinmcSE.service.impl.AuthService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/account")
    @PermitAll
    public CommonResult<CreateAccountResponse> createAccount(@RequestBody @Valid AccountRequest request){
        return CommonResult.success(authService.createAccount(request));
    }

    @PostMapping("/session")
    @PermitAll
    public CommonResult<CreateSessionResponse> createSession(@RequestBody @Valid AccountRequest request){
        return CommonResult.success(authService.createSession(request));
    }

    @PostMapping("/verify")
    public CommonResult<VerifySessionRes> verifySession(@RequestBody @Valid VerifySessionReq request){
        return CommonResult.success(authService.verifySession(request));
    }

}
