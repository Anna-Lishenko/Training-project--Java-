package com.spring.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;
import com.spring.core.facade.MatrixFacade;
import com.spring.dao.MatrixDAO;
import com.spring.entity.Matrix;

@Service
@Transactional
public class MatrixFacadeImpl implements MatrixFacade {
	
	private static final long serialVersionUID = 9115153419945111967L;
	
	@Autowired
	private MatrixDAO matrixDAO;

	@Override
	public List<Matrix> findAll() throws DatastoreException {
		return matrixDAO.findAll();
	}
	public List<Matrix> findAll(int id) throws DatastoreException {
		return matrixDAO.findAll(id);
	}
	public Matrix update(Matrix entity) throws UpdateException{
		return matrixDAO.update(entity);
	}
	public Matrix findById(int id) throws DatastoreException{
		return matrixDAO.findById(id);
	}
	public Integer getCount() throws DatastoreException{
		return matrixDAO.getCount();
	}
	public void deleteById(int id) throws RemoveException{
		matrixDAO.deleteById(id);
	}
	public Matrix create(Matrix entity) throws CreateException{
		return matrixDAO.create(entity);
	}
}
