package io.upinmcSE.service;

import com.nimbusds.jose.JOSEException;
import io.upinmcSE.entity.Account;

import java.text.ParseException;
import java.util.Date;

public interface JwtService {
    String generateJwt(Account account, boolean isRefresh);
    boolean isJwtValid(String token, boolean isRefresh) throws JOSEException, ParseException;
    String extractAccountName(String token) throws ParseException;
    Date extractExpiration(String token);
}
