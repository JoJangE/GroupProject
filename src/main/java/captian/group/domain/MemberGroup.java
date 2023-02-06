package captian.group.domain;

import javax.persistence.*;

@Entity
public class MemberGroup {

    @Id @GeneratedValue
    @Column(name = "member_group_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
