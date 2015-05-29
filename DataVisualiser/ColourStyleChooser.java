/**
*	@file ColourStyleChooser.java
*	@author Chris Jenkins
*	@date 14 April 2013
*	@see ColourGroup, ColourSelector, GUI
*
*	@brief Header file for class which creates a Colour Chooser
*
*	This is a Class to create a Colour Chooser that will use ColourGroup to
*	receive the colours that it will use.
*/

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ColourStyleChooser {
	
	/**
	* Creates instants of other classes
	*
	* This will create instances of the ColourGroup and 	
	* GUI so they can be used in this class.
	*/
	private ColourGroup m_ColourGen = new ColourGroup(); 
	private GUI	m_Host;	
	
	/**
	* Creates a container
 	*/	
	public Container createInterface(){
		final Container colourStyleInterface;
		colourStyleInterface = new Container();
		colourStyleInterface.setLayout(new FlowLayout());
		
		JButton warmButton = new JButton(new ImageIcon(
		getClass().getResource("Warm.jpg")));
		warmButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {
				m_Host.SetColourScheme(ColourGroup.WARM);
			}
		});
			
		JButton coldButton = new JButton(new ImageIcon(
		getClass().getResource("Cold.jpg")));
		coldButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {	
				m_Host.SetColourScheme(ColourGroup.COLD);     
			}
		});		

		JButton kiwiButton = new JButton(new ImageIcon(
		getClass().getResource("Kiwi.jpg")));
		kiwiButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {
				m_Host.SetColourScheme(ColourGroup.KIWI);
			}
		});
			
		JButton grapeButton = new JButton(new ImageIcon(
		getClass().getResource("Grape.jpg")));
		grapeButton.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent evt) {
		m_Host.SetColourScheme(ColourGroup.GRAPE);
			}
		});	

		JButton customButton = new JButton(new ImageIcon(
		getClass().getResource("Custom.jpg")));
		customButton.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent evt) {
		ColourSelector c = new ColourSelector();
		m_Host.SetColourScheme(ColourGroup.CUSTOM);
			}
		});
			
		JButton randomButton = new JButton(new ImageIcon(
		getClass().getResource("random.jpg")));
		randomButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent evt) {		
				m_Host.SetColourScheme(ColourGroup.RANDOM);        
			}
		});
	
		/*The buttons are created*/
		colourStyleInterface.add(warmButton);  
		colourStyleInterface.add(coldButton);
		colourStyleInterface.add(kiwiButton);
	    colourStyleInterface.add(grapeButton);
	    colourStyleInterface.add(customButton);
		colourStyleInterface.add(randomButton);
		
		colourStyleInterface.setPreferredSize(new Dimension(300,400)); 
		return colourStyleInterface;	
	}
	
	/**
	* Displays the colour chooser container
	*
	* @param host this will set m_host to equal host so it 
	*        can be used in the GUI class
	*
	*/	
	public ColourStyleChooser(GUI Host){
		m_Host = Host;	
	}
}