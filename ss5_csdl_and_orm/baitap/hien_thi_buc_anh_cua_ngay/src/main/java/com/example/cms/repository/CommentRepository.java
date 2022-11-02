package com.example.cms.repository;

import com.example.cms.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where  c.id=:id", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            em.merge(comment);
        } else {
            em.persist(comment);
        }
    }

    @Override
    public void remove(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            em.remove(comment);
        }
    }
}
