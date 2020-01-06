package engine.graphics;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;

public class Texture {

	private int id;
	
	public Texture(String fileName) {
		// TODO Auto-generated constructor stub
		InputStream is = Texture.class.getResourceAsStream(fileName);
		if(is == null)
			throw new RuntimeException("recource not found");
		
		ByteBuffer rawBytes = null;
		try {
			rawBytes = ioResourceToByteBuffer(is, 16384);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IntBuffer w = BufferUtils.createIntBuffer(1);
		IntBuffer h = BufferUtils.createIntBuffer(1);
		IntBuffer c = BufferUtils.createIntBuffer(1);
		ByteBuffer decodeImage = STBImage.stbi_load_from_memory(rawBytes, w, h, c, 0);
		if(decodeImage == null) {
			throw new RuntimeException("image could not be decoded");
		}
		
		int width = w.get();
		int height = h.get();
		
		id = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width, height,0, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, decodeImage);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		
		STBImage.stbi_image_free(decodeImage);
		System.out.println("t");
		
	}
	
	public void release() {
		GL11.glDeleteTextures(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static ByteBuffer ioResourceToByteBuffer(InputStream source, int buffersize) throws IOException{
		ByteBuffer buffer = null;
		
		try(ReadableByteChannel rbc = Channels.newChannel(source)){
			buffer = BufferUtils.createByteBuffer(buffersize);
			
			while(true) {
				int bytes = rbc.read(buffer);
				if(bytes == -1)
					break;
				if(buffer.remaining() == 0)
					buffer = resizeBuffer(buffer,buffer.capacity()*2);
			}
		}
			catch(Throwable t ) {
				throw new NullPointerException("Input stream not valid!");
			}
			buffer.flip();
			return buffer;
		}
	
	
	private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity) {
		ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
		buffer.flip();
		newBuffer.put(buffer);
		return newBuffer;
	}
	}

