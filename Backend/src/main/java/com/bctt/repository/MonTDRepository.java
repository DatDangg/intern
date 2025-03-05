package com.bctt.repository;

import com.bctt.model.MonTonDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonTDRepository extends JpaRepository<MonTonDong,Long> {
    @Query("SELECT m FROM MonTonDong m WHERE m.nganh.maNganh = :maNganh AND m.nganh.namDaotao = :namDaotao")
    List<MonTonDong> findByNganhMaNganhAndNganhNamDaotao(@Param("maNganh") String tenNganh, @Param("namDaotao") String namDaotao);
}