package com.spring.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.spring.core.exception.CreateException;
import com.spring.core.exception.DatastoreException;
import com.spring.core.exception.RemoveException;
import com.spring.core.exception.UpdateException;
import com.spring.core.facade.HistoryFacade;
import com.spring.core.facade.MatrixFacade;
import com.spring.data.MatrixData;
import com.spring.entity.Matrix;
import com.spring.entity.History;

@Controller
public class HiberController {
	
	@Autowired
	private MatrixFacade matrixFacade;
	@Autowired
	private HistoryFacade historyFacade;
	
	@RequestMapping(value = "/hiber", method = RequestMethod.GET)
	public String hiber(HttpServletRequest request, HttpServletResponse response, Model model) throws DatastoreException {
		System.out.println("/hiber");
		List<Matrix> matrixListA = new ArrayList<Matrix>();
		List<Matrix> matrixListB = new ArrayList<Matrix>();
		try {
			matrixListA = matrixFacade.findAll(1);
			matrixListB = matrixFacade.findAll(2);
		} catch (DatastoreException e) {
			System.out.println("error!!");
			e.printStackTrace();
		}
		model.addAttribute("matrixListA", new MatrixData(matrixListA,1));
		model.addAttribute("matrixListB", new MatrixData(matrixListB,2));
		int N=(int)Math.sqrt(matrixFacade.getCount()/2);
		System.out.println("/hiber " + N);
		return "hiber"; 
	}
	
	@RequestMapping(value = "/resp", method = RequestMethod.POST)
	public String resp(HttpServletRequest request, HttpServletResponse response, Model model) throws UpdateException, CreateException, DatastoreException, IOException {
		System.out.println("Start");
		int N=(int)Math.sqrt(matrixFacade.getCount()/2);
		List<Matrix> matrixListA = new ArrayList<Matrix>();
		List<Matrix> matrixListB = new ArrayList<Matrix>();
		try {
			matrixListA = matrixFacade.findAll(1);
			matrixListB = matrixFacade.findAll(2);
		} catch (DatastoreException e) {
			e.printStackTrace();
		}
		
		MatrixData A = new MatrixData(matrixListA,1);
		MatrixData B = new MatrixData(matrixListB,2);
		MatrixData Result = new MatrixData(N);
		model.addAttribute("Result", Result.matrix—alculation(25, A, B));
		History h = new History(historyFacade.getCount(), null, A.Serialization(), B.Serialization(), Result.Serialization());
		historyFacade.create(h);  
		return "resp"; 
	}

        public void Parser(String name, String value) throws UpdateException, DatastoreException{
        	System.out.println("Parser");
    	String[] numbers = name.split("\\D");  	
		int 	  id_Matrix = Integer.parseInt(numbers[0])
				, i = Integer.parseInt(numbers[1])
				, j = Integer.parseInt(numbers[2])
				, size = (int)Math.sqrt(matrixFacade.getCount()/2)
				, value1 = Integer.parseInt(value);	
		int id = (i*size+j)+(size*size)*(id_Matrix-1);
		if(!(matrixFacade.findById(id)).getValue().equals(value1))
		{
			Matrix m = new Matrix(id, id_Matrix,  i,  j,  value1);
			System.out.println(m.toString());
			matrixFacade.update(m);
		}		   	
    }
        
        @RequestMapping(value = "/openUpdate", method = RequestMethod.POST)
    	public String openUpdate(HttpServletRequest request, HttpServletResponse response, Model model) throws UpdateException, CreateException, DatastoreException, IOException {
        	String index = request.getParameter("fName2");
        	model.addAttribute("index", index);
        	return "openUpdate";
        }
        
        @RequestMapping(value = "/update", method = RequestMethod.POST)
    	public String update(HttpServletRequest request, HttpServletResponse response, Model model) throws UpdateException, CreateException, DatastoreException, IOException {
        	String index = request.getParameter("index");
        	String value = request.getParameter("value");
        	Parser(index, value);
        	return "hiber";
        }
        
        @RequestMapping(value = "/history", method = RequestMethod.POST)
    	public String history(HttpServletRequest request, HttpServletResponse response, Model model) throws UpdateException, CreateException, DatastoreException, IOException {
        	List<History> historyList = new ArrayList<History>();
    		historyList = historyFacade.findAll();
    		model.addAttribute("historyList", historyList);
        	return "history";
        }
        
        
    	public static MatrixData random(int N) {
    		MatrixData A = new MatrixData(N);
    		for (int i = 0; i < N; i++){
    			for (int j = 0; j < N; j++){
    				A.setMatrixElement(i, j, ((int)(Math.random()*10)));
    			}
    		}
    		return A;		
    	}
        
        @RequestMapping(value = "/changeSize", method = RequestMethod.POST)
    	public String changeSize(HttpServletRequest request, HttpServletResponse response, Model model) throws CreateException, DatastoreException, IOException, RemoveException {
        	int n = Integer.parseInt(request.getParameter("n"));
        	int nOld = matrixFacade.getCount();
        	MatrixData A = random(n);
        	MatrixData B = random(n);
        	A.printMatrixData();
        	B.printMatrixData();
        	for(int i = 0; i < nOld; i++) 
        		matrixFacade.deleteById(i);
        	for(int id_Matrix = 1; id_Matrix <= 2; id_Matrix++)
        	{    		
	        	for(int i = 0; i < n; i++)
	        	{
	        		for(int j = 0; j < n; j++)
	        		{
	        			if(id_Matrix == 1)
	        				matrixFacade.create(new Matrix((i*n+j)+(n*n)*(id_Matrix-1),id_Matrix,i,j,A.getMatrixElement(i, j)));
	        			else
	        				matrixFacade.create(new Matrix((i*n+j)+(n*n)*(id_Matrix-1),id_Matrix,i,j,B.getMatrixElement(i, j)));
	        		}
	        	}
        	}	
        	return "hiber";
        }
        
        @RequestMapping(value = "/matrixAB", method = RequestMethod.POST)
    	public String matrixAB(HttpServletRequest request, HttpServletResponse response, Model model) throws UpdateException, CreateException, DatastoreException, IOException {
        	String index = request.getParameter("index");
        	int indexNum = Integer.parseInt(index);
        	List<Matrix> matrixList = new ArrayList<Matrix>();
        	matrixList = matrixFacade.findAll(indexNum);
        	model.addAttribute("matrixListA", new MatrixData(matrixList, indexNum));
        	model.addAttribute("index",  index);
        	return "matrixAB";
        }
}
