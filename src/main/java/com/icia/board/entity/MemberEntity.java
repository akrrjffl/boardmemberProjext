package com.icia.board.entity;

import com.icia.board.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // length = 20 -> 영문자 기준 20자 (varchar)
    // nullable = false -> 입력을 안했을 경우 오류가 뜨는 것이 아닌 없는 값으로 처리 (not null)
    // unique = true -> 중복체크를 할 것인지 (primary key)
    @Column(length = 50, unique = true)
    private String memberEmail;

    @Column(length = 50)
    private String memberPassword;

    @Column(length = 20)
    private String memberName;

    @Column(length = 20, unique = true)
    private String memberMobile;

    @Column(length = 20)
    private String memberBirth;

    @Column
    private int memberProfile;

    @Column
    private String createdAt;

    @Column
    private int fileAttached;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberEntity.getMemberPassword());
        memberEntity.setMemberName(memberEntity.getMemberName());
        memberEntity.setMemberMobile(memberEntity.getMemberMobile());
        memberEntity.setMemberBirth(memberEntity.getMemberBirth());
        memberEntity.setMemberProfile(memberEntity.getMemberProfile());
        return memberEntity;
    }
}
