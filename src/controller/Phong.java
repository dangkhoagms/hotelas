package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ReadDAO;
import entity.KhachHang;

public class Phong {
	private Connect con = new Connect();
	private ReadDAO read = new ReadDAO();

	public void FindviewbyCMND(JTextField txt, JTextField txtTenkh, JTextField txtSodienthoai,
			JComboBox<String> cbbGioitinh) {
		String cmnd = txt.getText().trim();
		KhachHang kh = new KhachHang();
		if (cmnd.equals("") || cmnd.equals(null))
			try {
				kh = read.readKhachHangbyCMND(cmnd);
				txtTenkh.setText(kh.getTenKhachHang());
				txtSodienthoai.setText(kh.getSoDienThoai());
				cbbGioitinh.setName(kh.getGioTinh());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Chưa có khách hàng trong hệ thống");
				txtTenkh.requestFocus();
			}	

	}

	private String GrowCode(String str, String friststr) {
		String code = str;
		String laststr = str.substring(friststr.length());
		int stt = Integer.parseInt(laststr);
		str = friststr + (stt + 1);
		int sott = str.substring(friststr.length()).length();
		int i = 0;
		while (str.length() < code.length()) {
			str = str.substring(0, friststr.length() + i).concat("0");
			str = str.concat(stt + 1 + "");
			i++;
		}
		return str;
	}

}
