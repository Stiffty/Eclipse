package engine.graphics;

import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Entity {

	private Mesh mesh;
	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;
	
	private Matrix4f transformationMatrix;
	
	public Entity(Mesh mesh) {
		// TODO Auto-generated constructor stub
		this.mesh = mesh;
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		this.scale = new Vector3f(1,1,1);
		this.transformationMatrix = new Matrix4f();
	}

	public void update() {
		transformationMatrix.identity();
		transformationMatrix.translate(position);
		transformationMatrix.scale(scale);
		transformationMatrix.rotateXYZ((float)(Math.toRadians(rotation.x)), (float)(Math.toRadians(rotation.y)), (float)(Math.toRadians(rotation.z)));
		
	}

	public Mesh getMesh() {
		return mesh;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}

	public Matrix4f getTransformationMatrix() {
		return transformationMatrix;
	}

	public void setTransformationMatrix(Matrix4f transformationMatrix) {
		this.transformationMatrix = transformationMatrix;
	}
	
}

