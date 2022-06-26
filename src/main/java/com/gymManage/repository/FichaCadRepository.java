package com.gymManage.repository;


import com.gymManage.modules.FichaCadModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaCadRepository extends JpaRepository<FichaCadModels, Integer> {
}
