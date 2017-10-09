package entity;

public class Phong {

	private String maPhong;
	private String tenPhong;
	private int tinhTrang;
	private String maloai;
	// chua có loại phòng

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public Phong() {

	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Phong(String maPhong, String tenPhong, int tinhTrang, String maloai) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.tinhTrang = tinhTrang;
		this.maloai = maloai;
	}

	public Phong(String maPhong, int tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tinhTrang = tinhTrang;
	}

	public Phong(int tinhTrang) {
		super();
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return String.format("Phong [maPhong=%s, tenPhong=%s, tinhTrang=%s]", maPhong, tenPhong, tinhTrang);
	}

}
