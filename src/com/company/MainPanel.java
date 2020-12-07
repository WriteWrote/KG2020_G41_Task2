package com.company;

import com.company.linedrawers.BresenhamLineDrawer;
import com.company.linedrawers.DDALineDrawer;
import com.company.linedrawers.WuLineDrawer;
import com.company.pixeldrawers.GraphicsPixelDrawer;
import com.company.utils.DrawUtils;
import com.company.utils.figures.Arc;
import com.company.utils.figures.BresenhamCircle;
import com.company.utils.figures.BresenhamEllipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public MainPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();

        bi_g.setColor(Color.white);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);

        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        BresenhamLineDrawer ld = new BresenhamLineDrawer(pd);
        bi_g.setColor(Color.black);
        bi_g.fillOval(150, 150, 50, 50);

        drawTestSnowFlakes(pd);
        BresenhamCircle circle = new BresenhamCircle(pd, 50, 430, 70, Color.BLACK);
        circle.drawCircle();

        BresenhamEllipse ellipse = new BresenhamEllipse(pd, 350, 500, 100, 70, Color.MAGENTA);
        ellipse.drawEllipse();
        ellipse.setParams(550, 500, 50, 100, Color.BLACK);
        ellipse.drawEllipse();

        Arc arc = new Arc(pd, 150, 600, 70, 0, Math.PI, Color.green);
        arc.drawArc();
        arc.setParams(350, 600, 100, 0, Math.PI * 2, Color.LIGHT_GRAY);
        arc.drawArc();
        arc.setParams(350, 600, 100, -Math.PI / 4, 2 * Math.PI / 3, Color.RED);
        arc.drawArc();

//        drawDraggingLine(new DDALineDrawer(pd));
        drawDraggingLine(new BresenhamLineDrawer(pd));

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawTestSnowFlakes(PixelDrawer pixelDrawer) {
        DrawUtils.drawSnowFlake(new DDALineDrawer(pixelDrawer), 100, 100, 100, 32, Color.MAGENTA);
        DrawUtils.drawSnowFlake(new BresenhamLineDrawer(pixelDrawer), 300, 100, 100, 32, Color.GREEN);
        DrawUtils.drawSnowFlake(new WuLineDrawer(pixelDrawer), 500, 100, 100, 32, Color.RED);
        DrawUtils.drawSnowFlake(new DDALineDrawer(pixelDrawer), 100, 300, 100, 32, Color.BLACK);
        DrawUtils.drawSnowFlake(new BresenhamLineDrawer(pixelDrawer), 300, 300, 100, 32, Color.BLACK);
        DrawUtils.drawSnowFlake(new WuLineDrawer(pixelDrawer), 500, 300, 100, 32, Color.BLACK);
    }

    private void drawDraggingLine(LineDrawer ld) {
        //DrawUtils.drawSnowFlake(ld, getWidth() / 2, getHeight() / 2, 100, 13, Color.BLACK);
        ld.drawLine(getWidth() / 2, getHeight() * 5 / 6, position.x, position.y, Color.BLACK);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
