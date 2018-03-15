package Engine.Models;

public class RawModel {
    private int VAO;
    private int Vertices;
    private int Indices;
    private int ShaderProgram;

    public RawModel(int VAO, int VertexCount, int IndexCount, int ShaderProgram) {
        this.VAO = VAO;
        this.Vertices = Vertices;
        this.Indices = Indices;
        this.ShaderProgram = ShaderProgram;
    }

    public int getVAO() {
        return VAO;
    }

    public int getVertices() {
        return Vertices;
    }

    public int getIndices() {
        return Indices;
    }

    public int getShaderProgram() {
        return ShaderProgram;
    }
}
