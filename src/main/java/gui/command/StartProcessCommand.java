package gui.command;

import java.io.IOException;


public class StartProcessCommand extends CommandAbs {

    @Override
    public void execute() throws IOException {
        if (filename != null) {
            receiver.startProcess(initProcess(filename), filename);
        }
    }

    protected Process initProcess(String fileName) {
        Runtime rt = Runtime.getRuntime();
        try {
            Process process = rt.exec(fileName);
            return process;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
