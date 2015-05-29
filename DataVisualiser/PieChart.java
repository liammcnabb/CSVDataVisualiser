/**
 * @file PieChart.java
 * @author V1: Jason Enderby, V2: Liam McNabb
 * @date 28Feb 2013
 * @see Visualisation, GraphData, ColourGroup
 * 
 * @brief This class generates a Pie Chart from a
 * specified GraphData
 */


import java.util.Random;

import	org.jfree.chart.ChartFactory;
import	org.jfree.chart.JFreeChart;
import	org.jfree.chart.plot.PiePlot;
import	org.jfree.data.general.DefaultPieDataset;
import	org.jfree.data.general.PieDataset;
import	org.jfree.util.Rotation;
import  org.jfree.data.general.Dataset;

public class PieChart extends Visualisation {
	

	
	/**
	*	Constructor for PieChart
	*
	*	@param data - The data of the chart to be plotted
	*	@param title - The title of the chart to be plotted
	*	@param colourGroup - The colour scheme of the chart to be plotted
	*	@param host - The object of GUI being used
	*
	*	@return - a chart of type PieChart
	*/
	public PieChart(GraphData data, String chartTitle, String colourGroup, GUI host,
		int Increment) {
		super(data, chartTitle, colourGroup);
		SetHost(host);
		//SetIncrement(0);
		
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
	*	Creates and returns a pie chart in JFreeChart format
	*
	*	@param plotData - The dataset of the chart to be ploted
	*	@param title - The title of the chart to be ploted
	*	@param colourGroup - The colour scheme of the chart to be ploted
	*
	*	@return - a chart of type JFreeChart
	*/
	JFreeChart CreateChart(Dataset plotData, String title, 
	String colourGroup) {
		final long	START_ANGLE = 180;
		
		title = title + ": " + 
		GetGraphData().Get(ChartTypeChooser.GetIncrement(), 0)+"\n"+
					"Legend Defines '" + GetGraphData().Get(0,0)+"'";
		JFreeChart chart = ChartFactory.createPieChart( title ,	// Chart title
			(PieDataset) plotData,	//	Data
			GetHost().GetColourLegend(),					//	Include legend
			true,					//	Include tooltips
			false);					//	Do not include URLs

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(START_ANGLE);
		plot.setDirection(Rotation.CLOCKWISE);
		if (GetHost().GetColumns().length == 1){
			for (int i = 0; i < GetGraphData().Height(); i++) {
				plot.setSectionPaint(GetGraphData().Get(i, 0), 
				ColourGroup.GetColour(colourGroup));
			}
		}else{
			for (int i = 0; i < GetGraphData().MaxWidth(); i++) {
				plot.setSectionPaint(GetGraphData().Get(0, i), 
				ColourGroup.GetColour(colourGroup));
			}
		}
		return chart;
	}
	
	/**
	*	Converts a GraphData type into data that can be displayed by PieChart
	*
	*	@param data - The data of type GraphData
	*
	*	@return - the data of type Dataset
	*/
	public Dataset CreateDataset(GraphData data) {
		DefaultPieDataset result = new DefaultPieDataset();
		//System.out.println(GetIncrement());
		if (GetHost().GetColumns().length == 1){
			for (int i = 1; i < data.Height() ; i++) {
				result.setValue(/**data.Get(0, 0)+ ": " + */data.Get(i,0),
					Double.parseDouble(
					data.Get(i,0)));
			}
		}else{
			for (int i = 1; i < data.MaxWidth() ; i++) {
				result.setValue(/**data.Get(0, 0)+ ": " + */data.Get(0,i),
					Double.parseDouble(
					data.Get(ChartTypeChooser.GetIncrement(),i)));
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
			gui.LeftPanelContent(new PieChart(gui.TestData(),"Test",
			"C_RANDOM", gui, 1));
		}
		
	}
	private GUI	m_Host;
	public static int m_Incrementer;
} 