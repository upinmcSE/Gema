package io.upinmcSE.repository;

import io.upinmcSE.entity.DownloadTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadTaskRepository extends JpaRepository<DownloadTask, Long> {
}
