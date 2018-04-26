package Project;


/*
 * need to add download the Reference library for the project 
 * Jfreechart download page: https://sourceforge.net/projects/jfreechart/files/
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
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
   
	public JPanel graph2( String title, Vector <Double> avgV,  Vector <String> time ) {
		
    	  final TimeSeries high = new TimeSeries("High");
    	  final TimeSeries average = new TimeSeries("Price");
    	  final TimeSeries low = new TimeSeries("Low");
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
    			   /*
    			   Calendar cal = Calendar.getInstance();
    			  
    				cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.get(i).split(":")[0]));
    				cal.set(Calendar.MINUTE,30);
    				//cal.set(Calendar.SECOND,0);
    				//cal.set(Calendar.MILLISECOND,0);
    				
    				Date day = cal.getTime();
    			   */
    		// Date day = new SimpleDateFormat("HH:MM").parse("9:30");
    		 try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time.get(i));
				
				hold =  avgV.get(i);
				average.addOrUpdate(new Day(date), round(hold,2));
    			//average.add( null, round(hold,2));
				high.addOrUpdate(new Day(date), round(hold1,2));
	    		low.addOrUpdate(new Day(date), round(hold2,2));
    			 //high.add(spacing*i, round(hold1,2));
    		//  low.add(spacing*i, round(hold2,2));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		  }
    		  
    	  }
    	  
    	  
    	 TimeSeriesCollection dataset = new TimeSeriesCollection(high); 
      	dataset.addSeries(low);
      	dataset.addSeries(average);
      	JFreeChart chart;
      	
      	chart = createChart2(dataset, title);
      	
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
 
  /*
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
  			   
  			  
  			   
  		// Date day = new SimpleDateFormat("HH:MM").parse("9:30");
  		 
  			 hold =  avgV.get(i);
  			average.add(spacing*i, round(hold,2));
  			 high.add(spacing*i, round(hold1,2));
  		 low.add(spacing*i, round(hold2,2));
  		  }
  		  
  	  }
  	  
  	  
  	XYSeriesCollection dataset = new XYSeriesCollection(high); 
    	dataset.addSeries(low);
    	dataset.addSeries(average);
    	JFreeChart chart;
    
    	chart = createChart2(dataset, title);
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
      */ 
    }
	
	
	public JPanel graph1( String title, Vector <Double> avgV) {
		
    
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
  			   
  			  
  			   
  		// Date day = new SimpleDateFormat("HH:MM").parse("9:30");
  		 
  			 hold =  avgV.get(i);
  			average.add(spacing*i, round(hold,2));
  			 high.add(spacing*i, round(hold1,2));
  		 low.add(spacing*i, round(hold2,2));
  		  }
  		  
  	  }
  	  
  	  
  	XYSeriesCollection dataset = new XYSeriesCollection(high); 
    	dataset.addSeries(low);
    	dataset.addSeries(average);
    	JFreeChart chart;
    	chart = createChart1(dataset, title);
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
	
	
	/*
	public static void main (String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,17);
		cal.set(Calendar.MINUTE,30);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		
		Date day = cal.getTime();
		//Date day = new SimpleDateFormat("HH:MM").parse(day.toString());
		 
		System.out.println(day);
		//day = new SimpleDateFormat("HH:MM").parse("9:45");
		//System.out.println(day.getHours()+":"+day.getHours());
	}
	*/
	

    private JFreeChart createChart1(final XYDataset dataset, String title) {
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
        ValueAxis axis = plot.getDomainAxis(); 
        //axis.setDateFormatOverride(null);
        //ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        //axis.setFixedAutoRange(60000.0);  // 60 seconds
        //axis = (DateAxis) plot.getRangeAxis();
       //// axis.setRange(0.0, 500.0); 
        NumberAxis xAxis = new NumberAxis();
        
       plot.setDomainAxis(axis);
          //result.getXYPlot().setDomainAxis(null);     
        //plot.setDomainAxis(null);
        return result;
    }
    private JFreeChart createChart2(final XYDataset dataset, String title) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
        		title , 
            "Time Interval", 
            "Price",
            dataset, 
            true, 
            true, 
            false
        );
        ///final XYPlot plot = result.getXYPlot();   
        return result;
    }
    /*
    @SuppressWarnings("unused")
	private JFreeChart createChart(final XYDataset dataset, String title, Vector <String> Time) {
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
    */


}



