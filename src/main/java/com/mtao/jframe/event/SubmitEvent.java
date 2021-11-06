package com.mtao.jframe.event;

import com.mtao.jframe.AppMain;
import com.mtao.jframe.FileHistory;
import com.mtao.jframe.FileOp;
import com.mtao.jframe.FileSigle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubmitEvent implements ActionListener {
    private AppMain appMain;

    public SubmitEvent(AppMain appMain) {
        this.appMain = appMain;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        String dateValue = appMain.getDateTextField().getText().trim();
        String preValue = appMain.getPretextField().getText().trim();
        String titleValue = appMain.getTitleTxtField().getText().trim();
        String versionValue = appMain.getVersionTextField().getText().trim();
        String labelValue = appMain.getLabelTextField().getText().trim();
        String usersValue = appMain.getUserTextField().getText().trim();
        String commentsValue = appMain.getCommentsTextField().getText().trim();
        String fileValue = appMain.getFileTextField().getText().trim();
        FileSigle fileSigle = new FileSigle();
        fileSigle.setTime(dateValue);
        fileSigle.setPre(preValue);
        fileSigle.setTitle(titleValue);
        fileSigle.setVersion(versionValue);
        String[] labelArr = labelValue.split("/n");
        fileSigle.setLabel(labelArr);
        fileSigle.setUsers(usersValue);
        fileSigle.setComments(commentsValue);

        FileOp fileOp = new FileOp();
        fileOp.setFileMeda(fileSigle);
        try {
            fileOp.rename(fileValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel jPanel = new JPanel();
        JOptionPane.showMessageDialog(
                jPanel, "您已成功修改文件名为: " + fileSigle.__toString(),"提示消息",
                JOptionPane.NO_OPTION);

    }
}
