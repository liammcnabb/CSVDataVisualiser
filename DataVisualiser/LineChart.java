/**	
*	@file	LineChart.java
*	@author	V1: Alex Gurr, V2: Liam McNabb
*	@date	28 Feb 2013
*	@see	Visualisation, GraphData, ColourGroup
*	
*	@brief The Line Chart class generates a graph and plots the selected data on the chart.
*
*/



import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;



/**
*Builds on the currently existing Visualisation class and builds the chart
*using the parameters and the built dataset
*
*@param data - contains the selected data from the table
*@param chartTitle - a string passed from the GUI that changes with the button
*@param colourGroup - takes in string of the colour scheme
*
*@return chart - to the main GUI to display
*/

public class LineChart extends Visualisation {

	public LineChart(GraphData data, String chartTitle, String colourGroup,
			GUI host ) {
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
	


	JFreeChart CreateChart(Dataset plotData, String title, String colourGroup){
		
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		String Y;
		if (GetHost().GetColumns().length == 2){
			Y = GetGraphData().Get(1,0);
		} else {
			Y = "Numerical Value";
		}
			
		JFreeChart chart = ChartFactory.createXYLineChart(title, // Chart title
			GetGraphData().Get(0,0),		//  Domain/x axis label
			Y,
			(XYDataset) plotData,	//Data
			orientation,			//Orientation of bars
			GetHost().GetColourLegend(),					//Include legend
			true,					//Include tooltips
			false);					//Do not include URLs

		chart = setColours(chart, colourGroup);

		return chart;
	}

	/**
	*Sets the colours of the line series from ColourGroup class
	*
	*@param chart - takes in the chart to be edited
	*@param colourGroup - the name of the colour scheme to generate colors from
	*
	*@return chart - returns the finished chart to the method
	*/

	private JFreeChart setColours(JFreeChart chart, String colourGroup) {

		//Set line colour
		XYPlot plot = (XYPlot) chart.getPlot();
		
		
		
		for(int colourloop = 0; colourloop < GetGraphData().MaxWidth();
			colourloop++){
			plot.getRenderer().setSeriesPaint(colourloop, 
			ColourGroup.GetColour(colourGroup));
	    }
		return chart;
	}

	/**
	*Creates the dataset from the data
	*
	*@param data - takes in selected data to create the dataset for the chart
	*
	*@return result - this returns the dataset to the createChart method 
	*/
	XYDataset CreateDataset(GraphData data) {
		XYSeriesCollection result = new XYSeriesCollection();
		XYSeries series1; 
		if (GetHost().GetColumns().length == 1){
			
			series1 = new XYSeries(data.Get(0, 0)); 
			
			for (int i = 1; i < data.Height()	; i++) {
				System.out.println(data.Get(i, 0));
				series1.add(Double.parseDouble(data.Get(i,0)), 
						Double.parseDouble(data.Get(i,0)));
			}
			result.addSeries(series1);
		}else{	
		for (int j = 1; j < data.Height(); j++){
			
			series1 = new XYSeries(data.Get(j, 0)); 


		for (int i = 1; i < data.MaxWidth()	; i++) {
			series1.add(Double.parseDouble(data.Get(0, i)), 
						Double.parseDouble(data.Get(j, i)));
		}
		
		result.addSeries(series1);
		}
		}
		return result;
	}
	public static void main(String[] args){
		boolean testing = true;
		if(testing){
			GUI gui =  new GUI();
			int[] test = {1,2};
			gui.SetColumns(test);
	
	
			GraphData data = new GraphData();
			gui.LeftPanelContent(new LineChart(gui.TestData(),
			"Test","C_RANDOM", gui));
		}
	}
	private GUI	m_Host;
		
} 