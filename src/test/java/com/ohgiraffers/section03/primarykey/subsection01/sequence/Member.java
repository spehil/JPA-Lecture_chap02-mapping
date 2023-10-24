package com.ohgiraffers.section03.primarykey.subsection01.sequence;

import javax.persistence.*;
import java.util.Date;

@Entity(name="member_section03_subsection01")
@Table(name="tbl_member_section03_subsection01")//테이블과 매핑하겠다. 존재하지 않는테이블은 만들으면서 하겠다는걸 설정에 추가해줌
@SequenceGenerator(
        name = "member_sequence_generator",//시퀀스 제너레이터 명칭, 식별자 생성기 이름
        sequenceName =  "SEQ_MEMBER_NO", //시퀀스 오브젝트(객체)이름, 데이터 베이스 시퀀스 객체명
        initialValue = 5, //시퀀스 시작값 설정
        allocationSize = 1 )//시퀀스 증가값 설정 JPA에 기본값으로 50이 되어있는데, 값끼리 충돌이 없게하려고 하는건데 우리는 시퀀스 증가값1로 지정해줌
public class Member {
    @Id
    @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "member_sequence_generator")
    private int memberNo;
    @Column(name="member_id")
    private String memberId;
    @Column(name="member_pwd")
    private String memberPwd;
    @Column(name="nickname")
    private String nickname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="enroll_date")
    private Date enrollDate;

    @Column(name="member_role")
    private String memberRole;
    @Column(name="status")
    private String status;
    public Member() {}
    public Member(int memberNo, String memberId, String memberPwd, String nickname, String phone,
                  String email, String address, Date enrollDate, String memberRole, String status) {
        super();
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }
    public String getMemberRole() {
        return memberRole;
    }
    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
                + ", nickname=" + nickname + ", phone=" + phone + ", email=" + email
                + ", address=" + address + ", enrollDate=" + enrollDate + ", memberRole=" + memberRole
                + ", status=" + status + "]";
    }
}
