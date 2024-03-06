package Activity.model;

import java.io.Serializable;

public class GioHang implements Serializable {
    private String tensp;
    private int giasp;
    private int soluongsp;
    private int hinhsp;

    public GioHang() {    }
    public GioHang(String tensp, int giasp, int soluongsp, int hinhsp) {
        this.tensp = tensp;
        this.giasp = giasp;
        this.soluongsp = soluongsp;
        this.hinhsp = hinhsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public int getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(int hinhsp) {
        this.hinhsp = hinhsp;
    }
}
