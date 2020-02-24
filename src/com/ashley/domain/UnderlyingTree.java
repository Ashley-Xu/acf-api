package com.ashley.domain;

import java.util.Arrays;

public class UnderlyingTree {

	private double[][] underlyingTree;
	
	private int n;
	private int maturity;
	private double poc_0;
	private double sigma;
	
	
	public UnderlyingTree(int n, int t, double poc_0, double sigma) {
		super();
		this.underlyingTree = new double[n+1][n+1];
		this.n = n;
		this.maturity = t;
		this.poc_0 = poc_0;
		this.sigma = sigma;
		initTree();
	}
	
	public double[][] getTree() {
		return underlyingTree;
	}
	
	public int getTsize() {
		return underlyingTree.length;
	}
	
	public double[] getColumn(int index) {
		return underlyingTree[index];
	} 

	public void initTree() {
		double dt = maturity/n;
		double up = Math.exp(sigma * Math.sqrt(dt));
		double down = 1/up; 
		
		System.out.println("up is  " + up);
		System.out.println("poc_0 is  " + poc_0);
		
		for (int t = 0; t < n+1; t++) {
			for (int i = 0; i < t+1; i++) {
				underlyingTree[t][i] = poc_0 * (Math.pow(down, i)) * (Math.pow(up, (t-i)));
				
			}
		}
	}
	
	public double getUnderlyingPrice(int i, int t) {
		return underlyingTree [i] [t];
	}
	
}


