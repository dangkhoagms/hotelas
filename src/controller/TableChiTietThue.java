package controller;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entity.ChiTietThuePhong;

public class TableChiTietThue extends AbstractTableModel{
	private final static String[] header = {"Phòng","Loại phòng","Tiền đặt","Tiền phòng","Dịch vụ","Số lượng","Đơn giá","Thành tiền","Khuyến mãi"};
	private ArrayList<ChiTietThuePhong> listChitiet;
	public TableChiTietThue(ArrayList<ChiTietThuePhong> list) {
		// TODO Auto-generated constructor stub
		this.listChitiet = list;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listChitiet.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			
			break;

		default:
			break;
		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return header[column];
	}
	

}
