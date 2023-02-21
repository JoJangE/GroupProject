package com.example.jojange.dto;

import com.example.jojange.domain.Member;
import lombok.Getter;

@Getter
public class GetMemberResponseDto {
    private String email;
    private String name;
    private String nickname;

    public GetMemberResponseDto(String email, String name, String nickname) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public GetMemberResponseDto(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickname = member.getNickname();
    }
}
