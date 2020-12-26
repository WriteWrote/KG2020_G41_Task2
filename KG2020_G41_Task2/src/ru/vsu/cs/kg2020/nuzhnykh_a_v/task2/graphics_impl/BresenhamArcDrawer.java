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
        startAngle = startAngle - Math.PI / 2;
        PixelDrawer pixelDrawer = pd;
        int radius = width / 2;
        /*
        x = x + width/2;
        y = y + height/2;
        int _x = 0;
        int _y = height / 2;
        int a_sqr = width * width / 4; // a^2, a - большая полуось
        int b_sqr = height * height / 4; // b^2, b - малая полуось
        int delta = 4 * b_sqr * ((_x + 1) * (_x + 1)) +
                a_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * a_sqr * b_sqr; // Функция координат точки (x+1, y-1/2)
        while (a_sqr * (2 * _y - 1) > 2 * b_sqr * (_x + 1)) // Первая часть дуги
        {
            pixelDrawer.setPixel(x + _x, y + _y, color);
            pixelDrawer.setPixel(x + _x, y - _y, color);
            pixelDrawer.setPixel(x - _x, y - _y, color);
            pixelDrawer.setPixel(x - _x, y + _y, color);
            if (delta < 0) // Переход по горизонтали
            {
                ++_x;
                delta += 4 * b_sqr * (2 * _x + 3);
            } else // Переход по диагонали
            {
                ++_x;
                delta = delta - 8 * a_sqr * (_y - 1) + 4 * b_sqr * (2 * _x + 3);
                --_y;
            }
        }
        delta = b_sqr * ((2 * _x + 1) * (2 * _x + 1)) +
                4 * a_sqr * ((_y + 1) * (_y + 1)) - 4 * a_sqr * b_sqr; // Функция координат точки (x+1/2, y-1)
        while (_y + 1 != 0) // Вторая часть дуги, если не выполняется условие первого цикла, значит выполняется a^2(2y - 1) <= 2b^2(x + 1)
        {
            pixelDrawer.setPixel(x + _x, y + _y, color);
            pixelDrawer.setPixel(x + _x, y - _y, color);
            pixelDrawer.setPixel(x - _x, y - _y, color);
            pixelDrawer.setPixel(x - _x, y + _y, color);
            if (delta < 0) // Переход по вертикали
            {
                --_y;
                delta += 4 * a_sqr * (2 * _y + 3);
            } else // Переход по диагонали
            {
                --_y;
                delta = delta - 8 * b_sqr * (_x + 1) + 4 * a_sqr * (2 * _y + 3);
                ++_x;
            }
        }
         */

       ///*
        double delta = Math.PI / 360;
        if (sweepAngle > 0) {
            for (double i = startAngle; i < startAngle + sweepAngle; i += delta) {
                int curr_x = (int) (x + radius - radius * Math.sin(i));
                int curr_y = (int) (y + radius - radius * Math.cos(i));
                pixelDrawer.setPixel(curr_x, curr_y, color);
            }
        } else {
            for (double i = startAngle + sweepAngle; i < startAngle; i += delta) {
                int curr_x = (int) (x + radius - radius * Math.sin(i));
                int curr_y = (int) (y + radius - radius * Math.cos(i));
                pixelDrawer.setPixel(curr_x, curr_y, color);
            }
        }
        //*/
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