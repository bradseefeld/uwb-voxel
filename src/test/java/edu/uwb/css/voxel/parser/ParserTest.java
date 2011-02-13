package edu.uwb.css.voxel.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import edu.uwb.css.voxel.domain.Camera;
import edu.uwb.css.voxel.domain.Scene;
import edu.uwb.css.voxel.domain.Vector3;

public class ParserTest {

	protected Parser parser;
	
	protected static final String BASE_PATH = "edu/uwb/css/voxel/parser/";
	
	@Before
	public void setUp() {
		parser = new Parser();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseWhenNull() throws Exception {
		parser.parse(null);
	}
	
	@Test
	public void testParseWithSingleSphere() throws Exception {
		InputStream in = ClassLoader.getSystemResourceAsStream(BASE_PATH + "singleSphere.txt");
		assertNotNull(in);
		
		Scene scene = parser.parse(in);
		assertNotNull(scene);
		assertEquals(1, scene.getSpheres().size());
	}
	
	@Test
	public void testParseSceneTest1() throws Exception {
		InputStream in = ClassLoader.getSystemResourceAsStream(BASE_PATH + "testScene1.txt");
		assertNotNull(in);
		
		Scene scene = parser.parse(in);
		assertNotNull(scene);
		assertEquals(37, scene.getSpheres().size());
		assertEquals(1, scene.getLights().size());
		
		assertEquals(new Vector3(0.5f, 0.5f, 1f), scene.getBackgroundColor());
		assertEquals(new Vector3(1f, 1f, 1f), scene.getAmbientLight());
		
		assertEquals(1, scene.getSuperSampleWidth());
		
		Camera cam = scene.getCamera();
		assertNotNull(cam);
		assertEquals(new Vector3(0f, 0.1f, 2f), cam.getEye());
		assertEquals(new Vector3(0f, 0f, 0f), cam.getLookAt());
		assertEquals(new Vector3(0f, 1f, 0f), cam.getUp());
		assertEquals(1f, cam.getScreenDistance(), 0.0001f);
		assertEquals(1.3f, cam.getScreenWidth(), 0.0001f);
	}
}
