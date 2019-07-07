package composite;


/**
 * Team
 * id
 * name
 * Workers
 */
public class App {

    public static void main(String[] args) {

        Manager manager = new BusinessManager();
        Tester tester = new QATester();
        Developer dev1 = new JavaDeveloper();
        Developer dev2 = new JSDeveloper();

        Team team = new BankProjectTeam().new Builder()
                .addManager(manager)
                .addDeveloper(dev1)
                .addDeveloper(dev2)
                .addDeveloper(dev1)
                .build();

        team.work();


    }

}
