package test;
import windows.x64.org.lwjgl.opengl.*;
import org.lwjgl.system.windows.*;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
public class Main {

	private static long window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new_Window();

	}

	static void new_Window() {
		
		GLFW.glfwInit();
		
		window = GLFW.glfwCreateWindow(100, 100, "test", 0, 0);
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, videoMode.width()/2, videoMode.height()/2);
		
		GLFW.glfwShowWindow(window);
	}
}
