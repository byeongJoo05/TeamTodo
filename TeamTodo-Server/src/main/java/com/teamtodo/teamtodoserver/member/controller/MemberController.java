package com.teamtodo.teamtodoserver.member.controller;

import com.teamtodo.teamtodoserver.member.dto.MemberDTO;
import com.teamtodo.teamtodoserver.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public Map<String, Long> register(@RequestBody MemberDTO memberDTO) {
        Map<String, Long> resultMap = new HashMap<>();

        Long mid = memberService.register(memberDTO);

        resultMap.put("mid", mid);

        return resultMap;
    }
}
