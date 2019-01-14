package gui.view.ganttchart;

import gui.event.myDateEvent.StatusEvent;
import gui.model.date.Status;
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
    protected List<Status> statusList;

    private AtomicInteger tick = new AtomicInteger(0);
    public static volatile boolean ready = false;


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

        for (int i = 0; i < n; i++) {
            threads.add("Thread " + (i + 1));
            XYChart.Series serie = new XYChart.Series();
            serie.getData().add(new XYChart.Data(0, threads.get(i), new GanttChart.ExtraData(0, "status-blue")));
            seriesList.add(serie);
            chart.getData().add(seriesList.get(i));
        }

        chart.getStylesheets().add("ganttchart.css");

    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof StatusEvent) {
            if (ready)
                if (((StatusEvent) event).getData() != null)
                    for (int i = 0; i < seriesList.size(); i++) {
                        final int counter = i;
                        if (((StatusEvent) event).getData().getThreadId() == (i + 1)) {
                            if (((StatusEvent) event).getData().getStatus().equalsIgnoreCase("SCHEDULING")) {
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
                    }
        }
    }


//    //Funzione per eliminare i dati da gant
//    @Override
//    public void run() {
//
//
//        while (isRunning) {
//            try {
//                Thread.sleep(200);
//                for (int i = 0; i < seriesList.size(); i++) {
//                    final int counter = i;
//                    if (statusList.get(counter).getStatus().equalsIgnoreCase("SCHEDULING"))
//                        Platform.runLater(() -> {
//                            seriesList.get(counter).getData().add(new XYChart.Data<>(tick.getAndIncrement(), threads.get(counter), new GanttChart.ExtraData(1, "status-blue")));
//                            chart.getData().retainAll(seriesList);
//                            try {
//                                chart.getData().add(seriesList.get(counter));
//                            } catch (IllegalArgumentException e) {
//
//                            }
//                        });
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//
//    }

    public GanttChart<Number, String> getChart() {
        return chart;
    }

    public void setGanttList(List<Status> statusList) {
        this.statusList = statusList;
    }
}
