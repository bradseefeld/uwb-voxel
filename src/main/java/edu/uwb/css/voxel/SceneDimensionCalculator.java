package edu.uwb.css.voxel;

import java.util.List;

import edu.uwb.css.voxel.domain.Sphere;
import edu.uwb.css.voxel.domain.Vector3;

public class SceneDimensionCalculator implements Runnable {
	
	protected List<Sphere> spheres;
	
	protected Vector3 minPositions;
	
	protected Vector3 maxPositions;
	
	public SceneDimensionCalculator(List<Sphere> spheres) { //, Callback<>) {
		this.spheres = spheres;
	}
	
	public Vector3 getMinPositions() {
		return null;
	}
	
	public Vector3 getMaxPositions() {
		return null;
	}
	
	/**
	 * Calculate min/max from list.
	 */
	public void run() {
		
		minPositions = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
		maxPositions = new Vector3(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
		
		Vector3 center = null;
		for (Sphere sphere : spheres) {
			center = sphere.getCenter();
			
			maxPositions.setX(calculateMax(center.getX(), sphere.getRadius(), maxPositions.getX()));
		}
	}
	
	float calculateMax(float x, float radius, float currentMax) {
		if (x + radius > currentMax) {
			return x + radius;
		}
		
		return currentMax;
	}
}
