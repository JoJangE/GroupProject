package captian.group.repository;

import captian.group.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // 회원저장
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    // 한 명 찾기
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 반환
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 이름으로 회원 찾기
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
