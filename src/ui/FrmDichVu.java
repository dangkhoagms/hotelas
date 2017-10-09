package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.components.JSpinField;

import controller.QuanLyTienIch;
import controller.TableSuDung;
import controller.TableValues;

public class FrmDichVu extends JFrame implements ActionListener,KeyListener {
	private JPanel pnlThongtinDV;
	private JPanel pnlThongtinSD;

	private JTable tblDv;
	private JLabel lblLoaidv;
	private JComboBox cmbLoaidv;
	private JLabel lblTenphong;
	private JTextField txtTenphong;
	private JTable tblSudung;
	private JPanel pnlCenter;
	private JSpinField Spin;
	private JButton btnBack;
	private JButton btnNext;
	private JFrame parent;
	private String Maphong;
	private QuanLyTienIch ql = new QuanLyTienIch();

	public FrmDichVu(JFrame frm, String maphong) {
		Maphong = maphong;

		parent = frm;
		pnlThongtinDV = panelDichVu();
		pnlThongtinSD = panelThongtin();
		pnlCenter = pnlCenter();
		add(pnlThongtinDV);
		add(pnlCenter);
		add(pnlThongtinSD);
		setLayout(null);
		pnlThongtinDV.setBounds(5, 0, 340, 450);
		pnlThongtinSD.setBounds(420, 0, 270, 450);
		pnlCenter.setBounds(345, 0, 60, 450);
		pnlThongtinDV.setBorder(BorderFactory.createTitledBorder("Thông tin dịch vụ"));
		pnlThongtinSD.setBorder(BorderFactory.createTitledBorder("Thông tin sử dụng dịch vụ"));
		// set
		setSize(700, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Maphong == null || Maphong =="") {
						Maphong = "A0001";
						txtTenphong.setText("Phòng 101");
					}
					ql.getData(tblDv, tblSudung, Maphong, "Thức uống");
					ql.getLoaidichvu(cmbLoaidv);
					ql.WriteField(txtTenphong, maphong);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				parent.setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				ql.XuLyDichVu(tblDv, Spin);
			}
		});
	}

	private JPanel panelDichVu() {
		JPanel panel = new JPanel();
		tblDv = new JTable();
		lblLoaidv = new JLabel("Loại dịch vụ:");
		cmbLoaidv = new JComboBox<>();

		JScrollPane scroll = new JScrollPane(tblDv);
		
		panel.add(scroll);
		panel.add(lblLoaidv);
		panel.add(cmbLoaidv);
		panel.setLayout(null);
		lblLoaidv.setBounds(10, 20, 70, 20);
		cmbLoaidv.setBounds(100, 20, 200, 20);
		scroll.setBounds(10, 50, 320, 390);
		cmbLoaidv.addActionListener(this);
		return panel;
	}

	private JPanel panelThongtin() {
		JPanel panel = new JPanel();
		lblTenphong = new JLabel("Tên Phòng");
		txtTenphong = new JTextField();
		tblSudung = new JTable();

		JScrollPane scroll = new JScrollPane(tblSudung);
		panel.add(lblTenphong);
		panel.add(txtTenphong);
		panel.add(scroll);
		panel.setLayout(null);
		lblTenphong.setBounds(10, 20, 70, 20);
		txtTenphong.setBounds(90, 20, 150, 20);
		scroll.setBounds(10, 50, 250, 390);
		txtTenphong.addKeyListener(this);;
		return panel;
	}

	private JPanel pnlCenter() {
		JPanel panel = new JPanel();
		Spin = new JSpinField();
		panel.add(Spin);
		panel.setLayout(null);
		Spin.setBounds(10, 100, 50, 20);
		BufferedImage imageBack = null, imageNext = null;
		try {
			imageBack = ImageIO.read(new File("images/iconBack.png"));
			imageNext = ImageIO.read(new File("images/iconNext.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconBack = new ImageIcon(imageBack.getScaledInstance(32, 32, imageBack.SCALE_SMOOTH));
		ImageIcon iconNext = new ImageIcon(imageNext.getScaledInstance(32, 32, imageNext.SCALE_SMOOTH));
		btnBack = new JButton();
		btnNext = new JButton();
		panel.add(btnBack);
		panel.add(btnNext);
		btnBack.setIcon(iconBack);
		btnNext.setIcon(iconNext);
		btnBack.setBounds(20, 140, 32, 32);
		btnNext.setBounds(20, 200, 32, 32);
		btnBack.setContentAreaFilled(false);
		btnNext.setContentAreaFilled(false);
		btnNext.addActionListener(this);
		return panel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(cmbLoaidv)) {
			String loaidv = (String) cmbLoaidv.getItemAt(cmbLoaidv.getSelectedIndex());
			try {
				ql.getData(tblDv, tblSudung, Maphong, loaidv);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(obj.equals(btnNext)) {
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
			
				ql.getData(tblDv, tblSudung, ql.getMaphong(txtTenphong), "Thức uống");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
