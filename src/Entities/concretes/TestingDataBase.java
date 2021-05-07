package Entities.concretes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestingDataBase {


    public final static  String TAG_NAME="name";
    public final static  String TAG_SURNAME="surname";
    public final static  String TAG_EMAIL_FORMAT ="email_format";
    public final static  String TAG_EMAIL_EXIST ="email_exixts";
    public final static  String TAG_EMAIL_ALREADY ="email_already";
    public final static  String TAG_PASSWORD="password";

    public  static ArrayList<String> createdEmailList= new ArrayList<>();
    public  static ArrayList<String> createdLogList2= new ArrayList<>();
    public  static ArrayList<User> createdUserList= new ArrayList<>();

    // using for swing uı , as you know no_db...
    public  static Map<String,String> createdLogList= new HashMap<>();
}
