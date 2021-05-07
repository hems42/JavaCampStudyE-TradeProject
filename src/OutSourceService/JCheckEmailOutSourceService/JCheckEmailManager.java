package OutSourceService.JCheckEmailOutSourceService;

import Entities.concretes.TestingDataBase;

public class JCheckEmailManager {
   public boolean isValidMail(String mailAdress)
    {
        TestingDataBase.createdLogList2.add(mailAdress+ " adresinin geçerlilği onaylanmıştır.");
       return true;
    }

}
