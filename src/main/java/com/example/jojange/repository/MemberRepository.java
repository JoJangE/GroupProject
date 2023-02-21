package com.example.jojange.repository;

import com.example.jojange.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Member createMember(String email, String passwd, String name, String nickname) {
        if (isDuplicate(email)) {
            throw new IllegalArgumentException("해당 이메일로 가입된 유저가 이미 존재합니다.");
        }
        Member member = new Member(email, passwd, name, nickname);
        em.persist(member);
        return member;
    }

    public Member getMember(Long id) {
        Member member = em.find(Member.class, id);
        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return member;
    }

    public Optional<Member> findByEmail(String emailParam) {
        List<Member> member = em.createQuery("select m from Member m where m.email=:email", Member.class)
                .setParameter("email", emailParam)
                .getResultList();

        return member.stream().findAny();
    }

    private boolean isDuplicate(String email) {
        if (findByEmail(email).isEmpty()) {
            return false;
        }
        return true;
    }
}
