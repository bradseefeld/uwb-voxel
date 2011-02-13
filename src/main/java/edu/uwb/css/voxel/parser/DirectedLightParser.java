package edu.uwb.css.voxel.parser;

import java.util.List;

import edu.uwb.css.voxel.domain.DirectedLight;
import edu.uwb.css.voxel.domain.Vector3;

public class DirectedLightParser extends TypeParser {

	private static final String DIRECTION_TOKEN = "direction=";
	
	private static final int DIRECTION_TOKEN_LENGTH = DIRECTION_TOKEN.length();
	
	private static final String COLOR_TOKEN = "color=";
	
	private static final int COLOR_TOKEN_LENGTH = COLOR_TOKEN.length();
	
	public DirectedLight parse(List<String> raw) {
		
		if (raw == null) {
			throw new IllegalArgumentException("Raw input cannot be null.");
		}
		
		Vector3 direction = null;
		Vector3 color = null;
		
		for (String line : raw) {
			
			if (line == null) {
				// Do nothing
			} else if (line.contains(DIRECTION_TOKEN)) {
				direction = parseVector3(line, DIRECTION_TOKEN_LENGTH);
			} else if (line.contains(COLOR_TOKEN)) {
				color = parseVector3(line, COLOR_TOKEN_LENGTH);
			}
		}
		
		if (direction == null || color == null) {
			return null;
		}
		
		return new DirectedLight(direction, color);
	}
}
