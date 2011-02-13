package edu.uwb.css.voxel.parser;

import edu.uwb.css.voxel.domain.Vector3;

public abstract class TypeParser {

	protected Vector3 parseVector3(String vector3Line, int trimLength) {
		
		vector3Line = vector3Line.substring(trimLength);
		if (vector3Line == null) {
			return null;
		}
		
		vector3Line = vector3Line.trim();
		
		String[] points = vector3Line.split("\\s");
		
		if (points.length != 3) {
			return null;
		}
		
		float x = Float.parseFloat(points[0]);
		float y = Float.parseFloat(points[1]);
		float z = Float.parseFloat(points[2]);
		
		return new Vector3(x, y, z);
	}
	
	protected int parseInt(String intLine, int trimLength) {
		intLine = intLine.substring(trimLength);
		if (intLine == null) {
			return 0;
		}

		intLine = intLine.trim();
		if (intLine == null) {
			return 0;
		}
		
		return Integer.parseInt(intLine);
	}
	
	protected float parseFloat(String floatLine, int trimLength) {
		floatLine = floatLine.substring(trimLength); // end of radius=
		if (floatLine == null) {
			return 0f;
		}

		floatLine = floatLine.trim();
		if (floatLine == null) {
			return 0f;
		}
		
		return Float.parseFloat(floatLine);
	}
}
