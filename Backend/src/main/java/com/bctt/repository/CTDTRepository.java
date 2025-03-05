package com.bctt.repository;

import com.bctt.model.CTDT;
import com.bctt.model.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTDTRepository extends JpaRepository<CTDT,String> {
    List<CTDT> findByNganhAndNamDaotao(Nganh nganh, String namDaotao);
}
