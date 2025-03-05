package com.bctt.repository;

import com.bctt.model.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NganhRepository extends JpaRepository<Nganh,String> {
    Optional<Nganh> findByTenNganh(String tenNganh);
}
