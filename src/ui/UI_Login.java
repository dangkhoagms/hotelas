package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.DangNhap;
public class UI_Login extends JFrame implements ActionListener,KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UI_Login UI;
	private static DangNhap dn;
	private JLabel lbltenPhanmem;
	private JLabel lblTendangnhap;
	private JLabel lblPass;
	private JTextField txtTendangnhap;
	private JTextField txtPass;
	private JButton btnLogin;
	public  UI_Login() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		JPanel panelMain = new JPanel(){ 
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) 
            { 
                Dimension d = getSize(); 
                Image img=this.getToolkit().getImage("images/background-login.jpg"); 
                g.drawImage(img, 0, 0, d.width, d.height, this); 

                setOpaque( false );  
                super.paintComponent(g); 
            } 
        }; 
		add(panelMain);
		panelMain.setLayout(null);
		lbltenPhanmem = new JLabel("Quản Lý Khách Sạn");
		panelMain.add(lbltenPhanmem);
		Font font = new Font("Tahoma",Font.BOLD, 30);
		Font font1 = new Font("Tahoma",Font.BOLD, 18);
		lbltenPhanmem.setFont(font);
		lbltenPhanmem.setForeground(Color.BLACK);
		lbltenPhanmem.setBounds(230, 50, 317, 35);
		panelMain.setBounds(0, 0, 800, 600);
		lblTendangnhap = new JLabel("Tên Đăng Nhập");
		lblPass = new JLabel("Mật Khẩu");
		txtTendangnhap = new JTextField();
		txtPass = new JPasswordField();
		btnLogin = new JButton("Đăng Nhập");
		panelMain.add(lblTendangnhap);
		panelMain.add(lblPass);
		panelMain.add(txtTendangnhap);
		panelMain.add(txtPass);
		panelMain.add(btnLogin);
		lblTendangnhap.setFont(font1);
		lblTendangnhap.setForeground(Color.RED);
		lblPass.setFont(font1);
		lblPass.setForeground(Color.RED);
		lblTendangnhap.setBounds(48, 220, 150, 30);
		lblPass.setBounds(100, 260, 150, 30);
		txtTendangnhap.setBounds(200, 220, 350, 30);
		txtPass.setBounds(200, 260, 350, 30);
		btnLogin.setBounds(450, 320, 100, 30);
		//set action
		btnLogin.addActionListener(this);
		txtTendangnhap.addKeyListener(this);
		txtPass.addKeyListener(this);
		// setUI
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UI = new UI_Login();
		dn = new DangNhap();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		if(obj.equals(btnLogin)) {
			
			try {
				if(dn.kiemTra(UI,txtTendangnhap, txtPass)) {
					new UI_Main();
					dispose();
				}else {
					dn.LoginFail(UI, txtTendangnhap, txtPass);
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
				if(dn.kiemTra(UI,txtTendangnhap, txtPass)) {
					new UI_Main();
					dispose();
				}else {
					dn.LoginFail(UI, txtTendangnhap, txtPass);
					
				}
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


