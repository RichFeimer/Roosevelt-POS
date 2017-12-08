import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import TenderPanel.ButtonListener;

public class TenderFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenderFrame frame = new TenderFrame();
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
	public TenderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel1 = new JPanel(new GridLayout(4, 3));

	    panel1.add(btn1);
	    panel1.add(btn2);
	    panel1.add(btn3);
	    panel1.add(btn4);
	    panel1.add(btn5);
	    panel1.add(btn6);
	    panel1.add(btn7);
	    panel1.add(btn8);
	    panel1.add(btn9);
	    panel1.add(btnD);
	    panel1.add(btn0);
	

	    ButtonListener listener = new ButtonListener();

	    btn1.addActionListener(listener);
	    btn2.addActionListener(listener);
	    btn3.addActionListener(listener);
	    btn4.addActionListener(listener);
	    btn5.addActionListener(listener);
	    btn6.addActionListener(listener);
	    btn7.addActionListener(listener);
	    btn8.addActionListener(listener);
	    btn9.addActionListener(listener);
	    btn0.addActionListener(listener);
	    btnD.addActionListener(listener);
	

	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(panel1, BorderLayout.CENTER);
	    btnClear.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		do_bclear_actionPerformed(e);
	    	}
	    });
	    getContentPane().add(btnClear, BorderLayout.SOUTH);
	    getContentPane().add(jtf, BorderLayout.NORTH);

	    jtf.setHorizontalAlignment(SwingConstants.RIGHT);
	    jtf.setPreferredSize(new Dimension(300, 30));
	}
	
	
	String numberString = "";

	JTextField jtf = new JTextField();
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btnD = new JButton(".");
	JButton btn0 = new JButton("0");
	//JButton btnp = new JButton("#");
	JButton btnClear = new JButton("Clear");


	/*
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {

	        public void run() {
	            JFrame frame = new JFrame();
	            frame.add(new TenderPanel());
	            frame.setSize(300, 400);
	            frame.setVisible(true);

	        }
	    });
	}
*/
	class ButtonListener implements ActionListener {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == btn1) {
	            numberString += "1";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn2) {
	            numberString += "2";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn3) {
	            numberString += "3";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn4) {
	            numberString += "4";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn5) {
	            numberString += "5";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn6) {
	            numberString += "6";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn7) {
	            numberString += "7";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn8) {
	            numberString += "8";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn9) {
	            numberString += "9";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btn0) {
	            numberString += "0";
	            jtf.setText(numberString);
	        }else if (e.getSource() == btnD) {
	            numberString += ".";
	            jtf.setText(numberString);
	        }

	        // finish all the else ifs
	    }

	}

	protected void do_bclear_actionPerformed(ActionEvent e) {
		jtf.setText("");
	}

}
