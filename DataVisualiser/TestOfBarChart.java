import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.Dataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class TestOfBarChart extends ApplicationFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor.
	 *
	 * @param title the frame title.
	 */
	public TestOfBarChart(String title) {
		super(title);
		setContentPane(createDemoPanel());
	}
	/**
	 * Creates a sample dataset.
	 * 
	 * @return A sample dataset.
	 */
	private static DefaultCategoryDataset createDataset() {
		//DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		final String series1 = "First";
		final String series2 = "Second";
		final String series3 = "Third";

		// column keys...
		final String category1 = "Category 1";
		final String category2 = "Category 2";
		final String category3 = "Category 3";
		final String category4 = "Category 4";
		final String category5 = "Category 5";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, series1, category1);
		dataset.addValue(4.0, series1, category2);
		dataset.addValue(3.0, series1, category3);
		dataset.addValue(5.0, series1, category4);
		dataset.addValue(5.0, series1, category5);

		dataset.addValue(5.0, series2, category1);
		dataset.addValue(7.0, series2, category2);
		dataset.addValue(6.0, series2, category3);
		dataset.addValue(8.0, series2, category4);
		dataset.addValue(4.0, series2, category5);

		dataset.addValue(4.0, series3, category1);
		dataset.addValue(3.0, series3, category2);
		dataset.addValue(2.0, series3, category3);
		dataset.addValue(3.0, series3, category4);
		dataset.addValue(6.0, series3, category5);
		return dataset; 
	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset the dataset.
	 * 
	 * @return A chart.
	 */
	private static JFreeChart createChart(DefaultCategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart(
			"Test Bar Chart",						//	Chart title
			"Test Data",	// 	Domain/x axis label
			"Numerical Value", 			// 	Range/y axis label 
			(CategoryDataset) dataset,	//	Data
			PlotOrientation.VERTICAL,	//	Orientation
			true, //Include legend
			true,				//	Include tooltips
			false);				//	Do not include URLs

			
			//CategoryPlot plot = chart.getCategoryPlot(); 
			
		   // BarRenderer barRenderer = (BarRenderer)plot.getRenderer();


		    return chart;
		}

	/**
	 * Creates a panel for the demo (used by SuperDemo.java).
	 * 
	 * @return A panel.
	 */
	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());

		return new ChartPanel(chart);
	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args ignored.
	 */
	public static void main(String[] args) {
		TestOfBarChart demo = new TestOfBarChart("Bar Chart Test One");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
