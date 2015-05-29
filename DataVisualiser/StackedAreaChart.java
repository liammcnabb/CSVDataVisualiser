/**
*	@file	StackedAreaChart.java
*	@author	Sam Lucas, amended by Christian Clements
*	@date	28 Feb 2013
*	@see	Visualisation, GraphData, ColourGroup
*	
*	@brief  This class generates a StackedAreaChart from a specified GraphData
*
*   This is a Class creates a Stacked Area Chart based on the data input
*   by the user. It expects to receive data of type GraphData,
*   a String chartTitle, and a colourGroup of type String
*
*/

import	java.awt.Color;
import	org.jfree.chart.JFreeChart;
import	org.jfree.data.general.Dataset;
import	org.jfree.data.category.CategoryDataset;
import	org.jfree.chart.plot.PlotOrientation;
import	org.jfree.chart.ChartFactory;
import	org.jfree.chart.plot.CategoryPlot;
import	org.jfree.chart.renderer.category.StackedAreaRenderer;
import  org.jfree.data.category.DefaultCategoryDataset;



public class StackedAreaChart extends Visualisation {
	
	/**
	*	Constructor for StackedAreaChart
	*
	*	@param data - The data of the chart to be plotted
	*	@param title - The title of the chart to be plotted
	*	@param colourGroup - The colour scheme of the chart to be plotted
	*
	*	@return - a chart of type PieChart
	*/
	public StackedAreaChart(GraphData data, String chartTitle,
	String colourGroup,GUI host) {
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
	*	Creates and returns a stacked area chart in JFreeChart format
	*
	*	@param plotData - The data-set of the chart to be plotted
	*	@param title - The title of the chart to be plotted
	*	@param colourGroup - The colour scheme of the chart to be plotted
	*
	*	@return - a chart of type JFreeChart
	*/	
	public JFreeChart CreateChart(Dataset plotData, String title,
	String colourGroup) {
		boolean Test = true;
		if ((Test == true) && (title.length()==0)){
			System.out.println("ERROR! StackedAreaChart:- CreateChart()String"+
					" title has returned a length of zero!");
		}else{
			System.out.println("StackedAreaChart:- CreateChart()String title"+
					" has loaded correctly");
		}
		
		if ((Test == true) && (colourGroup.length()==0)){
			System.out.println("ERROR! StackedAreaChart:- CreateChart()String"+
					" colorGroup has returned a length of zero!");
		}else{
			System.out.println("StackedAreaChart:- CreateChart() String" +
					" colourGroup has loaded correctly");
		}
		
		JFreeChart chart = ChartFactory.createStackedAreaChart(
			title,	                   //   Chart title
			"Category",                //   X-axis title
			null,                      //   Y-axis title
			(CategoryDataset) plotData,//	Data
			PlotOrientation.VERTICAL,  //   orientation
			GetHost().GetColourLegend(),//	Include legend
			true,					   //	Include tooltips
			false);					   //	Do not include URLs
		
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinePaint(ColourGroup.GetColour(colourGroup));
        plot.setRangeGridlinePaint(ColourGroup.GetColour(colourGroup));
		
		StackedAreaRenderer renderer = (StackedAreaRenderer)plot.getRenderer();
		for (int i = 0; i < GetGraphData().MaxWidth()-1; i++) {
			renderer.setSeriesPaint(i, ColourGroup.GetColour(colourGroup));
		}
		return chart;
	}

	/**
	*	Converts a GraphData type into data that can be displayed by
	*	StackedAreaChart
	*
	*	@param data - The data of type GraphData
	*
	*	@return - the data of type Dataset
	*/	
	public Dataset CreateDataset(GraphData data) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		System.out.println(GetHost().GetColumns());
		if (GetHost().GetColumns().length == 1){
			for (int j = 1; j < data.Height(); j++) { //Cycle each column
				System.out.println("MaxWidth: "+data.MaxWidth());
				System.out.println("test " + data.Get(j, 0));
				dataset.setValue(Double.parseDouble(data.Get(j, 0)), //value
				data.Get(0, 0)    //series (each column header)
				,data.Get(j, 0)); //category (each of the left-most column)
				 
			}
		}else{
			for (int j = 1; j < data.Height(); j++) { //Cycle each column
				for (int i = 1; i < data.MaxWidth(); i++) {
					dataset.setValue(Double.parseDouble(data.Get(j, i)),//value
					data.Get(j, 0)    //series
					,data.Get(0, i)); //category
				} 
			}
		}
		return dataset;
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
			gui.LeftPanelContent(new StackedAreaChart(gui.TestData(),
			"Test","C_RANDOM", gui));
		}
	}	
	private GUI	m_Host;
	
}