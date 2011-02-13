package edu.uwb.css.voxel.domain;

public class Camera {

	protected Vector3 eye;
	
	protected Vector3 lookAt;
	
	protected Vector3 up;
	
	protected float screenDistance;
	
	protected float screenWidth;
	
	public Camera(Vector3 eye, Vector3 lookAt, Vector3 up, float screenDist, float screenWidth) {
		this.eye = eye;
		this.lookAt = lookAt;
		this.up = up;
		this.screenDistance = screenDist;
		this.screenWidth = screenWidth;
	}

	/**
	 * @return the eye
	 */
	public Vector3 getEye() {
		return eye;
	}

	/**
	 * @param eye the eye to set
	 */
	public void setEye(Vector3 eye) {
		this.eye = eye;
	}

	/**
	 * @return the lookAt
	 */
	public Vector3 getLookAt() {
		return lookAt;
	}

	/**
	 * @param lookAt the lookAt to set
	 */
	public void setLookAt(Vector3 lookAt) {
		this.lookAt = lookAt;
	}

	/**
	 * @return the up
	 */
	public Vector3 getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(Vector3 up) {
		this.up = up;
	}

	/**
	 * @return the screenDistance
	 */
	public float getScreenDistance() {
		return screenDistance;
	}

	/**
	 * @param screenDistance the screenDistance to set
	 */
	public void setScreenDistance(float screenDistance) {
		this.screenDistance = screenDistance;
	}

	/**
	 * @return the screenWidth
	 */
	public float getScreenWidth() {
		return screenWidth;
	}

	/**
	 * @param screenWidth the screenWidth to set
	 */
	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}
}
