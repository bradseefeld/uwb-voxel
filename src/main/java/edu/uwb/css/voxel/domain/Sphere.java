package edu.uwb.css.voxel.domain;

public class Sphere {

	protected Vector3 center;
	
	protected float radius;
	
	protected Vector3 color;
	
	public Sphere(Vector3 center, float radius, Vector3 color) {
		this.center = center;
		this.radius = radius;
		this.color = color;
	}

	public Vector3 getCenter() {
		return center;
	}

	public Vector3 getColor() {
		return color;
	}

	public float getRadius() {
		return radius;
	}
}
