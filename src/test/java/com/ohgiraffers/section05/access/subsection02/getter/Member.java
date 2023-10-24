package com.ohgiraffers.section05.access.subsection02.getter;

import javax.persistence.*;
import java.util.Date;

@Entity(name="member_section05_subsection02")
@Table(name="tbl_member_section05_subsection02")//테이블과 매핑하겠다. 존재하지 않는테이블은 만들으면서 하겠다는걸 설정에 추가해줌
//@Access(AccessType.PROPERTY)//클래스레벨: 모든 필드에 대해 getter 접근방식 사용
//주의할점 : @Id 어노테이션이 필드레벨에 있으면 엔터티 생성이 안되므로 getter 메소드 위로 옮겨야함.
public class Member {
    @Id//필드 접근이 아닌경우 @Id는
    @Column(name="member_no")

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
    @Access(AccessType.PROPERTY)//메소드 레벨 : 해당 값의 접근 방식만 getter로 변경한다.

    //일반적으로는 필드 접근을 사용하지만, getter로 접근하면 가공 확인 등의 코드를 작성해서 사용할수 있다.
    public String getNickname() {
        System.out.println("getNickname()를 이용한 access 확인 ..");
        return nickname + "님";
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
