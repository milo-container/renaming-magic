package com.mtao.jframe;

import com.mtao.jframe.event.FileUploadEvent;
import com.mtao.jframe.event.SubmitEvent;
import com.mtao.jframe.event.cancelEvent;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppMain extends JFrame {
    private JFrame frame = new JFrame("文件规范命名工具");
    private JTextField dateTextField = new JTextField();
    private JTextField pretextField = new JTextField();
    private JTextField titleTxtField = new JTextField();
    private JTextField versionTextField = new JTextField();
    private JTextArea labelTextField = new JTextArea();
    private JTextArea userTextField = new JTextArea();
    private JTextArea commentsTextField = new JTextArea();
    private JTextField fileTextField = new JTextField(10);

    public AppMain()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
        Box vBox = Box.createVerticalBox();
        JLabel topBox = new JLabel("Top");
        topBox.setForeground(Color.GREEN);
//        topBox.setFont();
        JPanel datepanel = this.getDatePanel();

        JPanel prePanel = this.getPrePanel();
        JPanel titlePanel = this.getTitlePanel();
        JPanel versionPanel = this.getVersionPanel();
        JPanel labelPanel = this.getLabelPanel();
        JPanel userPanel = this.getUserPanel();
        JPanel commentsPanel = this.getCommentsPanel();
        JPanel filePanel = this.getFilePanel();
        JPanel button = this.getButton();

        vBox.add(topBox);
        vBox.add(filePanel);
        vBox.add(datepanel);
        vBox.add(prePanel);
        vBox.add(titlePanel);
        vBox.add(versionPanel);
        vBox.add(labelPanel);
        vBox.add(userPanel);
        vBox.add(commentsPanel);

        vBox.add(button);
        frame.setContentPane(vBox);
        frame.setLocationRelativeTo(null);
        frame.setBounds(550,100,500,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel getDatePanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("时间 ：");    //创建一个标签
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        dateTextField.setText(df.format(new Date()));
        dateTextField.setPreferredSize(new Dimension (300, 35));
        jp.add(jl);
        jp.add(dateTextField);
        return jp;
    }

    /**
     * 换行
     * @param text
     * @return
     */
    private JPanel nextLine(String text)
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel(text);    //创建一个标签
        jl.setHorizontalAlignment(SwingConstants.RIGHT);
        jp.add(jl);
        return jp;
    }

    private JPanel getPrePanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("前缀：");    //创建一个标签
        pretextField.setPreferredSize(new Dimension (300, 35));
        jp.add(jl);
        jp.add(pretextField);
        return jp;
    }

    private JPanel getTitlePanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("标题：");    //创建一个标签
        titleTxtField.setPreferredSize(new Dimension (300, 35));
        jp.add(jl);
        jp.add(titleTxtField);
        return jp;
    }

    private JPanel getVersionPanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("版本：");    //创建一个标签
        versionTextField.setPreferredSize(new Dimension (300, 35));
        jp.add(jl);
        jp.add(versionTextField);
        return jp;
    }

    private JPanel getLabelPanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("标签：");    //创建一个标签
        labelTextField.setPreferredSize(new Dimension (300, 100));
        labelTextField.setLineWrap(true);    //设置文本域中的文本为自动换行
        labelTextField.setForeground(Color.BLACK);    //设置组件的背景色
//        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jp.add(jl);
        jp.add(labelTextField);
        return jp;
    }

    private JPanel getUserPanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("人物：");    //创建一个标签
        userTextField.setPreferredSize(new Dimension (300, 100));
        userTextField.setLineWrap(true);    //设置文本域中的文本为自动换行
        userTextField.setForeground(Color.BLACK);    //设置组件的背景色
        jp.add(jl);
        jp.add(userTextField);
        return jp;
    }

    private JPanel getCommentsPanel()
    {
        JPanel jp=new JPanel();    //创建面板
        JLabel jl=new JLabel("评论：");    //创建一个标签
        commentsTextField.setPreferredSize(new Dimension (300, 100));
        commentsTextField.setLineWrap(true);    //设置文本域中的文本为自动换行
        commentsTextField.setForeground(Color.BLACK);    //设置组件的背景色
        jp.add(jl);
        jp.add(commentsTextField);
        return jp;
    }

    private JPanel getFilePanel()
    {
        JPanel panel=new JPanel();
        JLabel label=new JLabel("选择文件：");
        JButton button=new JButton("浏览");
        panel.add(label);
        panel.add(fileTextField);
        panel.add(button);
        button.addActionListener(new FileUploadEvent(this));    //监听按钮事件
        return panel;
    }

    private JPanel getButton()
    {
        JPanel panel = new JPanel();
        JButton submit = new JButton("确定");
        JButton cancel = new JButton("取消");
        JButton historyView = new JButton("查看历史记录");
        panel.add(submit);
        panel.add(cancel);
        panel.add(historyView);
        submit.addActionListener(new SubmitEvent(this));
        cancel.addActionListener(new cancelEvent(frame));
        return panel;
    }

    public static void main(String[] agrs)
    {
        new AppMain();    //创建一个实例化对象
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getDateTextField() {
        return dateTextField;
    }

    public JTextField getTitleTxtField() {
        return titleTxtField;
    }

    public JTextField getPretextField() {
        return pretextField;
    }

    public JTextField getVersionTextField() {
        return versionTextField;
    }

    public JTextArea getLabelTextField() {
        return labelTextField;
    }

    public JTextArea getUserTextField() {
        return userTextField;
    }

    public JTextArea getCommentsTextField() {
        return commentsTextField;
    }

    public JTextField getFileTextField() {
        return fileTextField;
    }
}
