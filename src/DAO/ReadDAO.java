package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Connect;
import entity.DichVu;
import entity.HoaDonDatPhong;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

/**
 * @name ReadDAO
 * @version 1.0
 * @created 07-Oct-2017 11:30:14 AM
 * @copyright VuNhuCuong
 */
public class ReadDAO {
	private Connect con = new Connect();

	/*
	 * method name: readAllDichVu input: none output: return ArrayList DichVu
	 */
	public java.util.ArrayList<DichVu> readAllDichVu() throws Exception {
		ArrayList<DichVu> dv = new ArrayList<DichVu>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  DichVu");
		while (rs.next()) {
			String maDichVu = rs.getString("madv");
			String tenDichVu = rs.getString("dongia");
			int soluong = rs.getInt("soluong");
			double donGia = rs.getDouble("dongia");
			DichVu d = new DichVu(maDichVu, tenDichVu, soluong, donGia);
			dv.add(d);
		}

		return dv;
	}

	/*
	 * method name: readAllDonDonDat input: none output: return ArrayList
	 * HoaDonDatPhong
	 */
	public java.util.ArrayList<HoaDonDatPhong> readAllDonDonDat() throws Exception {
		ArrayList<HoaDonDatPhong> hd = new ArrayList<HoaDonDatPhong>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();

		ResultSet rs = stmt.executeQuery("select * from  HoaDonDatPhong");
		while (rs.next()) {
			String madat = rs.getString("madatphong");
			String makh = rs.getString("makh");
			String manv = rs.getString("manv");
			double tiendat = rs.getDouble("tiendatphong");
			java.sql.Date ngaytra = rs.getDate("ngaytra");
			java.sql.Date ngaydat = rs.getDate("ngaydat");
			HoaDonDatPhong h = new HoaDonDatPhong(madat, tiendat, makh, manv, ngaytra, ngaydat);
			hd.add(h);
		}
		return hd;
	}

	/*
	 * method name: readAllHoaDonThue input: none output: return ArrayList
	 * HoaDonThuePhong
	 */
	public java.util.ArrayList<HoaDonThuePhong> readAllHoaDonThue() throws Exception {
		ArrayList<HoaDonThuePhong> hd = new ArrayList<HoaDonThuePhong>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();

		ResultSet rs = stmt.executeQuery("select * from  HoaDonThuePhong");
		while (rs.next()) {
			String maThue = rs.getString("mathuephong");
			String maNV = rs.getString("manv");
			String maDat = rs.getString("madatphong");
			double tongTien = rs.getDouble("tongtien");
			Date ngayLap = rs.getDate("ngaylap");
			HoaDonThuePhong h = new HoaDonThuePhong(maThue, maDat, maNV, tongTien, ngayLap);
			hd.add(h);
		}

		return hd;
	}

	/*
	 * method name: readAllKhachHang input: none output: return ArrayList KhachHang
	 */
	public java.util.ArrayList<KhachHang> readAllKhachHang() throws Exception {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  KhachHang");
		String maKhachHang;
		String tenKhachHang;
		String soCMND;
		String soDienThoai;
		String gioiTinh;
		while (rs.next()) {
			maKhachHang = rs.getString("makh");
			tenKhachHang = rs.getString("tenkh");
			soCMND = rs.getString("socmnd");
			soDienThoai = rs.getString("sdt");
			gioiTinh = rs.getString("gioitinh");

			KhachHang k = new KhachHang(maKhachHang, tenKhachHang, soCMND, soDienThoai, gioiTinh);
			kh.add(k);
		}
		return kh;

	}

	/*
	 * method name: readAllKhuyenMai input: none output: return ArrayList KhuyenMai
	 */
	public java.util.ArrayList<KhuyenMai> readAllKhuyenMai() throws Exception {
		ArrayList<KhuyenMai> km = new ArrayList<KhuyenMai>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  KhuyenMai");
		String maKhuyenMai;
		String tenKhuyenMai;
		Date ngayApDung;
		Date ngayKetThuc;
		String moTa, triGia;
		while (rs.next()) {
			maKhuyenMai = rs.getString("makm");
			tenKhuyenMai = rs.getString("tenkm");
			ngayApDung = rs.getDate("ngayapdung");
			ngayKetThuc = rs.getDate("ngayketthuc");
			moTa = rs.getString("mota");
			triGia = rs.getString("trigia");
			KhuyenMai k = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayApDung, ngayKetThuc, moTa, triGia);
			km.add(k);
		}
		return km;
	}

	/*
	 * method name: readAllNhanvien input: none output: return ArrayList NhanVien
	 */
	public java.util.ArrayList<NhanVien> readAllNhanvien() throws Exception {
		ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  NhanVien");
		String maNhanVien;
		String tenNhanVien;
		String soDienThoai;
		Date ngaySinh;
		String gioiTinh;
		while (rs.next()) {
			maNhanVien = rs.getString("manv");
			tenNhanVien = rs.getString("tennv");
			soDienThoai = rs.getString("sdt");
			ngaySinh = rs.getDate("ngaysinh");
			gioiTinh = rs.getString("gioitinh");

			NhanVien n = new NhanVien(maNhanVien, tenNhanVien, soDienThoai, ngaySinh, gioiTinh);
			nv.add(n);
		}
		return nv;
	}

	/*
	 * method name: readAllPhong input: none output: return ArrayList Phong
	 */
	public java.util.ArrayList<Phong> readAllPhong() throws Exception {
		ArrayList<Phong> p = new ArrayList<Phong>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  Phong");
		String maPhong;
		String tenPhong;
		String maLoai;
		int tinhtrang;
		while (rs.next()) {
			maPhong = rs.getString("maphong");
			tenPhong = rs.getString("tenphong");
			tinhtrang = rs.getInt("tinhtrang");
			maLoai = rs.getString("maloai");
			Phong phong = new Phong(maPhong, tenPhong, tinhtrang, maLoai);
			p.add(phong);
		}
		return p;
	}

	/*
	 * method name: readAllPhong input: none output: return ArrayList Phong
	 */
	public java.util.ArrayList<Phong> readAllPhongByTinhTrang(int tinhtrang) throws Exception {
		ArrayList<Phong> p = new ArrayList<Phong>();
		Connection connect = con.getConnect();
		String sql = "select * from  Phong where tinhtrang = ?";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setInt(1, tinhtrang);
		ResultSet rs = stmt.executeQuery();
		String maPhong;
		String tenPhong;
		String maLoai;
		while (rs.next()) {
			maPhong = rs.getString("maphong");
			tenPhong = rs.getString("tenphong");
			maLoai = rs.getString("maloai");
			Phong phong = new Phong(maPhong, tenPhong, tinhtrang, maLoai);
			p.add(phong);
		}
		return p;
	}

	/*
	 * method name: readAllTaiKhoan input: none output: return ArrayList TaiKhoan
	 */
	public java.util.ArrayList<TaiKhoan> readAllTaiKhoan() throws Exception {
		ArrayList<TaiKhoan> tk = new ArrayList<TaiKhoan>();
		Connection connect = con.getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from  TaiKhoan");
		String tenDangNhap;
		String matKhau;
		String manv;
		while (rs.next()) {
			tenDangNhap = rs.getString("tendangnhap");
			matKhau = rs.getString("matkhau");
			manv = rs.getString("manv");
			TaiKhoan k = new TaiKhoan(tenDangNhap, matKhau, manv);
			tk.add(k);
		}
		return tk;
	}

	/*
	 * method name: readDichVu input: maDV output: return DichVu
	 */
	public DichVu readDichVu(String maDV) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from DichVu where maDV=?");
		pst.setString(1, maDV);
		ResultSet rs = pst.executeQuery();
		String maDichVu = rs.getString("madv");
		String tenDichVu = rs.getString("dongia");
		int soluong = rs.getInt("soluong");
		double donGia = rs.getDouble("dongia");
		return new DichVu(maDichVu, tenDichVu, soluong, donGia);
	}

	/**
	 * 
	 * @param maHd
	 * @throws Exception
	 */
	public HoaDonDatPhong readHoaDonDat(String maHd) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from hoadondatphong where maThuePhong=?");
		pst.setString(1, maHd);
		ResultSet rs = pst.executeQuery();
		String maDat = rs.getString("madatphong");
		String maKh = rs.getString("makh");
		String maNv = rs.getString("manv");
		double tienDat = rs.getDouble("tiendatphong");
		java.sql.Date ngayTra = rs.getDate("ngaytra");
		java.sql.Date ngayDat = rs.getDate("ngaydat");
		HoaDonDatPhong h = new HoaDonDatPhong(maDat, tienDat, maKh, maNv, ngayTra, ngayDat);
		return h;

	}

	/*
	 * method name: readHoaDonThue input: maHoaDon output: return HoaDonThuePhong
	 */
	public HoaDonThuePhong readHoaDonThue(String maHoaDon) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from HoaDonThuePhong where maThuePhong=?");
		pst.setString(1, maHoaDon);
		ResultSet rs = pst.executeQuery();
		String maThue = rs.getString("mathuephong");
		String maNV = rs.getString("manv");
		String maDat = rs.getString("madatphong");
		double tongTien = rs.getDouble("tongtien");
		Date ngayLap = rs.getDate("ngaylap");
		HoaDonThuePhong h = new HoaDonThuePhong(maThue, maDat, maNV, tongTien, ngayLap);
		return h;
	}

	/*
	 * method name: readKhachHangByMa input: maKH output: return KhachHang
	 */
	public KhachHang readKhachHangByMa(String maKH) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from KhachHang where maKH=?");
		pst.setString(1, maKH);
		ResultSet rs = pst.executeQuery();
		String maKhachHang = rs.getString("makh");
		String tenKhachHang = rs.getString("tenkh");
		String soCMND = rs.getString("socmnd");
		String soDienThoai = rs.getString("sdt");
		String gioiTinh = rs.getString("gioitinh");
		KhachHang k = new KhachHang(maKhachHang, tenKhachHang, soCMND, soDienThoai, gioiTinh);
		return k;
	}

	/*
	 * method name: readKhachHangbyCMND input: cmnd output: return KhachHang
	 */
	public KhachHang readKhachHangbyCMND(String cmnd) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from KhachHang where soCMND=?");
		pst.setString(1, cmnd);
		ResultSet rs = pst.executeQuery();
		String maKhachHang = rs.getString("makh");
		String tenKhachHang = rs.getString("tenkh");
		String soCMND = rs.getString("socmnd");
		String soDienThoai = rs.getString("sdt");
		String gioiTinh = rs.getString("gioitinh");
		KhachHang k = new KhachHang(maKhachHang, tenKhachHang, soCMND, soDienThoai, gioiTinh);
		return k;
	}

	/*
	 * method name: readKhuyenMai input: maKM output: return KhuyenMai
	 */
	public KhuyenMai readKhuyenMai(String maKM) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from KhuyenMai where maKM=?");
		pst.setString(1, maKM);
		ResultSet rs = pst.executeQuery();
		String maKhuyenMai = rs.getString("makm");
		String tenKhuyenMai = rs.getString("tenkm");
		java.sql.Date ngayApDung = rs.getDate("ngayapdung");
		java.sql.Date ngayKetThuc = rs.getDate("ngayketthuc");
		String moTa = rs.getString("mota");
		String triGia = rs.getString("trigia");
		KhuyenMai k = new KhuyenMai(maKhuyenMai, tenKhuyenMai, ngayApDung, ngayKetThuc, moTa, triGia);
		return k;
	}

	/*
	 * method name: readLoaiPhong input: maLoai output: return LoaiPhong
	 */
	public LoaiPhong readLoaiPhong(String maLoai) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from LoaiPhong where maLoai=?");
		pst.setString(1, maLoai);
		ResultSet rs = pst.executeQuery();
		maLoai = rs.getString("maloai");
		String maKm = rs.getString("makm");
		String tenLoai = rs.getString("tenloai");
		double donGia = rs.getDouble("dongia");
		int soNguoi = rs.getInt("songuoi");
		LoaiPhong l = new LoaiPhong(maLoai, maKm, tenLoai, donGia, soNguoi);
		return l;
	}

	/*
	 * method name: readNhanVien input: maNV output: return NhanVien
	 */
	public NhanVien readNhanVien(String maNV) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from NhanVien where maNV=?");
		pst.setString(1, maNV);
		ResultSet rs = pst.executeQuery();
		String maNhanVien = rs.getString("manv");
		String tenNhanVien = rs.getString("tennv");
		String soDienThoai = rs.getString("sdt");
		java.sql.Date ngaySinh = rs.getDate("ngaysinh");
		String gioiTinh = rs.getString("gioitinh");
		NhanVien n = new NhanVien(maNhanVien, tenNhanVien, soDienThoai, ngaySinh, gioiTinh);
		return n;
	}

	/*
	 * method name: readPhong input: maPhong output: return Phong
	 */
	public Phong readPhong(String maPhong) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from Phong where maPhong=?");
		pst.setString(1, maPhong);
		ResultSet rs = pst.executeQuery();
		maPhong = rs.getString("maphong");
		String tenPhong = rs.getString("tenphong");
		int tinhtrang = rs.getInt("tinhtrang");
		String maLoai = rs.getString("maloai");
		Phong phong = new Phong(maPhong, tenPhong, tinhtrang, maLoai);
		return phong;
	}

	/*
	 * method name: readTaiKhoan input: user output: return TaiKhoan
	 */
	public TaiKhoan readTaiKhoan(String user) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		pst = connect.prepareStatement("select * from TaiKhoan where tenDangNhap=?");
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		String tenDangNhap = rs.getString("tendangnhap");
		String matKhau = rs.getString("matkhau");
		String maNv = rs.getString("manv");
		TaiKhoan tk = new TaiKhoan(tenDangNhap, matKhau, maNv);
		return tk;
	}

	public static void main(String[] args) throws Exception {
		ReadDAO dao = new ReadDAO();
		ArrayList<HoaDonThuePhong> list = new ArrayList<>();
		list = dao.readAllHoaDonThue();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

}