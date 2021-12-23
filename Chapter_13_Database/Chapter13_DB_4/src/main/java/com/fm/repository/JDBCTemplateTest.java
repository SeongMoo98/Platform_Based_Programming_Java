package com.fm.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class JDBCTemplateTest {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em = emf.createEntityManager();
        JpaRepository<Player, Long> playerRepository = new JpaRepository(Player.class, em);
        Optional<Player> player = playerRepository.findById(1L);
        System.out.println(player.get());
        em.close();
        emf.close();
    }
}
