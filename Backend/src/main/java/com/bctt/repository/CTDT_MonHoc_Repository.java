package com.bctt.repository;

import com.bctt.model.CTDT;
import com.bctt.model.CTDT_MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTDT_MonHoc_Repository extends JpaRepository<CTDT_MonHoc, Long> {
    List<CTDT_MonHoc> findByCtdtMaCTDT(String maCTDT);
    List<CTDT_MonHoc> findByCtdtIn(List<CTDT> ctdts);
}
