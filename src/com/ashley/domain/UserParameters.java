package com.ashley.domain;

public class UserParameters {

	private int n; 
	private int T; 
	private double poc_0; 
	private double sigma; 
	private double rf; 
	private double pop_0;
	private double aoc; 
	private double coo; 
	private RealOption[] realOptions;	

	RealOption oi0 = new RealOption(0, 10000);
	RealOption oi1 = new RealOption(-250000, 20000);
	RealOption oi2 = new RealOption(0, 0);
	static RealOption[] oIa = new RealOption[3];
	
	{
		oIa[0] = oi0;
		oIa[1] = oi1;
		oIa[2] = oi2;
	}

	public UserParameters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserParameters(int n, int t, double poc_0, double sigma, double rf, double pop_0, double aoc, double coo, RealOption[] realOptions) { 
		super();
		this.n = n;
		this.T = t;
		this.poc_0 = poc_0;
		this.sigma = sigma;
		this.rf = rf;
		this.pop_0 = pop_0;
		this.aoc = aoc;
		this.coo = coo;
		this.realOptions = realOptions;
	}
	
	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getT() {
		return T;
	}


	public void setT(int t) {
		T = t;
	}


	public double getPoc_0() {
		return poc_0;
	}


	public void setPoc_0(double poc_0) {
		this.poc_0 = poc_0;
	}


	public double getSigma() {
		return sigma;
	}


	public void setSigma(double sigma) {
		this.sigma = sigma;
	}


	public double getRf() {
		return rf;
	}


	public void setRf(double rf) {
		this.rf = rf;
	}


	public double getPop_0() {
		return pop_0;
	}


	public void setPop_0(double pop_0) {
		this.pop_0 = pop_0;
	}


	public double getAoc() {
		return aoc;
	}


	public void setAoc(double aoc) {
		this.aoc = aoc;
	}


	public double getCoo() {
		return coo;
	}


	public void setCoo(double coo) {
		this.coo = coo;
	}

	public RealOption[] getRealOptions() {
		return realOptions;
	}
	
	public void setRealOptions(RealOption[] realOptions) {
		this.realOptions = realOptions;
		
	}
	
}
