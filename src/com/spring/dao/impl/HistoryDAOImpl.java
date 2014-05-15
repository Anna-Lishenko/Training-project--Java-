package com.spring.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.HistoryDAO;
import com.spring.entity.History;

@Repository
@Transactional 
public class HistoryDAOImpl extends GenericDAOImpl<History> implements HistoryDAO {

	private static final long serialVersionUID = 6193759658444611814L;
	
}
