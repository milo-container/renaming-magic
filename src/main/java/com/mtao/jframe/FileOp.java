package com.mtao.jframe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileOp {

    public FileSigle FileMeda;

    public void rename(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        String name = FileMeda.__toString() + "." + prefix;
        File parentFile = file.getParentFile();
        File newFile = new File(parentFile, name);
        file.renameTo(newFile);
        insertHistory(filePath);
    }


    private void insertHistory(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FileHistory fileHistory = new FileHistory(file.getName(),
                FileMeda.__toString() + "." + prefix,
                System.getProperty("user.name"),
                simpleDateFormat.format(new Date()));
        String fileHistoryJson = JSON.toJSONString(fileHistory);
        String path = FileOp.class.getClassLoader().getResource("").getPath();
        FileWriter fileWritter = new FileWriter(path + "/fileHistory.log", true);
        BufferedWriter writer = new BufferedWriter(fileWritter);
        writer.write(fileHistoryJson+"\r\n");//写入文件
        writer.flush();//清空缓冲区数据
        writer.close();//关闭读写流
        fileWritter.close();
    }

    public void setFileMeda(FileSigle fileMeda)
    {
        this.FileMeda = fileMeda;
    }
}
