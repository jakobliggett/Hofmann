package Engine.Renderer;

//TODO why am I running with -XstartOnFirstThread JVM flag


import Engine.Models.RawModel;
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

public class Renderer {
    private long window;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        glfwInit();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4); //Set to run on openGL version 400 core
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE); //This line is necessary to tell macOS not to use legacy openGL 2.1
        window = glfwCreateWindow(WIDTH, HEIGHT, "Test Window 1", NULL, NULL);

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1); //Enables vsync
        GL.createCapabilities();
        System.out.println("Attempting startup with openGL version: " + glGetString(GL_VERSION));
        glClearColor(0.1f, 0.1f, 0.1f, 0.5f); //Set background color

    }

    private void DrawModels(RawModel[] models) {
        for (RawModel model : models) {
            //System.out.println("Attempting to draw");
            GL30.glBindVertexArray(model.getVAO());
            GL20.glUseProgram(model.getShaderProgram());

            glDrawArrays(GL_TRIANGLES, 0, 3);
            //glDrawElements(GL_TRIANGLES, model.getIndices(), GL_UNSIGNED_INT, 0);

            GL20.glUseProgram(0);
            GL30.glBindVertexArray(0);
        }
    }

    public void render(RawModel[] scene) {
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT);

            DrawModels(scene);

            glfwSwapBuffers(window);

            glfwPollEvents();
        }
        glfwTerminate();
    }
}