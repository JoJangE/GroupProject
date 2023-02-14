package captian.group.Controller;

import captian.group.Dto.GetUserResponseDto;
import captian.group.Dto.LoginReq;
import captian.group.Dto.LoginRes;
import captian.group.Dto.UserDto;
import captian.group.Service.UserService;
import captian.group.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/create")
    @ResponseBody
    public User CreateUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getNickname());
    }

    // 회원 정보 조회 (pw는 포함하면 절대 안됨)!!!!! - Dto 새로 만들기

    @GetMapping("/{id}")
    @ResponseBody
    public GetUserResponseDto getUser(@PathVariable int id) {
        return new GetUserResponseDto(userService.getUser(id));
    }

    @PostMapping("/login")
    @ResponseBody
    public LoginRes login(@RequestBody LoginReq loginReq) {
        return userService.login(loginReq.getEmail(), loginReq.getPassword());
    }

    // 로그인

    // 1. id도 존재하지 않음. message : "존재하지 않는 계정입니다" oooo

    // 2. id는 존재함.  pw 틀림 "message : 패스워드가 틀렸습니다" oooo

    // 3. id도 맞고, pw도 맞음 : "message : 로그인 성공" oooo
}
