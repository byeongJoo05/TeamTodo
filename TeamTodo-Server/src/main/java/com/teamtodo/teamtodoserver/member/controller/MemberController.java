package com.teamtodo.teamtodoserver.member.controller;

import com.teamtodo.teamtodoserver.member.dto.MemberDTO;
import com.teamtodo.teamtodoserver.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Map<String, Long>> register(@Valid @RequestBody MemberDTO memberDTO) {
        Map<String, Long> resultMap = new HashMap<>();

        Long mid = memberService.register(memberDTO);

        resultMap.put("mid", mid);

        return ResponseEntity.ok(resultMap);
    }

    @GetMapping("/email")
    public ResponseEntity<Map<String, Boolean>> duplicateEmail(@Valid @RequestParam String email) {
        Map<String, Boolean> resultMap = new HashMap<>();

        Boolean result = memberService.duplicateEmail(email);

        resultMap.put("result", result);

        return ResponseEntity.ok(resultMap);
    }

    @GetMapping("/nickname")
    public ResponseEntity<Map<String, Boolean>> duplicateNickname(@Valid @RequestParam String nickname) {

        Map<String, Boolean> resultMap = new HashMap<>();

        Boolean result = memberService.duplicateNickname(nickname);

        resultMap.put("result", result);

        return ResponseEntity.ok(resultMap);
    }
}
