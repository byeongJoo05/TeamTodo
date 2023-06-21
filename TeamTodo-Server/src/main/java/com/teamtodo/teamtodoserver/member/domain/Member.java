package com.teamtodo.teamtodoserver.member.domain;

import java.time.LocalDateTime;

import com.teamtodo.teamtodoserver.common.domain.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    private String name;

    private String password;

    private String nickname;
}
