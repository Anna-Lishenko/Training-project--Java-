package com.spring.dao;

import java.io.Serializable;
import java.util.List;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;
import com.spring.entity.Matrix;

public interface MatrixDAO extends Serializable {
	
	List<Matrix> findAll() throws DatastoreException;
	List<Matrix> findAll(int id) throws DatastoreException;
	Integer getCount() throws DatastoreException;
	public Matrix update(Matrix entity) throws UpdateException;
	public Matrix findById(int id) throws DatastoreException;
	void deleteById(int id) throws RemoveException;
	Matrix create(Matrix entity) throws CreateException;
}
