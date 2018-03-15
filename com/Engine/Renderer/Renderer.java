package Engine.Renderer;

//TODO why am I running with -XstartOnFirstThread JVM flag


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
        window = glfwCreateWindow(WIDTH, HEIGHT, "Test Window 1", NULL, NULL);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1); //Enables vsync
        GL.createCapabilities();
        glClearColor(0.1f, 0.1f, 0.1f, 0.5f); //Set background color
    }
    public void render() {
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(window);

            glfwPollEvents();
        }
        glfwTerminate();
    }
}