package atm.services;

import atm.exceptions.AuthException;
import atm.model.Account;

public class ConsoleAuthentification implements Auth {

    @Override
    public Account login(String login, String password) throws AuthException {
        throw new AuthException();
    }
}
