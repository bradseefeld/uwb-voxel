package edu.uwb.css.voxel.domain;

public class Voxel extends Scene {

	protected Vector3 center;
	
	protected float height;
	
	protected float width;
	
	public Voxel(Vector3 center, float width, float height) {
		this.center = center;
		this.width = width;
		this.height = height;
	}
}
