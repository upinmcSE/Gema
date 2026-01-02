package io.upinmcSE.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_account_pwd")
public class AccountPassword extends BaseEntity {
    @Id
    @Column(name = "of_account_id")
    private Long ofAccountId;

    private String password;
}
