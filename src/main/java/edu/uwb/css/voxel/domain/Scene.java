package edu.uwb.css.voxel.domain;

import java.util.LinkedList;
import java.util.List;

public class Scene {

	protected List<Sphere> spheres;
	
	protected Camera camera;
	
	public Scene() {
		spheres = new LinkedList<Sphere>();
	}
	
	/**
	 * @return the camera
	 */
	public Camera getCamera() {
		return camera;
	}

	/**
	 * @param camera the camera to set
	 */
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public void add(Sphere sphere) {
		spheres.add(sphere);
	}
	
	public List<Sphere> getSpheres() {
		return spheres;
	}
}
