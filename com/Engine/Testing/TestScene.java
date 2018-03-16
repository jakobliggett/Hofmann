package Engine.Testing;

import Engine.Models.ModelLoader;
import Engine.Models.RawModel;
import Engine.Renderer.Renderer;

public class TestScene {

    public static void main(String[] args) {

        Renderer renderer = new Renderer();
        renderer.init(); // MUST INIT FIRST

        float[] triangle_verts = {
                0.0f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f
        };
        int[] triangle_indis = {
          0, 1, 2
        };


        float[] square_verts = {
                0.5f,  0.5f, 0.0f,  // top right
                0.5f, -0.5f, 0.0f,  // bottom right
                -0.5f, -0.5f, 0.0f,  // bottom left
                -0.5f,  0.5f, 0.0f   // top left
        };
        int[] square_indis = {
                0, 1, 3,   // first triangle
                1, 2, 3    // second triangle
        };

        ModelLoader loader = new ModelLoader();

        RawModel triangleOBJ = loader.dataToRawModel(triangle_verts, triangle_indis);
        RawModel squareOBJ = loader.dataToRawModel(square_verts, square_indis);
        System.out.println("Created obj");
        RawModel[] scene = {squareOBJ};


        System.out.println("Finished init");
        renderer.render(scene);
        System.out.println("Terminating render loop");
    }
}
