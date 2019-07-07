package hello.entity;

public class Account {
    private String id;
    private String number;
    private Double amount;
    private String holder;

    public Account(String id, String number, Double amount, String holder) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.holder = holder;
    }

    public Account(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
