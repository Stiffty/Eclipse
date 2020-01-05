package engine.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

public class Mesh {

	private Vertex[] vertices;
	private int[] indices;
	private int vao,pbo,ibo;
	
	public Mesh(Vertex[] vertices, int[] indices) {
		super();
		this.vertices = vertices;
		this.indices = indices;
	}
	
	public void create() {
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		FloatBuffer positionbuffer = MemoryUtil.memAllocFloat(vertices.length*3);
		float[] positiondata = new float[vertices.length*3];
		for (int i = 0; i < vertices.length; i++) {
			positiondata[i*3] = vertices[i].getPosition().getX();
			positiondata[i*3 + 1] = vertices[i].getPosition().getY();
			positiondata[i*3 + 2] = vertices[i].getPosition().getZ();
		}
		
		positionbuffer.put(positiondata).flip();
		
		pbo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, pbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positionbuffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
		IntBuffer indicesbuffer = MemoryUtil.memAllocInt(indices.length);
		indicesbuffer.put(indices).flip();
		
		ibo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesbuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		
	}

	public Vertex[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertex[] vertices) {
		this.vertices = vertices;
	}

	public int[] getIndices() {
		return indices;
	}

	public void setIndices(int[] indices) {
		this.indices = indices;
	}

	public int getVao() {
		return vao;
	}

	public void setVao(int vao) {
		this.vao = vao;
	}

	public int getPbo() {
		return pbo;
	}

	public void setPbo(int pbo) {
		this.pbo = pbo;
	}

	public int getIbo() {
		return ibo;
	}

	public void setIbo(int ibo) {
		this.ibo = ibo;
	}
	
}
