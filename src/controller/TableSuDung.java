package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.AbstractTableModel;

import entity.DichVu;

public class TableSuDung extends AbstractTableModel {

	public final static String[] columnNames = { "Dịch vụ", "Số lượng" };
	private ArrayList<DichVu> dichvu;

	public TableSuDung(ArrayList<DichVu> dv) {
		dichvu = dv;
	}

	public int getRowCount() {
		return dichvu.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return dichvu.get(rowIndex).getTenDichVu();
		case 1:
			return dichvu.get(rowIndex).getSoluong();
		}
		return null;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

}