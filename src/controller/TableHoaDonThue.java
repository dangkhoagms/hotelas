package controller;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entity.HoaDonThuePhong;

public class TableHoaDonThue extends AbstractTableModel {
	private ArrayList<HoaDonThuePhong> listHoadon;
	private final static String[] Header = { "Mã thuê phòng", "Mã khách hàng", "Tên Kh", "Mã nhân viên", "Tên Nv", "Tổng tiền",
			"Ngày lập" };

	public TableHoaDonThue(ArrayList<HoaDonThuePhong> list) {
		this.listHoadon = list;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listHoadon.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listHoadon.get(rowIndex).getMathue();
		case 1: 
			return listHoadon.get(rowIndex).getMakh();
		case 2:
			return listHoadon.get(rowIndex).getTenkh();
		case 3:
			return listHoadon.get(rowIndex).getManv();
		case 4:
			return listHoadon.get(rowIndex).getTennv();
		case 5:
			return listHoadon.get(rowIndex).getTongtien();
		case 6:
			return listHoadon.get(rowIndex).getNgaylap();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return Header[column];
	}
	

}
