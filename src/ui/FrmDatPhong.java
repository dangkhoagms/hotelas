package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FrmDatPhong extends JFrame implements ActionListener{
	private JPanel pnTop;
	private JPanel pnCenter;
	private JLabel lblCMND;
	private JLabel lblTen;
	private JLabel lblGioiTinh;
	private JLabel lblSoDT;
	private JTextField txtCMND;
	private JTextField txtTen;
	private JComboBox cmbGioiTinh;
	private JTextField txtSoDT;
	private JButton btnTim;
	private JScrollPane scrThongTin;
	private JTable tblPhong;
	private DefaultTableModel tblMode;
	private JButton btnChonDichVu;
	private JButton btnDatPhong;
	private JButton btnHuy;
	private JPanel pnSouth;
	private JLabel lblTienDat;
	private JTextField txtTienDat;
	private JButton btnThemPhong;
	private JFrame parent;
	private String maphong;
	private JFrame UI;
	
	public FrmDatPhong(JFrame frm,String tenphong) {
		setSize(418, 460);
		setLocationRelativeTo(null);
		UI = this;
		maphong = tenphong;
		parent =frm;
		// setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Thông tin Đặt Phòng");
		createFormDatPhong();
		setVisible(true);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
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
				
			}
		});
			}

	private void createFormDatPhong() {
		// TODO Auto-generated method stub
		setLayout(null);
		add(pnTop = new JPanel(), BorderLayout.NORTH);
		pnTop.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		pnTop.setBounds(12, 3, 376, 175);
		pnTop.setLayout(null);
		pnTop.add(lblCMND = new JLabel("Số CMND:"));
		lblCMND.setBounds(10, 20, 100, 20);
		pnTop.add(txtCMND = new JTextField());
		txtCMND.setBounds(120, 20, 200, 20);
		pnTop.add(btnTim = new JButton(new ImageIcon("images/search.png")));
		btnTim.setBounds(330, 20, 22, 26);
		btnTim.setBorder(null);
	
		pnTop.add(lblTen = new JLabel("Tên khách hàng:"));
		lblTen.setBounds(10, 50, 100, 20);
		pnTop.add(txtTen = new JTextField());
		txtTen.setBounds(120, 50, 200, 20);
		pnTop.add(lblGioiTinh = new JLabel("Giới tính:"));
		lblGioiTinh.setBounds(10, 80, 100, 20);
		String[] arrGioiTinh = { "Nam", "Nữ" };
		pnTop.add(cmbGioiTinh = new JComboBox<>(arrGioiTinh));
		cmbGioiTinh.setBounds(120, 80, 200, 20);
		pnTop.add(lblSoDT = new JLabel("Số điện thoại:"));
		lblSoDT.setBounds(10, 110, 100, 20);
		pnTop.add(txtSoDT = new JTextField());
		txtSoDT.setBounds(120, 110, 200, 20);
		pnTop.add(lblTienDat=new JLabel("Tiền đặt (VND):"));
		lblTienDat.setBounds(10, 140, 100, 20);
		pnTop.add(txtTienDat=new JTextField());
		txtTienDat.setBounds(120, 140, 200, 20);

		add(pnCenter = new JPanel(), BorderLayout.CENTER);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Thông tin Đặt phòng"));
		pnCenter.setLayout(null);
		pnCenter.setBounds(0, 190, 400, 160);
		String head[] = { "STT", "Tên phòng", "Loại phòng","Dịch vụ","Ngày thuê" ,"Ngày trả"};
		tblMode = new DefaultTableModel(head, 0);
		pnCenter.add(scrThongTin = new JScrollPane(tblPhong = new JTable(tblMode)));
		//		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
		String row[] = { "1", "phòng 101", "vip" };
		String row1[] = { "2", "phòng 301", "thường" };
		scrThongTin.setBounds(5, 30, 390, 100);
		pnCenter.add(btnThemPhong=new JButton(new ImageIcon("images/add.png")));
		btnThemPhong.setBounds(187, 130, 23, 21);
		btnThemPhong.setBorder(null);
	//	scrThongTin.setPreferredSize(new Dimension(400,200));
		tblMode.addRow(row);
		tblMode.addRow(row1);
		

		// tblPhong.setModel(tblMode);
		// scrThongTin.add(tblPhong);
		// String [] arrLoaiphong = {"Vip","Thường","Phòng đôi","Phòng đơn"};
		// cbbLoaiphong = new JComboBox<>(arrLoaiphong);
		
		//btnDatPhong.setBounds(150, 370, 130, 25);
		add(pnSouth=new JPanel(),BorderLayout.SOUTH);
		pnSouth.setLayout(null);
		pnSouth.setBounds(0, 330, 400, 80);
	
		pnSouth.add(btnChonDichVu=new JButton("Chọn dịch vụ"));
		pnSouth.add(btnDatPhong=new JButton("Đặt phòng"));
		pnSouth.add(btnHuy=new JButton("Hủy"));
		btnHuy.setBounds(15,38 ,80  , 30);
		btnChonDichVu.setBounds(125,38 ,110  , 30);
		btnDatPhong.setBounds(265,38 ,100  , 30);
		btnChonDichVu.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnDatPhong)) {
			parent.setEnabled(true);
			dispose();
			
		}else if(obj.equals(btnHuy)) {
			parent.setEnabled(true);
			dispose();
		}else if(obj.equals(btnChonDichVu)) {
			new FrmDichVu(UI, maphong);
			System.out.println(maphong);
			UI.setEnabled(false);
		}
	}
	
	
}
