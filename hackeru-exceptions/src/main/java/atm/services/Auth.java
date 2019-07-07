package atm.services;

import atm.exceptions.AuthException;
import atm.model.Account;

public interface Auth {
    Account login(String login, String password) throws AuthException;
}
