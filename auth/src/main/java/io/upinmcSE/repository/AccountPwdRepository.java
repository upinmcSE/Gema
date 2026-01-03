package io.upinmcSE.repository;

import io.upinmcSE.entity.AccountPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountPwdRepository extends JpaRepository<AccountPassword, Integer> {
    Optional<AccountPassword> findAccountPasswordByOfAccountId(long accountId);
}
