package engine.graphics;

import engine.maths.Vector3f;

public class Vertex {
	private Vector3f position;

	public Vertex(Vector3f position) {
		super();
		this.position = position;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	

}
