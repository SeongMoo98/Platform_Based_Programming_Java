package com.fm.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class JDBCTemplateTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
        EntityManager em = emf.createEntityManager();

        //Club Class와 EntityManager를 Persistence Context를 만들고 DB에 저장할 수 있게 해줍니다
        JpaRepository<Club, Long> clubRepository = new JpaRepository<>(Club.class, em);

        Club club2 = new Club();
        club2.setId(99999L);
        club2.setName("PNU");
        clubRepository.save(club2);
        //Club의 ID로 id = 18503인 Club를 찾아 반환해줍니다
        Optional<Club> club = clubRepository.findById(18503L);
        System.out.println(club.get());
        //Club에는 List<Player2>가 있으므로 stream을 통해 출력해줍니다
        List<Player2> list = club.get().getPlayers();
        list.stream().forEach(System.out::println);
        em.close(); emf.close();
    }
}