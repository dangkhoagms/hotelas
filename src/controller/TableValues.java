package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.AbstractTableModel;

import entity.DichVu;

public class TableValues extends AbstractTableModel {

	private final static String[] columnNames = { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá" };
	private ArrayList<DichVu> listDichvu;

	public TableValues(ArrayList<DichVu> dv) {
		this.listDichvu = dv;
	}

	public int getRowCount() {
		return listDichvu.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listDichvu.get(rowIndex).getMaDichVu();
		case 1:
			return listDichvu.get(rowIndex).getTenDichVu();
		case 2:
			return listDichvu.get(rowIndex).getSoluong();
		case 3:
			return listDichvu.get(rowIndex).getDonGia();

		default:
			return null;
		}
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

}