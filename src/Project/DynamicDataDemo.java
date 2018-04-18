package Project;


/*
 * need to add download the Reference library for the project 
 * Jfreechart download page: https://sourceforge.net/projects/jfreechart/files/
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JPanel;
import org.jfree.chart.plot.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYItemRenderer;
//import org.jfree.data.time.Millisecond;
//import org.jfree.data.time.Minute;
//import org.jfree.data.time.Month;
//import org.jfree.data.time.TimeSeries;
//import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
//import java.awt.BasicStroke;
//import demo.DynamicDataDemo1;


@SuppressWarnings("serial")
public class DynamicDataDemo extends JPanel {
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}


    /**
     * Constructs a new demonstration application.
     *
     * @param title  the frame title.
     */
   
	public JPanel graph2( String title, Vector <Double> avgV, String type ) {
		
    	  final XYSeries high = new XYSeries("High");
    	  final XYSeries average = new XYSeries("Price");
    	  final XYSeries low = new XYSeries("Low");
    	  double hold = 0;
    	  double hold1 = -1;
    	  double hold2 = 100000000;
    	  int spacing = 20;
    	  
    	 for (int i =0; i< avgV.size(); i++) {
    		   if (avgV.get(i) != -1 && avgV.get(i) != 0) {
    			   if (hold1 < avgV.get(i)) {
    				   hold1 =  avgV.get(i);
    			   }
    		 
    			   if (hold2 > avgV.get(i)) {
    				   hold2 =  avgV.get(i);
    				   //System.out.println(hold2);
    			   }
    		 
    			 hold =  avgV.get(i);
    			 average.add(spacing*i, round(hold,2));
    			 high.add(spacing*i, round(hold1,2));
    		  low.add(spacing*i, round(hold2,2));
    		  }
    		  
    	  }
    	  
    	  
      	XYSeriesCollection dataset = new XYSeriesCollection(high); 
      	dataset.addSeries(low);
      	dataset.addSeries(average);
      	JFreeChart chart = createChart(dataset, title);
      	chart.getPlot().setBackgroundPaint( Color.BLACK );
        ChartPanel chartPanel = new ChartPanel(chart);
       // chartPanel.overlayChanged(event);
        
        JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        //content.add(button, BorderLayout.SOUTH);
        chartPanel.setPreferredSize(new java.awt.Dimension(375, 320));
        //setContentPane(content)
        //this.add(content);
        return content;
 
        
    }
	

    private JFreeChart createChart(final XYDataset dataset, String title) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
        		title , 
            "Time Interval", 
            "Price",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis(); 
        axis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        //ValueAxis axis = plot.getDomainAxis();
        //axis.setAutoRange(true);
        //axis.setFixedAutoRange(60000.0);  // 60 seconds
        //axis = (DateAxis) plot.getRangeAxis();
       // axis.setRange(0.0, 500.0); 
       // NumberAxis xAxis = new NumberAxis();
        plot.setDomainAxis(axis);
        return result;
    }
    


}



