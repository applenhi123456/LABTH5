
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyHangDoi quanLyHangDoi = new QuanLyHangDoi();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("==== He thong quan ly hang doi mua ve tai nha ga====");
            System.out.println("1. Them khach hang moi vao hang doi mua ve");
            System.out.println("2. Ban mot ve cho khach hang");
            System.out.println("3. Hien thi danh sach khach hang");
            System.out.println("4. Huy mot khach hang ra khoi danh sach");
            System.out.println("5. Thong ke tinh hinh ban ve");
            System.out.println("6. Luu danh sach vao file");
            System.out.println("7. Hien thi danh sach cac ga dang cho mua vé");
            System.out.println("8. Hien thi danh sach cac ga dang cho mua ve va so ve tuong ung");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("-------------------------------------------------------");
            System.out.print("Chon muc: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Nhap so CMND khach hang: ");
                    String soCMND = scanner.nextLine();
                    System.out.print("Nhap ten khach hang: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhap ga den: ");
                    String gaDen = scanner.nextLine();
                    System.out.print("Nhap gia tien: ");
                    double giaTien = scanner.nextDouble();
                    quanLyHangDoi.themKhachHang(soCMND, ten, gaDen, giaTien);
                    break;
                case 2:
                    quanLyHangDoi.banVe();
                    break;
                case 3:
                    quanLyHangDoi.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Nhap so CMND khach hang can huy: ");
                    String cmndHuy = scanner.nextLine();
                    quanLyHangDoi.huyKhachHang(cmndHuy);
                    break;
                case 5:
                    quanLyHangDoi.thongKeTinhHinhBanVe();
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.print("Nhap ten file: ");
                    String tenFile = scanner.nextLine();
                    quanLyHangDoi.luuDanhSachVaoFile(tenFile);
                    break;
                case 7:
                    quanLyHangDoi.hienThiDanhSachGaDenChoMuaVe();
                    break;
                case 8:
                    quanLyHangDoi.hienThiDanhSachGaDenVaSoVeTuongUng();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long chon lai.");
                    break;
            }
        }

        scanner.close();
    }
}
