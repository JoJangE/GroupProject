package captian.group.Service;

import captian.group.Dto.LoginRes;
import captian.group.Repository.JPAUserRepository;
import captian.group.User.User;
import captian.group.common.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional // 이걸 붙여야 persist 인식 가능
public class UserService {

    private JPAUserRepository userRepository;
    private JwtProvider jwtProvider;

    @Autowired
    public UserService(JPAUserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public User createUser(String email, String password, String name, String nickname) {
        return userRepository.createUser(email, password, name, nickname);
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public LoginRes login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            // 1. user를 findByEmail(Repository) -> 없으면 예외처리 -> 위에 까지 끝!
            LoginRes loginRes = new LoginRes(false, "존재하지 않는 계정입니다.");
            return loginRes;
        }
        User user = userOptional.get();
        if (!password.equals(user.getPassword())) {
            // 2. 해당 유저의 비밀번호와 request로 들어온 비밀번호가 같아야 함 -> false
            LoginRes loginRes = new LoginRes(false, "비밀번호가 일치하지 않습니다.");
            return loginRes;
        }

        // 3. 같으면 true
        String accessToken = jwtProvider.issueAccessToken(user);
        String refreshToken = jwtProvider.issueRefreshToken(user);
        return new LoginRes(true, "로그인 성공", accessToken, refreshToken);
    }
}
