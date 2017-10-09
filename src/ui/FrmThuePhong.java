package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import controller.Phong;

public class FrmThuePhong extends JFrame implements ActionListener, MouseListener {
	private JRadioButton radThuedattruoc;
	private JRadioButton radThuechuadattruoc;
	private JPanel panel;
	private JTextField txtCmnd;
	private JLabel lblCmnd;
	private JButton btnTim;
	private JLabel lblTenkh;
	private JTextField txtTenkh;
	private JLabel lblGioitinh;
	private JComboBox<String> cbbGioitinh;
	private JLabel lblSodienthoai;
	private JTextField txtSodienthoai;
	private JPanel panelThuephong;
	private JLabel lblMaphieu;
	private JTextField txtMaphieu;
	private JLabel lblLoaiphong;
	private JTextField txtLoaiphong;
	private JLabel lblPhong;
	private JTextField txtPhong;
	private JLabel lblNgaytra;
	private JButton btnThuephong;
	private JButton btnHuy;
	private JFrame parent;
	private Phong phong = new Phong();
	private JDateChooser DateNgaytra;
	private JButton btnAdd;
	private JFrame frm;
	private String listmaphong;

	public FrmThuePhong(JFrame frm, String maphong) {
		this.frm = this;
		parent = frm;
		this.listmaphong = maphong;
		panel = new JPanel();
		String[] arrGioitinh = { "Nam", "Nữ" };
		panel.add(radThuedattruoc = new JRadioButton("Thuê phòng đặt trước"));
		panel.add(radThuechuadattruoc = new JRadioButton("Thuê phòng chưa đặt trước"));
		panel.add(lblCmnd = new JLabel("Số CMND:"));
		panel.add(txtCmnd = new JTextField());
		panel.add(btnTim = new JButton("Tìm"));
		panel.add(lblTenkh = new JLabel("Tên khách hàng"));
		panel.add(txtTenkh = new JTextField());
		panel.add(lblGioitinh = new JLabel("Giới tính"));
		panel.add(cbbGioitinh = new JComboBox<>(arrGioitinh));
		panel.add(lblSodienthoai = new JLabel("Số điện thoại"));
		panel.add(txtSodienthoai = new JTextField());
		panel.setLayout(null);
		ButtonGroup group = new ButtonGroup();
		group.add(radThuechuadattruoc);
		group.add(radThuedattruoc);
		radThuedattruoc.setBounds(10, 20, 150, 20);
		radThuechuadattruoc.setBounds(160, 20, 200, 20);
		lblCmnd.setBounds(10, 50, 100, 20);
		txtCmnd.setBounds(120, 50, 200, 20);
		btnTim.setBounds(325, 50, 60, 20);
		lblTenkh.setBounds(10, 80, 100, 20);
		txtTenkh.setBounds(120, 80, 200, 20);
		lblGioitinh.setBounds(10, 110, 100, 20);
		cbbGioitinh.setBounds(120, 110, 200, 20);
		lblSodienthoai.setBounds(10, 140, 100, 20);
		txtSodienthoai.setBounds(120, 140, 200, 20);
		panel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		add(panel);
		panel.setBounds(0, 0, 400, 200);

		BufferedImage imageAdd = null;
		try {
			imageAdd = ImageIO.read(new File("images/add.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconAdd = new ImageIcon(imageAdd.getScaledInstance(20, 20, imageAdd.SCALE_SMOOTH));
		panelThuephong = new JPanel();
		add(panelThuephong);
		panelThuephong.setLayout(null);
		panelThuephong.setBorder(BorderFactory.createTitledBorder("Thông tin thuê phòng"));
		panelThuephong.setBounds(0, 210, 400, 170);
		panelThuephong.add(lblMaphieu = new JLabel("Mã phiếu thuê:"));
		panelThuephong.add(txtMaphieu = new JTextField());
		panelThuephong.add(lblLoaiphong = new JLabel("Loại phòng:"));
		panelThuephong.add(txtLoaiphong = new JTextField());
		panelThuephong.add(lblPhong = new JLabel("Phòng:"));
		panelThuephong.add(txtPhong = new JTextField());
		panelThuephong.add(lblNgaytra = new JLabel("Ngày trả dự kiến:"));
		panelThuephong.add(DateNgaytra = new JDateChooser());
		panelThuephong.add(btnAdd = new JButton());
		btnAdd.setIcon(iconAdd);
		// custom
		lblMaphieu.setBounds(10, 20, 100, 20);
		txtMaphieu.setBounds(120, 20, 200, 20);
		lblLoaiphong.setBounds(10, 50, 100, 20);
		txtLoaiphong.setBounds(120, 50, 200, 20);
		lblPhong.setBounds(10, 80, 100, 20);
		txtPhong.setBounds(120, 80, 200, 20);
		btnAdd.setBounds(330, 80, 20, 20);
		lblNgaytra.setBounds(10, 110, 100, 20);
		DateNgaytra.setBounds(120, 110, 200, 20);
		txtLoaiphong.setEditable(false);
		btnThuephong = new JButton("Thuê Phòng");
		btnHuy = new JButton("Hủy");
		add(btnThuephong);
		add(btnHuy);
		btnThuephong.setBounds(150, 390, 130, 25);
		btnHuy.setBounds(290, 390, 100, 25);
		btnThuephong.addActionListener(this);
		btnHuy.addActionListener(this);
		btnAdd.addActionListener(this);
		btnAdd.addMouseListener(this);

		// set
		setLayout(null);
		setVisible(true);
		setSize(400, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnTim)){
			phong.FindviewbyCMND(txtCmnd,txtTenkh,txtSodienthoai,cbbGioitinh);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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

	/*private JPopupMenu popupMenu(String text) throws Exception {
		JPopupMenu popupmenu = new JPopupMenu();
		popupmenu.setLayout(null);
		JPanel pnlPhong;
		JScrollPane scrPanel = new JScrollPane(pnlPhong = new JPanel());
		popupmenu.add(scrPanel);
		//
		scrPanel.setBounds(0, 50, 390, 200);
		pnlPhong.setLayout(new FlowLayout(FlowLayout.LEFT));
		scrPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnlPhong.setPreferredSize(new Dimension(350, 250));
		pnlPhong.removeAll();
		pnlPhong.validate();
		pnlPhong.repaint();
		createJPanelContent(phong.GetListPhongTrong(text), pnlPhong);

		return popupmenu;
	}*/
	
	private JPanel createJPanelContent(ArrayList<String> arrayList, JPanel panel) {
		// add array JButton to panel
		for (int i = 0; i < arrayList.size(); i++) {

			panel.add(createJButton(arrayList.get(i)));
		}
		return panel;
	}

	// create JButton

	private JButton createJButton(String buttonName) {
		JButton btn = new JButton(buttonName);
		BufferedImage imageControng = null;
		try {
			imageControng = ImageIO.read(new File("images/imgTrangThaiControng.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon iconConphong = new ImageIcon(imageControng.getScaledInstance(30, 30, imageControng.SCALE_SMOOTH));
		btn.setIcon(iconConphong);
		btn.addActionListener(this);
		btn.addMouseListener(this);
		return btn;
	}

}
