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

        if(Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            if(x1 > x2) {
                int temp = x1; x1 = x2; x2 = temp;
                temp = y1; y1 = y2; y2 = temp;
            }
            int dx = x2 - x1, dy = y2 - y1, d = 2*dy - dx;
            int k = dy > 0 ? 1 : -1; // костыль для 2 и 4 четвертей

            for (int x = x1, y = y1; x <= x2; x++) {
                pixelDrawer.setPixel(x, y, Color.black);
                if (d >= 0) {
                    d += 2 * dy * k - 2 * dx;
                    y += k;
                } else {
                    d += 2 * dy * k;
                }
            }
        }
        else {
            if(y1 > y2) {
                int temp = y1; y1 = y2; y2 = temp;
                temp = x1; x1 = x2; x2 = temp;
            }

            int dx = x2 - x1, dy = y2 - y1, d = 2*dx - dy;
            int k = dx > 0 ? 1 : -1; // костыль для 2 и 4 четвертей

            for (int x = x1, y = y1; y <= y2; y++) {
                pixelDrawer.setPixel(x, y, Color.black);
                if (d >= 0) {
                    d += 2 * dx * k - 2 * dy;
                    x += k;
                } else {
                    d += 2 * dx * k;
                }
            }
        }
    }
   /* @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        incx = sign(dx);
        incy = sign(dy);

        if (dx > dy)
        //определяем наклон отрезка:
        {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        } else//случай, когда прямая скорее "высокая", чем длинная, т.е. вытянута по оси y
        {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;//тогда в цикле будем двигаться по y
        }

        x = x1;
        y = y1;
        err = el / 2;
        pixelDrawer.setPixel(x, y, Color.BLACK);
        //g.drawLine (x, y, x, y);//ставим первую точку
        //все последующие точки возможно надо сдвигать, поэтому первую ставим вне цикла

        for (int t = 0; t < el; t++)//идём по всем точкам, начиная со второй и до последней
        {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;//сдвинуть прямую (сместить вверх или вниз, если цикл проходит по иксам)
                y += incy;//или сместить влево-вправо, если цикл проходит по y
            } else {
                x += pdx;//продолжить тянуть прямую дальше, т.е. сдвинуть влево или вправо, если
                y += pdy;//цикл идёт по иксу; сдвинуть вверх или вниз, если по y
            }
            if (t % 2 == 0)
                pixelDrawer.setPixel(x, y, Color.BLACK);
            else pixelDrawer.setPixel(x, y, Color.RED);
            //g.drawLine (x, y, x, y);
        }
    }

    private int sign(int x) {
        return Integer.compare(x, 0);
        //возвращает 0, если аргумент (x) равен нулю; -1, если x < 0 и 1, если x > 0.
    }*/
}
