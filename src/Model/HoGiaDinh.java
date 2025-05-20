/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dunnokiet
 */
public class HoGiaDinh extends AbstractHo {
    public HoGiaDinh(int maKH, String tenChuHo, double chiSoCu, double chiSoMoi) {
        super(maKH, tenChuHo, chiSoCu, chiSoMoi);
    }
    
    @Override
    public double tinhTienDien() {
        double chiSoSuDung = chiSoMoi - chiSoCu;
        double gia = chiSoSuDung > 100 ? 5500 : 3500;
        return gia * chiSoSuDung;
    }
}
