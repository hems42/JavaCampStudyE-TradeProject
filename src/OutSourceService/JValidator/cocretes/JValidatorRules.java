package OutSourceService.JValidator.cocretes;

import OutSourceService.JValidator.abstracts.BaseValidatorRules;

import java.util.regex.Pattern;

public class JValidatorRules implements BaseValidatorRules {


    @Override
    public boolean isValidLength(String s, int requiredCount)
    {
        if (s.length() < requiredCount) {
            return false;
        } else {

            return true;

        }
    }


    @Override
    public boolean isContainDigit(String s)
    {

        if(Pattern.matches("[0-9]",s))
        {
            return true;
        }
        else
        {
            return  false;
            }
        }


    @Override
    public boolean isContainCharacter(String s)
    {
        if(Pattern.matches("[a-zA-ZğĞçÇşŞüÜöÖıİ]",s))
        {
            return true;
        }
        else
        {
            return  false;
        }
    }


    @Override
    public boolean isValidForm(String s, String requiredForm)
    {

        if (Pattern.matches(requiredForm,s)) {
            return true;
        }
        else {

            return false;
        }




    }

}