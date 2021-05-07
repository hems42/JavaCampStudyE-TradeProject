package OutSourceService.JLogger.abstracts;


import Entities.concretes.TestingDataBase;

public abstract class JBaseLogger {

    protected String loggerName;




    public void log(String logMessage)
    {



        TestingDataBase.createdLogList2.add(loggerName+" loglandı : "+logMessage);
    }
}
