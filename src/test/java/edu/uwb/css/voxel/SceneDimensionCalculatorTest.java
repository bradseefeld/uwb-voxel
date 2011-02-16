package edu.uwb.css.voxel;

import static org.junit.Assert.*;
import org.junit.Test;

public class SceneDimensionCalculatorTest {

	
	@Test
	public void testCalculateMax() {
		SceneDimensionCalculator calc = new SceneDimensionCalculator(null);
		float actual = calc.calculateMax(1.2f, 1.3f, 1.0f);
		assertEquals(1.2f + 1.3f, actual, 0.0001f);
	}
}
