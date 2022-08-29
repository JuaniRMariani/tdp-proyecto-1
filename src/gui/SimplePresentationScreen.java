package gui;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textLU;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textGithubURL;
	private JLabel lblNewLabel_6;

	public SimplePresentationScreen(Student studentData) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TDP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(620, 267));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabInformation = new JPanel();
		tabInformation.setBorder(new LineBorder(UIManager.getColor("ComboBox.selectionBackground")));
		tabInformation.setBackground(Color.LIGHT_GRAY);
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lblNewLabel = new JLabel("LU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));		
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_3 = new JLabel("E-mail\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_4 = new JLabel("Github URL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textLU = new JTextField();
		textLU.setBackground(Color.WHITE);
		textLU.setEditable(false);
		textLU.setColumns(10);
		textLU.setText(studentData.getId() + "");
				
		textApellido = new JTextField();
		textApellido.setBackground(Color.WHITE);
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setText(studentData.getLastName());
		
		textNombre = new JTextField();
		textNombre.setBackground(Color.WHITE);
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setText(studentData.getFirstName());
		
		textEmail = new JTextField();
		textEmail.setBackground(Color.WHITE);
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setText(studentData.getMail());
				
		textGithubURL = new JTextField();
		textGithubURL.setBackground(Color.WHITE);
		textGithubURL.setEditable(false);
		textGithubURL.setColumns(10);
		textGithubURL.setText(studentData.getGithubURL());
		
		
		//Creamos el manejo de la fecha para colocar en la ventana de la gui en el formato DD/MM/YYYY.
		Date fechahoy = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
		String fecha = formatofecha.format(fechahoy);
		
		//Creamos la hora para colocar en la ventana de la gui en el formato HH:MM:SS
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);		
		String hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
		String minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		String segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
		

		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(10)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(textGithubURL, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(textEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(textNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(textLU, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(textApellido, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(textLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textGithubURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		tabInformation.setLayout(gl_tabInformation);
		
		//JLabel creado para insertar la imagen del estudiante.
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(studentData.getPathPhoto()));
		
		lblNewLabel_6 = new JLabel("Esta ventana fue generada el " + fecha + " a las " + hora + ":" + minutos + ":" + segundos + "");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
