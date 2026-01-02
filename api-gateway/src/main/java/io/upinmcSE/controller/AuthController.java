package io.upinmcSE.controller;

import io.upinmcSE.dto.ApiResponse;
import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.dto.response.CreateSessionResponse;
import io.upinmcSE.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

//    @GetMapping("/ping")
//    public Mono<String> ping(@RequestParam String name) {
//        return Mono.fromSupplier(() ->
//                authService.ping(PingRequest.newBuilder().setName(name).build()).getResponse()
//        );
//    }

    @PostMapping("/account")
    public ApiResponse<CreateAccountResponse> createAccount(@RequestBody AccountRequest request){
        return ApiResponse.<CreateAccountResponse>builder()
                .message("Create account success")
                .data(authService.createAccount(request))
                .build();
    }

    @PostMapping("/session")
    public ApiResponse<CreateSessionResponse> createSession(@RequestBody AccountRequest request){
        return ApiResponse.<CreateSessionResponse>builder()
                .message("Create session success")
                .data(null)
                .build();
    }

}
