//Huỳnh Lan Nhi
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class PhongHoc {
    private String maPhong;
    private String dayNha;
    private double dienTich;
    private int soBongDen;

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    @Override
    public String toString() {
        return "PhongHoc{" +
                "maPhong='" + maPhong + '\'' +
                ", dayNha='" + dayNha + '\'' +
                ", dienTich=" + dienTich +
                ", soBongDen=" + soBongDen +
                '}';
    }
}

class PhongHocLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongHocLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }

    @Override
    public String toString() {
        return "PhongHocLyThuyet{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", coMayChieu=" + coMayChieu +
                '}';
    }
}

class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    @Override
    public String toString() {
        return "PhongMayTinh{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", soMayTinh=" + soMayTinh +
                '}';
    }
}

class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }

    @Override
    public String toString() {
        return "PhongThiNghiem{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", sucChua=" + sucChua +
                ", coBonRua=" + coBonRua +
                '}';
    }
}

class QuanLyPhongHoc {
    private ArrayList<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public void themPhongHoc(PhongHoc phongHoc) {
        if (!kiemTraTonTai(phongHoc.getMaPhong())) {
            danhSachPhongHoc.add(phongHoc);
            System.out.println("Them phong hoc thanh cong.");
        } else {
            System.out.println("Ma phong da ton tai khong the them phong hoc.");
        }
    }

    public void timPhongHoc(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                System.out.println(phongHoc.toString());
                return;
            }
        }
        System.out.println("Khong tim thay phong hoc voi ma phong " + maPhong);
    }

    public void inDanhSachPhongHoc() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            System.out.println(phongHoc.toString());
        }
    }

    public void inDanhSachPhongHocDatChuan() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongHocLyThuyet) {
                if (((PhongHocLyThuyet) phongHoc).isCoMayChieu()) {
                    System.out.println(phongHoc.toString());
                }
            } else if (phongHoc instanceof PhongMayTinh) {
                if (phongHoc.getDienTich() / ((PhongMayTinh) phongHoc).getSoMayTinh() >= 1.5) {
                    System.out.println(phongHoc.toString());
                }
            } else if (phongHoc instanceof PhongThiNghiem) {
                if (((PhongThiNghiem) phongHoc).isCoBonRua()) {
                    System.out.println(phongHoc.toString());
                }
            }
        }
    }

    public void sapXepTheoDayNha() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDayNha));
    }

    public void sapXepTheoDienTich() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDienTich));
    }

    public void sapXepTheoSoBongDen() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getSoBongDen));
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinh) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongMayTinh && phongHoc.getMaPhong().equals(maPhong)) {
                ((PhongMayTinh) phongHoc).setSoMayTinh(soMayTinh);
                System.out.println("Cap nhat so may tinh thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay phong may tinh voi ma phong " + maPhong);
    }

    public void xoaPhongHoc(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                danhSachPhongHoc.remove(phongHoc);
                System.out.println("Xoa phong hoc thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay phong hoc voi ma phong " + maPhong);
    }

    public int demSoPhongHoc() {
        return danhSachPhongHoc.size();
    }

    public void inDanhSachPhongMayTinh(int soMayTinh) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongMayTinh && ((PhongMayTinh) phongHoc).getSoMayTinh() == soMayTinh) {
                System.out.println(phongHoc.toString());
            }
        }
    }

    private boolean kiemTraTonTai(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                return true;
            }
        }
        return false;
    }
}

