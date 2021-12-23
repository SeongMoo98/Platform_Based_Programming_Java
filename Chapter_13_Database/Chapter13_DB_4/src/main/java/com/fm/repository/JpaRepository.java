package com.fm.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaRepository<T,ID> {
    private final Class<T> domainType;
    private final EntityManager em;
    public static final String SELECT_ALL_QUERY_STRING = "select x from %s x";

    public JpaRepository(Class<T> domainType, EntityManager em) {
        this.domainType = domainType;
        this.em = em;
    }

    public T save(T entity){
        EntityTransaction tx =em.getTransaction();
        try{
            tx.begin();
            em.persist(entity);
            tx.commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return entity;
    }

    public List<T> findAll(){
        return em.createQuery(getSelectAllQueryString(),domainType).getResultList();
    }

    public void deleteById(ID id){
        Optional<T> entity = findById(id);
        EntityTransaction tx =em.getTransaction();
        try{
            tx.begin();
            em.remove(entity.orElseThrow(()->new RuntimeException(String.format("No %s entity with id %s exist!",domainType,id))));
            tx.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }
    }

    public Optional<T> findById(ID id){
        return Optional.ofNullable(em.find(domainType,id));

    }



    private String getSelectAllQueryString() {
        return String.format(SELECT_ALL_QUERY_STRING,
                domainType.getSimpleName());
    }


}
