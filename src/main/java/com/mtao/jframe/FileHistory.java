package com.mtao.jframe;

import com.alibaba.fastjson.annotation.JSONField;

public class FileHistory {
    @JSONField(name = "oldName")
    public String oldName;
    @JSONField(name = "newName")
    public String newName;
    @JSONField(name = "opUser")
    public String opUser;
    @JSONField(name = "opTime")
    public String opTime;

    public FileHistory(String oldName, String newName, String opUser, String opTime) {
        this.oldName = oldName;
        this.newName = newName;
        this.opUser = opUser;
        this.opTime = opTime;
    }
}
