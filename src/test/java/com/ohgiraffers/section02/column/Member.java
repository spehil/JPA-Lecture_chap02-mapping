package com.ohgiraffers.section02.column;

import javax.persistence.*;
import java.util.Date;

@Entity(name="member_section02")
@Table(name="tbl_member_section02")//테이블과 매핑하겠다. 존재하지 않는테이블은 만들으면서 하겠다는걸 설정에 추가해줌
public class Member {
    @Id
    @Column(name="member_no")
    private int memberNo;
    @Column(name="member_id", length= 20)
    private String memberId;
    @Column(name="member_pwd")
    private String memberPwd;
    @Column(name="nickname")
    @Transient //필드를 통해서 테이블 매핑을 할때 무시하겠다는 의미, 사용x (닉네임은 테이블생성시 만들어지지 않는다)
    private String nickname;
    @Column(name="phone", columnDefinition = "varchar2(200) default '010-0000-0000'")//디폴트값으로 작성해줌
    private String phone;
    @Column(name="email" , unique = true)//고유값이여야한다.
    private String email;
    @Column(name="address", nullable = false)//반드싀 입력해야하는 값으로 지정
    private String address;
    @Column(name="enroll_date")
    @Temporal(TemporalType.TIMESTAMP) //DATE + TIME :날짜 및 시간
   // @Temporal(TemporalType.DATE) //오라클에서는 TIMESTAMP와 동일
   // @Temporal(TemporalType.TIME) //1970/01/01에 시간만 맞게 나옴 날짜는 고정이고 시간만 맞게 나옴

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
