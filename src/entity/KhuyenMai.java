package entity;

import java.sql.Date;

/**
 * @name KhuyenMai
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private Date ngayApDung;
	private Date ngayKetThuc;
	private String moTa;
	private String triGia; ///???
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public Date getNgayApDung() {
		return ngayApDung;
	}
	public void setNgayApDung(Date ngayApDung) {
		this.ngayApDung = ngayApDung;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	public String getTriGia() {
		return triGia;
	}
	public void setTriGia(String triGia) {
		this.triGia = triGia;
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, Date ngayApDung, Date ngayKetThuc, String moTa,
			String triGia) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.ngayApDung = ngayApDung;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.triGia = triGia;
	}
	
	
}
