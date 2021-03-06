/**
* 	@file 	BarChart3D.java
* 	@author Christian Clements
* 	@date 	27 Feb 2013
* 	@see	Visualisation, GraphData
*
* 	@brief	Class used to generate a 3D bar chart from a specified GraphData
*
* 	This is a Class to create a 3D Bar Chart based upon the data which,
*	shall be input by the user. It expects to receive data of type,
* 	GraphData to create the chart. A String chartTitle used to give the Chart,
* 	a name and a colourGroup of type. 
*/

import	org.jfree.chart.ChartFactory;
import	org.jfree.chart.JFreeChart;
import  org.jfree.chart.plot.CategoryPlot;
import  org.jfree.chart.plot.PlotOrientation;
import  org.jfree.data.category.CategoryDataset;
import  org.jfree.data.category.DefaultCategoryDataset;
import  org.jfree.data.general.Dataset;
import  org.jfree.chart.renderer.category.BarRenderer;

public class BarChart3D extends Visualisation {
	
	/**
	* 	Constructs a 3DBarChart which sets an instance of the GUI class
	*
	*	@param data is the data that shall be used to create the chart
	* 	@param chartTitle is the title to be used upon creation of the chart
	* 	@param colourGroup is a string of the type of colour to use 	
	*/
	public BarChart3D(GraphData data, String chartTitle, String colourGroup,
	GUI host) {
		super(data, chartTitle, colourGroup);
		SetHost(host);
	}
	
	/**
	* A method used to get the host instance of the class GUI
	* \return the chosen file name
	*/
	public GUI GetHost() {
		return m_Host;
	}
	
	/**
	* A method that sets an instance of GUI class named host (tests in GUI)
	* \param host
	*/
	public void SetHost(GUI host) {
		m_Host = host;
	}
	
	/**
	* 	Create a chart of type BarChart. 
	*
	* 	@param plotData is the data that shall be used to create the chart
	* 	@param title is the title to be used upon creation of the chart
	* 	@param colourGroup is the colour scheme which the user has selected
	*
	* 	@return the newly created BarChart as chart 
	*/
	JFreeChart CreateChart(Dataset plotData, String title, String colourGroup){
		boolean Test = true;
		if ((Test == true) && (title.length()==0)){
			System.out.println("ERROR! BarChart3D:- CreateChart() String " +
					"title has returned a length of zero!");
		}else{
			System.out.println("BarChart3D:- CreateChart() String title has " +
					"loaded correctly");
		}
		
		if ((Test == true) && (colourGroup.length()==0)){
			System.out.println("ERROR! BarChart3D:- CreateChart() String " +
					"colorGroup has returned a length of zero!");
		}else{
			System.out.println("BarChart3D:- CreateChart() String colourGroup"+
					" has loaded correctly");
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D(
			title,						//  Chart title
			GetGraphData().GetTitle(0),	//  Domain/x axis label
			null, 						//  Range/y axis label
			(CategoryDataset) plotData,	//  Data
			PlotOrientation.VERTICAL,	//  Orientation
			GetHost().GetColourLegend(),//  Include legend
			true,						//  Include tooltips
			false);						//  Do not include URLs   
        		
				
				
		CategoryPlot plot = chart.getCategoryPlot(); 
		
	    BarRenderer barRenderer = (BarRenderer)plot.getRenderer();

		for(int colourloop = 0; colourloop < GetGraphData().MaxWidth(); 
		colourloop++){
			barRenderer.setSeriesPaint(colourloop,
			ColourGroup.GetColour(colourGroup));
	    }
		
	 return chart;
	}
	
	/**
	* 	Create a dataset of type DefaultCategoryDataset,
	*	using data of type GraphData 
	*
	* 	@param data is the data that shall be used to create the chart
	*
	* 	@return the newly created dataset as result 
	*/
	Dataset CreateDataset(GraphData data) {
		DefaultCategoryDataset result = new DefaultCategoryDataset();
		//if only one column is selected
			System.out.println(GetHost().GetColumns());
			if (GetHost().GetColumns().length == 1){
				for (int j = 1; j < data.Height(); j++) { //Cycle each column
					System.out.println("MaxWidth: "+data.MaxWidth());
					System.out.println("test " + data.Get(j, 0));
					result.setValue(Double.parseDouble(data.Get(j, 0)), //value
					data.Get(0, 0)    //series (each column header)
					,data.Get(j, 0)); //category (each element of the
					//left-most column)
								 
				}
			}else{
				for (int j = 1; j < data.Height(); j++) { //Cycle each column  
					for (int i = 1; i < data.MaxWidth(); i++) {
						result.setValue(Double.parseDouble(data.Get(j, i)), 
						data.Get(j, 0)    //series
						,data.Get(0, i)); //category
					} 
				}
			}
					
			return result;
		}
	
	/**
	 * Main used for Testing purposes
	 * @param args - Unused
	 */
	public static void main(String[] args){
		boolean testing = false;
		if(testing){
			GUI gui =  new GUI();
			int[] test = {1,2};
			gui.SetColumns(test);
	
	
			GraphData data = new GraphData();
			gui.LeftPanelContent(new BarChart3D(gui.TestData(),
			"Test","C_RANDOM", gui));
		}
	}
	
	/** An instance of the GUI class */
	private GUI	m_Host;
} 