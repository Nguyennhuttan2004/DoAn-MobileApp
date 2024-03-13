package model;

public class SanPham {
    private boolean bestfood;
    private double gia;
    private String hinh;
    private int id;
    private String mota;
    private double star;
    private int styleID;
    private String ten;
    private int numInCart;

    public SanPham() {}

    public SanPham(boolean bestfood, double gia, String hinh, int id, String mota, double star, int styleID, String ten, int numInCart) {
        this.bestfood = bestfood;
        this.gia = gia;
        this.hinh = hinh;
        this.id = id;
        this.mota = mota;
        this.star = star;
        this.styleID = styleID;
        this.ten = ten;
        this.numInCart = numInCart;
    }

    public boolean isBestfood() {
        return bestfood;
    }

    public void setBestfood(boolean bestfood) {
        this.bestfood = bestfood;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public int getStyleID() {
        return styleID;
    }

    public void setStyleID(int styleID) {
        this.styleID = styleID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNumInCart() {
        return numInCart;
    }

    public void setNumInCart(int numInCart) {
        this.numInCart = numInCart;
    }
}
