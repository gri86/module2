package models;

import java.util.Map;

public class ATM {
    private String name;
    private Map value;

    public String getName() {
        return name;
    }

    public Map getValue() {
        return value;
    }

    public static class Builder{

        private ATM atm;

        public Builder(){
            atm = new ATM();
        }

        public Builder withName(String name){
            atm.name = name;
            return this;
        }

        public Builder addAtmValue(Map value){
            atm.value = value;
            return this;
        }

        public ATM build(){
            return this.atm;
        }

    }
}
