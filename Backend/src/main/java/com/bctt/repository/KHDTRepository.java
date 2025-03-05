package com.bctt.repository;

import com.bctt.model.KHDT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KHDTRepository extends JpaRepository<KHDT, Long> {
    List<KHDT> findByNhomHocAndNamHoc(String nhomHoc, String namHoc);
}
