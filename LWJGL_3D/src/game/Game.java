package game;

import engine.graphics.GLSLProgram;
import engine.graphics.Mesh;
import engine.graphics.Texture;
import main.Main;

public class Game extends Main{

	private Mesh rect;
	private GLSLProgram basicShader;
	private Texture testtexture;
	
	private float vertexshaderoffset = 0.5f;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
	}

	@Override
	public void init() {
		testtexture = new Texture("/res/textures/a4-metallisierung-img-3416-b.jpg");
		rect = new Mesh( new float[] {
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,
                0.5f, 0.5f, 0
              });
		rect.createWithindexAndTextures(new int[] {
                0, 1, 3,
                3, 1, 2},new float[] {
                		0,0,
                		0,1,
                		1,1,
                		1,0
                });
		//shader
		basicShader = new GLSLProgram("/res/shader/basic.vs","/res/shader/basic.fs","postions","textureCoordinates");
		basicShader.addUniformVariable("offset");
		basicShader.addUniformVariable("diffuseTexture");
	}
	@Override
	public void render() {
		basicShader.enable();
		basicShader.setVec3("offset", vertexshaderoffset, 0f, 0f);
		basicShader.setTexture("diffuseTexture", testtexture, 0);
		rect.render();
		//vertexshaderoffset+=0.0001f;
	}
	@Override
	public void realease() {
		rect.release();
		basicShader.release();
	}
}
