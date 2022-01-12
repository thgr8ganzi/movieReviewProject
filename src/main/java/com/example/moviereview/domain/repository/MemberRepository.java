package com.example.moviereview.domain.repository;

import com.example.moviereview.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}