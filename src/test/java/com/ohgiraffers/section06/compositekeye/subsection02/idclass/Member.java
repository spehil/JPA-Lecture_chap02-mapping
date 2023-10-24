package com.ohgiraffers.section06.compositekeye.subsection02.idclass;

import com.ohgiraffers.section06.compositekeye.subsection01.embedded.MemberPK;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "member_section06_subsection02")
@Table(name = "tbl_member_section06_subsection02")
@IdClass(MemberPK.class)//클래스레벨에 MemberPK클래스에 Id클래스로 사용하고 있다고 작성
public class Member {
    @Id
    @Column(name = "member_no")
    private int memberNo;

    @Id
    @Column(name ="member_id")
    private String memberId;

    @Column(name = "phone")
    private  String phone;

    @Column(name = "address")
    private String address;

    public Member() {
    }

    public Member(int memberNo, String memberId, String phone, String address) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
