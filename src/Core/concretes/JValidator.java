package Core.concretes;

import Core.abstracts.ValidationService;

public class JValidator implements ValidationService {
    @Override
    public boolean isValid(String s) {
        return false;
    }
}
