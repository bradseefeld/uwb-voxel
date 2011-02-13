package edu.uwb.css.voxel.domain;

import java.util.LinkedList;
import java.util.List;

public class Scene {

	protected List<Sphere> spheres;
	
	protected List<DirectedLight> lights;
	
	protected Vector3 backgroundColor;
	
	protected Vector3 ambientLight;
	
	protected int superSampleWidth;
	
	protected Camera camera;
	
	public Scene() {
		spheres = new LinkedList<Sphere>();
		lights = new LinkedList<DirectedLight>();
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
	
	public void add(DirectedLight light) {
		lights.add(light);
	}
	
	public List<DirectedLight> getLights() {
		return lights;
	}
	
	public List<Sphere> getSpheres() {
		return spheres;
	}

	public Vector3 getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Vector3 backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Vector3 getAmbientLight() {
		return ambientLight;
	}

	public void setAmbientLight(Vector3 ambientLight) {
		this.ambientLight = ambientLight;
	}

	public int getSuperSampleWidth() {
		return superSampleWidth;
	}

	public void setSuperSampleWidth(int superSampleWidth) {
		this.superSampleWidth = superSampleWidth;
	}
}
