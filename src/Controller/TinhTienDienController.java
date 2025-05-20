/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AbstractHo;
import Model.Phuong;
import View.TinhTienDienView;

/**
 *
 * @author Dunnokiet
 */
public class TinhTienDienController {
    private final Phuong model;
    private final TinhTienDienView view;

    public TinhTienDienController(Phuong model, TinhTienDienView view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    private void initialize() {
        view.setCustomerData(model.getDanhSachHo());

        view.getSearchButton().setOnAction(e -> {
            String id = view.getSearchField().getText();
            AbstractHo ho = model.timKhachHang(Integer.parseInt(id));
            if (ho != null) {
                view.getSearchResult().setText("Tim thay: " + ho.getTenChuHo()+ ", Hoa don: " +
                        String.format("%.2f", ho.tinhTienDien()));
            } else {
                view.getSearchResult().setText("Khong tim thay");
            }
        });

        view.getAvgBillButton().setOnAction(e ->
                view.getAvgBillLabel().setText("Hoa don trung binh: " +
                        String.format("%.2f", model.tinhTrungBinh()) + " VND"));

        view.getMaxBillButton().setOnAction(e -> {
            AbstractHo max = model.timKhachHangTienDienLonNhat();
            if (max != null) {
                view.getMaxBillLabel().setText("Ho: " + max.getTenChuHo()+ ", " +
                        String.format("%.2f", max.tinhTienDien()) + " VND");
            }
        });

        view.getMinProdBillButton().setOnAction(e -> {
            AbstractHo min = model.timHoSanXuatTienDienNhoNhat();
            if (min != null) {
                view.getMinProdBillLabel().setText("Lowest Production Bill: " + min.getMaKH()+ ", " +
                        String.format("%.2f", min.tinhTienDien()) + " VND");
            }
        });
    }
}
