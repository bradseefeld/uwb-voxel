package edu.uwb.css.voxel.parser;

import java.util.List;

import edu.uwb.css.voxel.domain.Scene;
import edu.uwb.css.voxel.domain.Vector3;

public class SceneParser extends TypeParser {

	private static final String BACKGROUND_COLOR_TOKEN = "background-col=";
	
	private static final int BACKGROUND_COLOR_TOKEN_LENGTH = BACKGROUND_COLOR_TOKEN.length();
	
	private static final String AMBIENT_LIGHT_TOKEN = "ambient-light=";
	
	private static final int AMBIENT_LIGHT_TOKEN_LENGTH = AMBIENT_LIGHT_TOKEN.length();
	
	private static final String SUPER_SAMPLE_WIDTH_TOKEN = "super-samp-width=";
	
	private static final int SUPER_SAMPLE_WIDTH_TOKEN_LENGTH = SUPER_SAMPLE_WIDTH_TOKEN.length();
	
	public void parse(List<String> raw, Scene scene) {
		
		if (raw == null) {
			throw new IllegalArgumentException("Raw data cannot be null.");
		}
		
		if (scene == null) {
			throw new IllegalArgumentException("Scene cannot be null.");
		}
		
		for (String line : raw) {
			if (line == null) {
				// do nothing
			} else if (line.contains(BACKGROUND_COLOR_TOKEN)) {
				Vector3 bg = parseVector3(line, BACKGROUND_COLOR_TOKEN_LENGTH);
				synchronized(scene) {
					scene.setBackgroundColor(bg);
				}
			} else if (line.contains(AMBIENT_LIGHT_TOKEN)) {
				Vector3 light = parseVector3(line, AMBIENT_LIGHT_TOKEN_LENGTH);
				synchronized(scene) {
					scene.setAmbientLight(light);
				}
			} else if (line.contains(SUPER_SAMPLE_WIDTH_TOKEN)) {
				int sampleWidth = parseInt(line, SUPER_SAMPLE_WIDTH_TOKEN_LENGTH);
				scene.setSuperSampleWidth(sampleWidth);
			}
		}
	}
}
