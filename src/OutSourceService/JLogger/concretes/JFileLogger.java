package OutSourceService.JLogger.concretes;

import OutSourceService.JLogger.abstracts.JBaseLogger;

public class JFileLogger extends JBaseLogger {

    public JFileLogger() {
        loggerName="File";
    }

    @Override
    public void log(String logMessage) {
        super.log(logMessage);
    }
}
