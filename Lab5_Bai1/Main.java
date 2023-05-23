
import java.util.Scanner;

//hàm main của class PhongHoc
public class Main {
    public static void main(String[] args) {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Them phong hoc");
            System.out.println("2. Tim kiem phong hoc");
            System.out.println("3. In danh sach phong hoc");
            System.out.println("4. In danh sach phong hoc dat chuan");
            System.out.println("5. Sap xep danh sach theo day nha");
            System.out.println("6. Sap xep danh sach theo dien tich");
            System.out.println("7. Sap xep danh sach theo so bong den");
            System.out.println("8. Cap nhat so may tinh cho phong may tinh");
            System.out.println("9. Xoa phong hoc");
            System.out.println("10. In tong so phong hoc");
            System.out.println("11. In danh sach phong may có 60 may");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ kí tự new line

            switch (choice) {
                case 1:
                    System.out.println("1. Them phong hoc li thuyet");
                    System.out.println("2. Them phong may tinh");
                    System.out.println("3. Them phong thi nghiem");
                    System.out.print("Nhap lua chon cua ban: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ kí tự new line

                    System.out.print("Nhap ma phong: ");
                    String maPhong = scanner.nextLine();
                    System.out.print("Nhap day nha: ");
                    String dayNha = scanner.nextLine();
                    System.out.print("Nhap dien tich: ");
                    double dienTich = scanner.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = scanner.nextInt();

                    switch (option) {
                        case 1:
                            System.out.print("Có máy chiếu (true/false): ");
                            boolean coMayChieu = scanner.nextBoolean();
                            PhongHocLyThuyet phongLyThuyet = new PhongHocLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                            quanLyPhongHoc.themPhongHoc(phongLyThuyet);
                            break;
                        case 2:
                            System.out.print("Nhập số máy tính: ");
                            int soMayTinh = scanner.nextInt();
                            PhongMayTinh phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                            quanLyPhongHoc.themPhongHoc(phongMayTinh);
                            break;
                        case 3:
                            scanner.nextLine(); // Đọc bỏ kí tự new line
                            System.out.print("Nhập chuyên ngành: ");
                            String chuyenNganh = scanner.nextLine();
                            System.out.print("Nhập sức chứa: ");
                            int sucChua = scanner.nextInt();
                            System.out.print("Có bồn rửa (true/false): ");
                            boolean coBonRua = scanner.nextBoolean();
                            PhongThiNghiem phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                            quanLyPhongHoc.themPhongHoc(phongThiNghiem);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maPhongTimKiem = scanner.nextLine();
                    quanLyPhongHoc.timPhongHoc(maPhongTimKiem);
                    break;
                case 3:
                    System.out.println("Danh sách phòng học:");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 4:
                    System.out.println("Danh sách phòng học đạt chuẩn:");
                    quanLyPhongHoc.inDanhSachPhongHocDatChuan();
                    break;
                case 5:
                    quanLyPhongHoc.sapXepTheoDayNha();
                    System.out.println("Danh sách phòng học sau khi sắp xếp theo dãy nhà:");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 6:
                    quanLyPhongHoc.sapXepTheoDienTich();
                    System.out.println("Danh sách phòng học sau khi sắp xếp theo diện tích:");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 7:
                    quanLyPhongHoc.sapXepTheoSoBongDen();
                    System.out.println("Danh sách phòng học sau khi sắp xếp theo số bóng đèn:");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;
                case 8:
                    System.out.print("Nhập mã phòng cần cập nhật số máy tính: ");
                    String maPhongCapNhat = scanner.nextLine();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayTinhMoi = scanner.nextInt();
                    quanLyPhongHoc.capNhatSoMayTinh(maPhongCapNhat, soMayTinhMoi);
                    break;
                case 9:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maPhongXoa = scanner.nextLine();
                    System.out.print("Bạn chắc chắn muốn xóa? (true/false): ");
                    boolean xacNhanXoa = scanner.nextBoolean();
                    if (xacNhanXoa) {
                        quanLyPhongHoc.xoaPhongHoc(maPhongXoa);
                    } else {
                        System.out.println("Hủy xóa phòng học.");
                    }
                    break;
                case 10:
                    int soPhongHoc = quanLyPhongHoc.demSoPhongHoc();
                    System.out.println("Tổng số phòng học: " + soPhongHoc);
                    break;
                case 11:
                    System.out.println("Danh sách phòng máy có 60 máy:");
                    quanLyPhongHoc.inDanhSachPhongMayTinh(60);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
