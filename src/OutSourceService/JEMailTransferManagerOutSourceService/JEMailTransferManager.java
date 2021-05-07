package OutSourceService.JEMailTransferManagerOutSourceService;

import Entities.concretes.TestingDataBase;

public class JEMailTransferManager {

    public void sendMail(String emailMessage, String eMailAdress)
    {

        TestingDataBase.createdLogList2.add(eMailAdress+ "  adresine "+ emailMessage + "  e-mail olarak " +
                "yollanmıştır");
    }
}
