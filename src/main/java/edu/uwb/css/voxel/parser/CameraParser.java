package edu.uwb.css.voxel.parser;

import java.util.List;

import edu.uwb.css.voxel.domain.Camera;
import edu.uwb.css.voxel.domain.Vector3;

public class CameraParser extends TypeParser {
	
	private static final String EYE_TOKEN = "eye =";
	
	private static final int EYE_TOKEN_LENGTH = EYE_TOKEN.length();
	
	private static final String LOOK_AT_TOKEN = "look-at =";
	
	private static final int LOOK_AT_TOKEN_LENGTH = LOOK_AT_TOKEN.length();
	
	private static final String SCREEN_DIST_TOKEN = "screen-dist =";
	
	private static final int SCREEN_DIST_TOKEN_LENGTH = SCREEN_DIST_TOKEN.length();
	
	private static final String UP_DIRECTION_TOKEN = "up-direction =";
	
	private static final int UP_DIRECTION_TOKEN_LENGTH = UP_DIRECTION_TOKEN.length();
	
	private static final String SCREEN_WIDTH_TOKEN = "screen-width=";
	
	private static final int SCREEN_WIDTH_TOKEN_LENGTH = SCREEN_WIDTH_TOKEN.length();
	
	public Camera parse(List<String> raw) {
		
		if (raw == null) {
			throw new IllegalArgumentException("Raw data cannot be null");
		}
		
		Vector3 eye = null;
		Vector3 lookAt = null;
		Float screenDist = null;
		Vector3 up = null;
		Float screenWidth = null;
		
		for (String line : raw) {
			
			if (line == null) {
				// Do nothing
			} else if (line.contains(EYE_TOKEN)) {
				eye = parseVector3(line, EYE_TOKEN_LENGTH);
			} else if (line.contains(LOOK_AT_TOKEN)) {
				lookAt = parseVector3(line, LOOK_AT_TOKEN_LENGTH);
			} else if (line.contains(SCREEN_DIST_TOKEN)) {
				screenDist = parseFloat(line, SCREEN_DIST_TOKEN_LENGTH);
			} else if (line.contains(UP_DIRECTION_TOKEN)) {
				up = parseVector3(line, UP_DIRECTION_TOKEN_LENGTH);
			} else if (line.contains(SCREEN_WIDTH_TOKEN)) {
				screenWidth = parseFloat(line, SCREEN_WIDTH_TOKEN_LENGTH);
			}
		}
		
		if (eye == null || lookAt == null || screenDist == null || up == null || screenWidth == null) {
			return null;
		}
		
		Camera cam = new Camera(eye, lookAt, up, screenDist, screenWidth);
		return cam;
	}

}
