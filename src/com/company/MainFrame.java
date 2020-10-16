package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainPanel panel;

    public MainFrame() throws HeadlessException {
        panel = new MainPanel();
        this.add(panel);
    }

    @Override
    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
        //рисуем снежинку

    }
}
