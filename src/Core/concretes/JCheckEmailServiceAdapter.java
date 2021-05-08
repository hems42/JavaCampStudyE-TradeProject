package Core.concretes;


import Core.abstracts.CheckEmailService;
import Entities.concretes.TestingDataBase;
import OutSourceService.JCheckEmailOutSourceService.JCheckEmailManager;

public class JCheckEmailServiceAdapter implements CheckEmailService {

    @Override
    public boolean isValidMail(String e_mail) {


        return new JCheckEmailManager().isValidMail(e_mail);
    }

    @Override
    public boolean isAlreadyUsedMail(String e_mail) {

        boolean result=false;

        for(String s:TestingDataBase.createdEmailList)
        {
            if(s.equals(e_mail))
            {
                result=true;
                TestingDataBase.createdLogList2.add(e_mail +
                        " adresi daha önce başka bir kayıtta kullanılmıştır lütfen başka bir mail hesabı kullanın!!!");
                break;
            }
        }

        if(result==false)
        {
            TestingDataBase.createdLogList2.add(e_mail + " adresi doğrulaması başarılı...");
        }

        return result;

    }

       /* boolean result=true;


        for (String s : TestingDataBase.createdEmailList) {

            if(s==e_mail)
            {
                result=false;
            }
        }
        return false;
    }*/
}
