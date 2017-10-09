package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.components.JSpinField;

import entity.DichVu;

public class QuanLyTienIch {
	private Connect con = new Connect();
	private static Connection connect = null;

	private void Connect() {
		try {
			connect = con.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			// can't connect sql sever
		}
	}

	public void getData(JTable tabledv, JTable tablesudung, String maphong, String loaidv) throws Exception {
		// TODO Auto-generated method stub
		if (maphong == null || maphong == "") {
			JOptionPane.showMessageDialog(null, "Tên phòng không hợp lệ");
		} else {
			TableSuDung dataSudung = new TableSuDung(QueryDvSudung(maphong));
			tablesudung.setModel(dataSudung);
			TableValues dataValues = new TableValues(QueryDichVu(loaidv));
			tabledv.setModel(dataValues);
		}

	}

	public ArrayList<DichVu> QueryDichVu(String loaidv) throws Exception {
		Connect();
		ArrayList listDichvu = new ArrayList<DichVu>();
		String sql = "select madichvu,tendichvu,soluong,dongia from Dichvu " + "where loaidichvu=N'" + loaidv + "'";
		PreparedStatement stmt = connect.prepareStatement(sql);

		ResultSet rs = null;
		rs = stmt.executeQuery();
		while (rs.next()) {
			String madv = rs.getString("madichvu");
			String tendv = rs.getString("tendichvu");
			int soluong = rs.getInt("soluong");
			double dongia = rs.getDouble("dongia");

			DichVu dichvu = new DichVu(madv, tendv, soluong, dongia);
			listDichvu.add(dichvu);
		}
		return listDichvu;
	}

	public ArrayList<DichVu> QueryDvSudung(String maphong) throws Exception {
		Connect();
		ArrayList listDichvu = new ArrayList<DichVu>();
		String sql = "select distinct d.madichvu, d.tendichvu,dv.soluong "
				+ "from Sudungdichvu dv join Dichvu d on dv.madichvu = d.madichvu " + "where maphong ='" + maphong
				+ "'";
		PreparedStatement stmt = connect.prepareStatement(sql);

		ResultSet rs = null;
		rs = stmt.executeQuery();
		while (rs.next()) {
			String madv = rs.getString("madichvu");
			String tendv = rs.getString("tendichvu");
			int soluong = rs.getInt("soluong");
			DichVu dichvu = new DichVu(madv, tendv, soluong);
			listDichvu.add(dichvu);
		}
		return listDichvu;
	}

	public void getLoaidichvu(JComboBox<String> cmbDichvu) throws Exception {
		String sql = "select distinct loaidichvu from Dichvu";
		PreparedStatement stmt = connect.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			cmbDichvu.addItem(rs.getString(1));
		}
	}

	public void WriteField(JTextField txtTenphong, String maphong) throws Exception {
		txtTenphong.setText(getTenPhong(maphong));
	}

	public String getTenPhong(String maphong) throws Exception {
		String sql = "select tenphong from phong where maphong='" + maphong + "'";
		PreparedStatement stmt = connect.prepareStatement(sql);

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			rs.next();
		} catch (Exception e) {
			return null;
		}

		return rs.getString("tenphong");
	}

	public String getMaphong(JTextField txtTenphong) throws Exception {
		String tenphong = txtTenphong.getText().trim();
		if (tenphong != "" || tenphong != null) {
			return QueryPhong(tenphong);
		}
		return null;
	}

	public String QueryPhong(String TenPhong) throws Exception {
		String sql = "select maphong from Phong where tenPhong=N'" + TenPhong + "'";
		PreparedStatement stmt = connect.prepareStatement(sql);
		ResultSet rs = null;
		String tenphong = null;
		try {
			rs = stmt.executeQuery();
			rs.next();
			tenphong = rs.getString("maphong");
		} catch (Exception e) {
			return null;
		}

		return tenphong;
	}

	public void XuLyDichVu(JTable tblDichvu, JSpinField Spin) {
		tblDichvu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (e.getValueIsAdjusting()) {
					int row = -1;
					try {
						row = tblDichvu.getSelectedRow();
					} catch (Exception e1) {
						row = -1;
					}
					if (row > -1) {
						int max = (int) tblDichvu.getValueAt(row, 2);
						Spin.setMaximum(max);
						Spin.setMinimum(0);
						if (Spin.getValue() > max)
							Spin.setValue(max);
					}

				}
			}
		});
		;

	}
	
}
