package captian.group.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "group_members")
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRole roleType;

//    @Builder
//    public Member(Long id, String name, String email, String password) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
}
