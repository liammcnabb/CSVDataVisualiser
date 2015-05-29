/**
*	@file ColourSelector.java
*	@author Chris Jenkins
*	@date 1 April 2013
*	@see ColourGroup, ColourStyleChooser
*
*	@brief ColourSelector allows users to select colours from a palette
*
*	ColourSelector generates a window to allow the user to select a custom colour set.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	public class ColourSelector extends JFrame
	{
		/**
		 * The constructor for ColorSelect
		 */
		public ColourSelector(){
			
			/*The Colour chooser is generated*/
			Object[] possibilities = null;
			Component frame = null;
			Object icon;
			boolean isInt = false;
			
			/*Until the user input can be stored as an int it will loop */
			while (isInt == false){
			
			String s = JOptionPane.showInputDialog(frame,
		                    "How many colours would you like?" +
		                    " (Maximum 15)");
		
				/**An attempt is made to convert the string input into a
				 *  integer if successful it continues otherwise a pop up 
				 * box will appear and the loop will repeat until 
				 * required input is entered
				*/
				try{ColourGroup.SetSize(Integer.parseInt(s));
					isInt = true;
				}catch(NumberFormatException e) {
				}
				/*if the length is less than 2 a box pops up*/
				if(s.length() > 2) {
					JOptionPane.showMessageDialog(null, 
						"You enterd a String, not a number, " +
						"please try again", 
						"Strings Not Supported", JOptionPane.ERROR_MESSAGE);
				}
				/*if the input is empty a message box pops up*/
				if(s.equals("")) {
					JOptionPane.showMessageDialog(null, 
						"You did not enter a number, please try again", 
						"No Number Entered", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			/*The CheckInput and ColourLoad methods are called*/
			CheckInput();
			ColourLoad();
		}
		
		/**
		 * CheckInput - Checks the value entered by 
		 * the user is acceptable or not
		 */
		public void CheckInput(){
			int MAX_SIZE = 15;
		/*If the users chosen size is less than 15 it is accepted*/
			System.out.println(ColourGroup.GetSize());
		if(ColourGroup.GetSize() <= MAX_SIZE){
			Red = new int[ColourGroup.GetSize()];
			Blue = new int[ColourGroup.GetSize()];
			Green = new int[ColourGroup.GetSize()];
		/*If the users chosen size is less than 0 a message box pops up*/
		}else if(ColourGroup.GetSize() < 0){
			JOptionPane.showMessageDialog(null, 
					"You entered a value below 0  " +
					"The number of colours has been set to 1 for you.", 
					"Too few colours!", JOptionPane.ERROR_MESSAGE);
		}else {
			/*otherwise the value entered is greater than 15 and a 
			 * message box pops up*/
			JOptionPane.showMessageDialog(null, 
			"You entered a number greater than 15, " +
			"The number of colours has been set to 10 for you.", 
			"Too many colours!", JOptionPane.ERROR_MESSAGE);
	
			/*The size is set to 10 since the user's chosen 
			 * size was too big*/
			ColourGroup.SetSize(10);
			Red = new int[ColourGroup.GetSize()];
			Blue = new int[ColourGroup.GetSize()];
			Green = new int[ColourGroup.GetSize()];
			}
		}
	
		/***
		 * ColourLoad - loads colours into the Red, Blue and Green arrays
		 */
		public void ColourLoad(){
		/*takes in user colours until the user defined size is reached */
		for (int i = 0; i< ColourGroup.GetSize(); i++){
			/*takes in a colour and stores the red, green, blue values for it*/
			color = JColorChooser.showDialog(null, "Please pick a colour",
					color);
			Red[i] = color.getRed();
			Blue[i] = color.getBlue();
			Green[i] = color.getGreen();
		
			/*The users chosen colours are set*/
			ColourGroup.SetRed(Red);
			ColourGroup.SetBlue(Blue);
			ColourGroup.SetGreen(Green);
		}
	}
	
	/*The integer array that store the users chosen colour set*/
	private int Red[];
	private int Blue[];
	private int Green[];
		
	/*variable for colour*/
	private static Color color;
}