/**
* @file XYSplineChart.java
* @author Liam McNabb
* @date 20 March 2013
* 
*
* @brief Header file for class which creates an XY Spline Chart
*
* 
* This is a Class to create an XYSpline based upon the data input
* by the user. It expects to receive data of type GraphData,
* a String chartTitle, and a colourGroup of type String.
* 
*/

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class XYSplineChart extends Visualisation {
	
	/**
	* Constructor method for XYSpline
	* @param data - The selected graph data
	* @param chartTitle - Title of the chart
	* @param colourGroup - String used to define the colour
	* @param host
	*/
	public XYSplineChart(GraphData data, String chartTitle, String colourGroup,
		GUI host ) {
		super(data, chartTitle, colourGroup);
		SetHost(host);
	}
	
	/**
	* A method used to get the host instance of the class GUI
	* @return the chosen file name
	*/
	public GUI GetHost() {
		return m_Host;
	}
	
	/**
	* A method that sets an instance of GUI class named host (tests in GUI)
	* @param host
	*/
	public void SetHost(GUI host) {
		m_Host = host;
	}
	


	JFreeChart CreateChart(Dataset plotData, String title, String colourGroup){
		String Y;
		if (GetHost().GetColumns().length == 2){
			Y = GetGraphData().Get(1,0);
		} else {
			Y = "Numerical Value";
		}
		PlotOrientation orientation = PlotOrientation.VERTICAL;
	
		JFreeChart chart = ChartFactory.createXYLineChart(title, // Chart title
			GetGraphData().Get(0,0),		//  Domain/x axis label
			Y,
			(XYDataset) plotData,	//Data
			orientation,			//Orientation of bars
			GetHost().GetColourLegend(),					//Include legend
			true,					//Include tooltips
			false);					//Do not include URLs
		chart.getXYPlot().setRenderer(new XYSplineRenderer());
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
			gui.LeftPanelContent(new XYSplineChart(gui.TestData(),
			"Test","C_RANDOM", gui));
		}
	}
	private GUI	m_Host;
}
