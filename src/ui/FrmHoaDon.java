package ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyThongKe;

public class FrmHoaDon extends JFrame implements ActionListener {
	private JPanel pnTop;
	private JPanel pnBottom;
	private JPanel pnCenter;
	private JTable tblHoaDon;
	private JScrollPane scrThongTin;
	private JTable tblModel;
	private JButton btnXem;
	private JButton btnHuy;
	private JButton btnThanhToan;
	private JTable tblModel2;
	private JScrollPane scrChiTiet;
	private JTable tblChiTiet;
	private JFrame parent;
	private QuanLyThongKe ql = new QuanLyThongKe();
	public FrmHoaDon(JFrame frm) {
		// TODO Auto-generated constructor stub
		parent = frm;
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Hóa đơn đặt phòng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createFromHoaDon();
	}

	private void createFromHoaDon() {
		// TODO Auto-generated method stub
		setLayout(null);
		add(pnTop = new JPanel());
		pnTop.setLayout(null);
		pnTop.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		pnTop.setBounds(0, 0, 780, 250);
		
		tblModel = new JTable();
		pnTop.add(scrThongTin = new JScrollPane(tblModel));
		scrThongTin.setBounds(10, 30, 760, 200);
		add(pnCenter = new JPanel());
		pnCenter.setBounds(0, 250, 780, 50);
		pnCenter.add(btnXem = new JButton("Xem chi tiết"));
		pnCenter.add(btnThanhToan = new JButton("Thanh toán"));
		add(pnBottom = new JPanel());
		pnBottom.setLayout(null);
		pnBottom.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		pnBottom.setBounds(0, 300, 780, 260);
		tblModel2 = new JTable();
		pnBottom.add(scrChiTiet = new JScrollPane(tblChiTiet));
		scrChiTiet.setBounds(10, 30, 760, 200);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					ql.getData(tblModel);
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

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	

}
