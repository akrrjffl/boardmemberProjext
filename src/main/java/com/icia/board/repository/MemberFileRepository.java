package com.icia.board.repository;

import com.icia.board.entity.MemberFIleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFileRepository extends JpaRepository<MemberFIleEntity, Long> {
}