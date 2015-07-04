/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Tablas.Tpermcarrera;
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
public class TpermcarreraJpaController implements Serializable {

    public TpermcarreraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tpermcarrera tpermcarrera) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tpermcarrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tpermcarrera tpermcarrera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tpermcarrera = em.merge(tpermcarrera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tpermcarrera.getId();
                if (findTpermcarrera(id) == null) {
                    throw new NonexistentEntityException("The tpermcarrera with id " + id + " no longer exists.");
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
            Tpermcarrera tpermcarrera;
            try {
                tpermcarrera = em.getReference(Tpermcarrera.class, id);
                tpermcarrera.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tpermcarrera with id " + id + " no longer exists.", enfe);
            }
            em.remove(tpermcarrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tpermcarrera> findTpermcarreraEntities() {
        return findTpermcarreraEntities(true, -1, -1);
    }

    public List<Tpermcarrera> findTpermcarreraEntities(int maxResults, int firstResult) {
        return findTpermcarreraEntities(false, maxResults, firstResult);
    }

    private List<Tpermcarrera> findTpermcarreraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tpermcarrera.class));
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

    public Tpermcarrera findTpermcarrera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tpermcarrera.class, id);
        } finally {
            em.close();
        }
    }

    public int getTpermcarreraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tpermcarrera> rt = cq.from(Tpermcarrera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
