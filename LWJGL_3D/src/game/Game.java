package game;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement.GlobalScope;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL30;

import engine.graphics.Camera;
import engine.graphics.Entity;
import engine.graphics.GLSLProgram;
import engine.graphics.Mesh;
import engine.graphics.Texture;
import engine.io.Input;
import main.Main;

public class Game extends Main {

	private Mesh rect;
	private GLSLProgram basicShader;
	private GLSLProgram entityshader;
	private Texture testtexture;
	private Entity cube;
	private Camera camera;

	private Input input = new Input(this);
	private static List<Integer> key = new ArrayList<Integer>();
	
	private static float xOffsetCamera;
	private static float zOffsetCamera;

	private float vertexshaderoffset = 0.5f;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
	}

	@Override
	public void init() {
		camera = new Camera();

		xOffsetCamera = camera.getPosition().z;

		testtexture = new Texture("/res/textures/a4-metallisierung-img-3416-b.jpg");
		rect = new Mesh(new float[] { -0.5f, 0.5f, -0.5f, -0.5f, -0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, -0.5f,
				-0.5f, 0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.5f,

				0.5f, 0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.5f,

				-0.5f, 0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, 0.5f, -0.5f, 0.5f, 0.5f,

				-0.5f, 0.5f, 0.5f, -0.5f, 0.5f, -0.5f, 0.5f, 0.5f, -0.5f, 0.5f, 0.5f, 0.5f,

				-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, -0.5f, 0.5f });
		rect.createWithindexAndTextures(
				new int[] { 0, 1, 3, 3, 1, 2, 4, 5, 7, 7, 5, 6, 8, 9, 11, 11, 9, 10, 12, 13, 15, 15, 13, 14, 16, 17, 19,
						19, 17, 18, 20, 21, 23, 23, 21, 22 },
				new float[] { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1,
						1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 });

		cube = new Entity(rect);

		// shader
		basicShader = new GLSLProgram("/res/shader/basic.vs", "/res/shader/basic.fs", "postions", "textureCoordinates");
		basicShader.addUniformVariable("offset");
		basicShader.addUniformVariable("diffuseTexture");

		entityshader = new GLSLProgram("/res/shader/entity.vs", "/res/shader/entity.fs", "postions",
				"textureCoordinates");
		entityshader.addUniformVariable("diffuseTexture");
		entityshader.addUniformVariable("transformationMatrix");
		entityshader.addUniformVariable("viewMatrix");
		entityshader.addUniformVariable("projectionMatrix");
	}

	@Override
	public void render() {
		cube.getPosition().x = 4f;
		cube.getRotation().y += 1f;
		cube.getRotation().x += 1f;
		cube.getRotation().z += 1f;

		move();
		
		camera.getPosition().x = xOffsetCamera;
		camera.getPosition().z = zOffsetCamera;
		
		cube.update();
		camera.update();

		entityshader.enable();
		entityshader.setTexture("diffuseTexture", testtexture, 0);
		entityshader.setMatrix("transformationMatrix", cube.getTransformationMatrix());
		entityshader.setMatrix("viewMatrix", camera.getViewMatrix());
		entityshader.setMatrix("projectionMatrix", camera.getProjctionMatrix());

		cube.getMesh().render();

//		basicShader.enable();
//		basicShader.setVec3("offset", vertexshaderoffset, 0f, 0f);
//		basicShader.setTexture("diffuseTexture", testtexture, 0);
//		rect.render();
		// vertexshaderoffset+=0.0001f;
	}

	@Override
	public void realease() {
		cube.getMesh().release();
		basicShader.release();
	}

	public static void move() {
		float speed = 0.1f;
		
		
			for(int i = 0;i<key.size();i++) {
				if(key.get(i) == GLFW.GLFW_KEY_LEFT_SHIFT) {
					speed = 0.2f;
				}
				
				if(key.get(i) == GLFW.GLFW_KEY_W) {
					xOffsetCamera+=0.1;
				}
				if(key.get(i) == GLFW.GLFW_KEY_S) {
					xOffsetCamera-=0.1;
				}
				if(key.get(i) == GLFW.GLFW_KEY_A) {
					zOffsetCamera-=0.1;
				}
				if(key.get(i) == GLFW.GLFW_KEY_D) {
					zOffsetCamera+=0.1;
				}
			}
	}
	public static void movecall(List<Integer> keyi){
		key = keyi;
	}

}
