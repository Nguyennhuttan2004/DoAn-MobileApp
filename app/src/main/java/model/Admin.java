package model;

import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String tenql;
    private int hinh;
    public Admin() {
    }

    public Admin(int id, String tenql,int hinh) {
        this.id = id;
        this.tenql = tenql;
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenql() {
        return tenql;
    }

    public void setTenql(String tenql) {
        this.tenql = tenql;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
