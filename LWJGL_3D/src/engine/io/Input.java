package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class Input {

	static GLFWCursorPosCallback mousepos = new GLFWCursorPosCallback() {
		
		@Override
		public void invoke(long window, double x, double y) {
			// TODO Auto-generated method stub
			
		}
	};
	
	static GLFWKeyCallback key = new GLFWKeyCallback() {
		
		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			// TODO Auto-generated method stub
			System.out.println("(Debug) key: "+key+" Scan: "+ scancode + " action: "+action);
			if(key == GLFW.GLFW_KEY_F11) {
				System.out.println("(Debug)F11");
			}
		}
	};
	
	static GLFWMouseButtonCallback mButton = new GLFWMouseButtonCallback() {
		
		@Override
		public void invoke(long window, int key, int scancode, int action) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
