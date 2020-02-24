package com.ashley.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class initTreeTest {

	@Test
	void test() {
		UnderlyingTree test = new UnderlyingTree(2, 2, 1600, 0.36);
		test.initTree();
		double[][] expected = new double [][]{
				{1600.0, 0.0, 0.0},
				{2293.327063296544, 1116.2821217136498, 0.0},
				{3287.0931370302196, 1600.0, 778.8036095359548},
		};
		
		Assert.assertArrayEquals(expected, test.getTree());
		
	}

}