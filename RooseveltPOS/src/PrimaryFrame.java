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
import javax.swing.JOptionPane;

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
import java.awt.CardLayout;
import javax.swing.UIManager;

public class PrimaryFrame extends JFrame {

	private JPanel contentPane;
	
	private List<String> uniqueItems = new ArrayList<>();
	private Stack<String> orderStack = new Stack<>();
	private List<String> dailyTotalSold = new ArrayList<>();
	
	double subtotal = 0;
	boolean tenderWindowActive = false;
	TenderFrame activeFrame;
	double customTender = 0;
	boolean isTaxExempt = false;
	
	private final JButton btnSmPop = new JButton("Sm Popcorn");
	private final JButton btn3Musk = new JButton("3 Musketeers");
	private final JButton btnSqwigglies = new JButton("Sqwigglies");
	private final JButton btnBunchaCrunch = new JButton("Buncha Crunch");
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
	private final JButton btnPegReesesPieces = new JButton("Peg Reeses Pieces");
	private final JButton btnPegSourSkittles = new JButton("Peg Sour Skittles");
	private final JButton btnPegSkittles = new JButton("Peg Skittles");
	private final JButton btnReesesCups = new JButton("Reeses Cups");
	private final JButton btnCheese = new JButton("Cheese");
	private final JButton btnHotDog = new JButton("Hot Dog");
	private final JPanel pnlDeck = new JPanel();
	private final JPanel pnlDrinks = new JPanel();
	private final JButton btnNextPage = new JButton("Next Page");
	
	final static String candyPanel = "Panel containing candy and popcorn";
	final static String drinkPanel = "Panel containing bottled drinks";
	private final JButton btnPrevPage = new JButton("Prev Page");
	private final JButton btnSmCoffee = new JButton("Sm Coffee");
	private final JButton btnLgCoffee = new JButton("Lg Coffee");
	private final JButton btnWater = new JButton("Water");
	private final JButton btnPretzel = new JButton("Pretzel");
	private final JButton btnNachos = new JButton("Nachos");
	private final JButton btnIceCream = new JButton("Ice Cream");
	private final JButton btnIceCreamBar = new JButton("Ice Cream Bar");
	private final JButton btnAppleJuice = new JButton("Apple Juice");
	private final JButton btnLemonade = new JButton("Lemonade");
	private final JButton btnCherryCoke = new JButton("Cherry Coke");
	private final JButton btnMelloYello = new JButton("Mello Yello");
	private final JButton btnDietDrPepper = new JButton("Diet Dr Pepper");
	private final JButton btnMtBlast = new JButton("Mt Blast");
	private final JButton btnFruitPunch = new JButton("Fruit Punch");
	private final JButton btnVanCoke = new JButton("Van Coke");
	private final JButton btnFuze = new JButton("Fuze");
	private final JButton btnCokeZero = new JButton("Coke Zero");
	private final JButton btnEssential = new JButton("Essential");
	private final JButton btnSqueezed = new JButton("Squeezed");
	private final JButton btnFocus = new JButton("Focus");
	private final JButton btnXxx = new JButton("XXX");
	private final JButton btnRevive = new JButton("Revive");
	private final JButton btnBuckets = new JButton("Buckets");
	private final JLabel label_1 = new JLabel("");
	private final JLabel label_2 = new JLabel("");
	private final JLabel label_3 = new JLabel("");
	private final JLabel label_4 = new JLabel("");
	private final JLabel label_5 = new JLabel("");
	private final JButton btnTaxExempt = new JButton("Tax Exempt");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		pnlOrder.setToolTipText("Click to remove the last item that was added.");
		pnlOrder.setBackground(new Color(255, 255, 224));
		pnlOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_pnlOrder_mouseClicked(arg0);
			}
		});
		pnlOrder.setBorder(null);
		pnlOrder.setBounds(585, 1, 171, 321);
		
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
		btnVoidOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnVoidOne_actionPerformed(arg0);
			}
		});
		btnVoidOne.setEnabled(false);
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
		lblSubtotal.setBounds(690, 500, 56, 14);
		
		contentPane.add(lblSubtotal);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(744, 498, 56, 59);
		
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(lblSubtotalOutput);
		lblSubtotalOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubtotalOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalOutput.setBackground(SystemColor.menu);
		lblTenderOut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTenderOut.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panel_1.add(lblTenderOut);
		lblChangeOut.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panel_1.add(lblChangeOut);
		lblTender.setBounds(690, 520, 56, 14);
		
		contentPane.add(lblTender);
		lblChange.setBounds(690, 538, 56, 14);
		
		contentPane.add(lblChange);
		btnMenu.setEnabled(false);
		btnMenu.setBounds(585, 498, 95, 59);
		
		contentPane.add(btnMenu);
		pnlPrice.setBackground(new Color(255, 255, 224));
		pnlPrice.setBounds(756, 1, 44, 321);
		
		contentPane.add(pnlPrice);
		pnlPrice.setLayout(new BoxLayout(pnlPrice, BoxLayout.Y_AXIS));
		pnlDeck.setBounds(0, 0, 575, 578);
		
		contentPane.add(pnlDeck);
		pnlDeck.setLayout(new CardLayout(0, 0));
		pnlDeck.add(candyPanel, pnlCandy);
		pnlCandy.setLayout(new GridLayout(0, 6, 0, 0));
		btn3Musk.setMargin(new Insets(2, 8, 2, 8));
		btn3Musk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btn3Musk_actionPerformed(arg0);
			}
		});
		
		btnSmPop.setMargin(new Insets(0, 0, 0, 0));
		//order(10);
		
		btnSmPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSmPop_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSmPop);
		
		pnlCandy.add(btn3Musk);
		btnSqwigglies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSqwigglies_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSqwigglies);
		btnBunchaCrunch.setMargin(new Insets(2, 7, 2, 7));
		btnBunchaCrunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBunchaCrunch_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnBunchaCrunch);
		btnSlushy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSlushy_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSlushy);
		btnBulkCandy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBulkCandy_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnBulkCandy);
		btnMedPop.setMargin(new Insets(4, 9, 0, 9));
		btnMedPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMedPop_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnMedPop);
		btnNeccos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNeccos_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnNeccos);
		btnGummiBears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGummiBears_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnGummiBears);
		btnKitKat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnKitKat_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnKitKat);
		btnPegReesesPieces.setMargin(new Insets(2, 5, 2, 5));
		btnPegReesesPieces.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPegReesesPieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegReesesPieces_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnPegReesesPieces);
		btnSmCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSmCoffee_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSmCoffee);
		btnLgPop.setMargin(new Insets(2, 10, 2, 10));
		btnLgPop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLgPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLgPop_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnLgPop);
		btnReesesPieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnReesesPieces_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnReesesPieces);
		btnJrMints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnJrMints_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnJrMints);
		btnMikeIke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMikeIke_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnMikeIke);
		btnPegSourSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegSourSkittles_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnPegSourSkittles);
		btnLgCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLgCoffee_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnLgCoffee);
		btnSmDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSmDrink_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSmDrink);
		btnSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSkittles_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSkittles);
		btnMmPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMmPlain_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnMmPlain);
		btnGoober.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGoober.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoober_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnGoober);
		btnPegSkittles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPegSkittles_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnPegSkittles);
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnWater_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnWater);
		btnMedDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMedDrink_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnMedDrink);
		btnSnickers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSnickers_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSnickers);
		btnMmPeanut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMmPeanut_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnMmPeanut);
		btnRaisinets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRaisinets_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnRaisinets);
		btnReesesCups.setMargin(new Insets(2, 5, 2, 5));
		btnReesesCups.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReesesCups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReesesCups_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnReesesCups);
		btnPretzel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPretzel_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnPretzel);
		btnLgDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLgDrink_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnLgDrink);
		btnStarburstOrg.setMargin(new Insets(2, 5, 2, 5));
		btnStarburstOrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStarburstOrg_actionPerformed(arg0);
			}
		});
		btnStarburstOrg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		pnlCandy.add(btnStarburstOrg);
		btnMilkDuds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMilkDuds_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnMilkDuds);
		btnSnoCaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSnoCaps_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnSnoCaps);
		btnCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCheese_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnCheese);
		btnNachos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNachos_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnNachos);
		
		pnlCandy.add(label_1);
		btnStarburstTrop.setMargin(new Insets(2, 5, 2, 5));
		btnStarburstTrop.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnStarburstTrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStarburstTrop_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnStarburstTrop);
		btnPeanutChew.setMargin(new Insets(2, 4, 2, 4));
		btnPeanutChew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPeanutChew_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnPeanutChew);
		btnJujyFruits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnJujyFruits_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnJujyFruits);
		
		pnlCandy.add(label_2);
		btnIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnIceCream_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnIceCream);
		
		pnlCandy.add(label_3);
		btnSpree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSpree_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnSpree);
		btnCookieDoughBites.setMargin(new Insets(2, 4, 2, 4));
		btnCookieDoughBites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCookieDoughBites_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnCookieDoughBites);
		btnTwizzlers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTwizzlers_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnTwizzlers);
		btnHotDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHotDog_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnHotDog);
		btnIceCreamBar.setMargin(new Insets(2, 5, 2, 5));
		btnIceCreamBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnIceCreamBar_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnIceCreamBar);
		
		pnlCandy.add(label_4);
		btnTwix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnTwix_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnTwix);
		btnButterfingerBites.setMargin(new Insets(2, 2, 2, 2));
		btnButterfingerBites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnButterfingerBites_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnButterfingerBites);
		btnSourPatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSourPatch_actionPerformed(e);
			}
		});
		
		pnlCandy.add(btnSourPatch);
		
		pnlCandy.add(label_5);
		btnNextPage.setBackground(new Color(255, 0, 0));
		btnNextPage.setForeground(Color.BLACK);
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNextPage_actionPerformed(arg0);
			}
		});
		
		pnlCandy.add(btnNextPage);
		
		pnlDeck.add(drinkPanel, pnlDrinks);
		pnlDrinks.setLayout(null);
		btnPrevPage.setMargin(new Insets(2, 5, 2, 5));
		btnPrevPage.setBackground(Color.RED);
		btnPrevPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPrevPage_actionPerformed(arg0);
			}
		});
		btnPrevPage.setBounds(486, 512, 89, 60);
		
		pnlDrinks.add(btnPrevPage);
		btnAppleJuice.setMargin(new Insets(2, 5, 2, 5));
		btnAppleJuice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAppleJuice_actionPerformed(arg0);
			}
		});
		btnAppleJuice.setBounds(201, 11, 89, 60);
		
		pnlDrinks.add(btnAppleJuice);
		btnLemonade.setMargin(new Insets(2, 5, 2, 5));
		btnLemonade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnLemonade_actionPerformed(arg0);
			}
		});
		btnLemonade.setBounds(296, 11, 89, 60);
		
		pnlDrinks.add(btnLemonade);
		btnCherryCoke.setMargin(new Insets(2, 5, 2, 5));
		btnCherryCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCherryCoke_actionPerformed(arg0);
			}
		});
		btnCherryCoke.setBounds(201, 75, 89, 60);
		
		pnlDrinks.add(btnCherryCoke);
		btnMelloYello.setMargin(new Insets(2, 5, 2, 5));
		btnMelloYello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMelloYello_actionPerformed(arg0);
			}
		});
		btnMelloYello.setBounds(296, 75, 89, 60);
		
		pnlDrinks.add(btnMelloYello);
		btnDietDrPepper.setMargin(new Insets(2, 5, 2, 5));
		btnDietDrPepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnDietDrPepper_actionPerformed(arg0);
			}
		});
		btnDietDrPepper.setBounds(201, 136, 89, 60);
		
		pnlDrinks.add(btnDietDrPepper);
		btnMtBlast.setMargin(new Insets(2, 5, 2, 5));
		btnMtBlast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMtBlast_actionPerformed(arg0);
			}
		});
		btnMtBlast.setBounds(296, 136, 89, 60);
		
		pnlDrinks.add(btnMtBlast);
		btnFruitPunch.setMargin(new Insets(2, 5, 2, 5));
		btnFruitPunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFruitPunch_actionPerformed(arg0);
			}
		});
		btnFruitPunch.setBounds(201, 198, 89, 60);
		
		pnlDrinks.add(btnFruitPunch);
		btnVanCoke.setMargin(new Insets(2, 5, 2, 5));
		btnVanCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnVanCoke_actionPerformed(arg0);
			}
		});
		btnVanCoke.setBounds(296, 198, 89, 60);
		
		pnlDrinks.add(btnVanCoke);
		btnFuze.setMargin(new Insets(2, 5, 2, 5));
		btnFuze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFuze_actionPerformed(arg0);
			}
		});
		btnFuze.setBounds(201, 262, 89, 60);
		
		pnlDrinks.add(btnFuze);
		btnCokeZero.setMargin(new Insets(2, 5, 2, 5));
		btnCokeZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCokeZero_actionPerformed(arg0);
			}
		});
		btnCokeZero.setBounds(296, 262, 89, 60);
		
		pnlDrinks.add(btnCokeZero);
		btnEssential.setMargin(new Insets(2, 5, 2, 5));
		btnEssential.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnEssential_actionPerformed(arg0);
			}
		});
		btnEssential.setBounds(296, 388, 89, 60);
		
		pnlDrinks.add(btnEssential);
		btnSqueezed.setMargin(new Insets(2, 5, 2, 5));
		btnSqueezed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnSqueezed_actionPerformed(arg0);
			}
		});
		btnSqueezed.setBounds(201, 388, 89, 60);
		
		pnlDrinks.add(btnSqueezed);
		btnFocus.setMargin(new Insets(2, 5, 2, 5));
		btnFocus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFocus_actionPerformed(arg0);
			}
		});
		btnFocus.setBounds(201, 449, 89, 60);
		
		pnlDrinks.add(btnFocus);
		btnXxx.setMargin(new Insets(2, 5, 2, 5));
		btnXxx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnXxx_actionPerformed(arg0);
			}
		});
		btnXxx.setBounds(296, 449, 89, 60);
		
		pnlDrinks.add(btnXxx);
		btnRevive.setMargin(new Insets(2, 5, 2, 5));
		btnRevive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnRevive_actionPerformed(arg0);
			}
		});
		btnRevive.setBounds(201, 508, 89, 60);
		
		pnlDrinks.add(btnRevive);
		btnBuckets.setMargin(new Insets(2, 5, 2, 5));
		btnBuckets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBuckets_actionPerformed(arg0);
			}
		});
		btnBuckets.setBounds(10, 202, 89, 60);
		
		pnlDrinks.add(btnBuckets);
		
		//The Print Daily Total button displays all the items sold during that session and their amounts
		JButton btnPrintTotal = new JButton("Print Daily Total");
		btnPrintTotal.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPrintTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(Arrays.toString(dailyTotalSold.toArray()));
				JOptionPane.showMessageDialog(null, (Arrays.toString(dailyTotalSold.toArray())) );
			}
		});
		btnPrintTotal.setBounds(10, 551, 89, 16);
		pnlDrinks.add(btnPrintTotal);
		btnTaxExempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnTaxExempt_actionPerformed(arg0);
			}
		});
		btnTaxExempt.setMargin(new Insets(2, 4, 2, 4));
		btnTaxExempt.setBounds(727, 322, 73, 59);
		
		contentPane.add(btnTaxExempt);
	}
	
	public void orderManager(String concItem) {
		orderStack.push(concItem);
		refreshOrder();     
	}         
	
	//Updates the order panel to reflect the addition or removal of items to an order
	public void refreshOrder() {
	    uniqueItems.clear();     
		pnlOrder.removeAll();
		pnlPrice.removeAll();
		 String prevItem = "";
		 double totalPrice = 0;
		 double stateTax = 0;
		 

		    for(String item:orderStack){
		     if(!uniqueItems.contains(item))   
		    	if(! prevItem.equals(item)){
		            mainCount = 0;
		            countArray(orderStack.toArray(), 0, item);
		            prevItem = item;
		           //Adds the item to the array to keep track of unique items and prevent repeating 
		            uniqueItems.add(item);
		        }
		    }
		    //Adds up the total price of the items
		    for(int i = 0; i < pnlPrice.getComponentCount(); i++) {
		    	JLabel label = (JLabel)pnlPrice.getComponent(i);
		    	double price = Double.parseDouble(label.getText());
		    	totalPrice += price;
		    }
		    
		    if(!isTaxExempt) {
		    	stateTax = totalPrice * 0.08125;
		    }else {
		    	stateTax = 0;
		    }
		    
		    
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
	
	//Accesses the item database to retrieve prices
	private void getPrice(String item, int quantity) {
		ResultSet rs = null;
		Statement stmt = null;
		double price = 0;
		
		try
		{
			//establish the connection
			Connection conn = DriverManager.getConnection("jdbc:sqlite::resource:roosevelt.db");
			
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
	
	//The Start Tender button allows values that are not covered by the tender buttons to be entered
	protected void do_btnStartTender_actionPerformed(ActionEvent e) {
		if(!tenderWindowActive) {
			TenderFrame tenderFrame = new TenderFrame();
			tenderFrame.setVisible(true);
			activeFrame = tenderFrame;
			btnStartTender.setText("Tender Done");
			tenderWindowActive = true;
			
		}else{
			customTender = Double.parseDouble(activeFrame.getTender());
			if(customTender < subtotal) {
				JOptionPane.showMessageDialog(null, "Error: Tender must be greater than subtotal.", "Error",
                        JOptionPane.ERROR_MESSAGE);
				activeFrame.setAlwaysOnTop(true);
				activeFrame.jtf.setText("");
				activeFrame.numberString = "";
			}else {
			lblTenderOut.setText(String.format("%.2f", (customTender)));
			lblChangeOut.setText(String.format("%.2f", (customTender - subtotal)));
			endTransaction();
			btnStartTender.setText("Start Tender");
			activeFrame.dispose();
			tenderWindowActive = false;
			}
		}
		
	}
	
	
	//Once the customer has paid, the contents of the order are added to an array, the order panel is cleared, 
	//and the order stack is emptied
	public void endTransaction() {
		dailyTotalSold.addAll(orderStack);
		//System.out.println(Arrays.toString(dailyTotalSold.toArray()));
		orderStack.clear();
		pnlOrder.setBackground(new Color(255, 255, 0));
		pnlPrice.setBackground(new Color(255, 255, 0));
		btn50Dollars.setEnabled(true);
		btn5Dollars.setEnabled(true);
		btn10Dollars.setEnabled(true);
		btn20Dollars.setEnabled(true);
		isTaxExempt = false;
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
	protected void do_btnNextPage_actionPerformed(ActionEvent arg0) {
		CardLayout cardLayout = (CardLayout) pnlDeck.getLayout();
		cardLayout.next(pnlDeck);
	}
	protected void do_btnPrevPage_actionPerformed(ActionEvent arg0) {
		CardLayout cardLayout = (CardLayout) pnlDeck.getLayout();
		cardLayout.next(pnlDeck);
	}
	protected void do_btnSmCoffee_actionPerformed(ActionEvent arg0) {
		orderManager("Sm Coffee");
	}
	protected void do_btnLgCoffee_actionPerformed(ActionEvent arg0) {
		orderManager("Lg Coffee");
	}
	protected void do_btnWater_actionPerformed(ActionEvent arg0) {
		orderManager("Water");
	}
	protected void do_btnPretzel_actionPerformed(ActionEvent arg0) {
		orderManager("Pretzel");
	}
	protected void do_btnNachos_actionPerformed(ActionEvent arg0) {
		orderManager("Nachos");
	}
	protected void do_btnIceCream_actionPerformed(ActionEvent arg0) {
		orderManager("Ice Cream");
	}
	protected void do_btnIceCreamBar_actionPerformed(ActionEvent arg0) {
		orderManager("Ice Cream Bar");
	}
	protected void do_btnAppleJuice_actionPerformed(ActionEvent arg0) {
		orderManager("Apple Juice");
	}
	protected void do_btnLemonade_actionPerformed(ActionEvent arg0) {
		orderManager("Lemonade");
	}
	protected void do_btnCherryCoke_actionPerformed(ActionEvent arg0) {
		orderManager("Cherry Coke");
	}
	protected void do_btnMelloYello_actionPerformed(ActionEvent arg0) {
		orderManager("Mello Yello");
	}
	protected void do_btnDietDrPepper_actionPerformed(ActionEvent arg0) {
		orderManager("Diet Dr Pepper");
	}
	protected void do_btnMtBlast_actionPerformed(ActionEvent arg0) {
		orderManager("Mt Blast");
	}
	protected void do_btnFruitPunch_actionPerformed(ActionEvent arg0) {
		orderManager("Fruit Punch");
	}
	protected void do_btnVanCoke_actionPerformed(ActionEvent arg0) {
		orderManager("Vanilla Coke");
	}
	protected void do_btnFuze_actionPerformed(ActionEvent arg0) {
		orderManager("Fuze");
	}
	protected void do_btnCokeZero_actionPerformed(ActionEvent arg0) {
		orderManager("Coke Zero");
	}
	protected void do_btnEssential_actionPerformed(ActionEvent arg0) {
		orderManager("Essential");
	}
	protected void do_btnSqueezed_actionPerformed(ActionEvent arg0) {
		orderManager("Squeezed");
	}
	protected void do_btnFocus_actionPerformed(ActionEvent arg0) {
		orderManager("Focus");
	}
	protected void do_btnXxx_actionPerformed(ActionEvent arg0) {
		orderManager("XXX");
	}
	protected void do_btnRevive_actionPerformed(ActionEvent arg0) {
		orderManager("Revive");
	}
	protected void do_btnBuckets_actionPerformed(ActionEvent arg0) {
		orderManager("Buckets");
	}
	protected void do_btnVoidOne_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnTaxExempt_actionPerformed(ActionEvent arg0) {
		if(!isTaxExempt) {
			pnlOrder.setBackground(new Color(134, 195, 236));
		    pnlPrice.setBackground(new Color(134, 195, 236));
		    
		    isTaxExempt = true;	
		    refreshOrder();
		}else {
			pnlOrder.setBackground(new Color(255, 255, 224));
		    pnlPrice.setBackground(new Color(255, 255, 224));
		    
		    isTaxExempt = false;
		    refreshOrder();
		}
	}
}
