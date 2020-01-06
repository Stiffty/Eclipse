package engine.graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class GLSLProgram {

	private int program;
	public GLSLProgram(String fragmentShaderFile) {
		// TODO Auto-generated constructor stub
		program= GL20.glCreateProgram();
		addShader(GL20.GL_FRAGMENT_SHADER, fragmentShaderFile);
		
		
		GL20.glLinkProgram(program);
		GL20.glValidateProgram(program);
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

	private void addShader(int shaderTyp,String file) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(GLSLProgram.class.getResourceAsStream(file)));
			StringBuilder builder = new StringBuilder();
			while(reader.ready()) {
				builder.append(reader.readLine() + System.lineSeparator());
			}
			reader.close();
			
			
			int id = GL20.glCreateShader(shaderTyp);
			GL20.glShaderSource(id, builder);
			GL20.glCompileShader(id);
			
			if(GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
				throw new RuntimeException("Shader Copmiling failed: "+ GL20.glGetShaderInfoLog(id));
			}
			GL20.glAttachShader(program, id);
			GL20.glDeleteShader(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
