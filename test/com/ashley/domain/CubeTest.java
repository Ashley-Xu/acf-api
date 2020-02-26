package com.ashley.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CubeTest {
	private static Cube test;
	private static UserParameters userParams;

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			RealOption oi0 = new RealOption(0, 10000);
			RealOption oi1 = new RealOption(-250000, 20000);
			RealOption oi2 = new RealOption(0, 0);
			RealOption[] oIa = new RealOption[3];
			oIa[0] = oi0;
			oIa[1] = oi1;
			oIa[2] = oi2;
			
			userParams = new UserParameters(2, 2, 1600,0.36, 0.05, 350, 0.15, 100, oIa);
			UnderlyingTree assetPrices = new UnderlyingTree(2, 2, 1600, 0.36);
			
			test = Cube.getInstance(userParams, assetPrices);		
		}
		@Test
		void initCubeTest() {
		
			test.initCube();
			int tSize = userParams.getN()+1;
			int iSize = tSize;
			int optionNum = userParams.getRealOptions().length - 1;
			int oSize = 1 + 2 * optionNum;
			double[][][] expected = new double [tSize][oSize][iSize];
			
			double[][][] cubeData = new double [tSize][oSize][iSize];
			Slice[] cubeSlices = test.getCube();
			
			for(int i=0; i< tSize; i++) {
				Slice currSlice = cubeSlices[i];
				cubeData[i] = currSlice.getSlice();		
			}
		
			Assert.assertArrayEquals(expected, cubeData);
		}
		@Test
		void startProcessingTest() {
			
			double output = test.startProcessing();
			double expected = 4750000.0;
			assertEquals(expected, output);
		}
		@Test
		void computeProfitTest() {
			double[][] prevSlice = new double [][]{
				{2147483647, -146261924, 1331794},
				{2147483647, 156157300, 2413589},
				{0, 0, 0},
				{2147483647, -593592699, 2663589},
				{0, 0, 0},
			}; 
			double output = test.computeProfit(0, 0, prevSlice);
			double expected = -3.2212229705E12;
			assertEquals(expected, output);
		}
		
		@Test
		void computeDCFTest() {
			double[][] prevSlice = new double [][]{
				{2147483647, -146261924, 1331794},
				{2147483647, 156157300, 2413589},
				{0, 0, 0},
				{2147483647, -593592699, 2663589},
				{0, 0, 0},
			}; 
			double output = test.computeDCF(0, 0, prevSlice);
			
			double expected = 1.0590006135632353E9;
			assertEquals(expected, output);
		}
		


}
