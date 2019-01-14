package gui.view.ganttchart;

import gui.event.GanttEventScheduling;
import gui.event.GanttThreadEvent;

import javafx.application.Platform;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

public class GantChartInitialize implements Observer {


    protected final NumberAxis xAxis = new NumberAxis();
    protected final CategoryAxis yAxis = new CategoryAxis();
    protected final GanttChart<Number, String> chart = new GanttChart<>(xAxis, yAxis);

    private List<XYChart.Series> seriesList = new ArrayList<>();
    private static List<String> threads = new ArrayList<>();

    private AtomicInteger tick = new AtomicInteger(0);


    //funzione per inizializzare il gantt
    public static GantChartInitialize create() {
        final GantChartInitialize gantChartInitialize = new GantChartInitialize();
        gantChartInitialize.xAxis.setLabel("Time");
        gantChartInitialize.xAxis.setTickLabelFill(Color.CHOCOLATE);
        gantChartInitialize.xAxis.setMinorTickCount(100);

        gantChartInitialize.yAxis.setLabel("");
        gantChartInitialize.yAxis.setTickLabelFill(Color.CHOCOLATE);
        gantChartInitialize.yAxis.setTickLabelGap(10);


        gantChartInitialize.chart.setLegendVisible(false);
        gantChartInitialize.chart.setBlockHeight(50);
        return gantChartInitialize;
    }

    public void init(int n) {
        if (n == 0)
            return;

        if (seriesList.size() == 0) {
            for (int i = 0; i < n; i++) {
                threads.add("Thread " + (i + 1));
                XYChart.Series serie = new XYChart.Series();
                serie.getData().add(new XYChart.Data(0, threads.get(i), new GanttChart.ExtraData(0, "status-blue")));
                seriesList.add(serie);
                chart.getData().add(seriesList.get(i));
            }
        }
        chart.getStylesheets().add("ganttchart.css");
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof GanttEventScheduling) {
            for (int i = 0; i < seriesList.size(); i++) {
                final int counter = i;
                if (((GanttEventScheduling) event).getThreadNumber() == (i + 1)) {
                    Platform.runLater(() -> {
                        seriesList.get(counter).getData().add(new XYChart.Data<>(tick.getAndIncrement(), threads.get(counter), new GanttChart.ExtraData(1, "status-blue")));
                        chart.getData().retainAll(seriesList);
                        try {
                            chart.getData().add(seriesList.get(counter));
                        } catch (IllegalArgumentException e) {

                        }
                    });
                }
            }
        } else if (event instanceof GanttThreadEvent) {
            this.init(((GanttThreadEvent) event).getN());
        }
    }

    public GanttChart<Number, String> getChart() {
        return chart;
    }

}
