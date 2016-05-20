package com.kdp.junit;

import java.util.Arrays;

import org.junit.Test;

public class PerformanceTest {

	@Test(timeout=1000)
	public void testSortPerformance() {

		int arr[]={12,24,57,77,35,46};
		for(int i =0;i<=1000000;i++){
			arr[1]=i;
			Arrays.sort(arr);
		}
	}

}
