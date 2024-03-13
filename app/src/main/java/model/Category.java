package model;

public class Category {
    private int id;
    private String hinh;
    private String ten;

    public Category() {}

    public Category(int id, String hinh, String ten) {
        this.id = id;
        this.hinh = hinh;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
