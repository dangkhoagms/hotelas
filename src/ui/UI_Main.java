package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.ReadDAO;
import entity.Phong;

public class UI_Main extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UI_Main UI;
	private JTabbedPane tabPanel;
	private JPanel pnlHotel;
	private JPanel pnlQuanly;
	private JButton btnDatphong;
	private JButton btnThuephong;
	private JButton btnTraphong;
	private JLabel lblPhong;
	private JLabel lblDichvu;
	private JButton btnDichvu;
	private JButton btnKhuyenmai;
	private JSeparator sprDauGach;
	private JLabel lblTrangthai;
	private controller.Phong phong = new controller.Phong();
	private ReadDAO read = new ReadDAO();
	private ArrayList<Phong> listphong = new ArrayList<>();
	private BufferedImage imageThuephong = null, imageDatphong = null, imageTraphong = null, imageDichvu = null;
	private BufferedImage imageKhuyenmai = null, imageControng = null, imageDadat = null, imageDathue = null,
			imageSuachua = null;
	private JPanel panelUser;
	private JButton btnDangxuat;
	private String phongclick;
	private JButton btnQuanlyphong;
	private JButton btnQuanlydichvu;
	private JButton btnHoadon;
	private JLabel lblSuachua;
	private JLabel lblDathue;
	private JLabel lblConphong;
	private JLabel lblDadat;
	private JPanel panelDanhsachphong;
	private BufferedImage imageAllroom;
	private JLabel lblTatca;
	private Component pnlTab;
	private JLabel lblNormal;
	private JLabel lblSpecial;
	private boolean lblFlag = false;
	private ArrayList<Phong> list;
	private String listmaphong;
	private JTextField txtChange = new JTextField();

	public UI_Main() {

		UI = this;
		tabPanel = new JTabbedPane();
		pnlHotel = pnlHotel();
		pnlQuanly = pnlQuanly();
		panelUser = PanelUser();
		BufferedImage imageHotel = null, imageManage = null;
		try {
			imageHotel = ImageIO.read(new File("images/iconHotel.png"));
			imageManage = ImageIO.read(new File("images/setting.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ImageIcon iconHotel = new ImageIcon(imageHotel.getScaledInstance(32, 32, imageHotel.SCALE_SMOOTH));
		ImageIcon iconManage = new ImageIcon(imageManage.getScaledInstance(32, 32, imageManage.SCALE_SMOOTH));
		tabPanel.addTab("Khách Sạn", iconHotel, pnlHotel, "Tab Khách Sạn");
		tabPanel.addTab("Quản Lý", iconManage, pnlQuanly, "Tab Khách Sạn");

		setLayout(null);
		tabPanel.setBounds(0, 0, 800, 500);
		add(tabPanel);
		add(panelUser);
		panelUser.setBounds(0, 500, 200, 100);
		this.setBackground(Color.decode("#00CED1"));
		tabPanel.setBackground(Color.decode("#00CED1"));
		panelUser.setBackground(Color.decode("#7FFFD4"));
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JPanel pnlHotel() {
		JPanel panel = new JPanel();
		JPanel panelTop = new JPanel();
		JPanel panelPhong = new JPanel();
		JPanel panelDichVu = new JPanel();
		JPanel pnlTrangthai = pnlTrangthai();
		panelDanhsachphong = new JPanel();
		JPanel panelHoadon = PanelHoadon();
		btnDatphong = new JButton();
		btnThuephong = new JButton();
		btnTraphong = new JButton();
		btnDichvu = new JButton();
		btnKhuyenmai = new JButton();
		lblPhong = new JLabel("Quản Lý Phòng");
		lblDichvu = new JLabel("Dịch Vụ");

		panel.setLayout(null);

		panel.add(panelTop);
		panelTop.setBounds(0, 0, 800, 80);
		panelTop.setBackground(Color.decode("#7FFFD4"));
		panelTop.add(panelHoadon);

		/*
		 * panelPhong
		 */
		panelTop.add(panelPhong);
		panelPhong.setBackground(Color.decode("#B0E0E6"));
		panelPhong.add(btnDatphong);
		panelPhong.add(btnThuephong);
		panelPhong.add(btnTraphong);
		panelPhong.add(lblPhong);
		panelTop.setLayout(null);
		panelPhong.setBounds(0, 0, 200, 80);
		panelPhong.setLayout(null);
		panelPhong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnThuephong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnDatphong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnTraphong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnThuephong.setBounds(5, 0, 60, 60);
		btnDatphong.setBounds(70, 0, 60, 60);
		btnTraphong.setBounds(135, 0, 60, 60);
		lblPhong.setBounds(60, 65, 100, 15);
		/*
		 * panelDichvu
		 */
		panelTop.add(panelDichVu);
		panelDichVu.setLayout(null);
		panelDichVu.setBackground(Color.decode("#B0E0E6"));
		panelDichVu.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		panelDichVu.setBounds(205, 0, 135, 80);
		panelDichVu.add(btnDichvu);
		btnDichvu.setBounds(5, 0, 60, 60);
		btnDichvu.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		panelDichVu.add(btnKhuyenmai);
		btnKhuyenmai.setBounds(70, 0, 60, 60);
		btnKhuyenmai.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		panelDichVu.add(lblDichvu);
		lblDichvu.setBounds(55, 65, 100, 15);
		/*
		 * panelTrangthai
		 */
		panel.add(pnlTrangthai);

		/*
		 * panelDanhsachphong
		 */

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		panel.add(panelDanhsachphong);
		panel.add(pnlTab = pnlTab());
		panelDanhsachphong.setBounds(200, 80, 600, 350);
		panelDanhsachphong.setBackground(Color.decode("#B0C4DE"));
		panelDanhsachphong.setLayout(layout);
		pnlTab.setBounds(200, 430, 600, 50);
		pnlTab.setBackground(Color.decode("#B0C4DE"));
		createJPanelContent(listphong, panelDanhsachphong);
		/*
		 * set image button
		 */
		try {
			imageThuephong = ImageIO.read(new File("images/imgThuephong.png"));
			imageDatphong = ImageIO.read(new File("images/imgDatphong.png"));
			imageTraphong = ImageIO.read(new File("images/imgTraphong.png"));
			imageDichvu = ImageIO.read(new File("images/imgDichvu.png"));
			imageKhuyenmai = ImageIO.read(new File("images/imaKhuyenmai.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconThuephong = new ImageIcon(imageThuephong.getScaledInstance(60, 50, imageThuephong.SCALE_SMOOTH));
		ImageIcon iconDatphong = new ImageIcon(imageDatphong.getScaledInstance(60, 50, imageDatphong.SCALE_SMOOTH));
		ImageIcon iconTraphong = new ImageIcon(imageTraphong.getScaledInstance(60, 50, imageTraphong.SCALE_SMOOTH));
		ImageIcon iconDv = new ImageIcon(imageDichvu.getScaledInstance(60, 50, imageDichvu.SCALE_SMOOTH));
		ImageIcon iconKhuyenmai = new ImageIcon(imageKhuyenmai.getScaledInstance(60, 50, imageKhuyenmai.SCALE_SMOOTH));

		btnThuephong.setIcon(iconThuephong);
		btnTraphong.setIcon(iconTraphong);
		btnDatphong.setIcon(iconDatphong);
		btnDatphong.setContentAreaFilled(false);
		btnTraphong.setContentAreaFilled(false);
		btnThuephong.setContentAreaFilled(false);
		btnDichvu.setIcon(iconDv);
		btnDichvu.setContentAreaFilled(false);
		btnKhuyenmai.setIcon(iconKhuyenmai);
		btnKhuyenmai.setContentAreaFilled(false);

		btnDatphong.addActionListener(this);
		btnThuephong.addActionListener(this);
		btnTraphong.addActionListener(this);
		btnDichvu.addActionListener(this);
		btnKhuyenmai.addActionListener(this);
		LockQuanlyPhong(false);
		return panel;
	}

	private JPanel createJPanelContent(ArrayList<Phong> buttonName, JPanel panel) {
		// add array JButton to panel
		for (int i = 0; i < buttonName.size(); i++) {

			panel.add(createJButton(buttonName.get(i).getTenPhong(), buttonName.get(i).getTinhTrang()));
		}
		return panel;
	}

	// create JButton

	private JButton createJButton(String buttonName, int tinhtrang) {
		JButton btn = new JButton(buttonName);
		try {
			imageControng = ImageIO.read(new File("images/imgTrangThaiControng.png"));
			imageDadat = ImageIO.read(new File("images/imgTrangThaiDadat.png"));
			imageDathue = ImageIO.read(new File("images/imgTrangThaiDathue.png"));
			imageSuachua = ImageIO.read(new File("images/imgTrangThaiSuaChua.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconDathue = new ImageIcon(imageDathue.getScaledInstance(40, 40, imageDathue.SCALE_SMOOTH));
		ImageIcon iconConphong = new ImageIcon(imageControng.getScaledInstance(40, 40, imageControng.SCALE_SMOOTH));
		ImageIcon iconDadat = new ImageIcon(imageDadat.getScaledInstance(40, 40, imageDadat.SCALE_SMOOTH));
		ImageIcon iconSuachua = new ImageIcon(imageSuachua.getScaledInstance(40, 40, imageSuachua.SCALE_SMOOTH));
		if (tinhtrang == 0) {
			btn.setIcon(iconDathue);
		} else if (tinhtrang == 1) {
			btn.setIcon(iconConphong);
		} else if (tinhtrang == 2) {
			btn.setIcon(iconDadat);
		} else if (tinhtrang == 3) {
			btn.setIcon(iconSuachua);
		}
		btn.addActionListener(this);
		btn.addMouseListener(this);
		return btn;
	}

	public void actionPerformed(ActionEvent evt) {
		Object obj = evt.getSource();
		int kk = evt.getID();
		String command = evt.getActionCommand();
		for (int i = 0; i < listphong.size(); i++) {
			if (command == listphong.get(i).getTenPhong()) {
				LockQuanlyPhong(true);
				phongclick = listphong.get(i).getMaPhong();

			}

		}
		if (obj.equals(btnDatphong)) {
			UI.setEnabled(false);
			new FrmDatPhong(UI, phongclick);

		} else if (obj.equals(btnThuephong)) {
			UI.setEnabled(false);
			new FrmThuePhong(UI, listmaphong);

		} else if (obj.equals(btnTraphong)) {
			JOptionPane.showMessageDialog(null, "Bạn vừa chọn btnTraphong", "Thông báo", JOptionPane.CLOSED_OPTION);
		} else if (obj.equals(btnDichvu)) {
			UI.setEnabled(false);
			new FrmDichVu(UI, phongclick);
		} else if (obj.equals(btnKhuyenmai)) {
			JOptionPane.showMessageDialog(null, "Bạn vừa chọn btnKhuyenmai", "Thông báo", JOptionPane.CLOSED_OPTION);
		} else if (obj.equals(btnQuanlyphong)) {
			JOptionPane.showMessageDialog(null, "Bạn vừa chọn btnQuanlyphong", "Thông báo", JOptionPane.CLOSED_OPTION);
		} else if (obj.equals(btnQuanlydichvu)) {
			JOptionPane.showMessageDialog(null, "Bạn vừa chọn btnQuanlydichvu", "Thông báo", JOptionPane.CLOSED_OPTION);
		} else if (obj.equals(btnHoadon)) {
			UI.setEnabled(false);
			new FrmHoaDon(UI);

		}
	}

	private JPanel PanelUser() {
		JPanel panel = new JPanel();
		JLabel lblUser = new JLabel("User:");
		JLabel lblTenuser = new JLabel("LCK.Team");
		btnDangxuat = new JButton("Đăng Xuất");
		JLabel lblGroup = new JLabel("Nhóm:");
		JLabel lblTengroup = new JLabel("Quản Trị");
		panel.add(lblUser);
		panel.add(lblTenuser);
		panel.add(lblGroup);
		panel.add(lblTengroup);
		panel.add(btnDangxuat);
		panel.setLayout(null);
		lblUser.setBounds(10, 0, 40, 20);
		lblTenuser.setBounds(50, 0, 120, 20);
		lblGroup.setBounds(10, 20, 40, 20);
		lblTengroup.setBounds(50, 20, 120, 20);
		btnDangxuat.setBounds(10, 45, 120, 20);
		btnDangxuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new UI_Login();
			}
		});

		return panel;
	}

	private void LockQuanlyPhong(boolean flag) {
		btnTraphong.setEnabled(flag);
		btnThuephong.setEnabled(flag);
		btnDatphong.setEnabled(flag);
		// btnDichvu.setEnabled(flag);
	}

	private JPanel pnlQuanly() {
		JPanel panel = new JPanel();
		JPanel panelTop = new JPanel();
		JPanel pnlQuanlyPhong = new JPanel();
		btnQuanlyphong = new JButton();
		btnQuanlydichvu = new JButton();
		panel.setLayout(null);
		panel.add(panelTop);
		panelTop.setBounds(0, 0, 800, 80);
		panelTop.setBackground(Color.decode("#7FFFD4"));
		/*
		 * set Icon
		 */
		BufferedImage imageQuanlyphong = null, imageQuandichvu = null;
		try {
			imageQuanlyphong = ImageIO.read(new File("images/imgQuanlyphong.png"));
			imageQuandichvu = ImageIO.read(new File("images/imgQuanlydichvu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconQuanlyphong = new ImageIcon(
				imageQuanlyphong.getScaledInstance(70, 60, imageQuanlyphong.SCALE_SMOOTH));
		ImageIcon iconQuanlydichvu = new ImageIcon(
				imageQuandichvu.getScaledInstance(70, 60, imageQuandichvu.SCALE_SMOOTH));
		/*
		 * pnlQuanlyPhong
		 */
		panelTop.add(pnlQuanlyPhong);
		pnlQuanlyPhong.setBackground(Color.decode("#B0E0E6"));
		pnlQuanlyPhong.add(btnQuanlyphong);
		pnlQuanlyPhong.add(btnQuanlydichvu);
		panelTop.setLayout(null);
		pnlQuanlyPhong.setBounds(0, 0, 200, 80);
		pnlQuanlyPhong.setLayout(null);
		pnlQuanlyPhong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnQuanlyphong.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnQuanlyphong.setBounds(5, 0, 70, 60);
		btnQuanlyphong.setIcon(iconQuanlyphong);
		btnQuanlyphong.setContentAreaFilled(false);
		btnQuanlyphong.addActionListener(this);
		btnQuanlydichvu.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnQuanlydichvu.setBounds(80, 0, 70, 60);
		btnQuanlydichvu.setIcon(iconQuanlydichvu);
		btnQuanlydichvu.setContentAreaFilled(false);
		btnQuanlydichvu.addActionListener(this);

		return panel;
	}

	private JPanel PanelHoadon() {
		JPanel panel = new JPanel();
		panel.setBounds(345, 0, 200, 80);
		panel.setBackground(Color.decode("#B0E0E6"));
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		panel.add(btnHoadon = new JButton());
		BufferedImage imageHoadon = null;
		try {
			imageHoadon = ImageIO.read(new File("images/btnHoadon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconHoadon = new ImageIcon(imageHoadon.getScaledInstance(60, 50, imageHoadon.SCALE_SMOOTH));
		btnHoadon.setIcon(iconHoadon);
		btnHoadon.setBounds(5, 0, 60, 60);
		btnHoadon.setContentAreaFilled(false);
		btnHoadon.setBorder(BorderFactory.createLineBorder(Color.decode("#FFEBCD")));
		btnHoadon.addActionListener(this);

		return panel;
	}

	private JPanel pnlTrangthai() {
		JPanel pnl = new JPanel();

		// create
		lblTrangthai = new JLabel("Trạng Thái Phòng");
		sprDauGach = new JSeparator();
		lblConphong = new JLabel("Phòng Còn Trống");
		lblDadat = new JLabel("Phòng Đã Đặt");
		lblDathue = new JLabel("Phòng Đã Thuê");
		lblSuachua = new JLabel("Phòng Đang sữa chữa");
		lblTatca = new JLabel("Tất cả các phòng");
		// custom font
		Font font = new Font("Tahoma", Font.BOLD, 12);

		lblTrangthai.setFont(font);
		lblConphong.setFont(font);
		lblDadat.setFont(font);
		lblDathue.setFont(font);
		lblSuachua.setFont(font);
		lblTatca.setFont(font);

		// add from jpanel
		pnl.add(sprDauGach);
		pnl.add(lblTrangthai);
		pnl.add(lblConphong);
		pnl.add(lblDadat);
		pnl.add(lblDathue);
		pnl.add(lblSuachua);
		pnl.add(lblTatca);
		// create Icon
		try {
			imageControng = ImageIO.read(new File("images/imgTrangThaiControng.png"));
			imageDadat = ImageIO.read(new File("images/imgTrangThaiDadat.png"));
			imageDathue = ImageIO.read(new File("images/imgTrangThaiDathue.png"));
			imageSuachua = ImageIO.read(new File("images/imgTrangThaiSuaChua.png"));
			imageAllroom = ImageIO.read(new File("images/imgHotelAll.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconControng = new ImageIcon(imageControng.getScaledInstance(40, 40, imageControng.SCALE_SMOOTH));
		ImageIcon iconDadat = new ImageIcon(imageDadat.getScaledInstance(40, 40, imageDadat.SCALE_SMOOTH));
		ImageIcon iconDathue = new ImageIcon(imageDathue.getScaledInstance(40, 40, imageDathue.SCALE_SMOOTH));
		ImageIcon iconSuachua = new ImageIcon(imageSuachua.getScaledInstance(40, 40, imageSuachua.SCALE_SMOOTH));
		ImageIcon iconAllhotel = new ImageIcon(imageAllroom.getScaledInstance(40, 40, imageAllroom.SCALE_SMOOTH));
		// setIcon
		lblConphong.setIcon(iconControng);
		lblDadat.setIcon(iconDadat);
		lblDathue.setIcon(iconDathue);
		lblSuachua.setIcon(iconSuachua);
		lblTatca.setIcon(iconAllhotel);
		// setBounds
		pnl.setBounds(0, 80, 200, 400);
		pnl.setBackground(Color.decode("#5F9EA0"));
		pnl.setLayout(null);
		lblTrangthai.setBounds(45, 10, 120, 20);
		sprDauGach.setBounds(35, 31, 130, 2);
		lblConphong.setBounds(0, 40, 180, 50);
		lblDadat.setBounds(0, 95, 180, 50);
		lblDathue.setBounds(0, 150, 180, 50);
		lblSuachua.setBounds(0, 205, 180, 50);
		lblTatca.setBounds(0, 260, 180, 50);
		// addMouseListener
		lblSuachua.addMouseListener(this);
		lblDathue.addMouseListener(this);
		lblConphong.addMouseListener(this);
		lblDadat.addMouseListener(this);
		lblTatca.addMouseListener(this);
		return pnl;
	}

	private JPanel pnlTab() {
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.add(lblNormal = new JLabel("Thường"));
		pnl.add(lblSpecial = new JLabel("Đặt biệt"));
		JSeparator spr;
		pnl.add(spr = new JSeparator());
		spr.setOrientation(SwingConstants.VERTICAL);
		spr.setBounds(545, 0, 5, 50);
		lblNormal.setBounds(505, 0, 40, 30);
		lblSpecial.setBounds(550, 0, 50, 30);
		lblNormal.setEnabled(false);
		lblNormal.setToolTipText("Đang ở chế độ thường");
		lblSpecial.setToolTipText("Nhấn để di chuyển sang chế độ đặc biệt");
		lblNormal.addMouseListener(this);
		lblSpecial.addMouseListener(this);
		return pnl;
	}

	private JPanel pnlMaster(JPanel pnl) {
		JTable tbl = new JTable() {

			@Override
			public Dimension getPreferredScrollableViewportSize() {
				// TODO Auto-generated method stub
				return new Dimension(pnl.getWidth() - 20, this.getHeight());
			}

		};
		Object columnNames[] = { "Mã phòng", "Tên phòng", "Tình trạng" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		if (lblFlag) {
			list = listphong;
		} else {
			try {
				list = read.readAllPhong();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String showtinhtrang = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTinhTrang() == 0) {
				showtinhtrang = "Đã thuê";
			} else if (list.get(i).getTinhTrang() == 1) {
				showtinhtrang = "Còn trống";
			} else if (list.get(i).getTinhTrang() == 2) {
				showtinhtrang = "Đã đặt";
			} else if (list.get(i).getTinhTrang() == 3) {
				showtinhtrang = "Sửa chữa";
			}
			Object rowData[] = { list.get(i).getMaPhong(), list.get(i).getTenPhong(), showtinhtrang };
			model.addRow(rowData);
		}
		tbl.setModel(model);
		JScrollPane srcTable;
		pnl.add(srcTable = new JScrollPane(tbl));
		String tenphong;
		srcTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		srcTable.setPreferredSize(new Dimension(pnl.getWidth() - 20, pnl.getHeight() - 20));
		
		return pnl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		if (obj.equals(lblSuachua)) {
			lblFlag = true;
			try {
				listphong = read.readAllPhongByTinhTrang(3);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
		} else if (obj.equals(lblDathue)) {
			lblFlag = true;
			try {
				listphong = read.readAllPhongByTinhTrang(0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
		} else if (obj.equals(lblDadat)) {
			lblFlag = true;
			try {
				listphong = read.readAllPhongByTinhTrang(2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
		} else if (obj.equals(lblConphong)) {
			lblFlag = true;
			try {
				listphong = read.readAllPhongByTinhTrang(2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
		} else if (obj.equals(lblTatca)) {
			lblFlag = false;
			try {
				listphong = read.readAllPhong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
		} else if (obj.equals(lblNormal)) {
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			createJPanelContent(listphong, panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();

			lblNormal.setEnabled(false);
			lblSpecial.setEnabled(true);
			lblNormal.setToolTipText("Đang ở chế độ thường");
			lblSpecial.setToolTipText("Nhấn để di chuyển sang chế độ đặc biệt");

		} else if (obj.equals(lblSpecial)) {
			panelDanhsachphong.removeAll();
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			pnlMaster(panelDanhsachphong);
			panelDanhsachphong.validate();
			panelDanhsachphong.repaint();
			lblSpecial.setEnabled(false);
			lblNormal.setEnabled(true);
			lblNormal.setToolTipText("Nhấn để di chuyển sang thường");
			lblSpecial.setToolTipText("Đang ở chế độ đặc biệt");

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
