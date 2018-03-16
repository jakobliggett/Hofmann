package Engine.Models;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import java.nio.*;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import Engine.Models.RawModel;
import Engine.Shaders.ShaderLoader;

public class ModelLoader {
    public RawModel dataToRawModel(float[] vertices_data, int[] indices_data) {

        int VAO = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(VAO);

        FloatBuffer vertices = floatArrayToBuffer(vertices_data);
        IntBuffer indices = intArrayToBuffer(indices_data);

        CreateVBO(vertices);
        CreateEBO(indices);

        int ShaderProgram = ShaderLoader.loadShaderProgram();

        GL30.glBindVertexArray(0);
        //System.out.print("Creating new model with stats");
        //System.out.printf("VAO: %d, vert#: %d, ind#: %d, ShaderProg: %d \n", VAO, vertices_data.length, indices_data.length, ShaderProgram);
        return new RawModel(VAO, vertices_data.length, indices_data.length, ShaderProgram);
    }

    private int CreateVBO(FloatBuffer data) {
        int VBO = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, data, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        GL20.glEnableVertexAttribArray(0);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        return VBO;
    }

    private int CreateEBO(IntBuffer data) {
        int EBO = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, EBO);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, data, GL15.GL_STATIC_DRAW);
        //GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0); //NOTE: Don't unbind EBO as VAO removes ebo from itself when unbind is called
        return EBO;
    }


    private FloatBuffer floatArrayToBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    private IntBuffer intArrayToBuffer(int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }
}
