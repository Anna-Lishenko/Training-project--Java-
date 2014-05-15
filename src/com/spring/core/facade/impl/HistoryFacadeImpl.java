package com.spring.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.facade.HistoryFacade;
import com.spring.dao.HistoryDAO;
import com.spring.entity.History;

@Service
@Transactional
public class HistoryFacadeImpl implements HistoryFacade {

	private static final long serialVersionUID = 608117534914096920L;
	
	@Autowired
	private HistoryDAO historyDAO;
		
	@Override
	public List<History> findAll() throws DatastoreException{
		return historyDAO.findAll();
	}
	public Integer getCount() throws DatastoreException{
		return historyDAO.getCount();
	}
	public History create(History entity) throws CreateException{
		return historyDAO.create(entity);		
	}
	public History findById(int id) throws DatastoreException{
		return historyDAO.findById(id);
	}
}
