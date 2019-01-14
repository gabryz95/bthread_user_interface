package gui.model;

import gui.event.NewLineReadEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

public class OutputProcessingThread extends Observable implements Runnable {

    protected AtomicBoolean isMonitoring = new AtomicBoolean(false);
    protected Process process;
    protected Parser parser;

    public static OutputProcessingThread create(final Parser parser) {
        if (parser == null)
            return null;

        OutputProcessingThread outputProcessingThread = new OutputProcessingThread();
        outputProcessingThread.parser = parser;
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

    public void setProcess(Process process) {
        this.process = process;
    }

    void setIsMonitoring(boolean flag) {
        isMonitoring.set(flag);
    }
}
