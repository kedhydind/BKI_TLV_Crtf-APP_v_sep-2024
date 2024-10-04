package com.bki.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.bki.tlv.ipop.CustomerDtails;
import com.bki.tlv.ipop.TlvCrtIPOP;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import com.bki.tlv.cyv.elpt.CyVertElptIPOP;
/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/

public class AppMain implements ActionListener {
	
	//private static final Logger log= LogManager.getLogger(AppMain.class);

	private JFrame frame;
	private JPanel p1_1;
	private JTextField custName;
	private JTextField custMobNo;
	private JTextField cusrEmailId;
	private JTextField textField; //  tank Dia
	private JTextField tankHeigt;
	private JTextField dishHt;
	JTextArea custAddress;
	// --- cust and tank dtls fields
	String custNm = null;
	String custAdd =null;
	String mobileNo= null;
	String emailId = null;
	String tankDia = null;
	String tankHeightStr = null;
	String dishHeight = null;
	String typeOftank = null;
	private JTextField tankLocation;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
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
	public AppMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BKI Tank Volume certificate App");
		
		p1_1=new JPanel();  
		JPanel p2=new JPanel();  
	    JPanel p3=new JPanel();
		
		JTabbedPane tbPane = new JTabbedPane();
		tbPane.setBounds(105, 105, 750, 550);
		tbPane.add("main",p1_1);  
		tbPane.add("CyVerDish",p2);
		//p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		p2.setLayout(null);
		// Title label :---
		JLabel lblHeadingLabel = new JLabel("Cylindrical - Vertical - Dish End");
		lblHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblHeadingLabel.setSize(422, 30);
		lblHeadingLabel.setLocation(200, 25);
		p2.add(lblHeadingLabel);

		///----------------------
		
		
		
		// form Start 
		JLabel lblNewLabel = new JLabel("Customer Name* :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setSize(140, 20);
		lblNewLabel.setLocation(100, 114);
		p2.add(lblNewLabel);
		
		custName = new JTextField();
		custName.setFont(new Font("Arial", Font.PLAIN, 15));
		custName.setSize(230, 20);
		custName.setLocation(322, 114);
		p2.add(custName);
		//-----------------name end
		
		JLabel lbCustAdd = new JLabel("Customer Address* :");
		lbCustAdd.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustAdd.setSize(165, 20);
		lbCustAdd.setLocation(100, 149);
		p2.add(lbCustAdd);
		
		
		custAddress = new JTextArea();
		custAddress.setFont(new Font("Arial", Font.PLAIN, 15));
		custAddress.setSize(250, 100);
		custAddress.setLocation(322, 148);
		custAddress.setLineWrap(true);
		p2.add(custAddress);
		
		//-----------------address end

		
		JLabel lbCustMob = new JLabel("Mobile Number* :");
		lbCustMob.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustMob.setSize(134, 20);
		lbCustMob.setLocation(100, 270);
		p2.add(lbCustMob);
		
		custMobNo = new JTextField();
		custMobNo.setFont(new Font("Arial", Font.PLAIN, 15));
		custMobNo.setSize(230, 20);
		custMobNo.setLocation(322, 270);
		p2.add(custMobNo);
		
		//-----------------mobile end
		
		JLabel lbEmailId = new JLabel("Customer EmailId");
		p2.add(lbEmailId);
		
		cusrEmailId = new JTextField();
		p2.add(cusrEmailId);
		cusrEmailId.setColumns(10);
		
		JLabel lbTankDtls = new JLabel("Tank Details");
		lbTankDtls.setFont(new Font("Arial", Font.BOLD, 17));
		lbTankDtls.setBounds(101, 306, 126, 20);
		p2.add(lbTankDtls);
		
		JLabel lbTankDai = new JLabel("Tank Diameter* :");
		lbTankDai.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankDai.setBounds(101, 409, 126, 20);
		p2.add(lbTankDai);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(322, 409, 230, 20);
		p2.add(textField);
		
		JLabel lblCustDtls = new JLabel("Customer Details");
		lblCustDtls.setFont(new Font("Arial", Font.BOLD, 17));
		lblCustDtls.setBounds(100, 80, 140, 20);
		p2.add(lblCustDtls);
		
		JLabel lbTankHeight = new JLabel("Tank Height* :");
		lbTankHeight.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankHeight.setBounds(100, 446, 126, 20);
		p2.add(lbTankHeight);
		
		tankHeigt = new JTextField();
		tankHeigt.setFont(new Font("Arial", Font.PLAIN, 15));
		tankHeigt.setBounds(321, 446, 230, 20);
		p2.add(tankHeigt);
		
		JLabel lbDishHei = new JLabel("Dish Height* :");
		lbDishHei.setFont(new Font("Arial", Font.PLAIN, 15));
		lbDishHei.setBounds(100, 476, 126, 20);
		p2.add(lbDishHei);
		
		dishHt = new JTextField();
		dishHt.setFont(new Font("Arial", Font.PLAIN, 15));
		dishHt.setBounds(321, 476, 230, 20);
		p2.add(dishHt);
		
		JButton btnGC = new JButton("Gen Cert");
		btnGC.setFont(new Font("Arial", Font.BOLD, 12));
		btnGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ----------certificate creation--------------------
				//log.debug("gen cert clicked");
				System.out.println("gen cert clicked");
				processCertGen(p2);

						
			}
		});
		btnGC.setBounds(100, 528, 97, 21);
		p2.add(btnGC);
		
		JButton btnGS = new JButton("Gen Scale");
		btnGS.setFont(new Font("Arial", Font.BOLD, 12));
		btnGS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ----------scale creation--------------------
				
			}
		});
		btnGS.setBounds(275, 528, 97, 21);
		p2.add(btnGS);
		///---------------------------------------------------p2 end-----------
		tbPane.add("CyVerFlat",p3);
		//Add more here 
		frame.getContentPane().add(tbPane);
		frame.setVisible(true); 
		
		setMainTab_p1(p1_1, p2, p3);
		
		JLabel lblTankLocation = new JLabel("Tank Location* :");
		lblTankLocation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankLocation.setBounds(100, 336, 134, 20);
		p2.add(lblTankLocation);
		
		tankLocation = new JTextField();
		tankLocation.setFont(new Font("Arial", Font.PLAIN, 15));
		tankLocation.setBounds(322, 337, 230, 20);
		p2.add(tankLocation);
		
		JLabel lblTankId = new JLabel("Tank Id* :");
		lblTankId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankId.setBounds(100, 372, 134, 20);
		p2.add(lblTankId);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(322, 373, 230, 20);
		p2.add(textField_1);
		
	}
	
	
	
	public void setMainTab_p1(JPanel p1, JPanel p2, JPanel p3) {
		   
		ButtonGroup bg=new ButtonGroup();
		 JRadioButton rbCyVerDe_1 = new JRadioButton("Cylendrical-Verical-dishend");
		 rbCyVerDe_1.setBounds(130, 98, 200, 21);
		 rbCyVerDe_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		typeOftank= "CYVERDE";
		 		System.out.println("cylindrical vertical tank with dish end selected:"+ typeOftank);
		 		//p2.show();
		 		p2.setVisible(true);
		 		p2.repaint();
		 		//p1_1.setVisible(false);
		 	}
		 });
		 p1_1.setLayout(null);
		 rbCyVerDe_1.setSelected(true);
		 bg.add(rbCyVerDe_1);
		 p1_1.add(rbCyVerDe_1);
		
		 JLabel lblTankSelectionSection = new JLabel("Tank selection section");
		 lblTankSelectionSection.setBounds(120, 67, 180, 31);
		 lblTankSelectionSection.setFont(new Font("Arial", Font.BOLD, 15));
		 lblTankSelectionSection.setBorder(BorderFactory.createEmptyBorder(5, 5, 8, 8));
		 p1.add(lblTankSelectionSection);
		 p1.setVisible(true);
			JRadioButton rbCyVerFe = new JRadioButton("Cylendrical-Verical-Flatend");
			rbCyVerFe.setBounds(130, 123, 200, 21);
			 bg.add(rbCyVerFe);
			p1_1.add(rbCyVerFe);
			
			

	}
	

	public JPanel getP1() {
		return p1_1;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	
	public void processCertGen(JPanel p2) {
		TlvCrtIPOP iopo = new TlvCrtIPOP(); 
		CustomerDtails custDtl = new CustomerDtails();
		com.bki.tlv.cyv.elpt.CyVertElptIPOP  elptIpop = new com.bki.tlv.cyv.elpt.CyVertElptIPOP();
		iopo.setCustDtls(custDtl);
		iopo.setElpt(elptIpop);
		//String custNm = null;
		//String custAdd  = null;
		 //Component[] components = p2.getComponents();
//		 for(Component com : components) {
			// if(com instanceof JTextField && "custName".equalsIgnoreCase().getName())
			 
		 //}
		
		//----- Cust details----
		 custNm = custName.getText();
		 custDtl.setCustomerName(custNm);
		 custAdd  = custAddress.getText();
		 custDtl.setCustAdd(custAdd);
		 mobileNo = custMobNo.getText();
		 custDtl.setMobile(custAdd);
		 emailId = cusrEmailId.getText();
		 custDtl.setEmailId(emailId);
		 ////--------------------
		 
		////---Tank Details------
		// 
		 //----tankLocation = 
		 
		 
		 // Tank Dia
		 tankDia = textField.getText();
		 double tank_Dia = Double.parseDouble(tankDia);
		 elptIpop.setD(tank_Dia);
		 // Tank Height
		 tankHeightStr = tankHeigt.getText();
		 double tank_Height = Double.parseDouble(tankHeightStr);
		 elptIpop.setH(tank_Height);
		 dishHeight = dishHt.getText();
		 double dish_Height = Double.parseDouble(dishHeight);
		 elptIpop.setA(dish_Height);
		 
		 
		 System.out.println("custNm:"+custNm+",custAdd:"+custAdd+",mobileNo:"+mobileNo);
		 System.out.println("tankDia:"+tankDia+",tankHeigt:"+tankHeightStr+",dishHeight:"+dishHeight);
		 
		 com.bki.tlv.cyv.elpt.CyVertElptTLVCert cert = new com.bki.tlv.cyv.elpt.CyVertElptTLVCert();
		 double capacity = cert.measureCapacity(elptIpop);
		 iopo.setCapacity(capacity);
		 System.out.println("capacity:"+capacity);
		 
		 LinkedHashMap<Integer,String> VolData  = cert.genVolData(elptIpop);
		 iopo.setVolData(VolData);
		 System.out.println("VolData:"+VolData);
		 
		 
		 
		 
		 
		
	}
	
	public String makeHtmltbl(TlvCrtIPOP iopo) {
		String filePath = null;
		
		
		
		return filePath;
	}
}
//PDF generation
//https://templated.io/blog/how-to-convert-html-to-pdf-using-apache-pdfbox/ 

//https://www.ulfdittmer.com/view?PdfboxTable  ---------------------
//#######################################
//https://github.com/eduardohl/Paginated-PDFBox-Table-Sample/blob/master/src/pdftablesample/PDFTableGenerator.java