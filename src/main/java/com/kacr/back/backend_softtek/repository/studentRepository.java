package com.kacr.back.backend_softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kacr.back.backend_softtek.entity.studentEntity;

@Repository
public interface studentRepository extends JpaRepository<studentEntity, Integer> {
}
