package com.spring.entity;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = History.TABLE_NAME)
public class History implements Serializable {

	private static final long serialVersionUID = 8353134892817863337L;
	public final static String TABLE_NAME = "History";
	
	private Integer ID;
	private Date Date;
	private byte[] MatrixData1;
	private byte[] MatrixData2;
	private byte[] MatrixDataResult;
	
	
	public History() { }
	
	public History(Integer ID, Date Date, byte[] MatrixData1, byte[] MatrixData2, byte[] MatrixDataResult) { 
		this.ID = ID;
		this.Date = Date;
		this.MatrixData1 = MatrixData1;
		this.MatrixData2 = MatrixData2;
		this.MatrixDataResult = MatrixDataResult;
	}
	
	@Id
	@Column(name = "ID")
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	@Column(name = "Date")
	public Date getDate() {
		return Date;
	}	
	public void setDate(Date Date) {
		this.Date = Date;
	}
		
	@Column(name = "MatrixData1")
	public byte[] getMatrixData1() {
		return MatrixData1;
	}	
	public void setMatrixData1(Object MatrixData1) {
		this.MatrixData1 = (byte[])MatrixData1;
	}
	
	@Column(name = "MatrixData2")
	public byte[] getMatrixData2() {
		return MatrixData2;
	}	
	public void setMatrixData2(Object MatrixData2) {
		this.MatrixData2 = (byte[])MatrixData2;
	}
	
	@Column(name = "MatrixDataResult")
	public byte[] getMatrixDataResult() {
		return MatrixDataResult;
	}	
	public void setMatrixDataResult(Object MatrixDataResult) {
		this.MatrixDataResult = (byte[])MatrixDataResult;
	}

	@Override
	public String toString() {
		return "History [ID=" + ID + ", Date=" + Date + "]";
	}
}
