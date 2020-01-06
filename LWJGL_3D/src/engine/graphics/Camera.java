package engine.graphics;



import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import engine.io.Window;

public class Camera {

	private static final Vector3f UP_VECTOR = new Vector3f(0,1,0);
	
	protected Matrix4f viewMatrix = new Matrix4f();
	protected Matrix4f projctionMatrix = new Matrix4f();

	protected Vector3f position = new Vector3f();
	protected Vector3f rotation = new Vector3f(0, 90, 0);
	protected Vector3f direction = new Vector3f();
	protected Vector3f target = new Vector3f();

	protected float nearplane = 0.1f;
	protected float farplane = 1000f;
	protected float fov = 60;
	public Camera() {
		// TODO Auto-generated constructor stub
	}

	public void update() {
		double pitch = Math.toRadians(rotation.x);
		double yaw = Math.toRadians(rotation.y);
		
		direction.x =  (float) (Math.cos(pitch)*Math.sin(yaw));
		direction.y = (float)Math.sin(pitch);
		direction.z = (float)(Math.cos(pitch)*Math.cos(yaw));
		
		viewMatrix.setLookAt(position, position.add(direction,target ),UP_VECTOR);
		projctionMatrix.setPerspective((float) Math.toRadians(fov), 800/600, nearplane, farplane);
	}
	
	

	public Matrix4f getViewMatrix() {
		return viewMatrix;
	}

	public void setViewMatrix(Matrix4f viewMatrix) {
		this.viewMatrix = viewMatrix;
	}

	public Matrix4f getProjctionMatrix() {
		return projctionMatrix;
	}

	public void setProjctionMatrix(Matrix4f projctionMatrix) {
		this.projctionMatrix = projctionMatrix;
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

	public Vector3f getDirection() {
		return direction;
	}

	public void setDirection(Vector3f direction) {
		this.direction = direction;
	}

	public Vector3f getTarget() {
		return target;
	}

	public void setTarget(Vector3f target) {
		this.target = target;
	}

	public float getNearplane() {
		return nearplane;
	}

	public void setNearplane(float nearplane) {
		this.nearplane = nearplane;
	}

	public float getFarplane() {
		return farplane;
	}

	public void setFarplane(float farplane) {
		this.farplane = farplane;
	}

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public static Vector3f getUpVector() {
		return UP_VECTOR;
	}
	
}
