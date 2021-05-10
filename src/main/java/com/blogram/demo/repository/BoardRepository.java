package com.blogram.demo.repository;

import com.blogram.demo.domain.Board;
import com.blogram.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
