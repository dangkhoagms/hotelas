package entity;

import java.sql.Date;

public class HoaDonThuePhong {

	private String maThue;
	private String maDat;
	private String maNV;
	private double tongTien;
	private Date ngayLap;

	public String getMaThue() {
		return maThue;
	}

	public void setMaThue(String maThue) {
		this.maThue = maThue;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getMaDat() {
		return maDat;
	}

	public void setMaDat(String maDat) {
		this.maDat = maDat;
	}

	public HoaDonThuePhong(String maThue, String maDat, String maNV, double tongTien, Date ngayLap) {
		super();
		this.maThue = maThue;
		this.maDat = maDat;
		this.maNV = maNV;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;
	}
}
