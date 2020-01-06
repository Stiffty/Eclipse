package engine.graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;

public class GLSLProgram {

	private static final float[] MATRIX_BUFFER = new float[16];
	
	private int program;

	private HashMap<String, Integer> uniformvariables = new HashMap<>();

	public GLSLProgram(String fragmentShaderFile) {
		// TODO Auto-generated constructor stub
		program = GL20.glCreateProgram();
		addShader(GL20.GL_FRAGMENT_SHADER, fragmentShaderFile);

		GL20.glLinkProgram(program);
		GL20.glValidateProgram(program);
	}

	public GLSLProgram(String vertexShaderFile, String fragmentShaderFile, String... vertexAtributes) {
		// TODO Auto-generated constructor stub
		program = GL20.glCreateProgram();
		addShader(GL20.GL_VERTEX_SHADER, vertexShaderFile);
		addShader(GL20.GL_FRAGMENT_SHADER, fragmentShaderFile);

		for (int i = 0; i < vertexAtributes.length; i++) {
			GL20.glBindAttribLocation(program, i, vertexAtributes[i]);
		}

		GL20.glLinkProgram(program);
		GL20.glValidateProgram(program);
	}

	// uniform variable
	public void addUniformVariable(String variable) {
		int location = GL20.glGetUniformLocation(program, variable);

		uniformvariables.put(variable, location);

	}

	public void setVec3(String variable, float x, float y, float z) {
		if (uniformvariables.containsKey(variable)) {
			enable();
			int location = uniformvariables.get(variable);
			GL20.glUniform3f(location, x, y, z);
		}
	}
	
	public void setTexture(String variabel, Texture texture, int textureSlot) {
		if(uniformvariables.containsKey(variabel)) {
			enable();
			int location = uniformvariables.get(variabel);
			GL20.glUniform1i(location, textureSlot);
			GL13.glActiveTexture(GL13.GL_TEXTURE0 + textureSlot);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getId());
		}
	}

	public void setMatrix(String variable,Matrix4f matrix) {
		if(uniformvariables.containsKey(variable)) {
			enable();
			int location = uniformvariables.get(variable);
			GL20.glUniformMatrix4fv(location, false, matrix.get(MATRIX_BUFFER));
		}
	}
	public void enable() {
		GL20.glUseProgram(program);
	}

	public void disable() {
		GL20.glUseProgram(0);
	}

	public void release() {
		disable();
		GL20.glDeleteProgram(program);
	}

	private void addShader(int shaderTyp, String file) {

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(GLSLProgram.class.getResourceAsStream(file)));
			StringBuilder builder = new StringBuilder();
			while (reader.ready()) {
				builder.append(reader.readLine() + System.lineSeparator());
			}
			reader.close();

			int id = GL20.glCreateShader(shaderTyp);
			GL20.glShaderSource(id, builder);
			GL20.glCompileShader(id);

			if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) != GL11.GL_TRUE) {
				System.out.println("Shader Copmiling failed: " + GL20.glGetShaderInfoLog(id));
				throw new RuntimeException("Shader Copmiling failed: " + GL20.glGetShaderInfoLog(id));
			}
			GL20.glAttachShader(program, id);
			GL20.glDeleteShader(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
