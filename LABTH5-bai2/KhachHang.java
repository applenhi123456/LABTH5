import java.io.*;
import java.util.*;

class KhachHang {
    String soCMND;
    String ten;
    String gaDen;
    double giaTien;

    public KhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.ten = ten;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String toString() {
        return "So CMND: " + soCMND + ", Tên: " + ten + ", Ga đến: " + gaDen + ", Giá tiền: " + giaTien;
    }
}

class QuanLyHangDoi {
    Queue<KhachHang> hangDoi;
    List<KhachHang> danhSachDaMua;

    public QuanLyHangDoi() {
        hangDoi = new LinkedList<>();
        danhSachDaMua = new ArrayList<>();
    }

    public void themKhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        if (!kiemTraTrungCMND(soCMND)) {
            KhachHang khachHangMoi = new KhachHang(soCMND, ten, gaDen, giaTien);
            hangDoi.add(khachHangMoi);
            System.out.println("Them khach hang thanh cong vao hang doi mua ve.");
        } else {
            System.out.println("So CMND da ton tai trong danh sach.");
        }
    }

    public void banVe() {
        if (!hangDoi.isEmpty()) {
            KhachHang khachHangDauHangDoi = hangDoi.poll();
            danhSachDaMua.add(khachHangDauHangDoi);
            System.out.println("Ban ve thanh cong cho khach hang: " + khachHangDauHangDoi.ten);
        } else {
            System.out.println("Khong co khhach hang trong hang doi.");
        }
    }

    public void hienThiDanhSachKhachHang() {
        if (!hangDoi.isEmpty()) {
            System.out.println("Danh sach khach hang dang cho mua ve: ");
            for (KhachHang khachHang : hangDoi) {
                System.out.println(khachHang.toString());
            }
        } else {
            System.out.println("Khong co khhach hang trong hang doi.");
        }
    }

    public void huyKhachHang(String soCMND) {
        Iterator<KhachHang> iterator = hangDoi.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            KhachHang khachHang = iterator.next();
            if (khachHang.soCMND.equals(soCMND)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Huy khach hang thanh cong.");
        } else {
            System.out.println("Khong tim thay khach hang trong hang doi.");
        }
    }

    public void thongKeTinhHinhBanVe() {
        int soKhachHangChoNhanVe = hangDoi.size();
        int soKhachHangDaNhanVe = danhSachDaMua.size();
        double tongTienThuVe = 0;
        for (KhachHang khachHang : danhSachDaMua) {
            tongTienThuVe += khachHang.giaTien;
        }
        System.out.println("So khach hang cho nhan ve: " + soKhachHangChoNhanVe);
        System.out.println("So khach hang da nhan ve: " + soKhachHangDaNhanVe);
        System.out.println("Tong so tien thu ve: " + tongTienThuVe);
    }

    public void luuDanhSachVaoFile(String tenFile) {
        try {
            FileWriter fileWriter = new FileWriter(tenFile);
            for (KhachHang khachHang : danhSachDaMua) {
                fileWriter.write(khachHang.soCMND + "," + khachHang.ten + "," + khachHang.gaDen + "," + khachHang.giaTien + "\n");
            }
            fileWriter.close();
            System.out.println("Luu danh sach khach hang vao file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi luu danh sach vao file.");
        }
    }

    public void hienThiDanhSachGaDenChoMuaVe() {
        Set<String> gaDenSet = new HashSet<>();
        for (KhachHang khachHang : hangDoi) {
            gaDenSet.add(khachHang.gaDen);
        }
        System.out.println("Danh sach cac ga den va dang cho mua :");
        for (String gaDen : gaDenSet) {
            System.out.println(gaDen);
        }
    }

    public void hienThiDanhSachGaDenVaSoVeTuongUng() {
        Map<String, Integer> gaDenSoVeMap = new HashMap<>();
        for (KhachHang khachHang : hangDoi) {
            if (gaDenSoVeMap.containsKey(khachHang.gaDen)) {
                int soVe = gaDenSoVeMap.get(khachHang.gaDen);
                gaDenSoVeMap.put(khachHang.gaDen, soVe + 1);
            } else {
                gaDenSoVeMap.put(khachHang.gaDen, 1);
            }
        }
        System.out.println("Danh sach cac ga den dang cho mua ve va so ve tuong ung:");
        for (Map.Entry<String, Integer> entry : gaDenSoVeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vé");
        }
    }

    public boolean kiemTraTrungCMND(String soCMND) {
        for (KhachHang khachHang : hangDoi) {
            if (khachHang.soCMND.equals(soCMND)) {
                return true;
            }
        }
        return false;
    }
}

