package Engine.Testing;

import Engine.Renderer.Renderer;

public class TestScene {

    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        renderer.init();
        System.out.println("Finished init");
        renderer.render();
        System.out.println("Terminating render loop");
    }
}
