package edu.uwb.css.voxel.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.uwb.css.voxel.domain.DirectedLight;
import edu.uwb.css.voxel.domain.Vector3;

public class DirectedLightParserTest {

	protected DirectedLightParser parser;
		
	@Before
	public void setUp() {
		parser = new DirectedLightParser();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseWithNull() {
		parser.parse(null);
	}
	
	@Test
	public void testParse() {
		
		List<String> lines = new LinkedList<String>();
		lines.add("direction=0.3 -0.7 -1");
		lines.add("color=  1 1 1");
		
		DirectedLight light = parser.parse(lines);
		assertNotNull(light);
		assertEquals(new Vector3(0.3f, -0.7f, -1f), light.getDirection());
		assertEquals(new Vector3(1f, 1f, 1f), light.getColor());
	}
}
