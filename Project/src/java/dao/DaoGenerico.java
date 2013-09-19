package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author a1136917
 */
public class DaoGenerico<T> {

    private static EntityManager em = Persistence.createEntityManagerFactory("UP").createEntityManager();
    private Class classe;

    public DaoGenerico(Class classe) {
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

    public List<T> list() {
        return em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e").getResultList();
    }
 public void remove(Long id) {
        T e = obter(id);
        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
    }

    public T obter(Long id) {
        return (T) em.find(classe, id);
    }
 
}
