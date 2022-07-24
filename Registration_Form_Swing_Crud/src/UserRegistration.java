import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UserRegistration {

	private JFrame frame;
	private JTextField txtemail;
	private JTextField txtlname;
	private JTextField txtfname;
	private JTextField txtusername;
	private JTextField txtmobile;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration window = new UserRegistration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New User Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(247, 29, 237, 31);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblfname = new JLabel("First Name\r\n");
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfname.setBounds(32, 94, 67, 17);
		frame.getContentPane().add(lblfname);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(32, 149, 67, 17);
		frame.getContentPane().add(lblLastName);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAddress.setBounds(32, 202, 93, 17);
		frame.getContentPane().add(lblEmailAddress);

		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(153, 203, 138, 24);
		frame.getContentPane().add(txtemail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(387, 94, 67, 17);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(387, 149, 67, 17);
		frame.getContentPane().add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNumber.setBounds(387, 202, 97, 17);
		frame.getContentPane().add(lblMobileNumber);

		JButton btnbutton = new JButton("Register");
		btnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtfname.getText();
				String lastName = txtlname.getText();
				String emailId = txtemail.getText();
				String userName = txtusername.getText();
				String mobileNumber = txtmobile.getText();
				int len = mobileNumber.length();
				String password = passwordField.getText();

				String msg = "" + firstName;
				msg += " \n";
				if (len != 10) {
					JOptionPane.showMessageDialog(btnbutton, "Enter a valid mobile number");
				}

				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/swing_demo", "root", "");

					String query = "INSERT INTO account values ('" + firstName + "','" + lastName + "','" + userName
							+ "','" + password + "','" + emailId + "','" + mobileNumber + "')";

					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);

					if (x == 0) {
						JOptionPane.showMessageDialog(btnbutton, "This is already exist");
					} else {
						JOptionPane.showMessageDialog(btnbutton,
								"welcome, " + msg + "Your account is sucessfully created");
					}
					con.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnbutton.setBounds(289, 254, 111, 44);
		frame.getContentPane().add(btnbutton);

		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(153, 150, 138, 24);
		frame.getContentPane().add(txtlname);

		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBounds(153, 95, 138, 24);
		frame.getContentPane().add(txtfname);

		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(503, 94, 138, 24);
		frame.getContentPane().add(txtusername);

		txtmobile = new JTextField();
		txtmobile.setColumns(10);
		txtmobile.setBounds(503, 202, 138, 24);
		frame.getContentPane().add(txtmobile);

		passwordField = new JPasswordField();
		passwordField.setBounds(503, 150, 138, 24);
		frame.getContentPane().add(passwordField);
	}
}
