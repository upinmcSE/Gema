package io.upinmcSE.service.impl;

import io.upinmcSE.dto.request.AccountRequest;
import io.upinmcSE.dto.request.VerifySessionReq;
import io.upinmcSE.dto.response.CreateAccountResponse;
import io.upinmcSE.dto.response.CreateSessionResponse;
import io.upinmcSE.dto.response.VerifySessionRes;

public interface AuthService {
    CreateAccountResponse createAccount(AccountRequest request);
    CreateSessionResponse createSession(AccountRequest request);
    VerifySessionRes verifySession(VerifySessionReq request);
}
