package com.fm.repository;

/**
 * Managing Entity
 * Entity Manager가 Entity Manage한다
 * EntityManagerFactory를 통해 create해야한다
 *
 * EntityManager
 * Each EntityManager instance는 persistence context(set of entity instances)에 연관이 있다
 * ==> EntityManager interface는 persistence context와 interact
 *
 * EntityTransaction
 * Data를 "변경"하는 작업은 모두 Transaction안에서 이루어져야 한다(단순 조회는 상관 x)
 * EntityManager가 commit하기 전까지 Database에 저장하지않고 Query저장소에 SQL을 모아두었다가
 * commit()하면 변경
 * 왜냐하면 오류가 나면 rollback()할꺼기 때문이다
 *
 * LifeCycle of EntityManager instance
 * 1. create a new, isolated persistence context
 * 2. EntityManager, PersistenceContext는 같이 생성,같이 소멸(close)
 *
 * LifeCycle of Entity instance
 * NEW - 객체를 new
 * MANAGED - EntityManager.persist() - 객체(instance)를 Persistence Context에 등록한다
 * DETACHED - EntityManager.clear(),close()
 * REMOVED - EntityManager.remove()
 * DB와 Transaction
 *
 * DB에서 가져와 MANAGED State로
 * EntityManager.find() - entity의 Primary Key로 find
 * EntityManager.query() - SQL로 Find
 *
 * MANAGED State에서 Entity의 값을 바꾸고 Transaction.commit()하면
 * 변경된 값이 DB에 등록된다el
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaEntityTest {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em= emf.createEntityManager();
        Club club = new Club();
        club.setName("PNU");

        EntityTransaction tx= em.getTransaction();
        try{
            tx.begin();
            //Entity의 값을 바꾸려면 Transaction내에서 다뤄야한다
            Player player= em.find(Player.class,1L);
            player.setClub(club);
            //Club을 Persistence Context에 새로 등록
            club.getPlayers().add(player);
            em.persist(club);
            //commit()
            tx.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

        System.out.printf("%d, %s\n", club.getId(), club.getName());
    }
}
