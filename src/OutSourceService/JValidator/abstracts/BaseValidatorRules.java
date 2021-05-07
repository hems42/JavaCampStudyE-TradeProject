package OutSourceService.JValidator.abstracts;



public interface BaseValidatorRules {


    boolean isValidLength(String s, int requiredCount);
    boolean isValidForm(String s, String requiredForm);
    boolean isContainDigit(String s) ;
    boolean isContainCharacter(String s) ;




}
