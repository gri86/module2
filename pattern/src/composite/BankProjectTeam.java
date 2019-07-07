package composite;

import java.util.ArrayList;
import java.util.List;

public class BankProjectTeam implements Team {

    private Manager manager;
    private Tester tester;

    List<Developer> developers;


    public BankProjectTeam(){
        this.developers = new ArrayList<>();
    }


    @Override
    public void work() {
        developers.forEach(Developer::writeCode);
        tester.test();
        manager.manage();
    }

    public void addDeveloper(Developer developer){
        developers.add(developer);
    }

    public void deleteDeveloper(Developer developer){
        developers.remove(developer);
    }



    public class Builder{

        protected Builder(){}

        public Builder addDeveloper(Developer developer){
            BankProjectTeam.this.addDeveloper(developer);
            return this;
        }

        public Builder addTester(Tester tester){
            BankProjectTeam.this.tester = tester;
            return this;
        }

        public Builder addManager(Manager manager){
            BankProjectTeam.this.manager = manager;
            return this;
        }

        public BankProjectTeam build(){
            return BankProjectTeam.this;
        }

    }
}
