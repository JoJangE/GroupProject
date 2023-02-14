package captian.group.Dto;

import captian.group.User.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDto {

    private String email;
    private String name;
    private String nickname;

    public  GetUserResponseDto(String email, String name, String nickname) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public GetUserResponseDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.nickname = user.getNickname();
    }
}
