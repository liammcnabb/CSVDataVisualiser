/**	
*	@file	CSVImport.java
*	@author	Lloyd Roberts
*	@date	13 Apr 2013
*	@see	GUI, MyTableModel
*	
*	@brief CSVImport allows a .csv file to be imported into the software,
* 	with the imported data being stored in a JTable on the GUI.
*
*	DisplayChartTypeChooser creates a Container, and populates it with 
*	JButtons, assigning icons for each button, and putting code in the 
*	action listeners for these buttons to create a new graph with the data 
*	selected.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CSVImport {
	
	/**
	* Constructs a GUI using InitComponents method.
	* Is used for the good and bad testing of this class.
	* 
	* @param header
	* @param content
	* @param errors
	* @param filepath
	*/	
	public CSVImport(String header, String content, int errors, String filepath) {
	SetHeader(header);
	SetContent(content);
	SetErrorCount(errors);
	SetFilePath(filepath);
	}
	
	/**
	* This is a constructor which allows classes to set the filepath
	* \param filepath takes in a filepath
	* \returns nothing
	*/
	public CSVImport(String filePath){
		this.SetFilePath(filePath);
	}	
			
	/**
	* This returns the Content ArrayList
	* \returns Content
	*/
	public static ArrayList<String> GetContent(){
		return Content;		
	}
	
	/**
	* This returns the m_ErrorCount 
	* \returns m_ErrorCount
	*/
	public static int GetErrorCount(){
		return m_ErrorCount;
	}
	
	/**
	* This returns the m_FilePath 
	* \returns m_FilePath
	*/
	public static String GetFilePath(){
		return m_FilePath;
	} 
	
	/**
	* This returns the Headers Array 
	* \returns Headers
	*/
	public static ArrayList<String> GetHeaders(){
		return Headers;
	}
	
	/**
	* This adds elements to the Content ArrayList
	* \param content string representation of the content
	* \returns nothing
	*/
	public static void SetContent(String content){
		boolean test = true;
	
	    if ((content.equals("")) && (test == true)) {
	    	System.err.println("Warning CSVImport :: SetContent()" +
	    	" content are not set:");
	    } else if (test == true) {
	    	System.out.println("CSVImport :: SetContent()" +
	    	" Content is set: " + content);
	    }	    
		Content.add(content);
	}
	
	/**
	* This adds the m_ErrorCount to the error 
	* \param error is the number of errors
	* \returns nothing
	*/
	public static void SetErrorCount(int error){
		boolean test = true;
	
	    if ((error != 0)) {
	    	JOptionPane.showMessageDialog(null, "File has " + error +
	    	" errors, Empty cells have been removed",
	    	"Error Check", JOptionPane.ERROR_MESSAGE);
	    }
	    if(test) {
	    	System.out.println("CSVImport :: SetErrorCount() " +
	    	"m_ErrorCount is set: " + error);
	    }
		m_ErrorCount += error;
	}
	
	/**
	* This sets the m_FilePath to the path 
	* \param path is the file path
	* \returns nothing
	*/
	public static void SetFilePath(String path){
		boolean test = true;
	
	    if ((path.equals("")) && (test == true)) {
	    	System.err.println("Warning CSVImport :: SetFilePath()" +
	    	" path is not set:");
	    } else if (test == true) {
	    	System.out.println("CSVImport :: SetFilePath() " +
	    	"FilePath is set: " + path);
	    }	     
		m_FilePath = path;
	}
	
	/**
	* This adds elements to the Headers ArrayList 
	* \param headers string representation of a header
	* \returns nothing
	*/
	public static void SetHeader(String headers){
		boolean test = true;
	
	    if ((headers.equals("")) && (test == true)) {
	    	System.err.println("Warning CSVImport :: SetHeader() " +
	    	"headers are not set:");
	    } else if (test == true) {
	    	System.out.println("CSVImport :: SetHeader()" +
	    	" headers are set: " + headers);
	    }		
		Headers.add(headers);
	}
		
	/**
	* This clears all the information so new information can be stored
	* \returns nothing
	*/
	public static void Clear(){
		
		Headers.clear();
		System.out.println(Headers);
		Content.clear();
		System.out.println(Content);
		SetErrorCount(0);
	}	
	
	/**
	* This gets the information from a specific column and 
	* returns an ArrayList of them 
	* \param title this is a member of the Headers ArrayList
	* \returns column
	*/
	public static ArrayList<String> Column(String title){
		boolean test = false;

	    if ((title.equals("")) && (test == true)) {
	    	System.err.println("Warning CSVImport :: Column()" +
	    	" title is not set:");
	    } else if (test == true) {
	    	System.out.println("CSVImport :: Column()" +
	    	" title is set to " + title);
	    }
		
		ArrayList<String> column = new ArrayList<String>();
		
		for(int i = GetHeaders().indexOf(title);
		i < GetContent().size(); i += GetHeaders().size()){
			column.add(GetContent().get(i));
		}
		
		return column;
	}
	
	/**
	* This returns the Test boolean depending on if it has failed the check
	* \returns Test
	*/
	public static Boolean CorruptCheck() throws IOException{
		Boolean Test = false;
		File file = new File(GetFilePath());
		BufferedReader CorruptChk = new BufferedReader(new FileReader(file));
		String line2 = CorruptChk.readLine();
	    int countC = 0;
	    System.out.println("¶");
	   while (line2 != null) {
	       String []parts = line2.split(",");
	       for( int w =0; w< parts.length; w++) {
	           if (line2.contains("¶")){
	    	   countC++;;
	    	   }
	       }
	       System.out.println(countC);
	       line2 = CorruptChk.readLine();
	    }
	    if(countC > 1){
	    	Test = true;
	    	System.out.println("File may be corrupt, please use another CSV");
			JOptionPane.showMessageDialog(null,
	    		    "File may be corrupt, please use another CSV.");
	    }	
		return Test;
	}
	
	/**
	* This returns the Test boolean depending on if it has failed the check
	* \returns Test
	*/
	public static Boolean EmptyCheck() throws IOException{
		Boolean Test = false;
		File file = new File(GetFilePath());
		BufferedReader EmptyChk  = new BufferedReader(new FileReader(file));
		
		String line1 = EmptyChk.readLine();
	    int countE = 0;
	    while (line1 != null) {
	       String []parts = line1.split(" ");
	       for( String w : parts) {
	            countE++;        
	       }
	       line1 = EmptyChk.readLine();
	    }         
	    if(countE == 0){
	    	Test = true;
	    	System.out.println("File is empty, please use another CSV");

			JOptionPane.showMessageDialog(null,
	    		    "File is empty, please use another CSV.");
	    }
	    return Test;
	}
	
	/**
	* This method imports the data from .csv file, and stores it in a custom 
	* table model
	*
	* @return the custom table model, an instance of MyTableModel class,
	* containing all of the data from the imported file.
	*/			
	public TableModel ImportFromFile(){
		try {
			read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		m_MyModel.setColumnCount(0);
		
		for(int i = 0; i < GetHeaders().size(); i++){
			String columnData[] = new 
					String[Column(GetHeaders().get(i)).size()];
			for(int j = 0; j < Column(GetHeaders().get(i)).size(); j++){
				columnData[j] = Column(GetHeaders().get(i)).get(j); 
			}
			m_MyModel.addColumn(GetHeaders().get(i), columnData);
		}		
		
		return m_MyModel;		
	}
	
	public static void main(String[] args) throws IOException {
		int good1 = 100;
		boolean test = true;
		
		if(test) {
			CSVImport goodTest = new CSVImport("header", "content", good1, "filepath");
			CSVImport emptyTest = new CSVImport("", "", good1, "");
			
			CSVImport empty = new CSVImport("empty.csv");
			EmptyCheck();
			CSVImport corrupt = new CSVImport("image.csv");
			CorruptCheck();
		}
	}
	
	/**
	* This method is for reading in the csv file and retrieving the data 
	* from it
	*/
	public static void read() throws IOException{
		Clear();
	
		String line = null;
		int lineCount = 0;
		int errors = 0;
		
		//This reads in the csv file
		File file = new File(GetFilePath());
		BufferedReader reader  = new BufferedReader(new FileReader(file));
		
		if(EmptyCheck() == false && CorruptCheck() == false){
			//Goes through each line using .next and a delimiter 
			//to get every element  
			while((line = reader.readLine()) != null){
				//System.out.println(line);
				Scanner s = new Scanner(line).useDelimiter(",");
							
				//Goes through each element of the line that are made 
				//by the delimiter
				while(s.hasNext()){
					String in = s.next();
					if(in.equals("")){
						errors++;
						System.out.println();
						//System.out.println("Empty");
					}
					else{
						//System.out.println(in);
						if(lineCount != 0){
							SetContent(in);
						}
						//This takes the header names from the first 
						//line of the csv file
						if(lineCount == 0){
							SetHeader(in);
						}
					}
				}
				lineCount++;
			}
			SetErrorCount(errors);
		}		
	}
	
	/** This stores the model for the table */
	final TableModel m_MyModel = new TableModel();	
	/** This stores the content of the file */
	private static ArrayList<String> Content = new ArrayList<String>();
	/** This stores the headers in the file */
	private static ArrayList<String> Headers = new ArrayList<String>();
	/** This stores the location of the file */
	private static String m_FilePath;
	/** This saves the amount of errors in a file */
	private static int m_ErrorCount;
}