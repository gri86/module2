package models;

import java.util.Objects;

public final class Users {
    private final int id;
    private final String name;
    private final int accNumber;
    private final double amount;


    public Users(int id, String name, int accNumber, double amount) {
        this.id = id;
        this.name = name;
        this.accNumber = accNumber;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accNumber=" + accNumber +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                accNumber == users.accNumber &&
                Double.compare(users.amount, amount) == 0 &&
                name.equals(users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accNumber, amount);
    }
}
