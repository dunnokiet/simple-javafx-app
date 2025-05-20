/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Dunnokiet
 */
public class Phuong {
    private int maPhuong;
    private String tenPhuong;
    private ArrayList<AbstractHo> danhSachHo;
    
    public Phuong(int maPhuong, String tenPhuong) {
        this.maPhuong = maPhuong;
        this.tenPhuong = tenPhuong;
        this.danhSachHo = new ArrayList<>();
    }

    public ArrayList<AbstractHo> getDanhSachHo() {
        return danhSachHo;
    }
    
    public int khoiTao() {
        danhSachHo.add(new HoKinhDoanh(123, "A", 120, 960, 1.8));
        danhSachHo.add(new HoGiaDinh(124, "B", 400, 450));
        danhSachHo.add(new HoKinhDoanh(125, "C", 300, 689, 1.3));
        danhSachHo.add(new HoSanXuat(126, "D", 150, 965, 1.5));
        danhSachHo.add(new HoGiaDinh(127, "E", 500, 999));
        danhSachHo.add(new HoSanXuat(128, "F", 350, 987, 1.6));
        danhSachHo.add(new HoSanXuat(129, "G", 100, 989, 1.9));
        
        return danhSachHo.size();
    }
    
    public void tinhTienDien() {
        for (AbstractHo ho : danhSachHo) {
            System.out.printf("%s, HoaDon: %.0f VND%n", ho, ho.tinhTienDien());
        }
        System.out.println();

    }
    
    public void inDanhSach() {
        for (AbstractHo ho : danhSachHo) {
            System.out.println(ho);
        }
        System.out.println();
    }
    
    public AbstractHo timKhachHang(int maKH) {
        for (AbstractHo ho : danhSachHo) {
            if (ho.getMaKH() == maKH) {
                return ho;
            }
        }
        return null;
    }
    
    public double tinhTrungBinh() {
        if (danhSachHo.isEmpty()) return 0;

        double tong = 0;
        for (AbstractHo ho : danhSachHo) {
            tong += ho.tinhTienDien();
        }
        
        return tong / danhSachHo.size();
    }
    
    public AbstractHo timKhachHangTienDienLonNhat() {
        if (danhSachHo.isEmpty()) return null;
        
        AbstractHo hoTienDienLonNhat = null;
        double max = 0;
          for (AbstractHo ho : danhSachHo) {
              if (ho.tinhTienDien() > max) {
                  max = ho.tinhTienDien();
                  hoTienDienLonNhat = ho;
              }
        }
          
        return hoTienDienLonNhat;
    }
    
     public AbstractHo timHoSanXuatTienDienNhoNhat() {
        if (danhSachHo.isEmpty()) return null;
        
        AbstractHo hoTienDienNhoNhat = null;
        double min = Double.MAX_VALUE;
          for (AbstractHo ho : danhSachHo) {
              if (ho instanceof HoSanXuat)
              if (ho.tinhTienDien() < min) {
                  min = ho.tinhTienDien();
                  hoTienDienNhoNhat = ho;
              }
        }
          
        return hoTienDienNhoNhat;
    }
}
