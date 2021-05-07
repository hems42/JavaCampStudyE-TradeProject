package Core.abstracts;

public interface LoggerService {


    void logDatabase(String logMessage);
    void logEmail(String logMessage);
    void logSms(String logMessage);
    void logFile(String logMessage);

}
