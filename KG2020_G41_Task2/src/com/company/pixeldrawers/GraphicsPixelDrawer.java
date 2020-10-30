package com.company.pixeldrawers;

import com.company.PixelDrawer;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics g;

    public GraphicsPixelDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void setPixel(int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}
