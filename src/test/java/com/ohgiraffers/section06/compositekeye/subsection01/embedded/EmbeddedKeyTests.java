package com.ohgiraffers.section06.compositekeye.subsection01.embedded;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmbeddedKeyTests {
    private  static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public  static void initFactoty(){

        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");

    }

    @BeforeEach//EntityManager는 매번 만들어져야하므로 test하나가 수행되기 전마다 수행되는 BeforeEach 작성
    public void initManager(){

        entityManager = entityManagerFactory.createEntityManager();

    }

    @AfterAll //BeforeAll과 AfterAll은 static으로 작성한다.
    public  static  void closeFactory(){

        entityManagerFactory.close();
    }


    @AfterEach
    public void closeManager(){
        entityManager.close();
    }

    @Test
    public void 임베디드_아이디_사용한_복합키_테이블_매핑_테스트(){
        //given
        Member member = new Member();
        member.setMemberPK(new MemberPK(1,"user01"));
        member.setPhone("010-1234-5678");
        member.setAddress("서울시 종로구");
        //wheb
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member);
        entityTransaction.commit();
        //then
        Member foundMember = entityManager.find(Member.class, member.getMemberPK());//find()는 PK값으로 가져오니까..member.getMemberPK()가 복합키에서PK이크로
        assertEquals(member.getMemberPK(), foundMember.getMemberPK());

    }

}
