package edu.uwb.css.voxel.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.uwb.css.voxel.domain.Camera;
import edu.uwb.css.voxel.domain.Vector3;

public class CameraParserTest {

	protected CameraParser parser;
	
	@Before
	public void setUp() {
		parser = new CameraParser();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseWithNull() {
		parser.parse(null);
	}
	
	@Test
	public void testParse() {
		
		List<String> lines = new LinkedList<String>();
		lines.add("eye = 0 0.1 2");
		lines.add("look-at = 0 0 0");
		lines.add("screen-dist = 1");
		lines.add("up-direction = 0 1 0");
		lines.add("screen-width=1.3");
		
		Camera cam = parser.parse(lines);
		assertNotNull(cam);
		assertEquals(new Vector3(0f, 0.1f, 2f), cam.getEye());
		assertEquals(new Vector3(0f, 0f, 0f), cam.getLookAt());
		assertEquals(new Vector3(0f, 1f, 0f), cam.getUp());
		assertEquals(1f, cam.getScreenDistance(), 0.001f);
		assertEquals(1.3f, cam.getScreenWidth(), 0.001f);
	}
}
