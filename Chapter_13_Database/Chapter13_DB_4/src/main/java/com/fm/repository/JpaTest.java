package com.fm.repository;
/**
 * JPA (Java Persistence API)
 * OR(Object - Relation) Mapping을 제공한다
 *
 * OR Mapping
 * Object <--> Relation DB Table
 *
 * 1. The Java Persistence API
 * 2. The Query Language
 * 3. The Java Persistence Criteria API
 * 4. Object/Relational Mapping metadata (OR Mapping)
 *
 * Architecture
 * persistence.xml - Database 하나에 Mapping 된다
 * persistenece.xml을 EntityManagerFactory에 Loading 한다, JDBC Connection Pool을 자동 생성
 * EntityManagerFactory는 EntityManager를 create
 *
 * Entity
 * DataBase의 논리적 구성요소
 * ==> Database에서 표현하려는 무형(Not Instance)의 개체 ==> Class
 *
 * EntityManager
 * Entity를 저장, 수정, 삭제, 조회 등등 관리를 한다
 * 내부에 Persistence Context라는 Memory 공간을 둔다
 * 명령어에 따라 Table(DB)에 저장
 *
 * Persistence Context
 * 모든 Persistence Entity ID의 고유한 Entity Instance가 있는 Entity Instance Set
 * Entity를 영구저장(영속) 하는 환경
 *
 */

import javax.persistence.*;

public class JpaTest {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.find(Player.class,1L));
    }
}
