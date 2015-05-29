/**
 * @file ExtraOptionsFrame.java
 * @author Liam McNabb
 * @date 18th March 2013
 * 
 * @brief Frame to allow user to add optional data to their chart.
 *
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ExtraOptionsFrame {
	

	
	
	/**
	* Constructor that sets the host GUI
	* @param host - Object of the GUI
	*/
	public ExtraOptionsFrame(GUI host){
		this.SetHost(host);
	}

	/**
	* A method use for testing all Set methods within the class
	* @param title - Custom Title
	* @param legend - Colour Legend
	* @param time Time and Date
	* @param author - Custom Author
	* @param description Custom Description
	*/
	public ExtraOptionsFrame(String title, Boolean legend, Boolean time,
			String author, String description){
		SetTitle(title);
		SetColourLegend(legend);
		SetTimeDate(time);
		SetAuthor(author);
		SetDescriptiveCaption(description);
	}
	/**
	* Constructor for ExtraOptionsFrame
	*/
	public ExtraOptionsFrame(){
		
		try{
			BufferedImage myPicture = ImageIO.read(new File("Bar.png"));
			picLabel1 = new JLabel(new ImageIcon( myPicture ));
			picLabel2 = new JLabel(new ImageIcon( myPicture ));
			picLabel3 = new JLabel(new ImageIcon( myPicture ));
			picLabel4 = new JLabel(new ImageIcon( myPicture ));
			picLabel5 = new JLabel(new ImageIcon( myPicture ));
			}catch(IOException e){}
		
		header();
		colourLegend();
		timeDate();
		customTitle();
		author();
		descriptiveCaption();	
		
		pnl_ok.add(btn_ok);	
		
		//Setting up the frame
		frame.setSize(FRAMESIZEX, FRAMESIZEY);
		frame.setTitle(WINDOWTITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		frame.add(pnl_PleaseDecide, BorderLayout.NORTH);
		frame.add(pnl_main, BorderLayout.CENTER);
		frame.add(pnl_ok, BorderLayout.SOUTH);
		frame.setResizable(false);
		
		//adding action listeners
		btn_ok.addActionListener(handler);
		chk_DescriptiveCaption.addActionListener(handler);
		chk_Author.addActionListener(handler);
		chk_CustomTitle.addActionListener(handler);
		frame.setPreferredSize(new Dimension(FRAMESIZEX, FRAMESIZEY));
	
	}

	/**
	* Used to get the String of the first chosen header
	* from the first ComboBox. 
	* \return Returns first chosen header.
	*/
	public static String GetAuthor(){
		return m_Author;
	}
	/**
	 * Used to get the Colour Legend Boolean
	 * \return Returns the Boolean saved to m_ColourLegend "
	 */	
	public static Boolean GetColourLegend(){
		return m_ColourLegend;
	}
	/**
	* Used to get the String of the chosen chart title
	* from the "chart title" TextField. 
	* \return Returns Chart Title.
	*/    
	public static String GetDescriptiveCaption(){
		return m_DescriptiveCaption;
	}
	
	/**
	* A method used to get the host instance of the class GUI
	* \return the chosen file name
	*/
	public GUI GetHost() {
		return m_Host;
	}
	
	/**
	 * Used to get the Time and Date Now
	 * \return Returns the Time and Date in format "
	 */
	public static Boolean GetTimeDate(){
		return m_TimeDate;
	}
	
	/**
	 * Used to get the Value of the Title
	 * \return Returns the Boolean saved to m_Title "
	 */	
	public static String GetTitle(){
		return m_Title;
	}
	
	/**
	* Used to set the String of the first chosen header
	* from the first ComboBox. 
	* \param  choice Chosen title from JComboBox
	* \return Does not return anything.
	*/
	public void SetAuthor(String choice){
		boolean test = true;
		
		if((choice.isEmpty()) && (test)) {
			System.err.println("*** Warning ExtraOptionsFrame::" +
			"SetAuthor():: Author is set to empty string.");
		}else{
		  	System.out.println("ExtraOptionsFrame:: " +
		   	"SetAuthor():: Author is set to: " + choice);
		}
		
		m_Author = choice;
	}
	
	/**
	* Used to set the String of the first chosen header
	* from the first ComboBox. 
	* \param  choice Chosen title from JComboBox
	* \return Does not return anything.
	*/
	public void SetColourLegend(Boolean choice){
		if (choice) {
			System.out.println("ExtraOptionsFrame::" +
					"SetColourLegend():: ColourLegend is turned on (TRUE).");
		} else  {
			System.out.println("ExtraOptionsFrame::" +
					"SetColourLegend():: ColourLegend is turned off (FALSE).");
		}
		m_ColourLegend = choice;
	}	
	
	/**
	* Used to set the String of the chosen chart title
	* from the "chart title" TextField. 
	* \param choice Chosen Chart Title from TextField.
	* \return Does not return anything.
	*/
	public void SetDescriptiveCaption(String choice){ 
		if((choice.isEmpty())) {
			System.err.println("*** Warning ExtraOptionsFrame::" +
			"SetDescriptiveCaption():: Description is set to empty string.");
		}else{
		  	System.out.println("ExtraOptionsFrame:: " +
		   	"SetDescriptiveCaption():: Description is set to: " + choice);
		}
		m_DescriptiveCaption = choice;
	}

	/**
	* A method used to set the host instance of the class GUI
	* @param host - Object of GUI running
	*/
	private void SetHost(GUI host) {
		m_Host = host;
	}
	/**
	* Used to set the String of the first chosen header
	* from the first ComboBox. 
	* \param  choice Chosen title from JComboBox
	* \return Does not return anything.
	*/
	public void SetTimeDate(boolean b){
		if (b) {
			System.out.println("ExtraOptionsFrame::" +
					"SetTimeDate():: TimeDate is turned on (TRUE).");
		} else  {
			System.out.println("ExtraOptionsFrame::" +
					"SetTimeDate():: TimeDate is turned off (FALSE).");
		}
		m_TimeDate = b;
	}	
	
	/**
	* Used to set the String of the first chosen header
	* from the first ComboBox. 
	* \param  choice Chosen title from JComboBox
	* \return Does not return anything.
	*/
	public void SetTitle(String choice){
		if((choice.isEmpty())) {
			System.err.println("*** Warning ExtraOptionsFrame::" +
			"SetTitle():: Title is set to empty string.");
		}else{
		  	System.out.println("ExtraOptionsFrame:: " +
		   	"SetTitle():: Title is set to: " + choice);
		}
		m_Title = choice;
	}
	
	/**
	* Used to set the Author in the frame. 
	* \return Does not return anything.
	*/
	private void author(){
		pnl_SetAuthor.setLayout(new BorderLayout());
		pnl_SetAuthor.add(lbl_SetAuthor, BorderLayout.WEST);
		pnl_SetAuthor.add(fld_Author,BorderLayout.EAST);
		pnl_Author.setLayout(new BorderLayout());
		pnl_chkAuthor.setLayout(new BorderLayout());
		pnl_chkAuthor.add(chk_Author, BorderLayout.CENTER);
		pnl_chkAuthor.add(lbl_chkAuthor, BorderLayout.WEST);
		pnl_Author.add(pnl_chkAuthor, BorderLayout.NORTH);
		pnl_Author.add(pnl_SetAuthor, BorderLayout.SOUTH);
		pnl_main.add(pnl_Author);
		pnl_main.add(picLabel4);
	}
	/**
	* Used to set the Colour Legend in the frame. 
	* \return Does not return anything.
	*/
	private void colourLegend(){
		pnl_ColourLegend.setLayout(new BorderLayout());
		pnl_ColourLegend.add(chk_ColourLegend, BorderLayout.CENTER);
		pnl_ColourLegend.add(lbl_chkColourLegend, BorderLayout.WEST);
		pnl_main.add(pnl_ColourLegend);
		pnl_main.add(blank1);
	}
	/**
	* Used to set the Custom Title in the frame. 
	* \return Does not return anything.
	*/
	private void customTitle(){
		fld_CustomTitle.disable();
		fld_CustomTitle.setBackground(new Color(201,201,201));
		pnl_SetCustomTitle.setLayout(new BorderLayout());
		pnl_SetCustomTitle.add(lbl_SetCustomTitle, BorderLayout.WEST);
		pnl_SetCustomTitle.add(fld_CustomTitle, BorderLayout.EAST);
		pnl_CustomTitle.setLayout(new BorderLayout());
		pnl_chkCustomTitle.setLayout(new BorderLayout()); 
		pnl_chkCustomTitle.add(chk_CustomTitle, BorderLayout.CENTER);
		pnl_chkCustomTitle.add(lbl_CustomTitle, BorderLayout.WEST);
		pnl_CustomTitle.add(pnl_chkCustomTitle, BorderLayout.NORTH);
		pnl_CustomTitle.add(pnl_SetCustomTitle, BorderLayout.SOUTH);
		pnl_main.add(pnl_CustomTitle);
		pnl_main.add(picLabel3);
	}
	
	/**
	* Used to set the Descriptive Caption in the frame. 
	* \return Does not return anything.
	*/
	private void descriptiveCaption(){
		pnl_SetDescriptiveCaption.setLayout(new BorderLayout());
		pnl_SetDescriptiveCaption.add(lbl_SetDescriptiveCaption,
		BorderLayout.WEST);
		fld_DescriptiveCaption.setLineWrap(true);
		fld_DescriptiveCaption.setBackground(new Color(201,201,201));
		fld_DescriptiveCaption.disable();
		scrl_pane = new JScrollPane(fld_DescriptiveCaption);
		scrl_pane.setVerticalScrollBarPolicy(
										JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrl_pane.setPreferredSize(new Dimension(
		TEXTAREAWIDTH,DESCRIPTIONHEIGHT));
		pnl_SetDescriptiveCaption.add(scrl_pane, BorderLayout.EAST);
		pnl_DescriptiveCaption.setLayout(new BorderLayout());
		pnl_chkDescription.setLayout(new BorderLayout());
		pnl_chkDescription.add(chk_DescriptiveCaption,BorderLayout.CENTER);
		pnl_chkDescription.add(lbl_chkDescription,BorderLayout.WEST);
		fld_Author.setBackground(new Color(201,201,201));
		fld_Author.disable();
		pnl_DescriptiveCaption.add(pnl_chkDescription, BorderLayout.NORTH);
		pnl_DescriptiveCaption.add(pnl_SetDescriptiveCaption, 
		BorderLayout.SOUTH);
		pnl_main.add(pnl_DescriptiveCaption);
		pnl_main.add(picLabel5);
	}

	/**
	* Class used to give instruction to buttons when used
	* In this class, Ok button is implemented.
	* \return Does not return anything.
	*/ 
	private class guiEventHandler implements ActionListener{
	    public void actionPerformed(ActionEvent event) {
	        if (event.getSource()==chk_DescriptiveCaption){
	        	if (chk_DescriptiveCaption.isSelected() == true) {
	        		fld_DescriptiveCaption.enable();
	        		fld_DescriptiveCaption.setBackground(
	        				new Color(255,255,255));
	        	}else if (chk_DescriptiveCaption.isSelected() == false){
	        		fld_DescriptiveCaption.disable();
	        		fld_DescriptiveCaption.setBackground(
	        				new Color(201,201,201));
	        	}
	        }
	        if(event.getSource()==chk_CustomTitle){
	        	if (chk_CustomTitle.isSelected() == true) {
	        		fld_CustomTitle.enable();
	        		fld_CustomTitle.setBackground(new Color(255,255,255));
	        	}else if (chk_CustomTitle.isSelected() == false){
	        		fld_CustomTitle.disable();
	        		fld_CustomTitle.setBackground(new Color(201,201,201));
	        	}
	        }
	        if (event.getSource()==chk_Author){
	        	if (chk_Author.isSelected() == true) {
	        		fld_Author.enable();
	        		fld_Author.setBackground(new Color(255,255,255));
	        	}else if (chk_Author.isSelected() == false){
	        		fld_Author.disable();
	        		fld_Author.setBackground(new Color(201,201,201));
	        	}
	        }
	    	if (event.getSource()== btn_ok) {
	    			SetColourLegend(chk_ColourLegend.isSelected());
	    			SetTimeDate(chk_TimeDate.isSelected());
	    			if (chk_CustomTitle.isSelected()){
	    				SetTitle(fld_CustomTitle.getText());
	    			} else {
	    				SetTitle("Unset");
	    			}
	    			if (chk_Author.isSelected()){
	    				SetAuthor(fld_Author.getText());
	    			} else {
	    				SetAuthor("Unset");
	    			}
	    			if (chk_DescriptiveCaption.isSelected()){
	    				SetDescriptiveCaption(
	    				fld_DescriptiveCaption.getText());
	    			} else {
	    				SetDescriptiveCaption("Unset");
	    			}
	    			try{
	    			System.out.println(GetColourLegend());
	    			System.out.println(GetTimeDate());
	    			System.out.println(GetTitle());
	    			System.out.println(GetAuthor());
	    			System.out.println(GetDescriptiveCaption());
	       	    	Invisible();
	    			}catch (Exception e){};
	    			
	    			GUI.Extras();
	        }
	    }
	}
	
	/**
	* Used to set the Header in the frame. 
	* \return Does not return anything.
	*/
	private void header(){
		pnl_PleaseDecide.add(lbl_PleaseDecide);
		pnl_main.add(picLabel1);		
	}

	/**
	* Used to set the frame to invisible. 
	* \return Does not return anything.
	*/	
	public void Invisible(){
		frame.setVisible(false);
	}
	/**
	* Used to launch the GUI design from an object. 
	* Pack and Sets Default Close Operation before launching
	*
	* \return Does not Return anything.
	*/
	public void launchFrame(){
	    // Display Frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack(); //Adjusts panel to components for display
	}

	/**
	* Main method, sets up frame
	* \param args An array of arguements 
	* \return Does not return anything.
	*/
	public static void main(String[] args){
		ExtraOptionsFrame Test1 = new ExtraOptionsFrame( "title", true, false,
				"Author", "Description");
		ExtraOptionsFrame Test2 = new ExtraOptionsFrame( "", true, false,
				"", "");
		
	}
	/**
	* Used to set the Time and Date in the frame. 
	* \return Does not return anything.
	*/	
	private void timeDate(){
		pnl_TimeDate.setLayout(new BorderLayout());
		pnl_TimeDate.add(chk_TimeDate, BorderLayout.CENTER);
		pnl_TimeDate.add(lbl_TimeDate, BorderLayout.WEST);
		pnl_main.add(pnl_TimeDate);
		pnl_main.add(blank2);
		pnl_main.add(picLabel2);
	}
	
	/**
	* Used to set the frame to visible. 
	* \return Does not return anything.
	*/	
	public void Visible(){
		frame.setVisible(true);
	}

	
	private static final long serialVersionUID = 1L;
	//member variables
	
	
	private static String m_DescriptiveCaption;
	private static String m_Author;
	private static Boolean m_TimeDate;
	private static Boolean m_ColourLegend;
	private static String m_Title;
	
	
	//Constants
	/** Constant: Preferred Frame Size of X component */
	final static int FRAMESIZEX = 500;	
	/** Constant: Preferred Frame Size of Y component */
	final static int FRAMESIZEY = 350;
	/** Constant: Preferred Upper Limit of Strings (Only Warning given) */
	final static int UPPERLIMIT = 50;
	/** Constant: Preferred Height for Description Text Field */
	final static int DESCRIPTIONHEIGHT = 50;
	/** Constant: Preferred Total Height for Text Field including scroll */
	final static int SCROLLHEIGHT = 150;
	/** Constant: Preferred Height for Text Area */
	final static int TEXTAREAWIDTH = 300;
	/** Constant: Preferred Width for Text Field */
	final static int TEXTFIELDWIDTH = 25;
	/** Constant: Title given to frame */
	final static String WINDOWTITLE = "Extra Chart Options";
	//JFrame parts
	private JFrame frame = new JFrame(WINDOWTITLE);							
	//JPanel
	private JPanel pnl_SetDescriptiveCaption = new JPanel();	
	private JPanel pnl_DescriptiveCaption = new JPanel();										
	private JPanel pnl_SetAuthor = new JPanel();
	private JPanel pnl_Author = new JPanel();
	private JPanel pnl_PleaseDecide = new JPanel();
	private JPanel pnl_ok = new JPanel(); 
	private JPanel pnl_main = new JPanel();
	private JPanel pnl_buttons = new JPanel();
	private JPanel pnl_chkDescription = new JPanel();
	private JPanel pnl_chkAuthor = new JPanel();
	private JPanel pnl_TimeDate = new JPanel();
	private JPanel pnl_ColourLegend = new JPanel();
	private JPanel pnl_SetCustomTitle = new JPanel();
	private JPanel pnl_CustomTitle = new JPanel();
	private JPanel pnl_chkCustomTitle = new JPanel();

	//JTextField
	private JTextArea fld_DescriptiveCaption = new JTextArea();		
	private JTextField fld_Author = new JTextField(TEXTFIELDWIDTH);
	private JTextField fld_CustomTitle = new JTextField(TEXTFIELDWIDTH);
	//JLabel
	private JLabel lbl_PleaseDecide = new JLabel("What extra functions would" +
										" you like to add to your Charts?");
	private JLabel lbl_SetDescriptiveCaption = new JLabel("Enter Brief Descri"+
															"ption Heres: ");
	private JLabel lbl_SetAuthor = new JLabel("Enter Author Here:            "+
												"     ");
	private JLabel lbl_chkDescription = new JLabel("A Description of the Char"+
													"t:     ");
	private JLabel lbl_chkAuthor = new JLabel("The Author of the Chart:      "+
											  "  ");
	private JLabel lbl_TimeDate = new JLabel("Time and Date of Creation:     ")
	;
	private JLabel lbl_chkColourLegend = new JLabel("Colour Legend of the Cha"+
													"rt:    ");
	private JLabel lbl_SetCustomTitle = new JLabel("Enter Title Here:       " +
													"             "+
													"  ");
	private JLabel lbl_CustomTitle = new JLabel("The Title of the Chart:    " +
												"          ");
	private JLabel picLabel1 = new JLabel();	
	private JLabel picLabel2 = new JLabel();	
	private JLabel picLabel3 = new JLabel();	
	private JLabel picLabel4 = new JLabel();	
	private JLabel picLabel5 = new JLabel();	
	private JLabel blank1 = new JLabel("                                 " +
									   "                                  "+
									   "                          ");
	private JLabel blank2 = new JLabel("                                 " +
			   "                                  "+
			   "                          ");

	
	private JCheckBox chk_TimeDate = new JCheckBox();
	private JCheckBox chk_DescriptiveCaption = new JCheckBox();
	private JCheckBox chk_Author = new JCheckBox();
	private JCheckBox chk_ColourLegend = new JCheckBox("",true);
	private JCheckBox chk_CustomTitle = new JCheckBox();
	private GUI m_Host;
	private JScrollPane scrl_pane;
											
	//JButton
	private JButton btn_ok = new JButton("OK");										
	//Event Handler
	private guiEventHandler handler = new guiEventHandler();		

	}