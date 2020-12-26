package ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl;

import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.ArcDrawer;
import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PixelDrawer;

import java.awt.*;

public class BresenhamArcDrawer implements ArcDrawer {
    private ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PixelDrawer pd;

    public BresenhamArcDrawer(ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawArc(int x, int y, int width, int height, double startAngle, double sweepAngle, Color color) {
        double deltaAngle = sweepAngle;
        PixelDrawer pixelDrawer = pd;
        int radius = width / 2;

        double delta = Math.PI / 360;
        if (deltaAngle > 0) {
            for (double i = startAngle; i < startAngle + deltaAngle; i += delta) {
                int curr_x = (int) (x + radius * Math.cos(i));
                int curr_y = (int) (y + radius * Math.sin(i));
                pixelDrawer.setPixel(curr_x, curr_y, color);
            }
        } else {
            for (double i = startAngle + deltaAngle; i < startAngle; i += delta) {
                int curr_x = (int) (x + radius * Math.cos(i));
                int curr_y = (int) (y + radius * Math.sin(i));
                pixelDrawer.setPixel(curr_x, curr_y, color);
            }
        }
    }

/*
    @Override
    public void drawArc(int x, int y, int width, int height, double startAngle, double arcAngle, Color c) {
        int a = width / 2;
        int b = height / 2;
        int x0 = x + width / 2;
        int y0 = y + height / 2;
        draw(x0, y0, a, b, startAngle, arcAngle, c);
    }

    private void draw(int x0, int y0, int rX, int rY, double startAngle, double arcAngle, Color c) {
        int twoA = 2 * rX * rX;
        int twoB = 2 * rY * rY;
        int x = rX;
        int y = 0;
        int dx = rY * rY * (1 - 2 * rX);
        int dy = rX * rX;
        int error = 0;
        int stopX = twoB * rX;
        int stopY = 0;
        while (stopX > stopY) {
            drawPixels(x0, y0, x, y, startAngle, arcAngle, c);
            y++;
            stopY += twoA;
            error += dy;
            dy += twoA;
            if ((2 * error + dx) > 0) {
                x--;
                stopX -= twoB;
                error += dx;
                dx += twoB;
            }
        }
        x = 0;
        y = rY;
        dx = rY * rY;
        dy = rX * rX * (1 - 2 * rY);
        error = 0;
        stopX = 0;
        stopY = twoA * rY;
        while (stopX <= stopY) {
            drawPixels(x0, y0, x, y, startAngle, arcAngle, c);
            x++;
            stopX += twoB;
            error += dx;
            dx += twoB;
            if ((2 * error + dy) > 0) {
                y--;
                stopY -= twoA;
                error += dy;
                dy += twoA;
            }
        }
    }

    private void drawPixels(int x, int y, int dx, int dy, double startAngle, double arcAngle, Color c) {
        double angle = getAngle(dx, dy);
        if (inAngle(angle, startAngle, arcAngle)) {
            pd.setPixel(x + dx, y - dy, c);
        }
        if (inAngle(Math.PI - angle, startAngle, arcAngle)) {
            pd.setPixel(x - dx, y - dy, c);
        }
        if (inAngle(Math.PI + angle, startAngle, arcAngle)) {
            pd.setPixel(x - dx, y + dy, c);
        }
        if (inAngle(2 * Math.PI - angle, startAngle, arcAngle)) {
            pd.setPixel(x + dx, y + dy, c);
        }
    }

    private boolean inAngle(double angle, double startAngle, double arcAngle) {
        double a = Math.min(startAngle, startAngle + arcAngle);
        double b = Math.max(startAngle, startAngle + arcAngle);
        double ang = angle;
        while (ang <= b) {
            if (ang >= a && ang <= b) {
                return true;
            }
            ang += Math.PI * 2;
        }
        ang = angle;
        while (ang >= a) {
            if (ang >= a && ang <= b) {
                return true;
            }
            ang -= Math.PI * 2;
        }
        return false;
    }

    private double getAngle(int x, int y) {
        if (x == 0) {
            return Math.PI / 2;
        }
        double tan = ((double) y / x);
        return Math.atan(tan);
    }
    */
}