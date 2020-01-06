package game;

import engine.graphics.Mesh;
import main.Main;

public class Game extends Main{

	private Mesh rect;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
	}

	@Override
	public void init() {
		rect = new Mesh( new float[] {
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,
                0.5f, 0.5f, 0
              });
		rect.createWithindex(new int[] {
                0, 1, 3,
                3, 1, 2});
	}
	@Override
	public void render() {
		rect.render();
	}
	@Override
	public void realease() {
		rect.release();
	}
}
