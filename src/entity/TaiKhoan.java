package entity;
/**
 * @name TaiKhoan
 * @version 1.0
 * @created 24-Sep-2017 09:05:00 PM
 * @copyright VuNhuCuong
 */
public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private String manv;
	
	public TaiKhoan(String tenDangNhap, String matKhau, String manv) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.manv = manv;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public TaiKhoan(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}
	
}
