package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
 * @author darken
 * @version 1.0
 * @created 07-Oct-2017 11:30:15 AM
 */
public class CreateDAO {
	Connect con=new Connect();
	
	/**
	 * 
	 * @param dv
	 * @throws Exception 
	 */
	public boolean createDichVu(DichVu dv) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into DichVu values(?,?,?,?)");
		pst.setString(1,dv.getMaDichVu() );
		pst.setDouble(2, dv.getDonGia());
		pst.setString(3, dv.getTenDichVu());
		pst.setInt(4, dv.getSoluong());
		n=pst.executeUpdate();
		return n>0;
		
	}
		/**
	 * 
	 * @param hd
		 * @throws Exception 
	 */
	public boolean createHoaDonDat(HoaDonDatPhong hd) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into HoaDonDatPhong values(?,?,?,?,?,? )");
		pst.setString(1,hd.getMaDatPhong());
		pst.setString(2, hd.getMaKH());
		pst.setString(3, hd.getMaNV());
		pst.setDouble(4, hd.getTienDatPhong());
		pst.setDate(5, hd.getNgayTra());
		pst.setDate(6, hd.getNgayDat());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param hd:
	 * @throws Exception 
	 */
	public boolean createHoaDonThue(HoaDonThuePhong hd) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into HoaDonThuePhong values(?,?,?,?,? )");
		pst.setString(1,hd.getMaThue());
		pst.setString(2, hd.getMaDat()	);
		pst.setDouble(3, hd.getTongTien());
		pst.setString(4, hd.getMaNV());
		pst.setDate(5,hd.getNgayLap());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param khachhang
	 * @throws Exception 
	 */
	public boolean createKhachHang(KhachHang khachHang) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into KhachHang values(?,?,?,?,? )");
		pst.setString(1,khachHang.getMaKhachHang());
		pst.setString(2,khachHang.getSoCMND());
		pst.setString(3,khachHang.getSoDienThoai());
		pst.setString(4, khachHang.getTenKhachHang());
		pst.setString(5, khachHang.getGioTinh());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param khuyenmai
	 * @throws Exception 
	 */
	public boolean createKhuyenMai(KhuyenMai khuyenMai) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into KhuyenMai values(?,?,?,?,?,? )");
		pst.setString(1,khuyenMai.getMaKhuyenMai());
		pst.setString(2,khuyenMai.getMoTa());
		pst.setString(3, khuyenMai.getTriGia());
		pst.setString(4, khuyenMai.getTenKhuyenMai());
		pst.setDate(5, khuyenMai.getNgayApDung());
		pst.setDate(6, khuyenMai.getNgayKetThuc());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param loaiphong
	 * @throws Exception 
	 */
	public boolean createLoaiphong(LoaiPhong loaiPhong) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into LoaiPhong values(?,?,?,?,? )");
		pst.setString(1,loaiPhong.getMaLoai());
		pst.setString(2,loaiPhong.getMaKM());
		pst.setString(3, loaiPhong.getTenLoai());
		pst.setDouble(4, loaiPhong.getDonGia());
		pst.setInt(5, loaiPhong.getSoNguoi());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param nv
	 * @throws Exception 
	 */
	public boolean createNhanvien(NhanVien nv) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into NhanVien values(?,?,?,?,? )");
		pst.setString(1,nv.getMaNhanVien());
		pst.setString(2,nv.getGioiTinh());
		pst.setString(3, nv.getSoDienThoai());
		pst.setString(4, nv.getTenNhanVien());
		pst.setDate(5, nv.getNgaySinh());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param phong
	 * @throws Exception 
	 */
	public boolean createPhong(Phong phong) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into Phong values(?,?,?,? )");
		pst.setString(1,phong.getMaPhong());
		pst.setInt(2, phong.getTinhTrang());
		pst.setString(3, phong.getMaloai());
		pst.setString(4, phong.getTenPhong());
		n=pst.executeUpdate();
		return n>0;
	}

	/**
	 * 
	 * @param taikhoan
	 * @throws Exception 
	 */
	public boolean createTaiKhoan(TaiKhoan taiKhoan) throws Exception{
		Connection connect=con.getConnect();
		int n=0;
		PreparedStatement pst=connect.prepareStatement("insert into TaiKhoan values(?,?,? )");
		pst.setString(1,taiKhoan.getTenDangNhap());
		pst.setString(2,taiKhoan.getMatKhau());
		pst.setString(3, taiKhoan.getManv());
		n=pst.executeUpdate();
		return n>0;
	}
}

