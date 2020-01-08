package engine.io;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import game.Game;

public class Input {

	private static Game g;

	public Input(Game g) {
		this.g = g;
	}

	static GLFWCursorPosCallback mousepos = new GLFWCursorPosCallback() {

		private double lastX = -1;
		private double lastY = -1;
		
		private List<Integer> poses = new ArrayList<Integer>();
		
		@Override
		public void invoke(long window, double x, double y) {
			// TODO Auto-generated method stub
			if(lastX == -1&&lastY == -1) {
				lastX = x;
				lastY = y;
			}
				
			//System.out.println("(Debug) x: " + x +  " y: " + y);

			if(lastX>x) {
				poses.add(0);
				callMousePos(0,poses);
			}else if(lastX < x) {
				poses.add(1);
				callMousePos(1,poses);
			}
			
			lastX = x;
			lastY = y;
			
		}
	};

	static GLFWKeyCallback key = new GLFWKeyCallback() {
		private boolean pressed;
		private List<Integer> keys = new ArrayList<Integer>();

		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			// TODO Auto-generated method stub
			System.out.println("(Debug) key: " + key + " Scan: " + scancode + " action: " + action);

			if (action == 0) {
				keys.remove(keys.indexOf(key));
				Input.callKey(keys);
			} else if(action == 1){
				keys.add(key);
				Input.callKey(keys);
			}

		}
	};

	static GLFWMouseButtonCallback mButton = new GLFWMouseButtonCallback() {

		@Override
		public void invoke(long window, int key, int scancode, int action) {
			// TODO Auto-generated method stub

		}
	};

	public static void callKey(List<Integer> keys) {
		g.movecall( keys);
	}
	
	public static void callMousePos(int direction,List<Integer> poses) {
		g.mouseCall(direction,poses);

	}

}
