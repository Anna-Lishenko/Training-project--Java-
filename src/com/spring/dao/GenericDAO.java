package com.spring.dao;

import java.util.List;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;

public interface GenericDAO<T> {

	public T create(T entity) throws CreateException;

	T update(T entity) throws UpdateException;

	List<T> findAll(int startRow, int maxRows) throws DatastoreException;
	List<T> findAll(int id) throws DatastoreException;
	List<T> findAll() throws DatastoreException;
	public T findById(int id) throws DatastoreException;
	Integer getCount() throws DatastoreException;
	void deleteById(int id) throws RemoveException;
	//void setSessionFactory(SessionFactory sessionFactory);

	public void flush();
}
