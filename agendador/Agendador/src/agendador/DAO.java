/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendador;

import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author clodoaldo
 */
public class DAO<T> {

    private static EntityManager em
            = Persistence.createEntityManagerFactory("AgendadorPU").createEntityManager();
    private Class classe;

    public DAO(Class classe) {
        this.classe = classe;
    }

    public void insert(T entidade) {
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    public void update(T entidade) {
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public void remove(int id) {
        T entidade = get(id);
        if (entidade == null) {
            return;
        }
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
    }

    public T get(int id) {
        return (T) em.find(classe, id);
    }

    public List<T> list() {
        return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e").getResultList();
    }

    public List<T> listByNome(String nome) {
        return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e WHERE e.nome LIKE '%" + nome + "%'").getResultList();
    }

    public void close() {
        em.close();
    }

}
