package com.example.jojange.service;

import com.example.jojange.common.JwtProvider;
import com.example.jojange.domain.Member;
import com.example.jojange.dto.LoginRes;
import com.example.jojange.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;


    public Member createMember(String email, String password, String name, String nickname) {
        return memberRepository.createMember(email, password, name, nickname);
    }

    public Member getMember(Long id) {
        return memberRepository.getMember(id);
    }

    public LoginRes login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isEmpty()) {
            // 1. user를 findByEmail(Repository) -> 없으면 예외처리 -> 위에 까지 끝!
            LoginRes loginRes = new LoginRes(false, "존재하지 않는 계정입니다.");
            return loginRes;
        }
        Member member = memberOptional.get();
        if (!password.equals(member.getPassword())) {
            // 2. 해당 유저의 비밀번호와 request로 들어온 비밀번호가 같아야 함 -> false
            LoginRes loginRes = new LoginRes(false, "비밀번호가 일치하지 않습니다.");
            return loginRes;
        }

        // 3. 같으면 true
        String accessToken = jwtProvider.issueAccessToken(member);
        String refreshToken = jwtProvider.issueRefreshToken(member);
        return new LoginRes(true, "로그인 성공", accessToken, refreshToken);
    }
}
