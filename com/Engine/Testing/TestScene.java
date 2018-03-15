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

        ModelLoader loader = new ModelLoader();

        RawModel triangleOBJ = loader.dataToRawModel(triangle_verts, triangle_indis);
        System.out.println("Created triangle obj");
        RawModel[] scene = {triangleOBJ};


        System.out.println("Finished init");
        renderer.render(scene);
        System.out.println("Terminating render loop");
    }
}
