/**
* @file BubbleChart.java
* @author Liam McNabb
* @date 20 March 2013
* 
* @brief Header file for class which creates a Scatter Graph
*
* This is a Class to create a Scatter Graph based upon the data which shall be input
* by the user. It expects to receive data of type GraphData to create the chart,
* a String chartTitle used to give the Chart a name, and a colourGroup of type 
* 
*/

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.NormalizedMatrixSeries;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYZDataset;
import org.jfree.data.general.Dataset;

public class BubbleChart extends Visualisation {
	
	private GUI	m_Host;
	
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
	* Construct a Scatter Graph
	*
	* @param data is the data that shall be used to create the chart
	* @param chartTitle is the title to be used upon creation of the chart
	* @param colourGroup is a string of the type of colour to use 
	* 
	*/
	public BubbleChart(GraphData data, String chartTitle, String colourGroup,  
	GUI host) {
		super(data, chartTitle,colourGroup);
		SetHost(host);
	}

	/**
	* Create a chart of type ScatterGraph 
	*
	* @param plotData is the data that shall be used to create the chart
	* @param title is the title to be used upon creation of the chart
	* @param colourGroup is the colour scheme which the user has selected
	*
	* @return the newly created Scatter Graph as chart 
	*/
	public JFreeChart CreateChart(Dataset plotData, String title, 
													String colourGroup) {	
	    JFreeChart chart = ChartFactory.createBubbleChart(
		title,				//  Chart title
		GetGraphData().Get(0,0),		//  Domain/x axis label
		GetGraphData().Get(1,0),		//  Y-axis label
		(XYZDataset) plotData,		//  Data
		PlotOrientation.VERTICAL,	//  Orientation of abrs
		GetHost().GetColourLegend(),				//  Include legend
		true,				//  Include tooltips
		false);				//  Do not include URLs
		
		chart = setColours(chart, colourGroup);
		
	    return chart;
	}
	
	/**
	* Sets the colours of the line series from ColourGroup class
	*
	* @param chart - takes in the chart to be edited
	* @param colourGroup - the name of the colour scheme to generate 
	* colours from
	*
	* @return chart - returns the finished chart to the method
	*/

	private JFreeChart setColours(JFreeChart chart, String colourGroup) {            

		//Set line colour
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRenderer().setSeriesPaint(0, 
		ColourGroup.GetColour(colourGroup));

		return chart;
	}
	
	/**
	* Create a dataset of type XYDataset using data of type GraphData 
	*
	* @param data is the data that shall be used to create the chart
	*
	* @return the newly created dataset as result 
	*/

	public Dataset CreateDataset(GraphData data) {
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		double [] x = new double[data.MaxWidth()];
		double [] y = new double[data.MaxWidth()];
		double [] z = new double[data.MaxWidth()];
		for (int i = 1; i < data.MaxWidth(); i++){
			x[i] = Double.parseDouble(data.Get(0,i));
			y[i] = Double.parseDouble(data.Get(1,i));
			z[i] = Double.parseDouble(data.Get(2,i));
		}
		double[][] series = new double[][] {x, y, z};
		dataset.addSeries(data.Get(2,0), series);
		
		
	    return (Dataset) dataset;
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
			gui.LeftPanelContent(new BubbleChart(gui.TestData(),"Test",
			"C_RANDOM", gui));
		}
	}

} 
