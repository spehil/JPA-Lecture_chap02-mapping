package com.ohgiraffers.section03.primarykey.subsection01.sequence;



import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimaryKeyMappingTests {
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
    public void 식별자_매핑_테스트() {
//given
      Member member = new Member();

        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1234-5678");
        member.setAddress("서울시 종로구");
        member.setEnrollDate(new Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");


        Member member2 = new Member();
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("유관순");
        member2.setPhone("010-4567-8910");
        member2.setAddress("서울시 마포구");
        member2.setEnrollDate(new Date());
        member2.setMemberRole("ROLE_MEMBER");
        member2.setStatus("Y");
//when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member);
        entityManager.persist(member2);
        entityTransaction.commit();
//then
      String jpql = "SELECT A.memberNo FROM member_section03_subsection01 A";
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();//createQuery:아직 쿼리를 실행한 상태는 아니고 이렇게 해석해서 하겠다는 선언을 한것이다. createQuery(jpql, Integer.class):수행하고자하는 엔티티구문을 넘겨준다 jpql, 결과시 반환타입
        //getResultList() : 여러개의 값을 반환을때 사용
        memberNoList.forEach(System.out::println);
    }




}
