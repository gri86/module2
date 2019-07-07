package models;

import java.util.Objects;

public class Credentials {
    private int id;
    private final String login;
    private final String password;
    private final String role;


    public Credentials(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }
}
