package kr.co.pick.entity;

import jakarta.persistence.*;
import kr.co.pick.dto.request.MemberReqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "identity", unique = true)
    private String identity;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public Member(String identity,
                  String password,
                  String name,
                  String nickname,
                  String gender,
                  LocalDate birthDate,
                  Tag tag) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.tag = tag;
    }

    public void updateMember(MemberReqDto updateMember, Tag updateTag) {
        this.password = updateMember.getPassword();
        this.name = updateMember.getName();
        this.nickname = updateMember.getNickname();
        this.birthDate = updateMember.getBirthDate();
        this.gender = updateMember.getGender();
        this.tag = updateTag;
    }

}
