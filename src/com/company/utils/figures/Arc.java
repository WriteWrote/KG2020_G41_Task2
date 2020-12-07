package com.company.utils.figures;

import com.company.ArcDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class Arc implements ArcDrawer {
    private PixelDrawer pixelDrawer;
    private int x, y, radius;
    private Color color;
    private double startAngle, deltaAngle;

    public Arc(PixelDrawer pixelDrawer, int x, int y, int radius, double startAngle, double deltaAngle, Color color) {
        this.pixelDrawer = pixelDrawer;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.startAngle = startAngle;
        this.deltaAngle = deltaAngle;
    }

    @Override
    public void drawArc() {
        double delta = Math.PI / 360;
        if (deltaAngle > 0) {
            for (double i = startAngle; i < startAngle + deltaAngle; i += delta) {
                int curr_x = (int) (this.x + this.radius * Math.cos(i));
                int curr_y = (int) (this.y + this.radius * Math.sin(i));
                pixelDrawer.setPixel(curr_x, curr_y, this.color);
            }
        } else {
            for (double i = startAngle + deltaAngle; i < startAngle; i += delta) {
                int curr_x = (int) (this.x + radius * Math.cos(i));
                int curr_y = (int) (this.y + this.radius * Math.sin(i));
                pixelDrawer.setPixel(curr_x, curr_y, color);
            }
        }
    }

    @Override
    public void fillArc() {

    }

    public void setParams(int x, int y, int radius, double startAngle, double deltaAngle, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.startAngle = startAngle;
        this.deltaAngle = deltaAngle;
    }
}
