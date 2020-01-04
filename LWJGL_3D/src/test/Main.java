package test;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
public class Main {

	private static long window;
	
	private GLFWCursorPosCallback mousepos = new GLFWCursorPosCallback() {
		
		@Override
		public void invoke(long window, double x, double y) {
			// TODO Auto-generated method stub
			GLFW.glfwSetWindowTitle(window, "Test | x: " + x + " y: "+ y);
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		while(!GLFW.glfwWindowShouldClose(window)) {
			GLFW.glfwPollEvents();
			GLFW.glfwSwapBuffers(window);
		}
	}

	public Main() {
		
		GLFW.glfwInit();
		
		window = GLFW.glfwCreateWindow(1000, 1000, "test", 0, 0);
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, videoMode.width()/2, videoMode.height()/2);
		GLFW.glfwMakeContextCurrent(window);
		
		GLFW.glfwSetCursorPosCallback(window, mousepos);
		
		GLFW.glfwShowWindow(window);
		
		GLFW.glfwSwapInterval(0);
	}
}
