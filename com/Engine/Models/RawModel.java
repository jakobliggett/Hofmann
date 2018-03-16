package Engine.Models;

public class RawModel {
    private int VAO;
    private int VertexCount;
    private int IndexCount;
    private int ShaderProgram;

    public RawModel(int VAO, int VertexCount, int IndexCount, int ShaderProgram) {
        this.VAO = VAO;
        this.VertexCount = VertexCount;
        this.IndexCount = IndexCount;
        this.ShaderProgram = ShaderProgram;
    }

    public int getVAO() {
        return VAO;
    }

    public int getVertices() {
        return VertexCount;
    }

    public int getIndices() {
        return IndexCount;
    }
    
    public int getShaderProgram() {
        return ShaderProgram;
    }
}
