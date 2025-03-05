package com.bctt.repository;

import com.bctt.dto.reponse.MonTTResponse;
import com.bctt.model.MonThayThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonTTRepository extends JpaRepository<MonThayThe,Long> {
    @Query("SELECT m FROM MonThayThe m WHERE m.monhoc.maMonHoc = :maMonHoc")
    List<MonThayThe> findAllByMonhoc(@Param("maMonHoc") String maMonHoc);
}
