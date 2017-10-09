package entity;
/**
 * @name KhachHang
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String soCMND;
	private String soDienThoai;
	private String gioTinh;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	public String getGioTinh() {
		return gioTinh;
	}
	public void setGioTinh(String gioTinh) {
		this.gioTinh = gioTinh;
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String soCMND, String soDienThoai,String gioiTinh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.gioTinh=gioiTinh;
	
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	
}
