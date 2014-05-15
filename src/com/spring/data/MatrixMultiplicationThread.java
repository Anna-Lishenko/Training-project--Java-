package com.spring.data;

import com.spring.data.MatrixData;
import java.util.concurrent.*;

public class MatrixMultiplicationThread implements Callable<MatrixData> {
	
	private MatrixData firstMatrix;
	private MatrixData secondMatrix;
	private MatrixData resultMatrix;
	int num, i_start, j_start, i_end, j_end;
	
	public MatrixMultiplicationThread(){}
	
	public MatrixMultiplicationThread(MatrixData firstMatrix, MatrixData secondMatrix, MatrixData resultMatrix, int line)
	{
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
		this.resultMatrix = resultMatrix;
		this.num = line;
	}
	
	public MatrixMultiplicationThread(MatrixData firstMatrix, MatrixData secondMatrix, MatrixData resultMatrix, int i_start, int j_start, int i_end, int j_end, int num)
	{
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
		this.resultMatrix = resultMatrix;
		this.i_start = i_start;
		this.j_start = j_start;
		this.i_end = i_end;
		this.j_end = j_end;
		this.num = num;
	}
	
	public MatrixData call()
	{
		int temp = 0;
		int j = j_start, count = 0;
		for(int i = i_start; i <= i_end ; i++, j = 0)			
		{
			for(;  j < firstMatrix.getSize() && count < num; j++)
			{
				temp = 0;
				for(int k = 0; k < firstMatrix.getSize() ; k++)
				{
					temp += firstMatrix.getMatrixElement(i, k)*secondMatrix.getMatrixElement(k, j);						
				}
				resultMatrix.setMatrixElement(i, j, temp);
				count++;
			}
		}		
		return this.resultMatrix;
	}	
}

