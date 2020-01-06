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

	private float[] positions;
	
	private int vao,ibo;
	private int[] vbos;
	private int vertexCount;
	
	private boolean isUsingIndexBuffer;
	private int indexBufferVbo;
	
	public Mesh(float[] positions) {
		super();
		this.positions = positions;
	}
	
	public void create() {
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		int positionVBO = addStaticAttribute(0, positions, 3);
		
		vbos = new int[] {positionVBO};
		vertexCount = positions.length/3;
//		FloatBuffer positionbuffer = MemoryUtil.memAllocFloat(vertices.length*3);
//		float[] positiondata = new float[vertices.length*3];
//		for (int i = 0; i < vertices.length; i++) {
//			positiondata[i*3] = vertices[i].getPosition().getX();
//			positiondata[i*3 + 1] = vertices[i].getPosition().getY();
//			positiondata[i*3 + 2] = vertices[i].getPosition().getZ();
//		}
//		
//		positionbuffer.put(positiondata).flip();
//		
//		vbo = GL15.glGenBuffers();
//		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
//		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positionbuffer, GL15.GL_STATIC_DRAW);
//		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
//		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
//		
//		IntBuffer indicesbuffer = MemoryUtil.memAllocInt(indices.length);
//		indicesbuffer.put(indices).flip();
//		
//		ibo = GL15.glGenBuffers();
//		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
//		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesbuffer, GL15.GL_STATIC_DRAW);
//		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		
	}

	public void createWithindex(int[] indeces) {
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		indexBufferVbo = attachIndexBuffer(indeces);
		int positionVBO = addStaticAttribute(0, positions, 3);
		
		vbos = new int[] {positionVBO};
		vertexCount = indeces.length;
		
		isUsingIndexBuffer = true;
	}
	public void render() {
		GL30.glBindVertexArray(vao);
		
		for (int i = 0; i < vbos.length; i++) {
			GL20.glEnableVertexAttribArray(i);
		}
		
		if(isUsingIndexBuffer) {
			GL11.glDrawElements(GL11.GL_TRIANGLES, vertexCount, GL11.GL_UNSIGNED_INT,0);
		}else {
			GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
		}
		
		for (int i = 0; i < vbos.length; i++) {
			GL20.glDisableVertexAttribArray(i);
		}
	}
	
	public void release() {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glDeleteVertexArrays(vao);
		for(int id: vbos) {
			GL15.glDeleteBuffers(id);
		}
		if(isUsingIndexBuffer) {
			GL15.glDeleteBuffers(indexBufferVbo);
		}
	}
	
	int addStaticAttribute(int index,float[] data,int dataSize) {
		int vbo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(index, dataSize, GL11.GL_FLOAT, false, 0, 0);
		return vbo;
	}
	
	private int attachIndexBuffer(int[] indeces) {
		int vbo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);		
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indeces, GL15.GL_STATIC_DRAW);
		return vbo;
	}
	

	public int getVao() {
		return vao;
	}

	public void setVao(int vao) {
		this.vao = vao;
	}


	public int getIbo() {
		return ibo;
	}

	public void setIbo(int ibo) {
		this.ibo = ibo;
	}
	
}
