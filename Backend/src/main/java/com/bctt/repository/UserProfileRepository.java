package com.bctt.repository;

import com.bctt.model.User_profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<User_profile, Long> {
}
