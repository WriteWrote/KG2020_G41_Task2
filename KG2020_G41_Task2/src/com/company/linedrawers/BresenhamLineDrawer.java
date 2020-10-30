package com.company.linedrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pixelDrawer;

    public BresenhamLineDrawer(PixelDrawer pixelDrawer) {
        this.pixelDrawer = pixelDrawer;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        boolean s = Math.abs(x2 - x1) > Math.abs(y2 - y1);
        if (s) {        // horizontal
            if (x1 > x2) {      //isInverted
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            int d = 2 * dy - dx;
            int error = dy > 0 ? 1 : -1;

            for (int x = x1, y = y1; x <= x2; x++) {
                pixelDrawer.setPixel(x, y, Color.black);
                if (d >= 0) {
                    d += 2 * dy * error - 2 * dx;
                    y += error;
                } else {
                    d += 2 * dy * error;
                }
            }
        } else {        // vertical
            if (y1 > y2) {     // isInverted
                int temp = y1;
                y1 = y2;
                y2 = temp;
                temp = x1;
                x1 = x2;
                x2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            int d = 2 * dy - dx;
            int error = dx > 0 ? 1 : -1;


            for (int x = x1, y = y1; y <= y2; y++) {
                pixelDrawer.setPixel(x, y, Color.black);
                if (d >= 0) {
                    d += 2 * dx * error - 2 * dy;
                    x += error;
                } else {
                    d += 2 * dx * error;
                }
            }
        }
    }

    @Override
    public void drawColorLine(int x1, int y1, int x2, int y2, Color color) {
        boolean s = Math.abs(x2 - x1) > Math.abs(y2 - y1);
        if (s) {        // horizontal
            if (x1 > x2) {      //isInverted
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            int d = 2 * dy - dx;
            int error = dy > 0 ? 1 : -1;

            for (int x = x1, y = y1; x <= x2; x++) {
                pixelDrawer.setPixel(x, y, color);
                if (d >= 0) {
                    d += 2 * dy * error - 2 * dx;
                    y += error;
                } else {
                    d += 2 * dy * error;
                }
            }
        } else {        // vertical
            if (y1 > y2) {     // isInverted
                int temp = y1;
                y1 = y2;
                y2 = temp;
                temp = x1;
                x1 = x2;
                x2 = temp;
            }
            int dx = x2 - x1;
            int dy = y2 - y1;
            int d = 2 * dy - dx;
            int error = dx > 0 ? 1 : -1;


            for (int x = x1, y = y1; y <= y2; y++) {
                pixelDrawer.setPixel(x, y, color);
                if (d >= 0) {
                    d += 2 * dx * error - 2 * dy;
                    x += error;
                } else {
                    d += 2 * dx * error;
                }
            }
        }
    }

    public void drawBresenhamCircle(int x, int y, int radius) {
        int _x = radius;
        //int _x = x;
        int _y = 0;
        int radiusError = 1 - _x;
        while (_x >= _y) {
            pixelDrawer.setPixel(_x + x+radius, _y + y+radius, Color.BLACK);
            pixelDrawer.setPixel(_y + x+radius, _x + y+radius, Color.BLACK);
            pixelDrawer.setPixel(-_x + x+radius, _y + y+radius, Color.BLACK);
            pixelDrawer.setPixel(-_y + x+radius, _x + y+radius, Color.BLACK);
            pixelDrawer.setPixel(-_x + x+radius, -_y + y+radius, Color.BLACK);
            pixelDrawer.setPixel(-_y + x+radius, -_x + y+radius, Color.BLACK);
            pixelDrawer.setPixel(_x + x+radius, -_y + y+radius, Color.BLACK);
            pixelDrawer.setPixel(_y + x+radius, -_x + y+radius, Color.BLACK);
            _y++;
            if (radiusError < 0) {
                radiusError += 2 * _y + 1;
            } else {
                _x--;
                radiusError += 2 * (_y - _x + 1);
            }
        }
    }
}
