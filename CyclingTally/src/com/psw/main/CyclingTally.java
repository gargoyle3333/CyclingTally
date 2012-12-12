package com.psw.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CyclingTally extends JFrame {

	private JPanel contentPane;
	private JTextField txtDistance;
	private JTextField txtTotal;
	
	private float totalDistanceCovered = 0F;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CyclingTally frame = new CyclingTally();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CyclingTally() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 754);
		setTitle("Cycling Tally");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterDistance = new JLabel("Enter new cycling distance:");
		lblEnterDistance.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblEnterDistance.setBounds(83, 95, 612, 104);
		contentPane.add(lblEnterDistance);
		
		JLabel lblKms = new JLabel("KMS");
		lblKms.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblKms.setBounds(869, 40, 141, 119);
		contentPane.add(lblKms);
		
		txtDistance = new JTextField();
		txtDistance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					try {
						float distance = Float.parseFloat(txtDistance.getText());
						totalDistanceCovered += distance;
						txtTotal.setText(Float.toString(totalDistanceCovered));
						txtDistance.setText("");
						txtDistance.requestFocus();
					} catch (Exception ex) {
						// Do nothing!
					}
				}
			}
		});
		txtDistance.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txtDistance.setBounds(27, 258, 257, 104);
		contentPane.add(txtDistance);
		txtDistance.setColumns(10);
		
		JLabel lblKm = new JLabel("km");
		lblKm.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblKm.setBounds(294, 235, 161, 172);
		contentPane.add(lblKm);
		
		JButton btnCyclingDistanceAchieved = new JButton("Cycling distance achieved");
		btnCyclingDistanceAchieved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float distance = Float.parseFloat(txtDistance.getText());
					totalDistanceCovered += distance;
					txtTotal.setText(Float.toString(totalDistanceCovered));
					txtDistance.setText("");
				} catch (Exception ex) {
					// Do nothing!
				} finally {
					txtDistance.requestFocus();
				}
				
			}
		});
		btnCyclingDistanceAchieved.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnCyclingDistanceAchieved.setBounds(426, 239, 584, 119);
		contentPane.add(btnCyclingDistanceAchieved);
		
		JLabel lblTotalKmsCycled = new JLabel("Total Kms Cycled:");
		lblTotalKmsCycled.setFont(new Font("Tahoma", Font.BOLD, 54));
		lblTotalKmsCycled.setBounds(34, 496, 504, 124);
		contentPane.add(lblTotalKmsCycled);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txtTotal.setEditable(false);
		txtTotal.setBounds(548, 516, 408, 84);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
	}
}
