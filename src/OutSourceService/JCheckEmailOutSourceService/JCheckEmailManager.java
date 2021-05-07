package OutSourceService.JCheckEmailOutSourceService;

import Entities.concretes.CreatedEmails;

public class JCheckEmailManager {
   public boolean isValidMail(String mailAdress)
    {
        if(CreatedEmails.createdEmailList.contains(mailAdress))
        {
            System.out.println(mailAdress + " adresi daha önce başka bir kayıtta kullanılmıştır lütfen başka bir mail hesabı kullanın!!!");
            return false;
        }
        {
            System.out.println(mailAdress + " adresi doğrulaması başarılı...");


            return true;
        }

    }

}
