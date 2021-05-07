package Core.concretes;

import Core.abstracts.CheckEmailService;
import OutSourceService.GoogleAccountOfMailService.GoogleAccountsManager;

public class GoogleAccountOfMailServiceAdapter implements CheckEmailService {
    @Override
    public boolean isValidMail(String e_mail) {
        return new GoogleAccountsManager().isValidMailAdress(e_mail);
    }
}
