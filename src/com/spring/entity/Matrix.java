package com.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Matrix.TABLE_NAME)
public class Matrix implements Serializable {
	
	private static final long serialVersionUID = 4422107188566037483L;

	public final static String TABLE_NAME = "MatrixData";
	
	private Integer ID;
	private Integer MatrixID;
	private Integer RowNumber;
	private Integer ColumnNumber;
	private Integer Value;
	
	public Matrix(){ }
	
	public Matrix(int ID, int MatrixID, int RowNumber, int ColumnNumber, int Value)
	{
		this.ID = ID;
		this.MatrixID = MatrixID;
		this.RowNumber = RowNumber;
		this.ColumnNumber = ColumnNumber;
		this.Value = Value;
	}
	
	@Id
	@Column(name = "ID")
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	@Column(name = "MatrixID")
	public Integer getMatrixID() {
		return MatrixID;
	}	
	public void setMatrixID(Integer MatrixID) {
		this.MatrixID = MatrixID;
	}
	
	@Column(name = "RowNumber")
	public Integer getRowNumber() {
		return RowNumber;
	}
	public void setRowNumber(Integer RowNumber) {
		this.RowNumber = RowNumber;
	}
	
	@Column(name = "ColumnNumber")
	public Integer getColumnNumber() {
		return ColumnNumber;
	}
	public void setColumnNumber(Integer ColumnNumber) {
		this.ColumnNumber = ColumnNumber;
	}
	
	@Column(name = "Value")
	public Integer getValue() {
		return Value;
	}
	public void setValue(Integer Value) {
		this.Value = Value;
	}
	
	@Override
	public String toString() {
		return "Matrix [ID=" + ID + ", MatrixID=" + MatrixID + ", RowNumber="
				+ RowNumber + ", ColumnNumber=" + ColumnNumber + ", Value=" + Value + "]";
	}

}
