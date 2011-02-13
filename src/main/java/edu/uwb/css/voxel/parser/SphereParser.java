package edu.uwb.css.voxel.parser;

import java.util.List;

import edu.uwb.css.voxel.domain.Sphere;
import edu.uwb.css.voxel.domain.Vector3;

public class SphereParser extends TypeParser {

	private static final String CENTER_TOKEN = "center=";
	
	private static final int CENTER_TOKEN_LENGTH = CENTER_TOKEN.length();
	
	private static final String RADIUS_TOKEN = "radius=";
	
	private static final int RADIUS_TOKEN_LENGTH = RADIUS_TOKEN.length();
	
	private static final String DIFFUSE_TOKEN = "mtl-diffuse=";
	
	private static final int DIFFUSE_TOKEN_LENGTH = DIFFUSE_TOKEN.length();
	
	private static final String SPECULAR_TOKEN = "mtl-specular=";
	
	private static final int SPECULAR_TOKEN_LENGTH = SPECULAR_TOKEN.length();
	
	private static final String SHININESS_TOKEN = "mtl-shininess=";
	
	private static final int SHININESS_TOKEN_LENGTH = SHININESS_TOKEN.length();
	
	public Sphere parse(List<String> raw) {
		
		if (raw == null) {
			throw new IllegalArgumentException("Raw data cannot be null");
		}
		
		Vector3 center = null;
		Float radius = null;
		Vector3 diffuse = null;
		Vector3 specular = null;
		int shin = 0;
		
		for (String line : raw) {
			if (line == null) {
				// do nothing
			} else if (line.contains(CENTER_TOKEN)) {
				center = parseCenter(line);
			} else if (line.contains(RADIUS_TOKEN)) {
				radius = parseRadius(line);
			} else if (line.contains(DIFFUSE_TOKEN)) {
				diffuse = parseDiffuse(line);
			} else if (line.contains(SPECULAR_TOKEN)) {
				specular = parseSpecular(line);
			} else if (line.contains(SHININESS_TOKEN)) {
				shin = parseShininess(line);
			}
		}
		
		// Create sphere if all properties are present
		if (center != null && radius != null) {
			return new Sphere(center, radius, diffuse, specular, shin);
		}
		
		return null;
	}
	
	protected int parseShininess(String shinLine) {
		return parseInt(shinLine, SHININESS_TOKEN_LENGTH);
	}
	
	protected Vector3 parseSpecular(String specularLine) {
		return parseVector3(specularLine, SPECULAR_TOKEN_LENGTH);
	}
	
	protected Vector3 parseDiffuse(String diffuseLine) {
		return parseVector3(diffuseLine, DIFFUSE_TOKEN_LENGTH);
	}
	
	protected float parseRadius(String radiusLine) {
		return parseFloat(radiusLine, RADIUS_TOKEN_LENGTH);
	}
	
	protected Vector3 parseCenter(String centerLine) {
		return parseVector3(centerLine, CENTER_TOKEN_LENGTH);
	}
}
