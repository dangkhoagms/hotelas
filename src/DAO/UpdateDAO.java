package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.Connect;
import entity.DichVu;
import entity.HoaDonDatPhong;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.Phong;
import entity.TaiKhoan;

/**
 * @name UpdateDAO
 * @version 1.0
 * @created 07-Oct-2017 11:30:14 AM
 * @copyright VuNhuCuong
 */

public class UpdateDAO {
	private Connect con = new Connect();

	/**
	 * 
	 * @param dv
	 * @throws Exception
	 */
	public boolean updateDichVu(DichVu dv) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement("update DichVu set donGia=?, tenDV=?, soLuong=? where maDV=?");
		pst.setDouble(1, dv.getDonGia());
		pst.setString(2, dv.getTenDichVu());
		pst.setInt(3, dv.getSoluong());
		pst.setString(4, dv.getMaDichVu());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param hoadon
	 * @throws Exception
	 */
	public boolean updateHoaDonDatPhong(HoaDonDatPhong hoadon) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement(
				"update HoaDonDatPhong set tienDatPhong=?, maKH=?, maNV=?, ngayTra=?, ngayDat=? where maDatPhong=?");
		pst.setDouble(1, hoadon.getTienDatPhong());
		pst.setString(2, hoadon.getMaKH());
		pst.setString(2, hoadon.getMaNV());
		pst.setDate(4, hoadon.getNgayTra());
		pst.setDate(5, hoadon.getNgayDat());
		pst.setString(6, hoadon.getMaDatPhong());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param hoadon
	 * @throws Exception
	 */
	public boolean updateHoaDonThuePhong(HoaDonThuePhong hoadon) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement(
				"update HoaDonThuePhong set tongTien=?, maNV=?, maDatPhong=?, ngayLap=? where maThuePhong=?");
		pst.setDouble(1, hoadon.getTongTien());
		pst.setString(2, hoadon.getMaNV());
		pst.setString(3, hoadon.getMaDat());
		pst.setDate(4, hoadon.getNgayLap());
		pst.setString(5, hoadon.getMaThue());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param Khachhang
	 * @throws Exception
	 */
	public boolean updateKhachHang(KhachHang khachHang) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement("update KhachHang set soCMND	=?, SDT=?, tenKH =?, gioiTinh=? where maKH=?");
		pst.setString(1, khachHang.getSoCMND());
		pst.setString(2, khachHang.getSoDienThoai());
		pst.setString(3, khachHang.getTenKhachHang());
		pst.setString(4, khachHang.getGioTinh());
		pst.setString(5, khachHang.getMaKhachHang());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param khuyenmai
	 * @throws Exception
	 */
	public boolean updateKhuyenMai(KhuyenMai khuyenMai) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement(
				"update KhuyenMai set moTa	=?, triGia=?, tenKM =?, ngayApDung=?, ngayKetThuc=? where maKM=?");
		pst.setString(1, khuyenMai.getMoTa());
		pst.setString(2, khuyenMai.getTriGia());
		pst.setString(3, khuyenMai.getTenKhuyenMai());
		pst.setDate(4, khuyenMai.getNgayApDung());
		pst.setDate(5, khuyenMai.getNgayKetThuc());
		pst.setString(6, khuyenMai.getMaKhuyenMai());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param phong
	 * @throws Exception
	 */
	public boolean updatePhong(Phong phong) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement("update KhachHang set tinhTrang	=?, maLoai=?, tenPhong =? where maPhong=?");
		pst.setInt(1, phong.getTinhTrang());
		pst.setString(2, phong.getMaloai());
		pst.setString(3, phong.getTenPhong());
		pst.setString(4, phong.getMaPhong());
		n = pst.executeUpdate();
		return n > 0;
	}

	/**
	 * 
	 * @param taikhoan
	 * @throws Exception
	 */
	public boolean updateTaikhoan(TaiKhoan taiKhoan) throws Exception {
		Connection connect = con.getConnect();
		PreparedStatement pst = null;
		int n = 0;
		pst = connect.prepareStatement("update TaiKhoan set matKhau=? where tenDangNhap=?");
		pst.setString(1, taiKhoan.getMatKhau());
		pst.setString(2, taiKhoan.getTenDangNhap());
		n = pst.executeUpdate();
		return n > 0;
	}

}