package com.spring.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MatrixDAO;
import com.spring.entity.Matrix;

@Repository
@Transactional
public class MatrixDAOImpl extends GenericDAOImpl<Matrix> implements MatrixDAO {

	private static final long serialVersionUID = 3749782114499136220L;
	
}
