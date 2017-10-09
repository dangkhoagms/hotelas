package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import entity.HoaDonThuePhong;

public class QuanLyThongKe {
	private Connect con = new Connect();
	
	public ArrayList<HoaDonThuePhong> DanhSachHoaDonThue() throws SQLException {
		ArrayList<HoaDonThuePhong> listHoadon = new ArrayList<HoaDonThuePhong>();
		
		String sql = "select hd.mathue,kh.maKH,kh.tenKH,nv.manv,nv.tennv,hd.tongTien,hd.ngay \r\n" + 
				"from hoadonthuephong hd join KhachHang kh on hd.makhachhang = kh.maKH \r\n" + 
				"join NhanVien nv on nv.manv = hd.manhanvien";
		PreparedStatement stmt = null;
		try {
			 stmt = con.getConnect().prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String mathue = rs.getString(1);
			String makh = rs.getString(2);
			String tenkh = rs.getString(3);
			String manv = rs.getString(4);
			String tennv = rs.getString(5);
			double tongtien = rs.getDouble(6);
			String ngaylap = rs.getString(7);
			HoaDonThuePhong hd = new HoaDonThuePhong(mathue, makh, tenkh, manv, tennv, tongtien, ngaylap);
			listHoadon.add(hd);
		}
		con.Close();
		return listHoadon;
	}
	public void getData(JTable tblHoadon) throws Exception {
		
		TableHoaDonThue tableHoadon = new TableHoaDonThue(DanhSachHoaDonThue());
		tblHoadon.setModel(tableHoadon);
	}
}
