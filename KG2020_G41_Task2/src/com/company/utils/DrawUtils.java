package com.company.utils;

import com.company.LineDrawer;

import java.awt.*;
import java.util.LinkedList;

/*
не стоит стесняться пользовать именной пакет в программе. Это всегда хорошо
 */
public class DrawUtils {
    public static void drawSnowFlake(LineDrawer executor, int x, int y, int r, int n) {
        double angle = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(angle * i);
            double dy = r * Math.sin(angle * i);
            executor.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    public static void drawColouredSnowFlake(LineDrawer lineDrawer, int x, int y, int r, int n, Color color) {
        double angle = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(angle * i);
            double dy = r * Math.sin(angle * i);
            lineDrawer.drawColorLine(x, y, x + (int) dx, y + (int) dy, color);
        }
    }
}
