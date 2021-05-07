package Core.concretes;


import Core.abstracts.CheckEmailService;
import OutSourceService.JCheckEmailOutSourceService.JCheckEmailManager;

public class JCheckEmailServiceAdapter implements CheckEmailService {

    @Override
    public boolean isValidMail(String e_mail) {


        return new JCheckEmailManager().isValidMail(e_mail);
    }
}
