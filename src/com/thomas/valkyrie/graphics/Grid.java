package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-06.
 */
public class Grid
{
    private VertexArray vertexArray;
    private Texture texture;
    private static Entity entity;

    private Matrix4f grid_matrix;

    public Grid(float x, float y, float z)
    {
        // The vertices of our Triangle
        float[] vertices = new float[]
                {
                        -0.5f, 0.5f, 0.0f,
                        -0.5f, -0.5f, 0.0f,
                        0.5f, -0.5f, 0.0f,
                        0.5f, 0.5f, 0.0f
                };

        float[] textureCoordinates = new float[]
                {
                        0, 0,   //VO
                        0, 1,   //V1
                        1, 1,   //V2
                        1, 0,   //V3
                };

        // The indices that form the rectangle
        short[] indices = new short[]
                {
                        0,1,3,
                        3,1,2
                };

        Vector3f vector3f = new Vector3f(x, y, z);
        grid_matrix = Matrix4f.translate(vector3f);
        Shader.BG.setUniformMat4("transformationMatrix", Matrix4f.translate(vector3f));

        vertexArray = new VertexArray(vertices, textureCoordinates, indices);
        texture = new Texture("image");

        entity = new Entity(vertexArray, texture, vector3f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static Entity getEntity()
    {
        return entity;
    }
}