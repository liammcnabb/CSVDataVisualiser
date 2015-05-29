/**
 * @file ChartTypeChooser.java
 * @author Ashley Burgess
 * @date 20 March 2013
 * @see GUI, PieChart, BarChart, BubbleChart, LineChart, XYSplineChart, 
 * 		ScatterGraph, StackedAreaChart, BarChart3D
 * @brief ChartTypeGUI creates the pop up interface containing the buttons 
 * 		  for each chart type
 * 
 * ChartTypeGUI creates a container, and populates it with JButtons, assigning
 * icons for each button, and putting code in the action listeners for these
 * buttons to create a new graph with the data selected. 
 */

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ChartTypeChooser {
	
	/**
	* Construct the ChartTypeChooser and set the button images
	*
	* @param host is the main instance of the GUI class, containing the methods
	*        and variables that are needed for other classes 
	*/
	public ChartTypeChooser(GUI host){
		this.SetHost(host);
		this.SetPieChartImage("pie_chart.jpg");
		this.SetXYSplineChartImage("XYSpline.jpg");
		this.SetBarChartImage("bar_chart.jpg");
		this.SetStackedAreaChartImage("stacked_area.jpg");
		this.SetScatterPlotChartImage("scatter.jpg");
		this.SetLineChartImage("line.jpg");
		this.SetBubbleChartImage("BubbleChart.jpg");
		this.Set3DBarChartImage("3d_bar_chart.jpg"); 
	}
	
	/**
	* A method used to get the pie chart image name
	* \return the pie chart image name
	*/
	public String Get3DBarChartImage() {
		return m_3DBarChartImage;
	}
	
	/**
	* A method used to get the bar chart image name
	* \return the bar chart image name
	*/
	public String GetBarChartImage() {
		return m_BarChartImage;
	}
	
	/**
	* A method used to get the bubble chart image name
	* \return the bubble chart image name
	*/
	public String GetBubbleChartImage() {
		return m_BubbleChartImage;
	}
	
	/**
	* A method used to get the XYSpline chart image name
	* \return the XYSpline chart image name
	*/
	public String GetXYSplineChartImage() {
		return m_XYSplineChartImage;
	}
	
	/**
	* A method used to get the host instance of the class GUI
	* \return the chosen file name
	*/
	public GUI GetHost() {
		return m_Host;
	}
	/**
	 * Returns the incrementation value
	 * @return m_Incrementer
	 */
	public static int GetIncrement(){
		return m_Incrementer;
	}
	/**
	* A method used to get the line chart image name
	* \return the line chart image name
	*/
	public String GetLineChartImage() {
		return m_LineChartImage;
	}
	
	/**
	* A method used to get the pie chart image name
	* \return the pie chart image name
	*/
	public String GetPieChartImage() {
		return m_PieChartImage;
	}
	
	/**
	* A method used to get the scatter plot chart image name
	* \return the scatter plot chart image name
	*/
	public String GetScatterPlotChartImage() {
		return m_ScatterPlotChartImage;
	}
	
	/**
	* A method used to get the stacked area chart image name
	* \return the stacked area chart image name
	*/
	public String GetStackedAreaChartImage() {
		return m_StackedAreaChartImage;
	}
	
	/**
	* A method that sets the 3D Bar Chart image name
	* \param threeDBar
	*/
	public void Set3DBarChartImage(String threeDBar) {
		boolean test = true;
		
		if((threeDBar.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"Set3DBarChartImage():: image is set to an empty string.");
		}
		if ((threeDBar.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"Set3DBarChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"Set3DBarChartImage():: chosen image is set to: " 
		  	+ threeDBar);
		}
		m_3DBarChartImage = threeDBar;
	}
	
	/**
	* A method that sets the bar chart image name
	* \param bar
	*/
	public void SetBarChartImage(String bar) {
		boolean test = true;
		
		if((bar.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetBarChartImage():: image is set to an empty string.");
		}
		if ((bar.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetBarChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetBarChartImage():: chosen image is set to: " 
		  	+ bar);
		}
		m_BarChartImage = bar;
	}
	
	/**
	* A method that sets the bubble chart image name
	* \param bubble
	*/
	public void SetBubbleChartImage(String bubble) {
		boolean test = true;
		
		if((bubble.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetBubbleChartImage():: image is set to an empty string.");
		}
		if ((bubble.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetBubbleChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetBubbleChartImage():: chosen image is set to: " 
		  	+ bubble);
		}
		m_BubbleChartImage = bubble;
	}
	
	/**
	* A method that sets the XYSpline chart image name
	* \param XYSpline
	*/
	public void SetXYSplineChartImage(String XYSpline) {
		boolean test = true;
		
		if((XYSpline.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetXYSplineChartImage():: image is set to an empty string.");
		}
		if ((XYSpline.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetXYSplineChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetXYSplineChartImage():: chosen image is set to: " 
		  	+ XYSpline);
		}
		m_XYSplineChartImage = XYSpline;
	}
	
	/**
	* A method that sets an instance of GUI class named host (tests in GUI)
	* \param host
	*/
	public void SetHost(GUI host) {
		m_Host = host;
	}
	/**
	 * A method that setvan integer for incrementing the data to use
	 * @param increment used to decide which column will be compared to the
	 * first column
	 */
	public static void SetIncrement(int increment){
		m_Incrementer = increment;
		System.out.println("m_Incrementer set to: "+ m_Incrementer);
	}
	/**
	* A method that sets the line chart image name
	* \param line
	*/
	public void SetLineChartImage(String line) {
		boolean test = true;
		
		if((line.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetLineChartImage():: image is set to an empty string.");
		}
		if ((line.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetLineChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetLineChartImage():: chosen image is set to: " 
		  	+ line);
		}
		m_LineChartImage = line;
	}
	
	/**
	* A method that sets the pie chart image name
	* \param pie
	*/
	public void SetPieChartImage(String pie) {
		boolean test = true;
		
		if((pie.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetPieChartImage():: image is set to an empty string.");
		}
		if ((pie.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetPieChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetPieChartImage():: chosen image is set to: " 
		  	+ pie);
		}
		m_PieChartImage = pie;
	}
	
	/**
	* A method that sets the scatter plot chart image name
	* \param scatterPlot
	*/
	public void SetScatterPlotChartImage(String scatterPlot) {
		boolean test = true;
		
		if((scatterPlot.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetScatterPlotChartImage():: image is set to an empty string.");
		}
		if ((scatterPlot.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetScatterPlotChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetScatterPlotChartImage():: chosen image is set to: " 
		  	+ scatterPlot);
		}
		m_ScatterPlotChartImage = scatterPlot;
	}
	
	/**
	* A method that sets the stacked area chart image name
	* \param stackedArea
	*/
	public void SetStackedAreaChartImage(String stackedArea) {
		boolean test = true;
		
		if((stackedArea.isEmpty()) && (test)) {
			System.err.println("*** Warning ChartTypeChooser::" +
			"SetStackedAreaChartImage():: image is set to an empty string.");
		}
		if ((stackedArea.length() > MAX_SIZE) && (test)) {
		  	System.err.println("*** Warning ChartTypeChooser::" +
		  	"SetStackedAreaChartImage():: image is a very long name.");
		}
		else if (test) {
		  	System.out.println("ChartTypeChooser:: " +
		   	"SetStackedAreaChartImage():: chosen image is set to: " 
		  	+ stackedArea);
		}
		m_StackedAreaChartImage = stackedArea;
	}	
		
	/**
	* Create the interface of buttons, allowing a chart to be created
	*/	
	public Container createInterface(){
		ChartTypeInterface.setLayout(new GridLayout(4,2,20,20));
		
		MakePie();
		MakeXYSpline();
		MakeStacked();
		MakeScatter();
		MakeLine();
		MakeBubble();
		MakeBar();
		MakeBar3D();
					
		return ChartTypeInterface;
	}
	
	/**
	 * Makes the Bar Chart button
	 */
	public void MakeBar() {
		BarButton = new JButton(
				  new ImageIcon(getClass().getResource(GetBarChartImage())));	
		BarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new BarChart(
					GetHost().GetGraphData(), 
					"Bar chart", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new BarChart(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}
			}
		});
		
		ChartTypeInterface.add(BarButton);	
	}
	
	/**
	 * Makes the 3D Bar Chart button
	 */
	public void MakeBar3D() {
		BarButton3D = new JButton(
				   new ImageIcon(getClass().getResource(
					Get3DBarChartImage())));
		BarButton3D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new BarChart3D(
					GetHost().GetGraphData(), 
					"3D Bar Chart", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new BarChart3D(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}
			}
		});		
		
		ChartTypeInterface.add(BarButton3D);
	}
	
	/**
	 * Makes the Bubble Chart button
	 */
	public void MakeBubble() {
		BubbleButton = new JButton(
				new ImageIcon(getClass().getResource(GetBubbleChartImage())));
		BubbleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetColumns().length >= 3){
					
					if(GetHost().GetTitle() == UNSET) {
						GetHost().LeftPanelContent(new BubbleChart(
						GetHost().GetGraphData(), 
						"Bubble Chart", 
						GetHost().GetColourScheme(), GetHost()));
					}else {
						GetHost().LeftPanelContent(new BubbleChart(
						GetHost().GetGraphData(), 
						GetHost().GetTitle(), 
						GetHost().GetColourScheme(), GetHost()));
					}
				} else {
					JOptionPane.showMessageDialog(null, 
					"You must have three columns selected to use this chart", 
					"Bubble Chart Format", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		ChartTypeInterface.add(BubbleButton);
	}
	
	/**
	 * Makes the Line Chart button
	 */
	public void MakeLine() {
		LineButton = new JButton(
				new ImageIcon(getClass().getResource(GetLineChartImage())));
		LineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new LineChart(
					GetHost().GetGraphData(), 
					"Line Chart", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new LineChart(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}				
			}
		});
		
		ChartTypeInterface.add(LineButton);
	}
	
	/**
	 * Makes the Pie Chart button
	 */
	public void MakePie() {
		PieButton = new JButton(
				  new ImageIcon(getClass().getResource(GetPieChartImage())));
		PieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				JPanel piecharts = new JPanel();
				piecharts.setLayout(new WrapLayout());
				piecharts.setSize(new Dimension(600,400));
				piecharts.setBackground(Color.WHITE);
				
				if(GetHost().GetColumns().length == 1){
					if(GetHost().GetTitle() == UNSET) {
						piecharts.add(new PieChart(GetHost().GetGraphData(), 
						"Pie Chart", 
						GetHost().GetColourScheme(), GetHost(), 0));
					}else {
							piecharts.add(new PieChart(
							GetHost().GetGraphData(), 
							GetHost().GetTitle(), 
							GetHost().GetColourScheme(), GetHost(), 0));
					}
				}else {
					if(GetHost().GetTitle() == UNSET) {
						
						for(int i = 1; i<GetHost().GetColumns().length; i++){
							SetIncrement(i);
							piecharts.add(new PieChart(
							GetHost().GetGraphData(), "Pie Chart", 
							GetHost().GetColourScheme(), GetHost(), i));
						}
					}else {
							for(int i=1;i<GetHost().GetColumns().length; i++){
								SetIncrement(i);
								piecharts.add(new PieChart(
								GetHost().GetGraphData(), 
								GetHost().GetTitle(), 
								GetHost().GetColourScheme(), GetHost(), i));
							}
					}
					
				}
				
			Holder = new JScrollPane();
			Holder.setPreferredSize(new Dimension(800,450));
			Holder.setViewportView(piecharts);
			Holder.setVisible(true);
				
			GetHost().LeftPanelContent(Holder);
			}
		});
		
		ChartTypeInterface.add(PieButton);	
	}
	
	/**
	 * Makes the Scatter Plot Chart button
	 */
	public void MakeScatter() {
		ScatterButton = new JButton(
				new ImageIcon(getClass().getResource(
				GetScatterPlotChartImage())));
		ScatterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new ScatterGraph(
					GetHost().GetGraphData(), 
					"Scatter Plot Chart ", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new ScatterGraph(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}
			}
		});
		
		ChartTypeInterface.add(ScatterButton);
	}
	
	/**
	 * Makes the Stacked Area Chart button
	 */
	public void MakeStacked() {
		StackedButton = new JButton(
				   new ImageIcon(getClass().getResource(
				   GetStackedAreaChartImage())));
		StackedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new StackedAreaChart(
					GetHost().GetGraphData(), 
					"Stacked Area Chart", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new StackedAreaChart(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}
			}
		});
		
		ChartTypeInterface.add(StackedButton);
	}
	
	/**
	 * Makes the XYSpline Chart button
	 */
	public void MakeXYSpline() {
		XYSplineButton = new JButton(
				  new ImageIcon(getClass().getResource(
				  GetXYSplineChartImage())));
		XYSplineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GetHost().instructionText.setVisible(false);
				GetHost().ExportEnabled();
				
				if(GetHost().GetTitle() == UNSET) {
					GetHost().LeftPanelContent(new XYSplineChart(
					GetHost().GetGraphData(), 
					"XYSpline Chart", 
					GetHost().GetColourScheme(),GetHost()));
				}else {
					GetHost().LeftPanelContent(new XYSplineChart(
					GetHost().GetGraphData(), 
					GetHost().GetTitle(), 
					GetHost().GetColourScheme(),GetHost()));
				}
			}
		});
		
		ChartTypeInterface.add(XYSplineButton);	
	}
	
	/** A container which houses all of the chart buttons */
	Container ChartTypeInterface = new Container();
	/** A global variable object of the GUI class */
	private GUI m_Host;
	
	/** 
	 * Buttons used to populate the container and pass information 
	 * to the GUI class 
	 */
	private JButton PieButton;
	private JButton XYSplineButton;
	private JButton BarButton;
	private JButton StackedButton;
	private JButton ScatterButton;
	private JButton LineButton;		
	private JButton BubbleButton;
	private JButton BarButton3D;
	/** Holds the panel of pie charts */
	private JScrollPane Holder;
	/** Variables used to locate the button images used */
	private String m_PieChartImage;
	private String m_XYSplineChartImage;
	private String m_BarChartImage;
	private String m_StackedAreaChartImage;
	private String m_ScatterPlotChartImage;
	private String m_LineChartImage;
	private String m_BubbleChartImage;
	private String m_3DBarChartImage;
	private static int m_Incrementer;
	/** The maximum size that a String passed can be */
	private final int MAX_SIZE = 30;
	/** A default string used to test that a field is unset */
	private final String UNSET = "Unset";
}