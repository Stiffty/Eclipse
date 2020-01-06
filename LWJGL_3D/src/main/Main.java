package main;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import engine.*;
import engine.graphics.Mesh;
import engine.io.Window;
import engine.maths.Vector3f;

public class Main {

	private Window window;
	
	public Main() {
		create_Window();
	}
	
	void create_Window() {
			window = new Window(1000,500,"test",false);
			window.SetBackgroundColor(1, 0, 1);
			window.Create();
			init();
			while(!GLFW.glfwWindowShouldClose(Window.window)) {
				refresh();
			}
			realease();
	}
	public void refresh() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		render();
		window.render();
		window.update();
	}
	
	public void init() {
		
	}
	
	public void render() {
		
	}
	
	public void realease() {
		
	}
}
