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

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @return the z
	 */
	public float getZ() {
		return z;
	}
}
