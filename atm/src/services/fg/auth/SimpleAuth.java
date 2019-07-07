package services.fg.auth;

import app.Context;
import constants.Constants;
import exceptions.AuthException;
import models.Credentials;
import services.fg.logger.FileLogger;
import services.fg.logger.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SimpleAuth implements AuthService {

    private Logger log;

    private String login;
    private String password;

    public SimpleAuth(String login, String password){
        this.login = login;
        this.password = password;
        log = new FileLogger();
    }

    @Override
    public void authenticate() {
        try{

            List<Credentials> cred = getCredentialListFromFile(System.getProperty("user.dir")+"/resources/"+Constants.CREDENTIALS_DATA);
            for (Credentials user: cred) {
                if(user.getLogin().equals(this.login) && user.getPassword().equals(this.password)){
                    log.log("Пользователь: "+this.login+ " аутентифиуирован");
                    Context.isAuth = true;
                    Context.authUserId = user.getId();
                    return;
                }
            }
        }catch (AuthException ex){
            System.out.println(ex.getMessage());
            Context.isAuth =false;
        }
        Context.isAuth = false;
    }



    private List<Credentials> getCredentialListFromFile(String fileName) throws AuthException{
        List<Credentials> list = new ArrayList<>();
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null){
                String[] credArr = line.split("\\|");
                if(credArr.length < 4){
                    throw new AuthException("Ошибка парсинга данных о пользователе. Обратитесь в службу поддержки");
                }
                Integer id = Integer.parseInt(credArr[0]);
                list.add(new Credentials(id, credArr[1], credArr[2], credArr[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


}
