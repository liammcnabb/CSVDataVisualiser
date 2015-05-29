/**	
*	@file	GUI.java
*	@author	Ashley Burgess, Liam McNabb
*	@date	20 March 2013
*	@see	Visualisation, CSVImport, DisplayColourStyleChooser
*	
*	@brief	GUI class creates the GUI.
*	
*	GUI creates a JFrame, adds the components and runs the program,
*	by the main method. 	
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.JFreeChart;

/**	
*	GUI class, creates the GUI making a JFrame visible and adding
*	the different components to the frame.
*/
public class GUI extends JFrame{
	
	/**
	* Constructs a GUI using InitComponents method
	*/	
	public GUI(){
		InitComponents();
		Current = this;
	}
	
	/**
	* Constructs a GUI using InitComponents method.
	* Is used for the good and bad testing of this class.
	* 
	* @param author
	* @param timeAndDate
	* @param description
	* @param chosenFile
	* @param colourLegend
	* @param colourScheme
	* @param filePath
	* @param header
	* @param height
	* @param returnValue
	* @param title
	*/	
	public GUI(String author, boolean timeAndDate, String description, 
	String chosenFile, boolean colourLegend, String colourScheme,
	String filePath, String header, int height, int returnValue,
	String title, int[] m_Columns) {
	InitComponents();
	Current = this;

	SetAuthor(author);
	SetTimeDate(timeAndDate);
	SetDescriptiveCaption(description);
	SetChosenFile(chosenFile);
	SetColourLegend(colourLegend);
	SetColourScheme(colourScheme);
	SetFilePath(filePath);
	SetHeaders(header);
	SetHeight(height);
	SetReturnValue(returnValue);
	SetTitle(title);
	SetColumns(m_Columns);
	}
	
	/**
	* Used to get the Author of the class.
	*  
	* @return m_Author
	*/
	public static String GetAuthor(){
		return "Author: " + m_Author;
	}
	
	/**
	* A method used to get the file name that is chosen
	* 
	* @return m_ChosenFile
	*/
	public String GetChosenFile(){ return m_ChosenFile; }
	
	/**
	 * Used to get the Colour Legend value (TRUE or FALSE).
	 * 
	 * @return m_ColourLegend
	 */
	public static Boolean GetColourLegend(){
		return m_ColourLegend;
	}
	
	/**
	* The user selected colour scheme to be used
	*
	* @return m_colourSchemeSelected to be used by Visualisation
	*/	
	public String GetColourScheme(){
		return m_ColourSchemeSelected;
	}
	
	/**
	 * A method which returns an array of m_Columns selected
	 * 
	 * @return m_Columns
	 */
	public static int[] GetColumns() {
		return m_Columns;
	}
	
	/**
	 * A method which returns the compared data
	 * 
	 * @return m_Compared
	 */
	public ArrayList<String> GetCompared() {
		return m_Compared;
	}
	
	/**
	 * Get the original data taken from the CSV
	 * 
	 * @return m_Data
	 */
	public ArrayList<String> GetData() {
		return m_Data;
	}
	
	/**
	* Used to get the description given to a chart
	*  
	* @return m_DescriptiveCaption
	*/    
	public static String GetDescriptiveCaption(){
		return "Description: " + m_DescriptiveCaption;
	}
	
   /**
	* A method that gets the complete file path, to be used by
	* the InputData class to find the location of the file
	* 
	* @return m_FilePath
	*/
	public String GetFilePath(){ return m_FilePath; }
	
	/**
	* Returns the data set to be used by Visualisation
	*
	* @return GraphData the data set
	*/	
	public GraphData GetGraphData() {
		return GraphData;
	}
	
	/**
	 * Returns a list of the headers from the imported CSV file
	 * 
	 * @return m_Headers
	 */
	public ArrayList GetHeaders() {
		return m_Headers;
	}
	
	/**
	 * Returns the height of the table selected when grouped
	 * 
	 * @return m_Height
	 */
	public int GetHeight() {
		return m_Height;
	}
	
	/**
	* Returns the left panel with the added components
	*
	* @return LeftPanel left panel with components
	*/	
	public Component[] GetLeftPanelContent(){
		return LeftPanel.getComponents();
	}
	
	/** 
	* Used to test an 'if' statement for the file Chooser 
	* 
	* @return m_ReturnValue 
	*/
	public double GetReturnValue(){ return m_ReturnValue; }
	
	/**
	 * Gets the rows read from the CSV
	 * 
	 * @return m_Rows
	 */
	public int[] GetRows() {
		return m_Rows;
	}
	
	
	/**
	 * Used to get the Time and Date Now
	 * 
	 * @return m_TimeDate
	 */
	public static Boolean GetTimeDate(){
		return m_TimeDate;
	}
		
	/**
	* Used to get the title for the chart
	* 
	* @return m_Title
	*/
	public static String GetTitle(){
		return m_Title;
	}
	
	/**
	* Used to set the Author of the class
	*  
	* @param author The name of the person who made the chart
	*/
	public static void SetAuthor(String author){
		boolean test = true;
		
		if((author.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetAuthor():: Author is set to empty string.");
		}
		else if ((author.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetAutor():: Author name is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetAuthor():: Author is set to: " + author);
		}
		
		m_Author = author;
	}

	/**
	* A method that sets the file name
	* 
	* @param chosenFile
	*/
	public void SetChosenFile(String chosenFile) {
		boolean test = true;
		
		if((chosenFile.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetChosenFile():: chosen file is set to empty string.");
		}
		else if ((chosenFile.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetChosenFile():: chosen file is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetChosenFile():: chosen file is set to: " + chosenFile);
		}
		
		this.m_ChosenFile = chosenFile;
	}
	
	/**
	* Used to turn the Colour Legend's for the charts on or off
	* 
	* @param  on A boolean used for true or false on the Colour Legend
	*/
	public static void SetColourLegend(boolean on){
		if (on) {
			System.out.println("GUI::" +
					"SetColourLegend():: ColourLegend is turned on (TRUE).");
		} else  {
			System.err.println("*** Warning GUI::" +
					"SetColourLegend():: ColourLegend is turned off (FALSE).");
		}
		
		m_ColourLegend = on;
	}
	
	/**
	* Sets the variable for Visualisation to use,
	* from DisplayColourStyleChooser, so which colour scheme to use
	*
	* @param schemeChosen user selected colour scheme
	*/	
	public void SetColourScheme(String schemeChosen){
		boolean test = true;
		
		if((schemeChosen.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetColourScheme():: colour scheme is set to empty string.");
		}
		else if ((schemeChosen.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetColourScheme():: colour scheme name is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetColourScheme():: colour scheme is set to: " + schemeChosen);
		}
		
		m_ColourSchemeSelected = schemeChosen;	
	}
	
	/**
	 * Sets the number of m_Columns selected
	 * 
	 * @param m_Columns
	 */
	public static void SetColumns(int[] columns) {
		boolean test = true;

	    if (test == true  && columns.length > 0) {
	    	System.out.println("GUI::SetColumns():: Columns selected: " 
	    	+ columns.length);
	    }
	    else if (columns.length == 0) {
	    	System.err.println("*** Warning GUI:: SetColumns():: Columns " +
	    	"selected is set to: " + columns.length);
	    }
	    
		m_Columns = columns; 
	}
	
	/**
	 * A method which sets the compared data
	 * 
	 * @param compared
	 */
	public void SetCompared(ArrayList<String> compared) {
		m_Compared = compared;
	}
	
	/**
	 *  Sets the original data read from the CSV
	 * 
	 * @param data
	 */
	public void SetData(ArrayList<String> data) {
		m_Data = data;
	}
	
	/**
	* Used to set the String for the description given for a chart
	*  
	* @param description
	*/
	public static void SetDescriptiveCaption(String description){ 
		boolean test = true;
		
		if((description.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetDescriptiveCaption():: description is set to empty string.");
		}
		else if ((description.length() > BIG_MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetDescriptiveCaption():: description is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetDescriptiveCaption():: description is set to: " + description);
		}

		m_DescriptiveCaption = description;
	}
	
	/**
	* A method that sets the file path for the chosen file
	* 
	* @param filePath
	*/
	public void SetFilePath(String filePath) {
		boolean test = true;
		
		if((filePath.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetFilePath():: file path is set to empty string.");
		}
		else if ((filePath.length() > MAX_SIZE_FILE_PATH) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetFilePath():: file path is very long.");
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetFilePath():: file path is set to: " + filePath);
		}
				
		this.m_FilePath = filePath;
	}
	
	/**
	 * Sets a header from the imported CSV file
	 * 
	 * @param header
	 */
	public void SetHeaders(String header){
		boolean test = true;
		
		if((header.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetHeaders():: a header is set to empty string.");
		}
		else if ((header.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetHeaders():: a header name is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetHeaders():: a header is set to: " + header);
		}
		
		m_Headers.add(header);
	}
	
	/**
	 * Sets the height of the rows selected when grouped
	 * 
	 * @param height
	 */
	public void SetHeight(int height) {
		boolean test = true;

	    if (test == true  && height > 0) {
	    	System.out.println("GUI::SetHeight():: height: " 
	    	+ height);
	    }
	    else if (height < 0) {
	    	System.err.println("*** Warning GUI:: SetHeight():: height" +
	    	" is set to: " + height);
	    }
		
		m_Height = height;
	}
	
	/**
	* A method that sets the return value used to compare file format
	* 
	* @param returnValue
	*/
	public void SetReturnValue(double returnValue) {
		boolean test = true;
		
	    if ((returnValue < 0) && (test)) {
	    	System.err.println("*** Warning GUI::" +
	    	"SetReturnValue() return value is less than zero: " + returnValue);
	    }
	    else if (test) {
	    	System.out.println("GUI:: SetReturnValue() " +
	    	"return value: " + returnValue);
	    }
	    
	    this.m_ReturnValue = returnValue;	    
	}
	
	/**
	 * A method that sets the rows to be read
	 * 
	 * @param rows
	 */
	public void SetRows(int[] rows) {
		m_Rows = rows;
	}
	
	/**
	* Used to set the time and date to be shown or not.
	*  
	* @param on
	*/
	public static void SetTimeDate(boolean on){
		if (on) {
			 System.out.println("GUI:: SetTimeDate():: time and date is set " +
			 "to on (TRUE).");
		} else  {
			System.err.println("*** Warning GUI:: SetTimeDate():: " +
			"time and date is set " +
			"to off (FALSE).");
		}
		
		m_TimeDate = on;
	}	
	
	/**
	* Used to set the title of the chart
	*  
	* @param title
	*/
	public static void SetTitle(String title){
		boolean test = true;
		
		if((title.isEmpty()) && (test)) {
			System.err.println("*** Warning GUI::" +
			"SetTitle():: Title is set to empty string.");
		}
		else if ((title.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning GUI::" +
		  	"SetTitle():: Title name is very long.");
	
		}
		else if (test) {
		  	System.out.println("GUI:: " +
		   	"SetTitle():: Title is set to: " + title);
		}	
		
		m_Title = title;
	}
	
	/**
	 * Used to open the GUI for selecting a chart
	 */
	public void ChartPane() {
		ChartTypeChooser typeChooser
		= new ChartTypeChooser(Current);
	
		Container chartTypeContainer
		= typeChooser.createInterface();
	
		GraphData();
		JOptionPane.showMessageDialog(null, chartTypeContainer,
		"Choose a chart", JOptionPane.PLAIN_MESSAGE);
	}
	
	/** 
	* A method that opens the file Chooser GUI so that the user can
	* select a file that they want, as opposed to having to type it in.
	* Also it creates an object of CSVImport.  
	*/
	public void ChooseFile() {
		Chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new 
		FileNameExtensionFilter(
		"JPG & GIF Images, csv, txt", "csv", "txt");
		
		Chooser.setFileFilter(filter);
		SetReturnValue(Chooser.showOpenDialog(getParent()));
		
		if(GetReturnValue() == JFileChooser.ERROR_OPTION) {
			System.out.println("You clicked off this panel");
		}
		if(GetReturnValue() == JFileChooser.CANCEL_OPTION) {
			System.out.println("You clicked off this panel");
		}
		
		/** Checks if m_returnValue equals the option chosen */
		if(GetReturnValue() == JFileChooser.APPROVE_OPTION) {
			/** A Scanner object containing the file path, compared later */
			FileName =new Scanner(
					  Chooser.getSelectedFile().getAbsolutePath());
			
			SetFilePath(Chooser.getSelectedFile().getAbsolutePath());
			SetChosenFile(Chooser.getSelectedFile().getName());
		}
		/** Uses the scanner object to check the file format */
		if(FileName.findInLine(".csv") != null){
			CSVImport passing = new CSVImport(
			Chooser.getSelectedFile().getAbsolutePath());
			/** Sets the text field to display the file path */
		} else {
			/**
			 * If a file is entered and it has the wrong 
			 * format this will show
			 */
			JOptionPane.showMessageDialog(null, 
			"Incorrect file format, choose another file", 
			"File Format", JOptionPane.ERROR_MESSAGE);
			fileInput.setText("");
			SetChosenFile("");
		} 	    						       
	}
	
	/** 
	 * Enables the ExportButton to be used
	 */
	public void ExportEnabled() {
		ExportButton.setEnabled(true);
	}
	
	/** Exports the current chart being displayed */
	public void ExportImage(){
		Object[] options = {"Ok"};
		EXPORTER.ExportImage(LeftPanel);
	}

	/**
	 * This stuff should get checked when the okay button is 
	 * clicked on the extras frame
	 */
	public static void Extras(){
		extrasPanel.removeAll();
		/** An object for the kind of layout that the container uses */
		FlowLayout layout;
		layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEADING);
		extrasPanel.setLayout(layout);
		extrasPanel.setPreferredSize(new Dimension(600,300));
		
		SetAuthor(extrasFrame.GetAuthor());
		SetDescriptiveCaption(extrasFrame.GetDescriptiveCaption());
		SetTimeDate(extrasFrame.GetTimeDate());
		SetColourLegend(extrasFrame.GetColourLegend());
		SetTitle(extrasFrame.GetTitle());
		
		author = new JPanel();
		timeDate = new JPanel();
		description = new JPanel();
		
		if(GetAuthor().equals("Author: " + UNSET)) {
		}	
		else {
			authorText = new JLabel("Author: " + 
			extrasFrame.GetAuthor() + "   ");
			authorText.setBackground(Color.WHITE);
			authorText.setFont(new Font("Verdana", Font.BOLD, 11));
			author.add(authorText);
			authorText.setVisible(true);
			extrasPanel.add(author, BorderLayout.NORTH);
		}
		
		if(GetTimeDate()) {
			date = new java.util.Date();
			timeDateText = new JLabel("Time and date: " + 
			new Timestamp(date.getTime()) + "   ");
			timeDateText.setBackground(Color.WHITE);
			timeDateText.setFont(new Font("Verdana", Font.BOLD, 11));
			timeDate.add(timeDateText);
			timeDateText.setVisible(true);
			extrasPanel.add(timeDate);
		}
		
		if(GetDescriptiveCaption().equals("Description: " + UNSET)) {
		}	
		else {
			descriptiveText = new JTextArea(GetDescriptiveCaption());
			descriptiveText.setLineWrap(true);
			descriptiveText.setPreferredSize(new Dimension(500,100));
			descriptiveText.setBackground(new Color(238,238,238));
			descriptiveText.setFont(new Font("Verdana", Font.BOLD, 11));
			description.add(descriptiveText);
			descriptiveText.setVisible(true);
			extrasPanel.add(description, BorderLayout.SOUTH);
		}
	}
	
	/**
	* Enables the extras button when a file is imported 
	*/	
	public void ExtrasButtonTrue(){
		ExtrasButton.setEnabled(true);
	}
	
	/**
	 * Displays the instructions on how to use the program
	 */
	public void ExtrasFrame() {
		instructionText = new JTextArea("This program allows you to " +
				"visualise data in many ways, to do so follow these " +
				"steps:\n\n" +
				"1.) First select a file to import. \n" + "2.) Then either " +
				"select some data from the table or choose a" +
				" Colour Scheme to use or choose Extra options to add to" +
				" your graph. \n" + "3.) You may then select Create Graph" +
				" to choose" +
				" a graph to use. \n" + "4.) Finally you can save your " +
				"chart and information!");
		instructionText.setLineWrap(true);
		instructionText.setPreferredSize(new Dimension(800,300));
		instructionText.setBackground(Color.WHITE);
		extrasPanel.add(instructionText);		
	}
	
	/** Produces a sample data to be used in testing
	 * 
	 * @return TestData
	 *  */
	public GraphData TestData(){
		GraphData TestData = new GraphData();
		String first[][] = {{"Category", "Series1", "Series2"},
							{"1", "10", "50", "10"},
							{"2", "20", "30", "20"},
							{"3", "30", "10", "40"},
							{"4", "40", "20", "30"},
							{"5", "50", "40", "50"}};
		for(int x = 0; x < first.length; x++){
			for(int y = 0; y < first[x].length; y++){
				TestData.Insert(y, x, first[x][y]);
			}
		}
		
		for(int x = 0; x < first.length; x++){
			for(int y = 0; y < first[x].length; y++){
				System.out.println(TestData.Get(y, x));
			}
		}
		return TestData;
	}
	
	/**
	* This method sets the data selected to be used in the graphs 
	*/
	public void GraphData(){
		GraphData = new GraphData();
		m_Data = new ArrayList<String>();
		m_Compared = new ArrayList<String>();
		SetData(m_Data);
		SetCompared(m_Compared);

		SetRows(TableOfData.getSelectedRows());
		SetColumns(TableOfData.getSelectedColumns());

		for (int x = 0; x < GetRows().length; x++){
			for (int y = 0; y < GetColumns().length; y++){
				GetData().add(TableOfData.getValueAt(GetRows()[x],
				GetColumns()[y]).toString());
			}
		}	

		if(GetCompared().isEmpty()){
			for(int m = 0; m < GetColumns().length; m++){
				GetCompared().add(GetData().get(m));
			}
		}

		if(GetColumns().length == 1){
			for(int m = 1; m < GetRows().length; m++){
				GetCompared().add(GetData().get(m));
			}
		} else {
			NonUnary();
		}	

		for(int i = 0; i < GetCompared().size(); i++){
			System.out.println(GetCompared().get(i));
		}

		if(GetColumns().length == 1){
			for (int x = 0; x < GetRows().length; x++){
				GraphData.Insert(x, 0, GetCompared().get(x));
			}
			for (int y = 0; y < GetRows().length; y++){
				System.out.println(" " + GraphData.Get(y, 0));
			}
		} else {
			int list = 0;
			for (int x = 0; x < (GetCompared().size() / 
				GetColumns().length); x++){
				for (int y = 0; y < GetColumns().length; y++){
					GraphData.Insert(y, x, GetCompared().get(list));
					list ++;
				}
			}
		}

		for (int z = 0; z < GetColumns().length; z++) {
			GraphData.Insert(z, 0, TableOfData.getColumnName(GetColumns()[z]));
		}

		for (int z = 0; z < GetColumns().length; z++){
			SetHeaders(TableOfData.getColumnName(GetColumns()[z]));
		}

		SetHeight(GetCompared().size()/GetColumns().length);
	}
	
	/**
	* Constructs the components to be added to the GUI,
	* sets the size of the GUI,
	* adds the components to the GUI.
	*/	
	private void InitComponents(){
		//Construct new Components.
		Toolbar = new JToolBar();
		ImportButton = new JButton(new ImageIcon(
				getClass().getResource("Import.png")));
		ExtrasButton = new JButton(new ImageIcon(
				getClass().getResource("Add.png")));
		ExtrasButton.setEnabled(false);
		ChartChooserButton = new JButton(new ImageIcon(
				getClass().getResource("select_graph.png")));
		ChartChooserButton.setEnabled(false);
		SchemeChooserButton = new JButton(new ImageIcon(
				getClass().getResource("colour_icon.jpg")));
		SchemeChooserButton.setEnabled(false);
		ExportButton = new JButton(new ImageIcon(
				getClass().getResource("export.png")));
		ExportButton.setEnabled(false);
		TableOfData = new JTable();
		SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPanel,
		TableOfData);
		LeftPanel = new JPanel();
		m_ColourSchemeSelected = null;
		//Set up JFrame to correct size and location etc.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_X,FRAME_Y);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Graphical Representer, Version 2.0");
		extrasFrame = new ExtraOptionsFrame(); 
		extrasFrame.launchFrame();
		setVisible(true);
		
		
		InitToolbar();		
		
		extrasPanel = new JPanel();
		extrasPanel.setBackground(Color.WHITE);
		
		ExtrasFrame();
		
		SplitPaneVert = new JSplitPane(JSplitPane.VERTICAL_SPLIT, LeftPanel,
				extrasPanel);
		
		//Split Pane Components
		add(SplitPane);
		SplitPaneVert.setDividerLocation(VERT_DIV_LOC);
		SplitPane.setDividerLocation(DIV_LOC);
		SplitPane.setLeftComponent(SplitPaneVert);
		SplitPane.setBackground(Color.WHITE);
		SplitPane.setRightComponent(TableOfData);		
	}	

	/**
	* Creates the tool bar which contains buttons that perform actions
	*/	
	private void InitToolbar(){
		ImportButton.setText("Import  ");
		ImportButton.setFont(TOOLBAR_FONT);
		ImportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ChooseFile();
				UpdateData();
			}
		});
		Toolbar.add(ImportButton);		
		Toolbar.addSeparator();
		
		ExportButton.setText("Export ");
		ExportButton.setFont(TOOLBAR_FONT);
		ExportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				ExportImage();
			}
		});

		Toolbar.add(ExtrasButton);	
		Toolbar.addSeparator();

		SchemeChooserButton.setText("Choose Colour Scheme...");
		SchemeChooserButton.setFont(TOOLBAR_FONT);
		SchemeChooserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				ColourStyleChooser schemeChooser 
				= new ColourStyleChooser(Current);
				
				Container colourSchemeContainer 
				= schemeChooser.createInterface();
				
				JOptionPane.showMessageDialog(null, colourSchemeContainer,
				"Choose a colour scheme", JOptionPane.PLAIN_MESSAGE);
			}
		});
		Toolbar.add(SchemeChooserButton);		
		Toolbar.addSeparator();
		
		ChartChooserButton.setText("Create Graph...");
		ChartChooserButton.setFont(TOOLBAR_FONT);
		ChartChooserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (TableOfData.getSelectedRow() >= 0){
					if (GetColourScheme() == null){
						SetColourScheme(ColourGroup.RANDOM);
						
						ChartPane();			
					} else {
						ChartPane();
					}
				} else {
					JOptionPane.showMessageDialog(null,
					"Select data to create a graph");
				}
			}
		});
		Toolbar.add(ChartChooserButton);		
		Toolbar.addSeparator();
		
		ExtrasButton.setText("Extras ");
		ExtrasButton.setFont(TOOLBAR_FONT);
		ExtrasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				extrasFrame.Visible();
			}
		});
		Toolbar.add(ExportButton);	
		Toolbar.addSeparator();
		
		add(Toolbar, BorderLayout.NORTH);
		Toolbar.setFloatable(false);
	}
	
	/**
	* Adds the chart to the left component of the split pane
	* makes the setExport button available
	* 
	* @param chart the created Visualisation to be added to left panel
	*/	
	public void LeftPanelContent(Component chart){
		if (LeftPanel.getComponents().length > 0) {
			LeftPanel.removeAll();
		}						
		
		LeftPanel.add(chart, BorderLayout.NORTH);
		LeftPanel.setBackground(Color.WHITE);
		LeftPanel.add(extrasPanel);
		LeftPanel.updateUI();
		ExtrasButtonTrue();
	}
	
	/**
	* Main method runs the program and sets the GUI true,
	* it takes in an empty list of args, and returns nothing.
	* 
	* @param args input arguments are not used 
	*/
	public static void main(String[] args){
		int good1 = 10;
		int good2 = 0;
		int bad = -5;
		int goodColumns[] = new int[3];
		int badColumns[] = new int[0];
		
		boolean test = false;

		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new GUI().setVisible(true);
		}
		});

		if(test){
			GUI goodTest = new GUI("Ashley", true, "This chart shows " +
			"correlation", "coalDisasters .csv", true, "WARM",
			"A valid set file path is set" +
			"coalDisasters .csv", "Month", good1, good2, "Pie Chart",
			goodColumns);
			GUI badTest = new GUI("Aaaaaaassssssssssssshhhhlllllee", false,
			"Dddeeeesrrippppppptiooonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",
			"ccoooaaaalllldiisssaasstteerrsssss", false, 
			"WAAaAAAAARrrrrrRRRRRRRRRRRMMMMM",
			"A bigggggggggggggg fileeeeeeeeeeeeee pathhhhhhhhhhhhhhhhhhhh" +
			"ssssssssssshhhhheeeeeeeeeeeyyyyyyyyyyyyhh",
			"Daaayyyyy Offffffff Yyyeeeaaarrrrrrrr", bad, bad, 
			"A Bid Title For This Chart Is Being Set Here, Too Big!",
			badColumns);
			GUI emptyTest = new GUI("", false, "", "", false, "", "", "", bad, 
			bad, "", badColumns);
		}
	
	}
	
	/**
	 * This method is used if the selected amount of rows from the table is
	 * more than one.
	 */
	public void NonUnary() {
		boolean count = true;
		for(int i = GetColumns().length; i < GetData().size(); i+= 
		GetColumns().length){
			String elementd = GetData().get(i);
						
			for(int l = 0; l < GetCompared().size(); l+=GetColumns().length){
				String elementc = GetCompared().get(l);
				
				if((elementc.equals(elementd))){
					
					count = false;
					int n = i + 1;
					for(int m = l + 1;  m < GetColumns().length + l; m++){
						Double oldelement = Double.parseDouble(
						GetCompared().get(m));
						Double otherelement = Double.parseDouble(
						GetData().get(n));
						Double newelement = oldelement + otherelement;	
						System.out.println(oldelement + " test1");
						System.out.println(otherelement + " test2");
						System.out.println(newelement + " test3");
						GetCompared().set(m, Double.toString(newelement) );
						n++;
					}					
				}								 
			}
			
			if(count){
				for(int m = i; m < m_Columns.length + i; m++){					
					GetCompared().add(GetData().get(m));
				}				
			}
			count = true;
		}
	}
	
	/**
	 * This method is used if the selected amount of m_Columns is only one.
	 */
	public void Unary() {
		GetCompared().add("1");
		boolean count = true;
		for(int i = GetColumns().length; i < GetData().size(); i+=
		GetColumns().length){
			String elementd = GetData().get(i);							
			for(int l = 0; l < GetCompared().size(); l+=
			GetColumns().length + 1){
				String elementc = GetCompared().get(l);					
				if((elementc.equals(elementd))){						
					count = false;
					Double oldelement = Double.parseDouble(
					GetCompared().get(l+1));
					Double otherelement = 1.0;
					Double newelement = oldelement + otherelement;	
					GetCompared().set(l+1, Double.toString(newelement));										
				}								 
			}
			if(count){
				for(int m = i; m < GetColumns().length + i; m++){					
					GetCompared().add(GetData().get(m));
					GetCompared().add("1");
				}
			}
		}
	}
	
	/**
	* Creates the table for the data to be imported to,
	* adds the table to the split pane in the GUI
	*/	
	public void UpdateData(){	
		
		DefaultTableModel dataModel = new DefaultTableModel();
		TableOfData.setModel(dataModel);
		dataModel.setColumnCount(0);
		
		IMPORTER.Clear();
		
		TableOfData = new JTable(IMPORTER.ImportFromFile());
		TableOfData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableOfData.setColumnSelectionAllowed(true);
		
		JScrollPane m_Scrollpane = new JScrollPane(TableOfData);
		m_Scrollpane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		m_Scrollpane.setVisible(true);
		
		
		SplitPane.setRightComponent(m_Scrollpane);
		SplitPane.setDividerLocation(DIV_LOC);
		SplitPaneVert.setDividerLocation(VERT_DIV_LOC);
		ChartChooserButton.setEnabled(true);
		SchemeChooserButton.setEnabled(true);
		ExtrasButton.setEnabled(true);
	}
	
	/** A constant that is used when the default font isn't used */
	final private int FONT_SIZE = 14;
	/** A constant used for the horizontal size of the GUI */
	private final int FRAME_X = 1366;
	/** A constant used for the vertical size of the GUI */
	private final int FRAME_Y = 730;
	/** The constant used to set the horizontal split pane point */
	private final int DIV_LOC = 900;
	/** The constant used to set the vertical split pane point */
	private final int VERT_DIV_LOC = 520;
	/** The maximum size that a file path should be */
	private final int MAX_SIZE_FILE_PATH = 80;
	/** The maximum size that a String passed can be */
	private final static int MAX_SIZE = 30;
	/** A bigger maximum size that can be set for a String */
	private final static int BIG_MAX_SIZE = 50;
	/** A final variable used to test whether a variable is set */
	private final static String UNSET = "Unset";
	/** A variable that holds the author of the chart */
	private static String m_Author = UNSET;
	/** A variable that holds the description for the chart */
	private static String m_DescriptiveCaption = UNSET;
	/** A variable that holds the time and date of when a chart was made */
	private static Boolean m_TimeDate = false;
	/** A variable that holds the author of the chart  */
	private static String m_Title = UNSET;
	/** A variable that says whether the colour legend should be shown */
	private static Boolean m_ColourLegend = true;
	/** Simply used in an if statement to get the value from the Chooser */
	private double m_ReturnValue;
	/** The colour scheme set by checking m_ColourOptionIndex */
	private static String m_ColourScheme= "Regular Colours";
	/** Contains the chosen file to be used to create charts */
	private String m_ChosenFile="";
	/** The file path of the selected file */
	private String m_FilePath = "";
	/** A variable holding the name of the selected colour scheme */
	private String m_ColourSchemeSelected;
	/** Contains the headers of the imported file */
	private static ArrayList<String> m_Headers = new ArrayList<String>();
	/** An array list that stores the data taken from the imported file */
	private ArrayList<String> m_Data;
	/**
	 * An array list which contains the data which has been grouped from
	 * the imported CSV file
	 * */
	private ArrayList<String> m_Compared;
	/** An array which contains the information from the rows */
	private static int[] m_Rows;
	/** An array which contains the information on the m_Columns */
	private static int[] m_Columns;
	/** The height of the table for rows selected when grouped */
	private static int m_Height;

	/** A text box containing instructions on how to use the program */
	public JTextArea instructionText;
	/** A text box containing instructions on how to use the program */
	private static JTextArea descriptiveText;
	/** A text field which shows the file which will be used */
	private JTextField fileInput;
	/** A label that holds the author of a chart */
	private static JLabel authorText;
	/** A label that holds the time and date of when a chart was created */
	private static JLabel timeDateText;
	/** A label that holds the description of a chart */
	private static JLabel wordDescription;
	/** A panel that holds the m_Author of a chart */
	private static JPanel author;
	/** A panel that holds the m_TimeDate variable */
	private static JPanel timeDate;
	/** A panel that holds the m_DescriptiveCaption variable */
	private static JPanel description;
	/** A panel that holds the instructionText JTextArea */
	private static JPanel extrasPanel;
	/** An object of the JToolBar, used to hold the buttons of the program */
	private JToolBar Toolbar;
	/** The buttons used to select options on the program */
	private JButton ImportButton, ExtrasButton, ChartChooserButton, 
					SchemeChooserButton, ExportButton;
	/** The split pane used to divide main frame horizontally, left side
	 * contains the LeftPanel and the SplitPaneVert */
	private JSplitPane SplitPane;
	/** The split pane that contains the ExtrasPanel */
	private JSplitPane SplitPaneVert;
	/** an object of JTable which holds the data from the CSV file given  */
	private JTable TableOfData;
	/** A panel that will contain the chart and information about the chart */
	private JPanel LeftPanel;
	private final Font TOOLBAR_FONT = new Font("Font", Font.PLAIN, FONT_SIZE);
	private GUI	Current;
	private GraphData GraphData;
	final private CSVImport IMPORTER = new CSVImport("");
	final private Export EXPORTER = new Export();
	/** An object that brings up the file Chooser GUI */
	private JFileChooser Chooser;
	/** An object that contains the current time */
	private static java.util.Date date; 
	/** An object of the ExtraOptionsFrame class */
	private static ExtraOptionsFrame extrasFrame;
	/** An object that contains the total file path of the chosen file */
	private Scanner FileName;
}