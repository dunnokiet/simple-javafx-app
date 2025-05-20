/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dunnokiet
 */
public class HoKinhDoanh extends AbstractHo {
    protected double heSoSuDung;
    
    public HoKinhDoanh(int maKH, String tenChuHo, double chiSoCu, double chiSoMoi, double heSoSuDung) {
        super(maKH, tenChuHo, chiSoCu, chiSoMoi);
        this.heSoSuDung = heSoSuDung;
    }
    
    @Override
    public double tinhTienDien() {
        double chiSoSuDung = chiSoMoi - chiSoCu;
        return 7000 * chiSoSuDung * heSoSuDung;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", HeSoSuDung: " + heSoSuDung;
    }
}
