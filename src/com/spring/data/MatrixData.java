package com.spring.data;

import com.spring.data.MatrixMultiplicationThread;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.spring.entity.Matrix;

public class MatrixData implements Serializable {

	private static final long serialVersionUID = -5501080686744334735L;

	int[][] data;
	int N;
	
	//------------------------------------- ŒÕ—“–” “Œ–€------------------------------------------
	
	public MatrixData(int N, int[][] data)
	{
		this.N = N;
		this.data = data;
	}
	public MatrixData()
	{
		this.N = 1;
		this.data = new int[N][N];
		data[0][0] = 0;
	}
	public MatrixData(int N)
	{
		this.N = N;
		this.data = new int[N][N];
	}
	
	public MatrixData(Object obj)
	{
		this.N = obj.hashCode();
		this.data = (int[][]) obj;
	}
	public MatrixData(List<Matrix> matrixList, int id)
	{
		this.N = (int)Math.sqrt(matrixList.size());
		this.data = new int[N][N];
		for(Matrix matrix : matrixList) {
			//if(matrix.getMatrixID()==id)
				data[matrix.getRowNumber()][matrix.getColumnNumber()]=matrix.getValue();
		}
	}
	
	//-------------------------------------------GET&SET-----------------------------------------------------
	
	public void setSize(int N)
	{
		this.N = N;
	}	
	public int getSize()
	{
		return this.N;
	}
	
	public void setMatrixElement(int i, int j, int value)
	{
		this.data[i][j] = value;
	}
	
	public int getMatrixElement(int i, int j)
	{
		return this.data[i][j];
	}
	
	public int[][] getMatrixArray()
	{
		return this.data;
	}
	
	//------------------------------------------------------------------------------------------------------
	
	public void printMatrixData()
	{
		for (int i = 0; i < N; ++i)
		{
	         for (int j = 0; j < N; ++j)
	         {
	        	 System.out.print(this.data[i][j] + " ");
	         }
	         System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	//--------------------------------------------—≈–»¿À»«¿÷»ﬂ--------------------------------------------
	
	public byte[] Serialization() throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		byte[] Bytes;
		try {
		  out = new ObjectOutputStream(bos);   
		  out.writeObject(this);
		  Bytes = bos.toByteArray();
		}
		finally {
		  out.close();
		  bos.close();
		}
		return Bytes;
	}
	
	public MatrixData DeSerialization(byte[] Bytes)  throws IOException, ClassNotFoundException
	{
		Object o = null;
		ObjectInput in = null;
		ByteArrayInputStream bis = new ByteArrayInputStream(Bytes);
		try {
		  in = new ObjectInputStream(bis);
		  o = in.readObject(); 
		} finally {
		  bis.close();
		  in.close();
		}
		MatrixData a = (MatrixData) o;
		return a;
	}
	
	//---------------------------------------”ÃÕŒ∆≈Õ»≈------------------------------------------------
	public MatrixData matrix—alculation(int n, MatrixData a, MatrixData b)
	{		
		int Z = a.getSize() * a.getSize() / n;	
		int z = a.getSize() * a.getSize() - Z*n;
		int i_start = 0, j_start = 0, i_end = 0, j_end = 0, f = 1;
		 
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < n; i++)
		{			
			 if(i >= z) { f = 0; }
			 i_start = i_end;
			 j_start = j_end;		 
			 i_end = (Z + i_start * a.getSize() + j_start + f)/a.getSize();
			 j_end = (Z + i_start * a.getSize() + j_start + f) - i_end * a.getSize();
			 
			 exec.submit(new MatrixMultiplicationThread(a, b, this, i_start, j_start, i_end, j_end, Z+f));			 
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10*a.getSize());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		return this;
	}

}
