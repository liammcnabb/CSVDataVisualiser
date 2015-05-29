/**
* @file ScatterGraph.java
* @author V1:Connor Lynch, V2 Liam McNabb
* @date 27 Feb 2013
* 
*
* @brief Header file for class which creates a Scatter Graph
*
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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.general.Dataset;


public class ScatterGraph extends Visualisation {
	
	/**
	* Construct a Scatter Graph
	*
	* @param data is the data that shall be used to create the chart
	* @param chartTitle is the title to be used upon creation of the chart
	* @param colourGroup is a string of the type of colour to use 
	* 
	*/
	public ScatterGraph(GraphData data, String chartTitle, String colourGroup,
		GUI host) {
		super(data, chartTitle,colourGroup);
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
		String Y;
		if (GetHost().GetColumns().length == 2){
			Y = GetGraphData().Get(1,0);
		} else {
			Y = "Numerical Value";
		}
	    JFreeChart chart = ChartFactory.createScatterPlot(
		title,				//  Chart title
		GetGraphData().Get(0,0),		//  Domain/x axis label
		Y,		//  Y-axis label
		(XYDataset) plotData,		//  Data
		PlotOrientation.VERTICAL,	//  Orientation of abrs
		GetHost().GetColourLegend(),				//  Include legend
		true,				//  Include tooltips
		false);				//  Do not include URLs
		
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
	* Create a dataset of type XYDataset using data of type GraphData 
	*
	* @param data is the data that shall be used to create the chart
	*
	* @return the newly created dataset as result 
	*/
	public XYDataset CreateDataset(GraphData data) {
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
				
				for (int i = 1; i < data.MaxWidth(); i++) {
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
			gui.LeftPanelContent(new ScatterGraph(gui.TestData(),
			"Test","C_RANDOM", gui));
		}
	}
	private GUI	m_Host;
} 