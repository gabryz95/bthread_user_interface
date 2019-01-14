package gui.model;

import gui.event.NewLineReadEvent;
import gui.view.MainWindowView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

public class OutputProcessingThread extends Observable implements Runnable {

    protected AtomicBoolean isMonitoring = new AtomicBoolean(false);
    protected Process process;
    protected Parser parser;

    public static OutputProcessingThread create(final Process process, final ObserverList observerList, final Parser parser) {

        if (process == null)
            return null;

        if (observerList == null)
            return null;

        if (parser == null)
            return null;

        OutputProcessingThread outputProcessingThread = new OutputProcessingThread();
        outputProcessingThread.process = process;
        outputProcessingThread.parser = parser;
        for (int i = 0; i < observerList.size(); i++)
            outputProcessingThread.addObserver(observerList.getObserver(i));
        return outputProcessingThread;
    }


    @Override
    public void run() {
        InputStream input = process.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String line;
        Bthread bthread;
        try {
            while ((line = br.readLine()) != null) {
                Thread.sleep(100);
                bthread = Parser.parsing(line);
                parser.parsing2(line);
                if (bthread != null) {
                    if (bthread.getPid() != 0) {
                        if (isMonitoring.get()) {
                            this.setChanged();
                            notifyObservers(new NewLineReadEvent(line + "\n"));
                        }
                    }
                }
            }
            input.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void setIsMonitoring(boolean flag) {
        isMonitoring.set(flag);
    }
}
