/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tpermpuesto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rosario
 */
public class TpermpuestoJpaController implements Serializable {

    public TpermpuestoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tpermpuesto tpermpuesto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tpermpuesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tpermpuesto tpermpuesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tpermpuesto = em.merge(tpermpuesto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tpermpuesto.getId();
                if (findTpermpuesto(id) == null) {
                    throw new NonexistentEntityException("The tpermpuesto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tpermpuesto tpermpuesto;
            try {
                tpermpuesto = em.getReference(Tpermpuesto.class, id);
                tpermpuesto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tpermpuesto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tpermpuesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tpermpuesto> findTpermpuestoEntities() {
        return findTpermpuestoEntities(true, -1, -1);
    }

    public List<Tpermpuesto> findTpermpuestoEntities(int maxResults, int firstResult) {
        return findTpermpuestoEntities(false, maxResults, firstResult);
    }

    private List<Tpermpuesto> findTpermpuestoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tpermpuesto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tpermpuesto findTpermpuesto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tpermpuesto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTpermpuestoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tpermpuesto> rt = cq.from(Tpermpuesto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
