package com.bctt.repository;

import com.bctt.model.ThoiKhoaBieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface TKBRepository extends JpaRepository<ThoiKhoaBieu, Long> {

    @Query("SELECT t FROM ThoiKhoaBieu t WHERE t.namHoc = :namHoc AND t.kiHoc = :kiHoc")
    List<ThoiKhoaBieu> findThoiKhoaBieuByNamHocAndKiHoc(
            @Param("namHoc") String namHoc,
            @Param("kiHoc") String kiHoc);

    // Phương thức mới: lọc theo năm học, kỳ học và nhóm học
    @Query("SELECT t FROM ThoiKhoaBieu t WHERE t.namHoc = :namHoc AND t.kiHoc = :kiHoc AND t.nhomHoc = :nhomHoc")
    List<ThoiKhoaBieu> findThoiKhoaBieuByNamHocAndKiHocAndNhomHoc(
            @Param("namHoc") String namHoc,
            @Param("kiHoc") String kiHoc,
            @Param("nhomHoc") String nhomHoc);

    @Query("SELECT t FROM ThoiKhoaBieu t WHERE t.namHoc = :namHoc")
    List<ThoiKhoaBieu> findThoiKhoaBieuByNamHoc(@Param("namHoc") String namHoc);
}
