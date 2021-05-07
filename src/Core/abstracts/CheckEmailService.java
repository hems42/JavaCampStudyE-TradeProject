package Core.abstracts;

public interface CheckEmailService {

    boolean isValidMail(String e_mail);
    boolean isAlreadyUsedMail(String e_mail);
}
