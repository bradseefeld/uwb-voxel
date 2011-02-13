package edu.uwb.css.voxel.parser.runnable;

import java.util.List;

import edu.uwb.css.voxel.domain.Camera;
import edu.uwb.css.voxel.domain.DirectedLight;
import edu.uwb.css.voxel.domain.Scene;
import edu.uwb.css.voxel.domain.Sphere;
import edu.uwb.css.voxel.parser.CameraParser;
import edu.uwb.css.voxel.parser.DirectedLightParser;
import edu.uwb.css.voxel.parser.SceneParser;
import edu.uwb.css.voxel.parser.SphereParser;

public class NodeParserRunnable implements Runnable {

	protected Scene scene;
	
	protected List<String> raw;
	
	protected SphereParser sphereParser;
	
	protected SceneParser sceneParser;
	
	protected CameraParser cameraParser;
	
	protected DirectedLightParser directedLightParser;
	
	public NodeParserRunnable(
			Scene scene, 
			List<String> raw,
			CameraParser cameraParser,
			SceneParser sceneParser,
			SphereParser sphereParser,
			DirectedLightParser directedLightParser) {
		
		this.scene = scene;
		this.raw = raw;
		
		this.cameraParser = cameraParser;
		this.sceneParser = sceneParser;
		this.sphereParser = sphereParser;
		this.directedLightParser = directedLightParser;
		
	}
	
	public void run() {
		
		try {
			
			if (raw == null) {
				throw new IllegalStateException("Raw line data cannot be null.");
			}
			
			// What kind of node are we dealing with (sphere, light, etc)?
			String type = null;
			for (String line : raw) {
				if (line.contains(":")) {
					type = line.trim();
					break;
				}
			}
			
			if (type == null) {
				// Missing type. Will not parse.
				return;
			}
			
			type = type.trim();
			
			// Which type are we parsing?
			if (type.equals("sphere:")) {
				Sphere sphere = sphereParser.parse(raw);
				synchronized(scene) {
					scene.add(sphere);
				}
			} else if (type.equals("scene:")) {
				sceneParser.parse(raw, scene);
			} else if (type.equals("camera:")) {
				Camera cam = cameraParser.parse(raw);
				synchronized(scene) {
					scene.setCamera(cam);
				}
			} else if (type.equals("light-directed:")) {
				DirectedLight light = directedLightParser.parse(raw);
				synchronized(scene) {
					scene.add(light);
				}
			}
			
		} catch (RuntimeException e) {
			// TODO: Log exception
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
