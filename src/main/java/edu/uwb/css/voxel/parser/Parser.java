package edu.uwb.css.voxel.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import edu.uwb.css.voxel.domain.Scene;
import edu.uwb.css.voxel.parser.runnable.NodeParserRunnable;


public class Parser {

	protected CameraParser cameraParser;
	
	protected DirectedLightParser directedLightParser;
	
	protected SceneParser sceneParser;
	
	protected SphereParser sphereParser;
	
	// TODO: Make these thread pool values configurable
	
	protected static final int CORE_POOL_SIZE = 4; // Threads
	
	protected static final int MAX_POOL_SIZE = 100; // Threads
	
	public Parser() {
		this.sphereParser = new SphereParser();
		this.sceneParser = new SceneParser();
		this.cameraParser = new CameraParser();
		this.directedLightParser = new DirectedLightParser();
	}
	
	public Scene parse(InputStream input) throws IOException {
		
		if (input == null) {
			throw new IllegalArgumentException("InputStream cannot be null.");
		}
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				CORE_POOL_SIZE, 
				MAX_POOL_SIZE, 
				1, 
				TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>());
		
		Scene scene = new Scene();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
		String line = null;
		List<String> lines = new LinkedList<String>();
	
		do {
			line = reader.readLine();
			
			if (line != null) {
				lines.add(line);
			}

			// Have we finished reading in all the lines for a node?
			if (line == null || line.isEmpty()) {
				
				// Allow the parsing of the node to happen in a separate thread/runnable.
				NodeParserRunnable runnable = new NodeParserRunnable(
						scene, 
						lines,
						cameraParser,
						sceneParser,
						sphereParser,
						directedLightParser);
			
				executor.submit(runnable);
				
				// Reset lines queue.
				lines = new LinkedList<String>();
			}
			
		} while (line != null);
		
		// Wait for all threads to finish
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scene;
	}
}
