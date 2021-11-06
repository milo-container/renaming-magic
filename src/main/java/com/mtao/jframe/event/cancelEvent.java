package com.mtao.jframe.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class cancelEvent implements ActionListener {
    private JFrame jFrame;

    public cancelEvent(JFrame jFrame)
    {
        this.jFrame = jFrame;
    }
    public void actionPerformed(ActionEvent arg0) {
        this.jFrame.dispatchEvent(new WindowEvent(this.jFrame, WindowEvent.WINDOW_CLOSING));
    }

}
