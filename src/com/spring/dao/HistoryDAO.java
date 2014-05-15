package com.spring.dao;

import java.io.Serializable;
import java.util.List;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.entity.History;

public interface HistoryDAO extends Serializable {
	List<History> findAll() throws DatastoreException;
	Integer getCount() throws DatastoreException;
	public History create(History entity) throws CreateException;
	public History findById(int id) throws DatastoreException;
}
