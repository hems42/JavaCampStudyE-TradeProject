package Core.concretes;

import Core.abstracts.EmailTransferService;
import OutSourceService.JEMailTransferManagerOutSourceService.JEMailTransferManager;

public class JMailTransferManagerOutSourceServiceAdapter implements EmailTransferService {
    @Override
    public void sendMail(String mail,String mailAdress) {

        new JEMailTransferManager().sendMail(mail,mailAdress);
    }

    @Override
    public void getMail() {

    }
}
