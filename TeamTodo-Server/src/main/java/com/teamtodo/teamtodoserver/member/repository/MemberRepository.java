package com.teamtodo.teamtodoserver.member.repository;

import com.teamtodo.teamtodoserver.member.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}