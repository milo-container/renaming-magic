package com.mtao.jframe.event;

import com.mtao.jframe.AppMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

public class FileUploadEvent implements ActionListener {
    private AppMain appMain;

    public FileUploadEvent(AppMain appMain) {
        this.appMain = appMain;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        JFileChooser fc=new JFileChooser("F:\\");
        int val=fc.showOpenDialog(null);
        if (val==fc.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().toString();
            File file = new File(filePath);
            if (file.getName().length() < 100) {
                appMain.getTitleTxtField().setText(file.getName());
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            appMain.getDateTextField().setText(simpleDateFormat.format(file.lastModified()));
            appMain.getFileTextField().setText(filePath);
        } else {
            appMain.getFileTextField().setText("未选择文件");
        }
    }
}
