package captian.group.Repository;

import captian.group.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JPAUserRepository {

    private final EntityManager entityManager;

    public User createUser(String email, String passwd, String name, String nickname) {
        if (isDuplicate(email)) {
            throw new IllegalArgumentException("해당 이메일로 가입된 유저가 이미 존재합니다.");
        }
        User user = new User(email, passwd, name, nickname);
        entityManager.persist(user);
        return user;
    }

    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return user;
    }

    public Optional<User> findByEmail(String emailParam) {
        List<User> user = entityManager.createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", emailParam)
                .getResultList();

        return user.stream().findAny();
    }

    private boolean isDuplicate(String email) {
        if (findByEmail(email).isEmpty()) {
            return false;
        }
        return true;
    }
}
