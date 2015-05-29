/**	
*	@file	Export.java
*	@author	Christian Clements
*	@date	16 Feb 2013
*	@see	GUI, CSVImport
*	
*	@brief	Exports chart as image.
*	
*	Export takes in a JPanel as a parameter and saves the chart
*   on the Main GUI's left panel 
*	as a png, in a location specified by the user.
*/


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Export {
	
	/**
	* Export the chart to a png file.
	*
	* @param panel is the JPanel to be exported, defined in the GUI class.
	*
	*/	
	public void ExportImage(JPanel panel ){
		boolean Test = true;
		if ((Test == true) && (panel == null)){
			System.out.println("ERROR! Export:- ExportImage() JPanel panel" +
			" has returned null!");
		}else{
			System.out.println("Export:- ExportImage() JPanel panel has been" +
					" loaded correctly");
		}
		 
		//create a new file chooser
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a save location");  
		
		//Give the file chooser a filter for png files only
		FileNameExtensionFilter filter = new FileNameExtensionFilter("png " +
		"files","png");
		fileChooser.setFileFilter(filter);
		 
		//show the save dialog using panal as the parent JPanel
		int userSelection = fileChooser.showSaveDialog(panel);
		
		//if the user successfully chooses a file location
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			
			//create a new buffered image and file to save
			BufferedImage bi = ScreenImage.createImage(panel);
		    File fileToSave = fileChooser.getSelectedFile();
		    	try{
		    	
		    		// write the buffered image to a png and save
		    		// it in the selected location
		    		ImageIO.write(bi, "png", new File(
		    		fileToSave.getAbsolutePath()+".png"));
		    		System.out.println("Save as file: " + 
		    		fileToSave.getAbsolutePath()+".png");
		    
		    	//Catch the IOException
		    	}catch (IOException e1){
		    		System.out.println("ERROR! The specified file " +
		    		"path is null or erraneous!");
		    }
		}
		
	}	
	
}