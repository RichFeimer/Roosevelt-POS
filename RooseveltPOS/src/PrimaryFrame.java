import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;

import java.net.URL;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class PrimaryFrame extends JFrame {

	private JPanel contentPane;
	
	//private int maxSize;
	//private String[] orderStack;
	private List<String> uniqueItems = new ArrayList<>();
	private Stack<String> orderStack = new Stack<>();
	private List<String> dailyTotalSold = new ArrayList<>();
	//private int top;
	double subtotal = 0;
	boolean tenderWindowActive = false;
	JFrame activeFrame;
	
	private final JButton btnSmPop = new JButton("Sm Popcorn");
	private final JButton btn3Musk = new JButton("");
	private final JButton btnSqwigglies = new JButton("");
	private final JButton btnBunchaCrunch = new JButton("");
	private final JButton btnSlushy = new JButton("Slushy");
	private final JButton btnBulkCandy = new JButton("Bulk Candy");
	private final JPanel pnlOrder = new JPanel();
	private final JButton btn5Dollars = new JButton("$5.00");
	private final JButton btn10Dollars = new JButton("$10.00");
	private final JButton btn20Dollars = new JButton("$20.00");
	private final JButton btn50Dollars = new JButton("$50.00");
	private final JButton btnVoidOne = new JButton("Void One");
	private final JButton btnStartTender = new JButton("Start Tender");
	private final JButton btnExactChange = new JButton("Exact Change");
	private final JLabel lblSubtotal = new JLabel("Subtotal:");
	private final JLabel lblSubtotalOutput = new JLabel("0.00");
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblTender = new JLabel("Tender:");
	private final JLabel lblTenderOut = new JLabel("0.00");
	private final JLabel lblChange = new JLabel("Change:");
	private final JLabel lblChangeOut = new JLabel("0.00");
	private final JButton btnMenu = new JButton("Menu");

	
	public static int mainCount=0;
	private final JPanel pnlPrice = new JPanel();
	private final JLabel lblSmPopcorn = new JLabel("Sm Popcorn");
	private final JButton btnMedPop = new JButton("Med Popcorn");
	private final JButton btnLgPop = new JButton("Lg Popcorn");
	private final JButton btnSmDrink = new JButton("Sm Drink");
	private final JButton btnMedDrink = new JButton("Med Drink");
	private final JButton btnLgDrink = new JButton("Lg Drink");
	private final JButton btnNeccos = new JButton("Neccos");
	private final JButton btnReesesPieces = new JButton("Reeses Pieces");
	private final JButton btnSkittles = new JButton("Skittles");
	private final JButton btnSnickers = new JButton("Snickers");
	private final JButton btnStarburstOrg = new JButton("Starburst Org");
	private final JButton btnStarburstTrop = new JButton("Starburst Trop");
	private final JButton btnSpree = new JButton("Spree");
	private final JButton btnTwix = new JButton("Twix");
	private final JLabel lblSqwigglies = new JLabel("Sqwigglies");
	private final JLabel lblBunchaCrunch = new JLabel("Buncha Crunch");
	private final JLabel lblMusketeers = new JLabel("3 Musketeers");
	private final JButton btnGummiBears = new JButton("Gummi Bears");
	private final JButton btnJrMints = new JButton("Jr Mints");
	private final JButton btnMmPlain = new JButton("MM Plain");
	private final JButton btnMmPeanut = new JButton("MM Peanut");
	private final JButton btnMilkDuds = new JButton("Milk Duds");
	private final JButton btnPeanutChew = new JButton("Peanut Chew");
	private final JButton btnCookieDoughBites = new JButton("Cookie Dough Bites");
	private final JButton btnButterfingerBites = new JButton("Butterfinger Bites");
	private final JPanel pnlCandy = new JPanel();
	private final JButton btnKitKat = new JButton("Kit Kat");
	private final JButton btnMikeIke = new JButton("Mike Ike");
	private final JButton btnGoober = new JButton("Goober");
	private final JButton btnRaisinets = new JButton("Raisinets");
	private final JButton btnSnoCaps = new JButton("Sno Caps");
	private final JButton btnJujyFruits = new JButton("Jujy Fruits");
	private final JButton btnTwizzlers = new JButton("Twizzlers");
	private final JButton btnSourPatch = new JButton("Sour Patch");
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JButton btnPegReesesPieces = new JButton("Peg Reeses Pieces");
	private final JButton btnPegSourSkittles = new JButton("Peg Sour Skittles");
	private final JButton btnPegSkittles = new JButton("Peg Skittles");
	private final JButton btnReesesCups = new JButton("Reeses Cups");
	private final JButton btnCheese = new JButton("Cheese");
	private final JButton btnHotDog = new JButton("Hot Dog");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimaryFrame frame = new PrimaryFrame();
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
	public PrimaryFrame() {
		jbInit();
	}
	private void jbInit() {
		setType(Type.UTILITY);
		setTitle("Roosevelt POS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon("/resources/smPop.jpg");
		Image img = icon.getImage() ;  
		   Image newimg = img.getScaledInstance( 89, 74,  java.awt.Image.SCALE_SMOOTH ) ;  
		   icon = new ImageIcon( newimg );
		pnlOrder.setBackground(new Color(255, 255, 224));
		pnlOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_pnlOrder_mouseClicked(arg0);
			}
		});
		pnlOrder.setBorder(null);
		pnlOrder.setBounds(585, 11, 171, 311);
		
		contentPane.add(pnlOrder);
		pnlOrder.setLayout(new BoxLayout(pnlOrder, BoxLayout.Y_AXIS));
		btn5Dollars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn5Dollars_actionPerformed(arg0);
			}
		});
		btn5Dollars.setBounds(585, 322, 73, 59);
		
		contentPane.add(btn5Dollars);
		btn10Dollars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn10Dollars_actionPerformed(arg0);
			}
		});
		btn10Dollars.setBounds(658, 322, 73, 59);
		
		contentPane.add(btn10Dollars);
		btn20Dollars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn20Dollars_actionPerformed(arg0);
			}
		});
		btn20Dollars.setBounds(585, 380, 73, 59);
		
		contentPane.add(btn20Dollars);
		btn50Dollars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn50Dollars_actionPerformed(arg0);
			}
		});
		btn50Dollars.setBounds(658, 380, 73, 59);
		
		contentPane.add(btn50Dollars);
		btnVoidOne.setBounds(727, 380, 73, 59);
		
		contentPane.add(btnVoidOne);
		btnStartTender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnStartTender_actionPerformed(e);
			}
		});
		btnStartTender.setBounds(585, 439, 109, 59);
		
		contentPane.add(btnStartTender);
		btnExactChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExactChange_actionPerformed(e);
			}
		});
		btnExactChange.setBounds(694, 439, 106, 59);
		
		contentPane.add(btnExactChange);
		lblSubtotal.setBounds(694, 498, 52, 14);
		
		contentPane.add(lblSubtotal);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(744, 498, 56, 59);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		lblTenderOut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTenderOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenderOut.setBounds(0, 15, 56, 14);
		
		panel_1.add(lblTenderOut);
		lblChangeOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangeOut.setBounds(0, 30, 56, 14);
		
		panel_1.add(lblChangeOut);
		lblSubtotalOutput.setBounds(0, 0, 56, 14);
		panel_1.add(lblSubtotalOutput);
		lblSubtotalOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubtotalOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalOutput.setBackground(SystemColor.menu);
		lblTender.setBounds(694, 513, 46, 14);
		
		contentPane.add(lblTender);
		lblChange.setBounds(694, 528, 46, 14);
		
		contentPane.add(lblChange);
		btnMenu.setBounds(585, 498, 99, 59);
		
		contentPane.add(btnMenu);
		pnlPrice.setBackground(new Color(255, 255, 224));
		pnlPrice.setBounds(756, 11, 44, 311);
		
		contentPane.add(pnlPrice);
		pnlPrice.setLayout(new BoxLayout(pnlPrice, BoxLayout.Y_AXIS));
		tabbedPane.setBounds(0, 0, 580, 578);
		
		contentPane.add(tabbedPane);
		lblSqwigglies.setForeground(Color.BLACK);
		lblSqwigglies.setFont(new Font("Century", Font.BOLD, 11));
		lblSqwigglies.setHorizontalAlignment(SwingConstants.CENTER);
		lblSqwigglies.setLabelFor(btnSqwigglies);
		btn3Musk.setIcon(new ImageIcon(PrimaryFrame.class.getResource("/resources/3Musk.jpg")));
		btn3Musk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn3Musk_actionPerformed(arg0);
			}
		});
		lblSmPopcorn.setForeground(Color.BLACK);
		lblSmPopcorn.setFont(new Font("Century", Font.BOLD, 11));
		lblSmPopcorn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmPopcorn.setBounds(7, 55, 89, 14);
		tabbedPane.addTab("New tab", null, pnlCandy, null);
		
		pnlCandy.add(lblSmPopcorn);
		lblSmPopcorn.setLabelFor(btnSmPop);
		lblMusketeers.setFont(new Font("Century", Font.BOLD, 11));
		lblMusketeers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusketeers.setBounds(106, 57, 89, 14);
		
		pnlCandy.add(lblMusketeers);
		btn3Musk.setBounds(106, 11, 89, 60);
		
		pnlCandy.add(btn3Musk);
		btnSlushy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSlushy_actionPerformed(arg0);
			}
		});
		btnSlushy.setBounds(391, 11, 89, 60);
		
		pnlCandy.add(btnSlushy);
		btnBulkCandy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBulkCandy_actionPerformed(arg0);
			}
		});
		btnBulkCandy.setBounds(486, 11, 89, 74);
		
		pnlCandy.add(btnBulkCandy);
		btnMedPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMedPop_actionPerformed(arg0);
			}
		});
		btnMedPop.setBounds(7, 75, 89, 60);
		
		pnlCandy.add(btnMedPop);
		btnLgPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLgPop_actionPerformed(arg0);
			}
		});
		btnLgPop.setBounds(7, 136, 89, 60);
		
		pnlCandy.add(btnLgPop);
		
		btnSmPop.setMargin(new Insets(0, 14, 0, 0));
		btnSmPop.setIcon(new ImageIcon(PrimaryFrame.class.getResource("/resources/smallPopcorn.png")));
		//order(10);
		
		btnSmPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSmPop_actionPerformed(arg0);
			}
		});
		btnSmPop.setBounds(10, 11, 89, 60);
		
		pnlCandy.add(btnSmPop);
		btnSmDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSmDrink_actionPerformed(arg0);
			}
		});
		btnSmDrink.setBounds(7, 197, 89, 60);
		
		pnlCandy.add(btnSmDrink);
		btnMedDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMedDrink_actionPerformed(arg0);
			}
		});
		btnMedDrink.setBounds(7, 260, 89, 60);
		
		pnlCandy.add(btnMedDrink);
		btnLgDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLgDrink_actionPerformed(arg0);
			}
		});
		btnLgDrink.setBounds(7, 323, 89, 60);
		
		pnlCandy.add(btnLgDrink);
		btnNeccos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNeccos_actionPerformed(arg0);
			}
		});
		btnNeccos.setBounds(106, 75, 89, 60);
		
		pnlCandy.add(btnNeccos);
		btnReesesPieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnReesesPieces_actionPerformed(arg0);
			}
		});
		btnReesesPieces.setBounds(106, 136, 89, 60);
		
		pnlCandy.add(btnReesesPieces);
		btnSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSkittles_actionPerformed(arg0);
			}
		});
		btnSkittles.setBounds(106, 197, 89, 60);
		
		pnlCandy.add(btnSkittles);
		btnSnickers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSnickers_actionPerformed(arg0);
			}
		});
		btnSnickers.setBounds(106, 260, 89, 60);
		
		pnlCandy.add(btnSnickers);
		btnStarburstOrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStarburstOrg_actionPerformed(arg0);
			}
		});
		btnStarburstOrg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnStarburstOrg.setBounds(106, 323, 89, 60);
		
		pnlCandy.add(btnStarburstOrg);
		btnStarburstTrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStarburstTrop_actionPerformed(arg0);
			}
		});
		btnStarburstTrop.setBounds(106, 386, 89, 60);
		
		pnlCandy.add(btnStarburstTrop);
		btnSpree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSpree_actionPerformed(arg0);
			}
		});
		btnSpree.setBounds(106, 449, 89, 60);
		
		pnlCandy.add(btnSpree);
		btnTwix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnTwix_actionPerformed(arg0);
			}
		});
		btnTwix.setBounds(106, 512, 89, 60);
		
		pnlCandy.add(btnTwix);
		lblSqwigglies.setBounds(201, 55, 89, 14);
		
		pnlCandy.add(lblSqwigglies);
		btnSqwigglies.setIcon(new ImageIcon(PrimaryFrame.class.getResource("/resources/sqwigglies.png")));
		btnSqwigglies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSqwigglies_actionPerformed(arg0);
			}
		});
		btnSqwigglies.setBounds(201, 11, 89, 60);
		
		pnlCandy.add(btnSqwigglies);
		lblBunchaCrunch.setForeground(Color.WHITE);
		lblBunchaCrunch.setFont(new Font("Century", Font.BOLD, 10));
		lblBunchaCrunch.setBounds(296, 55, 89, 14);
		
		pnlCandy.add(lblBunchaCrunch);
		btnBunchaCrunch.setIcon(new ImageIcon(PrimaryFrame.class.getResource("/resources/bunchaCrunch.png")));
		btnBunchaCrunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBunchaCrunch_actionPerformed(arg0);
			}
		});
		btnBunchaCrunch.setBounds(296, 11, 89, 60);
		
		pnlCandy.add(btnBunchaCrunch);
		btnGummiBears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGummiBears_actionPerformed(arg0);
			}
		});
		btnGummiBears.setBounds(201, 75, 89, 60);
		
		pnlCandy.add(btnGummiBears);
		btnJrMints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnJrMints_actionPerformed(e);
			}
		});
		btnJrMints.setBounds(201, 136, 89, 60);
		
		pnlCandy.add(btnJrMints);
		btnMmPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMmPlain_actionPerformed(e);
			}
		});
		btnMmPlain.setBounds(201, 197, 89, 60);
		
		pnlCandy.add(btnMmPlain);
		btnMmPeanut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMmPeanut_actionPerformed(e);
			}
		});
		btnMmPeanut.setBounds(201, 260, 89, 60);
		
		pnlCandy.add(btnMmPeanut);
		btnMilkDuds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMilkDuds_actionPerformed(e);
			}
		});
		btnMilkDuds.setBounds(201, 322, 89, 60);
		
		pnlCandy.add(btnMilkDuds);
		btnPeanutChew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPeanutChew_actionPerformed(e);
			}
		});
		btnPeanutChew.setBounds(201, 386, 89, 60);
		
		pnlCandy.add(btnPeanutChew);
		btnCookieDoughBites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCookieDoughBites_actionPerformed(e);
			}
		});
		btnCookieDoughBites.setBounds(201, 449, 89, 60);
		
		pnlCandy.add(btnCookieDoughBites);
		btnButterfingerBites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnButterfingerBites_actionPerformed(e);
			}
		});
		btnButterfingerBites.setBounds(201, 513, 89, 59);
		
		pnlCandy.add(btnButterfingerBites);
		pnlCandy.setLayout(null);
		btnKitKat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnKitKat_actionPerformed(e);
			}
		});
		btnKitKat.setBounds(296, 75, 89, 60);
		
		pnlCandy.add(btnKitKat);
		btnMikeIke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMikeIke_actionPerformed(e);
			}
		});
		btnMikeIke.setBounds(296, 136, 89, 60);
		
		pnlCandy.add(btnMikeIke);
		btnGoober.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoober_actionPerformed(e);
			}
		});
		btnGoober.setBounds(296, 197, 89, 60);
		
		pnlCandy.add(btnGoober);
		btnRaisinets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRaisinets_actionPerformed(e);
			}
		});
		btnRaisinets.setBounds(296, 260, 89, 60);
		
		pnlCandy.add(btnRaisinets);
		btnSnoCaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSnoCaps_actionPerformed(e);
			}
		});
		btnSnoCaps.setBounds(296, 323, 89, 60);
		
		pnlCandy.add(btnSnoCaps);
		btnJujyFruits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnJujyFruits_actionPerformed(e);
			}
		});
		btnJujyFruits.setBounds(296, 386, 89, 60);
		
		pnlCandy.add(btnJujyFruits);
		btnTwizzlers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTwizzlers_actionPerformed(e);
			}
		});
		btnTwizzlers.setBounds(296, 449, 89, 60);
		
		pnlCandy.add(btnTwizzlers);
		btnSourPatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSourPatch_actionPerformed(e);
			}
		});
		btnSourPatch.setBounds(296, 512, 89, 60);
		
		pnlCandy.add(btnSourPatch);
		btnPegReesesPieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegReesesPieces_actionPerformed(e);
			}
		});
		btnPegReesesPieces.setBounds(391, 75, 89, 60);
		
		pnlCandy.add(btnPegReesesPieces);
		btnPegSourSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegSourSkittles_actionPerformed(e);
			}
		});
		btnPegSourSkittles.setBounds(391, 136, 89, 60);
		
		pnlCandy.add(btnPegSourSkittles);
		btnPegSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegSkittles_actionPerformed(e);
			}
		});
		btnPegSkittles.setBounds(391, 197, 89, 60);
		
		pnlCandy.add(btnPegSkittles);
		btnReesesCups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReesesCups_actionPerformed(e);
			}
		});
		btnReesesCups.setBounds(391, 260, 89, 60);
		
		pnlCandy.add(btnReesesCups);
		btnCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCheese_actionPerformed(e);
			}
		});
		btnCheese.setBounds(391, 323, 89, 60);
		
		pnlCandy.add(btnCheese);
		btnHotDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHotDog_actionPerformed(e);
			}
		});
		btnHotDog.setBounds(391, 449, 89, 60);
		
		pnlCandy.add(btnHotDog);
	}
	
	public void orderManager(String concItem) {
		orderStack.push(concItem);
		refreshOrder();     
	}         
	
	public void refreshOrder() {
	    uniqueItems.clear();     
		pnlOrder.removeAll();
		pnlPrice.removeAll();
		 String prevItem = "";
		 double totalPrice = 0;
		 double stateTax = 0;
		 
		    //Arrays.sort(orderStack.toArray());

		    for(String item:orderStack){
		     if(!uniqueItems.contains(item))   
		    	if(! prevItem.equals(item)){
		            mainCount = 0;
		            countArray(orderStack.toArray(), 0, item);
		            prevItem = item;
		           //Adds the item to the array to keep track of unique items to prevent repeating 
		            uniqueItems.add(item);
		        }
		    }
		    //Adds up the total price of the items
		    for(int i = 0; i < pnlPrice.getComponentCount(); i++) {
		    	JLabel label = (JLabel)pnlPrice.getComponent(i);
		    	double price = Double.parseDouble(label.getText());
		    	totalPrice = totalPrice + price;
		    }
		    stateTax = totalPrice * 0.08125;
		    
		    pnlOrder.add(new JLabel("State Tax"));
		    pnlOrder.validate();
	        pnlOrder.repaint();
	        pnlPrice.add(new JLabel(String.format("%.2f", stateTax)));
		    subtotal = totalPrice + stateTax;
		   
		    lblSubtotalOutput.setText(String.format("%.2f", subtotal));
		    
		//Disable and enable the tender buttons as necessary    
		    if(subtotal>5) {
		    	btn5Dollars.setEnabled(false);
		    }else {btn5Dollars.setEnabled(true);}
		    
		    if(subtotal>10) {
		    	btn10Dollars.setEnabled(false);
		    }else {btn10Dollars.setEnabled(true);}
		    
		    if(subtotal>20) {
		    	btn20Dollars.setEnabled(false);
		    }else {btn20Dollars.setEnabled(true);}
		    
		    if(subtotal>50) {
		    	btn50Dollars.setEnabled(false);
		    }else {btn50Dollars.setEnabled(true);}
		}

		private void countArray(Object[] objects, int currentPos, String item) {
		    if(currentPos == objects.length){
		        pnlOrder.add(new JLabel(mainCount + " " +  item));
		        pnlOrder.validate();
		        pnlOrder.repaint();
		        getPrice(item, mainCount);
		        return;
		    }
		    else{
		        if(objects[currentPos].toString().equals(item)){
		            mainCount += 1;
		        }
		        countArray(objects, currentPos+1, item);
		    }
	}
	
	
	
	protected void do_pnlOrder_mouseClicked(MouseEvent arg0) {
		//Clicking the order panel removes the last item added to the order
		if(!orderStack.isEmpty()) {
			orderStack.pop();
			refreshOrder();
		}else {
			//If the order is already empty, the order and price panels are cleared
			pnlOrder.removeAll();
			pnlOrder.revalidate();
		    pnlOrder.repaint();
		    pnlPrice.removeAll();
		    pnlPrice.revalidate();
		    pnlPrice.repaint();
		    pnlOrder.setBackground(new Color(255, 255, 224));
		    pnlPrice.setBackground(new Color(255, 255, 224));
		    lblTenderOut.setText("0.00");
		    lblChangeOut.setText("0.00");
		    lblSubtotalOutput.setText("0.00");
		}
		
	}
	
	
	private void getPrice(String item, int quantity) {
		ResultSet rs = null;
		Statement stmt = null;
		double price = 0;
		
		try
		{
			//establish the connection
			Connection conn = DriverManager.getConnection("jdbc:sqlite:F:/RooseveltPOS/roosevelt.db");
			
			//create the statement
			stmt = conn.createStatement();
			String query = "select * from inventory where itemName = " +"'" + item + "'";
			//System.out.println(query);

			//execute the statement
			rs = stmt.executeQuery(query);
			
			while (rs.next()){
				 price = rs.getDouble("itemPrice");
				//System.out.println(price);
			}
						
		//close connection
			rs.close();
			conn.close();
		
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} 
		
		double total = quantity * price;
		pnlPrice.add(new JLabel(Double.toString(total)));
        pnlPrice.validate();
        pnlPrice.repaint();
		
	}
	
	//When a tender button is pressed, the amount tendered and the change due are displayed in their respective fields
	protected void do_btn5Dollars_actionPerformed(ActionEvent arg0) {
		lblTenderOut.setText("5.00");
		lblChangeOut.setText(String.format("%.2f", (5 - subtotal)));
		endTransaction();
	}
	
	protected void do_btn10Dollars_actionPerformed(ActionEvent arg0) {
		lblTenderOut.setText("10.00");
		lblChangeOut.setText(String.format("%.2f", (10 - subtotal)));
		endTransaction();
	}
	
	protected void do_btn20Dollars_actionPerformed(ActionEvent arg0) {
		lblTenderOut.setText("20.00");
		lblChangeOut.setText(String.format("%.2f", (20 - subtotal)));
		endTransaction();
	}
	
	protected void do_btn50Dollars_actionPerformed(ActionEvent arg0) {
		lblTenderOut.setText("50.00");
		lblChangeOut.setText(String.format("%.2f", (50 - subtotal)));
		endTransaction();
	}
	
	protected void do_btnExactChange_actionPerformed(ActionEvent e) {
		lblTenderOut.setText(String.format("%.2f", (subtotal)));
		lblChangeOut.setText("0.00");
		endTransaction();
	}
	
	protected void do_btnStartTender_actionPerformed(ActionEvent e) {
		if(!tenderWindowActive) {
			TenderFrame tenderFrame = new TenderFrame();
			tenderFrame.setVisible(true);
			activeFrame = tenderFrame;
			btnStartTender.setText("Tender Done");
			tenderWindowActive = true;
		}else{
		
			btnStartTender.setText("Start Tender");
			activeFrame.dispose();
			tenderWindowActive = false;
		}
		
	}
	
	
	//Once the customer has paid, the contents of the order are added to an array, the order panel is cleared, 
	//and the order stack is emptied
	public void endTransaction() {
		dailyTotalSold.addAll(orderStack);
		System.out.println(Arrays.toString(dailyTotalSold.toArray()));
		orderStack.clear();
		pnlOrder.setBackground(new Color(255, 255, 0));
		pnlPrice.setBackground(new Color(255, 255, 0));
	}
	
	
	//When an item button is pressed, the corresponding parameter is sent to the order manager
	protected void do_btnSmPop_actionPerformed(ActionEvent arg0) {
		orderManager("Sm Popcorn");
	}
	protected void do_btn3Musk_actionPerformed(ActionEvent arg0) {
		orderManager("3Musketeers");		
	}
	protected void do_btnSqwigglies_actionPerformed(ActionEvent arg0) {
		orderManager("Sqwigglies");
	}
	protected void do_btnBunchaCrunch_actionPerformed(ActionEvent arg0) {
		orderManager("Buncha Crunch");
	}
	protected void do_btnSlushy_actionPerformed(ActionEvent arg0) {
		orderManager("Slushy");
	}
	protected void do_btnBulkCandy_actionPerformed(ActionEvent arg0) {
		orderManager("Bulk Candy");
	}
	protected void do_btnLgPop_actionPerformed(ActionEvent arg0) {
		orderManager("Lg Popcorn");
	}
	protected void do_btnMedPop_actionPerformed(ActionEvent arg0) {
		orderManager("Med Popcorn");
	}
	protected void do_btnSmDrink_actionPerformed(ActionEvent arg0) {
		orderManager("Sm Drink");
	}
	protected void do_btnMedDrink_actionPerformed(ActionEvent arg0) {
		orderManager("Med Drink");
	}
	protected void do_btnLgDrink_actionPerformed(ActionEvent arg0) {
		orderManager("Lg Drink");
	}
	protected void do_btnNeccos_actionPerformed(ActionEvent arg0) {
		orderManager("Neccos");
	}
	protected void do_btnReesesPieces_actionPerformed(ActionEvent arg0) {
		orderManager("Reeses Pieces");
	}
	protected void do_btnSkittles_actionPerformed(ActionEvent arg0) {
		orderManager("Skittles");
	}
	protected void do_btnSnickers_actionPerformed(ActionEvent arg0) {
		orderManager("Snickers");
	}
	protected void do_btnStarburstOrg_actionPerformed(ActionEvent arg0) {
		orderManager("Starburst Org");
	}
	protected void do_btnStarburstTrop_actionPerformed(ActionEvent arg0) {
		orderManager("Starburst Trop");
	}
	protected void do_btnSpree_actionPerformed(ActionEvent arg0) {
		orderManager("Spree");
	}
	protected void do_btnTwix_actionPerformed(ActionEvent arg0) {
		orderManager("Twix");
	}
	protected void do_btnGummiBears_actionPerformed(ActionEvent arg0) {
		orderManager("Gummi Bears");
	}
	protected void do_btnJrMints_actionPerformed(ActionEvent e) {
		orderManager("Jr Mints");
	}
	protected void do_btnMmPlain_actionPerformed(ActionEvent e) {
		orderManager("MM Plain");
	}
	protected void do_btnMmPeanut_actionPerformed(ActionEvent e) {
		orderManager("MM Peanut");
	}
	protected void do_btnMilkDuds_actionPerformed(ActionEvent e) {
		orderManager("Milk Duds");
	}
	protected void do_btnPeanutChew_actionPerformed(ActionEvent e) {
		orderManager("Peanut Chews");
	}
	protected void do_btnCookieDoughBites_actionPerformed(ActionEvent e) {
		orderManager("Cookie Dough Bites");
	}
	protected void do_btnButterfingerBites_actionPerformed(ActionEvent e) {
		orderManager("Butterfinger Bites");
	}
	protected void do_btnKitKat_actionPerformed(ActionEvent e) {
		orderManager("Kit Kat");
	}
	protected void do_btnMikeIke_actionPerformed(ActionEvent e) {
		orderManager("Mike Ike");
	}
	protected void do_btnGoober_actionPerformed(ActionEvent e) {
		orderManager("Goobers");
	}
	protected void do_btnRaisinets_actionPerformed(ActionEvent e) {
		orderManager("Raisinets");
	}
	protected void do_btnSnoCaps_actionPerformed(ActionEvent e) {
		orderManager("Sno Caps");
	}
	protected void do_btnJujyFruits_actionPerformed(ActionEvent e) {
		orderManager("Jujy Fruits");
	}
	protected void do_btnTwizzlers_actionPerformed(ActionEvent e) {
		orderManager("Twizzlers");
	}
	protected void do_btnSourPatch_actionPerformed(ActionEvent e) {
		orderManager("Sour Patch");
	}
	protected void do_btnPegReesesPieces_actionPerformed(ActionEvent e) {
		orderManager("Peg Reeses Pieces");
	}
	protected void do_btnPegSourSkittles_actionPerformed(ActionEvent e) {
		orderManager("Peg Sour Skittles");
	}
	protected void do_btnPegSkittles_actionPerformed(ActionEvent e) {
		orderManager("Peg Skittles");
	}
	protected void do_btnReesesCups_actionPerformed(ActionEvent e) {
		orderManager("Reeses Cups");
	}
	protected void do_btnCheese_actionPerformed(ActionEvent e) {
		orderManager("Cheese");
	}
	protected void do_btnHotDog_actionPerformed(ActionEvent e) {
		orderManager("Hot Dog");
	}
	
	
	
	
	
	
}
