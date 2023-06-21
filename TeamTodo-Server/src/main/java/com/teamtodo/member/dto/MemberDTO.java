package com.teamtodo.member.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 멤버 회원가입을 위해 DTO가 필요하다.
* DTO를 만드는 이유는 Controller <-> Repository 데이터 이동을 위해 사용된다.
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long mid;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;


}