package ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl.linedrawers;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics gr;

    public GraphicsPixelDrawer(Graphics gr) {
        this.gr = gr;
    }

    @Override
    public void colorPixel(int x, int y, Color color) {
        gr.setColor(color);
        gr.fillRect(x, y, 1, 1);
    }
}
