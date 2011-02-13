package edu.uwb.css.voxel.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.uwb.css.voxel.domain.Sphere;
import edu.uwb.css.voxel.domain.Vector3;

public class SphereParserTest {

	protected SphereParser parser;
	
	@Before
	public void setUp() {
		parser = new SphereParser();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseNull() {
		parser.parse(null);
	}
	
	@Test
	public void testParse() {
		List<String> lines = new LinkedList<String>();
		lines.add("########");
		lines.add("sphere:");
		lines.add("center=    0 1.2 0");
		lines.add("radius=0.2");
		lines.add("########");
		Sphere sphere = parser.parse(lines);
		assertNotNull(sphere);
		assertEquals(new Vector3(0, 1.2f, 0), sphere.getCenter());
		assertEquals(0.2f, sphere.getRadius(), 0.001f);
	}
	
	@Test
	public void testParseWithColors() {
		List<String> lines = new LinkedList<String>();
		lines.add("sphere:");
		lines.add("center=    0 1.2 0");
		lines.add("radius=0.2");
		lines.add("mtl-diffuse=0.98 0.48 0.4");
		lines.add("mtl-specular=0.7 0.7 0.7");
		lines.add("mtl-shininess=20");
		
		Sphere sphere = parser.parse(lines);
		assertNotNull(sphere);
		assertEquals(new Vector3(0.98f, 0.48f, 0.4f), sphere.getDiffuse());
		assertEquals(new Vector3(0.7f, 0.7f, 0.7f), sphere.getSpecular());
		assertEquals(20, sphere.getShininess());
	}
}
