package Core.abstracts;

public interface ValidationService {


    boolean isValidName(String s);
    boolean isValidSurName(String s);
       boolean isValidEmailFormat(String s);
       boolean isValidPassword(String s);
}
