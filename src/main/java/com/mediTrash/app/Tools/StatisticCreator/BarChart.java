//package com.mediTrash.app.Tools.StatisticCreator;
//
//import com.mediTrash.app.Data.Trash;
//import com.mediTrash.app.Tools.Methods.getTrash;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import javax.swing.*;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BarChart extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private getTrash trash = new getTrash();
//    private List<Trash> trashList = new ArrayList<>(trash.getTrash(1));
//
//    public BarChart(String appTitle) throws SQLException {
//        super(appTitle);
//
//        // Create Dataset
//        CategoryDataset dataset = createDataset();
//
//        //Create chart
//        JFreeChart chart= ChartFactory.createBarChart(
//                "Počet ročně", //Chart Title
//                "", // Category axis
//                "", // Value axis
//                dataset,
//                PlotOrientation.VERTICAL,
//                true,false,false
//        );
//
//        ChartPanel panel=new ChartPanel(chart);
//        setContentPane(panel);
//    }
//
//
//
//    private CategoryDataset createDataset() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(trashList.get(0).getCountOfTrash(), trashList.get(0).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(1).getCountOfTrash(), trashList.get(1).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(2).getCountOfTrash(), trashList.get(2).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(3).getCountOfTrash(), trashList.get(3).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(4).getCountOfTrash(), trashList.get(4).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(5).getCountOfTrash(), trashList.get(5).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(6).getCountOfTrash(), trashList.get(6).getNameOfTrash(), "");
//        dataset.addValue(trashList.get(7).getCountOfTrash(), trashList.get(7).getNameOfTrash(), "");
//
//        return dataset;
//    }
//
//}
