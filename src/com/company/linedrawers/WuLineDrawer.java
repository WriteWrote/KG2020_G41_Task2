package com.company.linedrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pixelDrawer;

    public WuLineDrawer(PixelDrawer pixelDrawer) {
        this.pixelDrawer = pixelDrawer;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

    }
}
