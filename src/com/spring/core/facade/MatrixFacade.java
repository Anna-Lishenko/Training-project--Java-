package com.spring.core.facade;

import java.io.Serializable;
import java.util.List;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;
import com.spring.entity.Matrix;

public interface MatrixFacade extends Serializable {

	List<Matrix> findAll() throws DatastoreException;
	List<Matrix> findAll(int id) throws DatastoreException;
	public Matrix update(Matrix entity) throws UpdateException;
	public Matrix findById(int id) throws DatastoreException;
	Integer getCount() throws DatastoreException;
	public void deleteById(int id) throws RemoveException;
	public Matrix create(Matrix entity) throws CreateException;
}
