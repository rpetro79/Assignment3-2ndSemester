import Actors.Accountant;
import Actors.King;
import Actors.TaxCollecter;
import tr.TreasureRoom;

public class StartPeople {
    public static void main(String[] args) {
        King king = new King("Richard Lionheart");
        Accountant a1 = new Accountant("Isaac");
        Accountant a2 = new Accountant("Waldemar");
        TaxCollecter collecter1 = new TaxCollecter("Wamba");
        TaxCollecter collecter2 = new TaxCollecter("Wilfred");
        TaxCollecter collecter3 = new TaxCollecter("Cedric");
        TaxCollecter collecter4 = new TaxCollecter("Athelstane");
        TaxCollecter collecter5 = new TaxCollecter("Brian");

        Thread t1 = new Thread(king);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a2);
        Thread t6 = new Thread(collecter1);
        Thread t7 = new Thread(collecter2);
        Thread t8 = new Thread(collecter3);
        Thread t9 = new Thread(collecter4);
        Thread t10 = new Thread(collecter5);

        t1.start();
        t2.start();
        t3.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
