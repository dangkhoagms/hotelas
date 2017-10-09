package entity;

import java.util.ArrayList;

public class ChiTietThuePhong {
	private String MaPhieu;
	private String Phong;
	private String LoaiPhong;
	private String CMND;
	private String TenKH;
	private String Phone;
	private ArrayList<DichVu> dichvu;
	
	public ArrayList<DichVu> getDichvu() {
		return dichvu;
	}
	public void setDichvu(ArrayList<DichVu> dichvu) {
		this.dichvu = dichvu;
	}
	public String getMaPhieu() {
		return MaPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		MaPhieu = maPhieu;
	}
	public String getPhong() {
		return Phong;
	}
	public void setPhong(String phong) {
		Phong = phong;
	}
	public String getLoaiPhong() {
		return LoaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		LoaiPhong = loaiPhong;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public ChiTietThuePhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietThuePhong(String maPhieu, String phong, String loaiPhong, String cMND, String tenKH, String phone) {
		super();
		MaPhieu = maPhieu;
		Phong = phong;
		LoaiPhong = loaiPhong;
		CMND = cMND;
		TenKH = tenKH;
		Phone = phone;
	}
	@Override
	public String toString() {
		return String.format("ChiTietThuePhong [MaPhieu=%s, Phong=%s, LoaiPhong=%s, CMND=%s, TenKH=%s, Phone=%s]",
				MaPhieu, Phong, LoaiPhong, CMND, TenKH, Phone);
	}
	
	
}
