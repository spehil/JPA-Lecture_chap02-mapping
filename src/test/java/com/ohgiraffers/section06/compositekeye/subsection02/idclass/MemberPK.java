package com.ohgiraffers.section06.compositekeye.subsection02.idclass;

import java.io.Serializable;
import java.util.Objects;

/*복합키 클래스는 반드시 직렬화 처리, equals&hashcode 오버라이딩 반드시 해주기 */

public class MemberPK implements Serializable {//복합키에 대한 대응 클랙스 //복합키처리는 반드시 직렬화 처리를 해줘야한다!!!! implements Serializable

    private  int memberNo;

    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
