package com.bctt.repository;

import com.bctt.model.Chianhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChianhomRepository extends JpaRepository<Chianhom, Long> {
    List<Chianhom> findByNamHocAndKhoa(String namHoc, String khoa);
}
