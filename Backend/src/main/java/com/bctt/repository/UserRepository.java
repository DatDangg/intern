package com.bctt.repository;

import com.bctt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailDN(String email);  // ✅ Tìm user theo email
}
