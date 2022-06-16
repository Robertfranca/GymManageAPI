package com.gymManage.repository;

import com.gymManage.modules.UserCadModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioCadRepository extends JpaRepository<UserCadModels, Long> {

    Optional<UserCadModels> findByEmail(String email);
}
