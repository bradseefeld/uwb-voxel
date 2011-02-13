package edu.uwb.css.voxel.parser;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.uwb.css.voxel.domain.Scene;
import edu.uwb.css.voxel.domain.Vector3;

public class SceneParserTest {

	protected SceneParser parser;
	
	@Before
	public void setUp() {
		parser = new SceneParser();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseWithNullRaw() {
		parser.parse(null, new Scene());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseWithNullScene() {
		parser.parse(new LinkedList<String>(), null);
	}
	
	@Test
	public void testParseScene() {
		List<String> lines = new LinkedList<String>();
		lines.add(" scene:  ");
		lines.add("background-col=   0.5 0.5 1");
		lines.add("ambient-light= 1 1 1    ");
		lines.add("super-samp-width=1");
		
		Scene scene = new Scene();
		parser.parse(lines, scene);
		
		assertEquals(new Vector3(0.5f, 0.5f, 1f), scene.getBackgroundColor());
		assertEquals(new Vector3(1f, 1f, 1f), scene.getAmbientLight());
		assertEquals(1, scene.getSuperSampleWidth());
	}
}
