package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.Connect;

/**
 * @name DeleteDAO
 * @version 1.0
 * @created 07-Oct-2017 11:30:14 AM
 * @copyright VuNhuCuong
 */
public class DeleteDAO {
	private Connect con = new Connect();
	

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteDichVu(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from DichVu where maDV=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteHoaDonDatPhong(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from HoaDonDatPhong where maDatPhong=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteHoaDonThuePhong(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from HoaDonThuePhong where maThuePhong=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteKhachHang(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from KhachHang where maKH=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteKhuyenMai(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from KhuyenMai where maKM=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deletePhong(String ma) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from Phong where maPhong=?");
				pst.setString(1, ma);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}

	/**
	 * 
	 * @param ma
	 * @throws Exception 
	 */
	public boolean deleteTaiKhoan(String tenTaiKhoan) throws Exception{
		Connection connect=con.getConnect();
		PreparedStatement pst=null;
		int n=0;
		
		try {
				pst=connect.prepareStatement("delete from TaiKhoan where tenDangNhap=?");
				pst.setString(1, tenTaiKhoan);
				n=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n>0;
	}

}