package entity;
/**
 * @name DichVu
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private int soluong;
	private double donGia;
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public DichVu() {
		
	}
	public DichVu(String maDichVu, String tenDichVu, int soluong) {
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.soluong = soluong;
	}
	public DichVu(String maDichVu, String tenDichVu, int soluong, double donGia) {
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.soluong = soluong;
		this.donGia = donGia;
	}
	
	
	
}
