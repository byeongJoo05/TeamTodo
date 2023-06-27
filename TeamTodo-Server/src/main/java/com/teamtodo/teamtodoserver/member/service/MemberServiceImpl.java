package com.teamtodo.teamtodoserver.member.service;

import com.teamtodo.teamtodoserver.member.domain.Member;
import com.teamtodo.teamtodoserver.member.dto.MemberDTO;
import com.teamtodo.teamtodoserver.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    private final ModelMapper modelMapper;

    // 회원가입 메서드
    @Override
    public Long register(MemberDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        Long mid = memberRepository.save(member).getMid();

        return mid;
    }

    @Override
    public Boolean duplicateEmail(String email) {
        Boolean result = memberRepository.existsMembersByEmail(email);

        return result;
    }

    @Override
    public Boolean duplicateNickname(String nickname) {
        Boolean result = memberRepository.existsMembersByNickname(nickname);

        return result;
    }
}
