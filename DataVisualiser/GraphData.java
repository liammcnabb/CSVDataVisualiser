/**	
*	@file	GraphData.java
*	@author	Lloyd Roberts
*	@date	28 Feb 2013
*   
*	@brief Data structure for all Visualisations
*
*/


import	java.util.ArrayList;

public class GraphData {
	
	/**
	*Accessor for member variable m_Data
	*
	*@return - m_Data
	*/
	private ArrayList<ArrayList<String>> getData() {
		return m_Data;
	}
	
	/**
	*Mutator for member variable m_Data
	*
	*@param data - The new value of m_Data
	*
	*@return - success
	*/
	private boolean setData(ArrayList<ArrayList<String>> data) {
		m_Data = data;
		return true;
	}
	
	/**
	*Adds a value to the end of the data structure
	*
	*@param row - The row to append
	*@param value - The value to add
	*
	*@return - success
	*/
	public boolean Add(int row, String value) {
		while (row >= Height()) {
			getData().add(new ArrayList<String>());
		}
		return true;
	}
	
	/**
	*Accessor method for individual data elements
	*
	*@param row - The row to queery
	*@param column - The column to queery
	*
	*@return - The stored data element, null for failure
	*/
	public String Get(int row, int column) {
		if (row < Height() && column < Width(row)) {
			return getData().get(row).get(column);
		}
		return null;
	}
	
	/**
	*Returns the title at specified row
	*
	*@param row - The row to collect the title from
	*
	*@return - The title at specified row
	*/
	public String GetTitle(int row) {
		return Get(row, 0);
	}
	
	/**
	*Constructor for GraphData from 2D String array
	*
	*@param data - Array to convert into GraphData
	*
	*@return - datatype of GraphData
	*/
	public GraphData(String[][] data) {
		setData(new ArrayList<ArrayList<String>>());
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				Insert(i, j, data[i][j]);
			}
		}
	}
	
	/**
	*Blank constructor for GraphData
	*
	*@return - datatype of GraphData
	*/	
	public GraphData() {
		setData(new ArrayList<ArrayList<String>>());
	}
	
	/**
	*Returns the Height
	*
	*@return - The number of rows
	*/
	public int Height() {
		return getData().size();
	}
	
	/**
	*Inserts a value into the data structure
	*
	*@param row - The row to insert into
	*@param column - The column to insert into
	*@param value - The value to insert
	*
	*@return - success
	*/
	public boolean Insert(int row, int column, String value) {
		while (row >= Height()) {
			getData().add(new ArrayList<String>());
		}
		while (column > Width(row)) {
			getData().get(row).add("");
		}
		getData().get(row).add(column, value);
		return true;
	}
	
	/**
	*Returns the maximum width
	*
	*@return - The largest number of columns stored in a row
	*/	
	public int MaxWidth() {
		int	width = 0;
		
		if (Height() > 0) {
			for (int i = 0; i < Height(); i++) {
				for (int j = 0; j < Width(i); j++) {
					if (width < Width(i)) {
						width = Width(i);
					}
				}
			}
		}
		return width;
	}
	
	/**
	*Returns the minimum width
	*
	*@return - The least number of columns stored in a row
	*/	
	public int MinWidth() {
		int width = 0;
		
		if (Height() > 0) {
			for (int i = 0; i < Height(); i++) {
				for (int j = 0; j < Width(i); j++) {
					if (width > Width(i)) {
						width = Width(i);
					}
				}
			}
		}
		return width;
	}
	
	/**
	*Mutates a value in the data structure
	*
	*@param row - The row to edit
	*@param column - The column to edit
	*@param value - The value to edit
	*
	*@return - success
	*/
	public boolean Set(int row, int column, String value) {
		if (row < Height() && column < Width(row)) {
			getData().get(row).set(column, value);
			return true;
		}
		return false;
	}
	
	/**
	*Method to convert the dataset into a string for display on console
	*
	*@return - String representation of data
	*/
	public String toString() {
		String result = "";
		for (int i = 0; i < MaxWidth(); i++) {
			result += "    " + i + "\t";
		}
		result += "\n";
		for (int i = 0; i < Height(); i++) {
			result += i + ">";
			for (int j = 0; j < Width(i); j++) {
				result += Get(i, j) + "\t|";
			}
			result += "\n";
		}
		return result;
	}
	
	/**
	*Returns the Width at specified row
	*
	*@param row - the row on which to calculate width
	*
	*@return - The number of columns at specified row
	*/
	public int Width(int row) {
		int height = 0;
		if (Height() > row) {
			height = getData().get(row).size();
		}
		return height;
	}	
	
	/** This stores the selected data */
	private static ArrayList<ArrayList<String>>	m_Data;
}