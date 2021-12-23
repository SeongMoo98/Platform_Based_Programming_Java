package com.fm.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class PlayerRepository implements IRepository{
    private final Class<Player> domainType;
    private final EntityManager em;
    public static final String
            SELECT_ALL_QUERY_STRING = "select x from %s x";
    private Club club = new Club();
    private Country country = new Country();

    public PlayerRepository(Class<Player> domainType,
                         EntityManager entityManager) {
        this.domainType = domainType;
        this.em = entityManager;
    }

    @Override
    public void save(Player t) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            club = t.getClub();
            country = t.getCountry();
            club.getPlayers().add(t);
            country.getPlayers().add(t);
            em.persist(club);
            em.persist(country);
            em.persist(t);
            tx.commit();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void deleteById(int id) {
        Optional<Player> entity = findById(id);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(entity.orElseThrow(()
                    -> new RuntimeException(
                    String.format("No %s entity with id %s exists!", domainType, id))));
            tx.commit();
        } catch (Exception ex){
            ex.printStackTrace(); tx.rollback();
        }
    }

    @Override
    public List<Player> findAll() {
        return em.createQuery(getSelectAllQueryString(), domainType).getResultList();
    }

    @Override
    public Optional<Player> findById(int id) {
        return Optional.ofNullable(em.find(domainType, id));
    }

    private String getSelectAllQueryString() {
        return String.format(SELECT_ALL_QUERY_STRING,
                domainType.getSimpleName());
    }

}
