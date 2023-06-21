package com.teamtodo.teamtodoserver.member.service;

import com.teamtodo.teamtodoserver.member.dto.MemberDTO;

public interface MemberService {
    public Long register(MemberDTO memberDTO);
}
