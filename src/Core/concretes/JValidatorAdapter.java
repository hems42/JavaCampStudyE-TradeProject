package Core.concretes;

import Core.abstracts.ValidationService;
import Entities.concretes.TestingDataBase;
import OutSourceService.JValidator.cocretes.JValidatorRules;


public class JValidatorAdapter implements ValidationService {

    private JValidatorRules jValidatorRules;



    public JValidatorAdapter() {

        jValidatorRules= new JValidatorRules();
    }



    @Override
    public boolean isValidName(String s) {

        boolean result = false;

        if(!jValidatorRules.isContainDigit(s))
        {
            if(jValidatorRules.isValidLength(s,2))
            {
                result=true;
            }
            else {
                fastLog(" Girilen ismin karakter uzunluğu en az iki olmalıdır!!");
            }
        }
        else
        {
            fastLog(" Girilen ismin için harf olmayan karakterler bulunmaktadır!!!");
        }
        return result;
    }

    @Override
    public boolean isValidSurName(String s) {
        boolean result = false;

        if(!jValidatorRules.isContainDigit(s))
        {
            if(jValidatorRules.isValidLength(s,2))
            {
                result=true;
            }
            else {
               fastLog(" Girilen  soy ismin karakter uzunluğu en az iki olmalıdır!!");
            }
        }
        else
        {
            fastLog(" Girilen soy ismin için harf olmayan karakterler bulunmaktadır!!!");
        }
        return result;
    }

    @Override
    public boolean isValidEmailFormat(String s) {

        if(jValidatorRules.isValidForm(s,"([a-zA-Z0-9])+\\@([a-zA-Z0-9])+\\.[a-zA-Z]{2,}"))
        {
            return  true;
        }
        else {


            fastLog("Girdiğiniz  e-mail adresi geçerli e-mail formatında değildir!!!");
            return false;
        }

    }

    @Override
    public boolean isValidPassword(String s) {
        if(jValidatorRules.isValidLength(s,6))
        {
            return  true;
        }
        else
        {
            fastLog("Oluşturulacak parola en az 6 karakterden oluşmalıdır!!!");
            return false;
        }

    }

    private void fastLog(String message)
    {
        TestingDataBase.createdLogList2.add(message);
    }
}
