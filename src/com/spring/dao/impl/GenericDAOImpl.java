package com.spring.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;
import com.spring.dao.GenericDAO;

@Transactional
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@Autowired(required = true)
	protected SessionFactory sessionFactory;
	
	
	@SuppressWarnings({"unchecked"})
    protected Class<T> getEntityClass() {
        ParameterizedType ptype = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) ptype.getActualTypeArguments()[0];
    }
	
    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }
	
	public T create(T entity) throws CreateException {
		try	{
			sessionFactory.getCurrentSession().save(entity);
			return entity;
		} catch (Exception e) {
			throw new CreateException(e);
		}
	}

	public T update(T entity) throws UpdateException {
		try {
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            return entity;
        } catch (Exception e) {
            throw new UpdateException(e);
        }
	}
	
	public T merge(T entity) throws DatastoreException{
		try {
            sessionFactory.getCurrentSession().merge(entity);
            return entity;
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
	}

	public void delete(T entity) throws RemoveException {
		try {
            sessionFactory.getCurrentSession().delete(entity);
        } catch (Exception e) {
            throw new RemoveException(e);
        }
	}

	public void deleteById(int id) throws RemoveException {
		try {
            delete(findById(id));
        } catch (Exception e) {
            throw new RemoveException(e);
        }
	}

	@SuppressWarnings("unchecked")
	public T findById(int id) throws DatastoreException {
		try {
            return (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(int startRow, int maxRows) throws DatastoreException {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM " + getEntityClass().getCanonicalName() + " e");
        if (startRow >= 0) {
        	query.setFirstResult(startRow);
        }
        if (maxRows >= 0) {
        	query.setMaxResults(maxRows);
        }
        return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(int id) throws DatastoreException {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM " + getEntityClass().getCanonicalName() + " e" + " where MatrixID = " + id);
        return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DatastoreException {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM " + getEntityClass().getCanonicalName() + " e");
        return query.list();
	}

	public Integer getCount() throws DatastoreException {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(e) FROM " + getEntityClass().getCanonicalName() + " e");
        Long count = (Long) query.uniqueResult();
        if (count == null) {
            return 0;
        }
        return count.intValue();
	}
	
	@SuppressWarnings("unchecked")
    public List<T> executeQueryList(String queryString, int startRow, int maxRows) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            if (startRow >= 0) {
            	query.setFirstResult(startRow);
            }
            if (maxRows >= 0) {
            	query.setMaxResults(maxRows);
            }
            return query.list();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }
	
    public Object executeQuerySingleResult(String queryString) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }

	@SuppressWarnings("unchecked")
    public List<T> executeNamedQueryList(String namedQuery, Object[] params) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter("p" + (i + 1), params[i]);
                }
            }
            return query.list();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T executeNamedQuery(String namedQuery, Object[] params) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter("p" + (i + 1), params[i]);
                }
            }
            return (T) query.uniqueResult();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }

    public void executeUpdateQuery(String namedQuery, Object[] params) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter("p" + (i + 1), params[i]);
                }
            }
            query.executeUpdate();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }
    
    public void executeNativeUpdateQuery(String queryString, Object[] params) throws DatastoreException {
        try {
            Query query = sessionFactory.getCurrentSession().createSQLQuery(queryString);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter("p" + (i + 1), params[i]);
                }
            }
            query.executeUpdate();
        } catch (Exception e) {
            throw new DatastoreException(e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
