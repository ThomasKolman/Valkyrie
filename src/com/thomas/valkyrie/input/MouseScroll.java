package com.thomas.valkyrie.input;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Created by Thomas on 2016-01-18.
 */
public class MouseScroll
{
    public static boolean[] keys = new boolean[65536];

    public void invoke(long window, double xoffset, double yoffset)
    {

    }

    public static boolean isMouseDown(int keycode)
    {
        return keys[keycode];
    }
}
