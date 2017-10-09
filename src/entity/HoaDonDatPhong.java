package entity;

import java.sql.Date;

/**
 * @name HoaDonDatPhong
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class HoaDonDatPhong {
	private String maDatPhong;
	private double tienDatPhong;
	private String maKH;
	private String maNV;
	private Date ngayTra;
	private Date ngayDat;

	public String getMaDatPhong() {
		return maDatPhong;
	}

	public void setMaDatPhong(String maDatPhong) {
		this.maDatPhong = maDatPhong;
	}

	public double getTienDatPhong() {
		return tienDatPhong;
	}

	public void setTienDatPhong(double tienDatPhong) {
		this.tienDatPhong = tienDatPhong;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public HoaDonDatPhong(String maDatPhong, double tienDatPhong, String maKH, String maNV, Date ngayTra,
			Date ngayDat) {
		super();
		this.maDatPhong = maDatPhong;
		this.tienDatPhong = tienDatPhong;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayTra = ngayTra;
		this.ngayDat = ngayDat;
	}

}
