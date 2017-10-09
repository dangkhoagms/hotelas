package entity;
/**
 * @name LoaiPhong
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class LoaiPhong {
	private String maLoai;
	private String maKM;
	private String tenLoai;
	private double donGia;
	private int soNguoi;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public LoaiPhong(String maLoai, String maKM, String tenLoai, double donGia, int soNguoi) {
		super();
		this.maLoai = maLoai;
		this.maKM = maKM;
		this.tenLoai = tenLoai;
		this.donGia = donGia;
		this.soNguoi = soNguoi;
	}
	
}
