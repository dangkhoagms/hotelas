package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DangNhap {
	private Connect con = new Connect();

	public boolean kiemTra(JFrame UI, JTextField txtTendangnhap, JTextField txtPass) throws Exception {
		String user = null;
		String pass = null;
		try {
			user = txtTendangnhap.getText().trim();
			pass = txtPass.getText().trim();
		} catch (Exception e) {
			e.getMessage();
		}

		if (user == null || pass == null || user.equals("") || pass.equals("")) {
			return false;

		} else {
			Connection connect = con.getConnect();
			String sql = "select matkhau from TaiKhoan where tenDangnhap='" + user + "'";
			PreparedStatement stmt = connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String pass2 = null;
			try {
				 pass2 = rs.getString(1);
			}catch (Exception e) {
				return false;
			}
			
			if (ConvertMD5(pass).equalsIgnoreCase(ConvertMD5(pass2))) {
				return true;
			}
		}

		return false;
	}

	private String ConvertMD5(String str) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1, digest.digest());
			result = bigInteger.toString(16);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void LoginFail(JFrame UI, JTextField txtTendangnhap, JTextField txtPass) {
		String user = txtTendangnhap.getText().trim();
		String pass = txtPass.getText().trim();
		if (user == null && pass == null || user.equals("") && pass.equals("")) {
			JOptionPane.showMessageDialog(UI, "Vui lòng điền tài khoản và mật khẩu");
			txtTendangnhap.requestFocus();
		} else if (user == null || user.equals("")) {
			JOptionPane.showMessageDialog(UI, "Vui lòng điền tài khoản");
			txtTendangnhap.requestFocus();
		} else if (pass == null || pass.equals("")) {
			JOptionPane.showMessageDialog(UI, "Vui lòng điền mật khẩu");
			txtPass.requestFocus();
		} else {
			JOptionPane.showMessageDialog(UI, "Tài khoản hoặc mật khẩu chưa đúng");
			txtTendangnhap.setText("");
			txtPass.setText("");
			txtTendangnhap.requestFocus();
		}

	}
}
