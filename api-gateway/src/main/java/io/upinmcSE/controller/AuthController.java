package io.upinmcSE.controller;

import io.upinmcSE.grpc.gen.PingRequest;
import io.upinmcSE.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/ping")
    public Mono<String> ping(@RequestParam String name) {
        return Mono.fromSupplier(() ->
                authService.ping(PingRequest.newBuilder().setName(name).build()).getResponse()
        );
    }

}
