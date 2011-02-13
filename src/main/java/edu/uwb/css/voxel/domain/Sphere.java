package edu.uwb.css.voxel.domain;

public class Sphere {

	protected Vector3 center;
	
	protected float radius;
	
	protected Vector3 diffuse;
	
	protected Vector3 specular;
	
	protected int shininess;
	
	public Sphere(Vector3 center, float radius) {
		this(center, radius, null, null, 0);
	}
	
	public Sphere(Vector3 center, float radius, Vector3 diffuse, Vector3 specular, int shin) {
		this.center = center;
		this.radius = radius;
		this.diffuse = diffuse;
		this.specular = specular;
		this.shininess = shin;
	}

	public Vector3 getCenter() {
		return center;
	}

	public float getRadius() {
		return radius;
	}

	public Vector3 getDiffuse() {
		return diffuse;
	}

	public Vector3 getSpecular() {
		return specular;
	}

	public int getShininess() {
		return shininess;
	}
}
