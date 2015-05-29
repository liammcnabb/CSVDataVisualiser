/**
 * @file Visualisation.java
 * @author Ashley Burgess
 * @date 20 March 2013
 * @see GraphData
 * @brief An Abstract class containing common methods and attributes for graphs
 */

import	javax.swing.JPanel;
import	org.jfree.chart.JFreeChart;
import	org.jfree.data.general.Dataset;
import	org.jfree.chart.ChartPanel;

public abstract class Visualisation extends JPanel {
		
	/**
	*	Constructor for Visualisation
	*
	*	@param data The data of the chart to be plotted
	*	@param chartTitle The title of the chart to be plotted
	*	@param colourGroup The colour scheme of the chart to be plotted
	*/
	public Visualisation(GraphData data, String chartTitle, 
	String colourGroup) {
		super();
		initGraph(data, chartTitle, colourGroup);
	}
	
	/**
	*	Accessor for member variable m_GraphData
	*
	*	@return - m_GraphData
	*/
	public GraphData GetGraphData() {
		return m_GraphData;
	}
	
	/**
	*	Accessor for member variable m_PlotData
	*
	*	@return m_PlotData
	*/
	private Dataset GetPlotData() {
		return m_PlotData;
	}
	
	/**
	*	Mutator for member variable m_GraphData
	*
	*	@param data - The new value of m_GraphData
	*
	*	@return - success
	*/
	public boolean SetGraphData(GraphData data) {
		m_GraphData = data;
		return true;
	}
	
	/**
	*	Mutator for member variable m_PlotData
	*
	*	@param plotData - The new value of m_PlotData
	*
	*	@return - success
	*/
	private boolean SetPlotData(Dataset plotData) {
		m_PlotData = plotData;
		return true;
	}
	
	/**
	*	Collects data and builds a visible element
	*
	*	@param data The data of the chart to be plotted
	*	@param chartTitle The title of the chart to be plotted
	*	@param colourGroup The colour scheme of the chart to be plotted
	*
	*/
	private void initGraph(GraphData data, String chartTitle,
	String colourGroup) {
		SetGraphData(data);
		SetPlotData(CreateDataset(data));
		JFreeChart	chart = CreateChart(GetPlotData(), chartTitle,
		colourGroup);
		ChartPanel	chartPanel = new ChartPanel(chart);
		add(chartPanel);
		setVisible(true);
	}
	
	/** An object of GraphData which holds the selected data */
	private GraphData m_GraphData;
	/** An object of Dataset which has the data to be plotted9 */
	private Dataset	m_PlotData;
	
	/** An object of Dataset which takes in the GraphData selected */
	abstract Dataset CreateDataset(GraphData data);
	/** Data to be parsed to the JFreeChart class to create a chart */
	abstract JFreeChart CreateChart(Dataset plotData, String title,
			String colourGroup);
}