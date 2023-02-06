package captian.group;

import captian.group.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init1();
        initService.init2();
        initService.init3();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;


        public void init1() {
            Member member = createMember("김명균1", "kyun9151@naver.com");
            em.persist(member);
        }
        public void init2() {
            Member member = createMember("김명균2", "kyun9151@gmail.com");
            em.persist(member);
        }

        public void init3() {
            Member member = createMember("김명균3", "mkmkmk000@daum.net");
            em.persist(member);
        }

        private Member createMember(String name, String email) {
            Member member = new Member();
            member.setName(name);
            member.setEmail(email);
            return member;
        }
    }
}
