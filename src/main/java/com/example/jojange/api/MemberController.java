package com.example.jojange.api;

import com.example.jojange.domain.Member;
import com.example.jojange.dto.GetMemberResponseDto;
import com.example.jojange.dto.LoginReq;
import com.example.jojange.dto.LoginRes;
import com.example.jojange.dto.MemberDto;
import com.example.jojange.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/create")
    @ResponseBody
    public Member CreateMember(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto.getEmail(), memberDto.getPassword(), memberDto.getName(), memberDto.getNickname());
    }

    // 회원 정보 조회 (pw는 포함하면 절대 안됨)!!!!! - Dto 새로 만들기
    @GetMapping("/{id}")
    @ResponseBody
    public GetMemberResponseDto getMember(@PathVariable Long id) {
        return new GetMemberResponseDto(memberService.getMember(id));
    }


    @PostMapping("/login")
    @ResponseBody
    public LoginRes login(@RequestBody LoginReq loginReq) {
        return memberService.login(loginReq.getEmail(), loginReq.getPassword());
    }

}
