package main;

import org.lwjgl.glfw.GLFW;

import engine.*;
import engine.graphics.Mesh;
import engine.graphics.Renderer;
import engine.graphics.Vertex;
import engine.io.Window;
import engine.maths.Vector3f;

public class Main {

	private Window window;
	
	private Renderer renderer = new Renderer();
	private Mesh mesh = new Mesh(new Vertex[] {
			new Vertex(new Vector3f(-0.5f,0.5f,0.0f)),
			new Vertex(new Vector3f(0.5f,0.5f,0.0f)),
			new Vertex(new Vector3f(0.5f,-0.5f,0.0f)),
			new Vertex(new Vector3f(-0.5f,-0.5f,0.0f))
	},new int[] {
		0, 1, 2,
		0, 3, 2
	});
	
	public Main() {
		create_Window();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}

	
	void create_Window() {
		//new Thread(()->{ 
			window = new Window(1000,500,"test",false);
			window.SetBackgroundColor(0, 0, 0);
			window.Create();
			mesh.create();
			while(!GLFW.glfwWindowShouldClose(Window.window)) {
				refresh();
			}
		//}).start();
	}
	void refresh() {
		window.update();
		renderer.renderMesh(mesh);
		window.render();
	}
}
