/**	
*	@file	TableModel.java
*	@author	Andy Small ammended by Lloyd Roberts
*	@date	16 Feb 2013
*	@see	Import
*	
*	@brief	Custom table model class
*	
*	TableModel extends the default table model class, allowing preferences to 
* 	be set to cover the imported data table's settings.	
*/


import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
		
	/**
	*	this method overrides the isCellEditable method, and sets it to false
	* 	by default.
	* 
	*   @param row - row on the table
	*   @param col - column on the table
	*   
	*   @return false - returns false
	*/
	@Override
	public boolean isCellEditable(int row, int col){
		return false;
	}
}
