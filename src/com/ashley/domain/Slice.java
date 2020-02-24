package com.ashley.domain;

public class Slice {
	
	private double[][] slice;
	
	public void setSlice(double[][] slice) {
		this.slice = slice;
	}

	public Slice(int x, int y) {
		slice = new double[x][y];
	}

	public double[][] getSlice() {
		return slice;
	}
	

}
