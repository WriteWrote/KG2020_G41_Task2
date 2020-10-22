package com.company.linedrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;
import java.util.Set;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pixelDrawer;

    public WuLineDrawer(PixelDrawer pixelDrawer) {
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
                //float _d = -1F * error / (dy + dx) / 1.15F;
                pixelDrawer.setPixel(x, y, new Color(0, 0, 0, dy / dx));
                //pixelDrawer.setPixel(x, y, Color.BLACK);
                if (error > 0) {
                    pixelDrawer.setPixel(x, y + 1, new Color(0, 0, 0, 1 - dy / dx));
                    //pixelDrawer.setPixel(x, y, SetColor((int) (1F / 2 - _d)));
                    //pixelDrawer.setPixel(x, y + 1, SetColor((int) (1F / 2 + _d)));
                } else {
                    pixelDrawer.setPixel(x, y - 1, new Color(0, 0, 0, 1 - dy / dx));
                    //pixelDrawer.setPixel(x, y, SetColor((int) (1F / 2 + d)));
                    //  pixelDrawer.setPixel(x, y - 1, SetColor((int) (1F / 2 - d)));
                }

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
                float _d = -1F * error / (dy + dx) / 1.15F;
                pixelDrawer.setPixel(x, y, new Color(0, 0, 0, dx / dy));
                //pixelDrawer.setPixel(x, y, Color.BLACK);
                if (error > 0) {
                    pixelDrawer.setPixel(x + 1, y, new Color(1 - dx / dy));
                    //    pixelDrawer.setPixel(x, y, SetColor((int) (1F / 2 - _d)));
                    //  pixelDrawer.setPixel(x + 1, y, SetColor((int) (1F / 2 + _d)));
                } else {
                    pixelDrawer.setPixel(x - 1, y, new Color(0, 0, 0, 1 - dx / dy));
                    //      pixelDrawer.setPixel(x, y, SetColor((int) (1F / 2 + d)));
                    //pixelDrawer.setPixel(x - 1, y, SetColor((int) (1F / 2 - d)));
                }

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

    }

    private Color SetColor(float t) {
        int c = (int) (255 * t);
        //Color res = new Color(Color.HSBtoRGB(c,c,c));
        Color res = Color.getHSBColor(c, c, c);
        //Color res = Color.FromArgb(c, c, c);
        return res;
    }
}
