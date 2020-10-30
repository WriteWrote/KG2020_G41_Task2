package com.company;

import java.awt.*;

public interface LineDrawer {
    void drawLine(int x1, int y1, int x2, int y2);
    void drawColorLine(int x1, int y1, int x2, int y2, Color color);
}