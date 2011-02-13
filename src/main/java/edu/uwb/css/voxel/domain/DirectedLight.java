package edu.uwb.css.voxel.domain;

public class DirectedLight {

	protected Vector3 direction;
	
	protected Vector3 color;
	
	public DirectedLight(Vector3 direction, Vector3 color) {
		this.direction = direction;
		this.color = color;
	}

	/**
	 * @return the direction
	 */
	public Vector3 getDirection() {
		return direction;
	}

	/**
	 * @return the color
	 */
	public Vector3 getColor() {
		return color;
	}
}
