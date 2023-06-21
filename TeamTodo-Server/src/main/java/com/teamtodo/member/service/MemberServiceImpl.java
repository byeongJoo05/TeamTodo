package com.teamtodo.member.service;

import com.teamtodo.member.domain.Member;
import com.teamtodo.member.dto.MemberDTO;
import com.teamtodo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
}
