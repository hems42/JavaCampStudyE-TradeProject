package Core.concretes;

import Core.abstracts.LoggerService;
import OutSourceService.JLogger.abstracts.JBaseLogger;
import OutSourceService.JLogger.concretes.JDataJBaseLogger;
import OutSourceService.JLogger.concretes.JEmailLoggerJ;
import OutSourceService.JLogger.concretes.JFileLogger;
import OutSourceService.JLogger.concretes.JSmsLoggerJ;

public class JLoggerAdapter implements LoggerService {





    @Override
    public void logDatabase(String logMessage) {

        new JDataJBaseLogger().log(logMessage);
    }

    @Override
    public void logEmail(String logMessage) {

        new JEmailLoggerJ().log(logMessage);
    }

    @Override
    public void logSms(String logMessage) {

        new JSmsLoggerJ().log(logMessage);

    }

    @Override
    public void logFile(String logMessage) {

        new JFileLogger().log(logMessage);

    }
}
