package com.ashley.controller;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ashley.domain.Cube;
import com.ashley.domain.RealOption;
import com.ashley.domain.Slice;
import com.ashley.domain.UnderlyingTree;
import com.ashley.domain.UserParameters;
import com.ashley.util.CubeHelper;

//annotations
@Path("/acf") // URI


public class AcfController {

	private static UserParameters userParams;
	
	//@GET
	//@Produces(MediaType.APPLICATION_JSON) 
	//@Path("{n}/{t}/{PriceOfCost}/{sigma}/{RiskFreeRate}/{PriceOfProduct}/{AmountOfCommodities}/{CostOfOperations}/{gainOrLoss}/{salesLevel")
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cr")
	//public double calculateAcf(@PathParam("n") int n, @PathParam("t") int t, @PathParam("PriceOfCost") double PoC_0, @PathParam("sigma") double sigma, @PathParam("RiskFreeRate") double rf, @PathParam("PriceOfProduct") double PoP_0, @PathParam("AmountOfCommodities") double AoC, @PathParam("CostOfOperations") double CoO, @PathParam("gainOrLoss") double gain) {
	//int n, int t, double PoC_0, double sigma, double rf, double PoP_0, double AoC, double CoO, double gain
	public double calculateResult(UserParameters userInput) {
	// double PoC_0, double sigma, double rf, double PoP_0, double AoC, double CoO, double gain
//		System.out.println("Hello2");
//		System.out.println("n is " + userInput.getN());
//		System.out.println("t is " + userInput.getT());
//		System.out.println("PoC_0 is " + userInput.getPoc_0());
//		System.out.println("Sigma is " + userInput.getSigma());
//		System.out.println("Rf is " + userInput.getRf());
//		System.out.println("pop_0 is " + userInput.getPop_0());
//		System.out.println("aoc is " + userInput.getAoc());
//		System.out.println("coo_0 is " + userInput.getCoo());
//		System.out.println("realOptions is " + userInput.getRealOptions());

		userParams = getUserParams(userInput.getN(), userInput.getT(), userInput.getPoc_0(), userInput.getSigma(), userInput.getRf(), userInput.getPop_0(), userInput.getAoc(), userInput.getCoo(), userInput.getRealOptions());
	
		UnderlyingTree assetPrices = new UnderlyingTree(userInput.getN(), userInput.getT(), userInput.getPoc_0(), userInput.getSigma()); //(n, t, PoC_0, sigma)
		Cube cube = new Cube(userParams, assetPrices);		
		
		double result = cube.startProcessing();
		System.out.println("The final result is " + result);
		return result;
		
	}
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ut")
	public UnderlyingTree returnUnderlyingTree (UserParameters userInput){
		
		UnderlyingTree assetPrices = new UnderlyingTree(userInput.getN(), userInput.getT(), userInput.getPoc_0(), userInput.getSigma()); //(n, t, PoC_0, sigma)
		
		return assetPrices;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rcube")
	public Slice[] returnSlices(UserParameters userInput) {
		userParams = getUserParams(userInput.getN(), userInput.getT(), userInput.getPoc_0(), userInput.getSigma(), userInput.getRf(), userInput.getPop_0(), userInput.getAoc(), userInput.getCoo(), userInput.getRealOptions());
		
		UnderlyingTree assetPrices = new UnderlyingTree(userInput.getN(), userInput.getT(), userInput.getPoc_0(), userInput.getSigma()); //(n, t, PoC_0, sigma)
		Cube cube = new Cube(userParams, assetPrices);		
		cube.startProcessing();
		return cube.getCube();
	}
	
	private static UserParameters getUserParams(int n, int t, double poc_0, double sigma, double rf, double pop_0, double aoc, double coo, RealOption[] realOptions) {
		//At some point we gonna ask the user
//		RealOption oi0 = new RealOption(0, 10000);
//		RealOption oi1 = new RealOption(-250000, 20000);
//		RealOption oi2 = new RealOption(0, 0);
//		RealOption[] oIa = new RealOption[3];
//		oIa[0] = oi0;
//		oIa[1] = oi1;
//		oIa[2] = oi2;
		
		//N is including the current period
		//OptionNum is one less than total (excluding current level)

		return new UserParameters(n, t, poc_0, sigma, rf, pop_0, aoc, coo, realOptions);
	}
}
