package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.*;

public class Window {

	private int heigth;
	private int width;
	private String titel;
	private boolean isFullscreen;
	
	private float[] backgroundColor = new float[3];
	
	private GLFWWindowSizeCallback windowSizeCallback;
	
	public static long window;

	public Window(int heigth, int width, String titel,boolean fullscreen) {
		super();
		this.heigth = heigth;
		this.width = width;
		this.titel = titel;
		this.isFullscreen = fullscreen;
	}

	public void Create() {
		GLFWErrorCallback.createPrint(System.err).set();
		GLFW.glfwInit();

		window = GLFW.glfwCreateWindow(heigth, width, titel, isFullscreen?GLFW.glfwGetPrimaryMonitor():0, 0);

		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width()-width) / 2, (videoMode.height()-heigth) / 2);
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		callbacks();

		GLFW.glfwShowWindow(window);

		GLFW.glfwSwapInterval(0);
	}
	
	void callbacks() {
		
		windowSizeCallback = new GLFWWindowSizeCallback() {
			
			@Override
			public void invoke(long window, int x, int y) {
				// TODO Auto-generated method stub
				width = x;
				heigth = y;
			}
		};
		
		GLFW.glfwSetWindowSizeCallback(window, windowSizeCallback);
		GLFW.glfwSetKeyCallback(window, Input.key);
		//GLFW.glfwSetCursorPosCallback(window, mousepos);
	}
	
	
	
	public void update() {
		GL11.glViewport(0, 0, width, heigth);
		GL11.glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], 1.0f);
		//GL11.glClearColor(100f, 100f, 100f, 1f);
		//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		GLFW.glfwPollEvents();
	}
	public void render() {
		GLFW.glfwSwapBuffers(window);
	}
	
	public void SetBackgroundColor(float r, float g, float b) {
		this.backgroundColor[0] = r;
		this.backgroundColor[1] = g;
		this.backgroundColor[2] = b;
	}
}
