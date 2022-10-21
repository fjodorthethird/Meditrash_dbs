//package com.mediTrash.app.Tools.StatisticCreator;
//
//import com.mediTrash.app.Data.Trash;
//import com.mediTrash.app.Tools.Methods.getTrash;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PiePlot3D;
//import org.jfree.chart.util.Rotation;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.general.PieDataset;
//
//import javax.swing.*;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PieChart extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private getTrash trash = new getTrash();
//    private List<Trash> trashList = new ArrayList<>(trash.getTrash(1));
//
//    public PieChart(String applicationTitle, String chartTitle) throws SQLException {
//        super(applicationTitle);
//        // This will create the dataset
//        PieDataset dataset = createDataset();
//        // based on the dataset we create the chart
//        JFreeChart chart = createChart(dataset, chartTitle);
//        // we put the chart into a panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        // default size
//        chartPanel.setPreferredSize(new java.awt.Dimension(900, 800));
//        // add it to our application
//        setContentPane(chartPanel);
//    }
//
//    private PieDataset createDataset() throws SQLException {
//        DefaultPieDataset result = new DefaultPieDataset();
//        result.setValue(trashList.get(0).getNameOfTrash(), trashList.get(0).getCountOfTrash());
//        result.setValue(trashList.get(1).getNameOfTrash(), trashList.get(1).getCountOfTrash());
//        result.setValue(trashList.get(2).getNameOfTrash(), trashList.get(2).getCountOfTrash());
//        result.setValue(trashList.get(3).getNameOfTrash(), trashList.get(3).getCountOfTrash());
//        result.setValue(trashList.get(4).getNameOfTrash(), trashList.get(4).getCountOfTrash());
//        result.setValue(trashList.get(5).getNameOfTrash(), trashList.get(5).getCountOfTrash());
//        result.setValue(trashList.get(6).getNameOfTrash(), trashList.get(6).getCountOfTrash());
//        result.setValue(trashList.get(7).getNameOfTrash(), trashList.get(7).getCountOfTrash());
//        return result;
//
//    }
//
//    private JFreeChart createChart(PieDataset dataset, String title) {
//
//        JFreeChart chart = ChartFactory.createPieChart3D(
//                title,                  // chart title
//                dataset,                // data
//                false,                   // include legend
//                false,
//                false
//        );
//
//        PiePlot3D plot = (PiePlot3D) chart.getPlot();
//        plot.setStartAngle(290);
//        plot.setDirection(Rotation.CLOCKWISE);
//        plot.setForegroundAlpha(0.5f);
//        return chart;
//    }
//
//}
