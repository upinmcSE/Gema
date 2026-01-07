package io.upinmcSE.entity;

import io.upinmcSE.entity.enums.DownloadStatus;
import io.upinmcSE.entity.enums.DownloadType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_download_task")
public class DownloadTask extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "of_account_id")
    private long ofAccountId;

    @Enumerated(EnumType.STRING)
    private DownloadType downloadType;

    private String url;

    @Enumerated(EnumType.STRING)
    private DownloadStatus downloadStatus;
}
