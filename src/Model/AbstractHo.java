/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dunnokiet
 */
public abstract class AbstractHo {
    protected int maKH;
    protected String tenChuHo;
    protected double chiSoCu;
    protected double chiSoMoi;
    
    public AbstractHo(int maKH, String tenChuHo, double chiSoCu, double chiSoMoi) {
        this.maKH = maKH;
        this.tenChuHo = tenChuHo;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }
    
    public int getMaKH() {
        return maKH;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }
    
    
    public abstract double tinhTienDien();
    
    @Override
    public String toString() {
        return "MaKH: " + maKH + ", TenChuHo: " +  tenChuHo + ", ChiSoCu: " + chiSoCu + ", ChiSoMoi: " + chiSoMoi;
    }
}
