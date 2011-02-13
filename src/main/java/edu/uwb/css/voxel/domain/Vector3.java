package edu.uwb.css.voxel.domain;

public class Vector3 {

	protected float x;
	
	protected float y;
	
	protected float z;
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof Vector3)) {
			return false;
		}
		
		Vector3 o = (Vector3) other;
		
		return o.x == x && o.y == y && o.z == z;
	}
}
