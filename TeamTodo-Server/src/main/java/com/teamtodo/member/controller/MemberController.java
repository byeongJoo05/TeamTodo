package com.teamtodo.member.controller;

import com.teamtodo.member.dto.MemberDTO;
import com.teamtodo.member.service.MemberService;
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

    @PostMapping("/member")
    public Map<String, Long> register(@Valid @RequestBody MemberDTO memberDTO) {
        Map<String, Long> mid = new HashMap<>();

        Long mid = memberService.register(memberDTO);
    }
}
