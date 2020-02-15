package Catalog;

public class Catalog {
    private static Catalog instance;

    private Catalog() {
    }

    public static Catalog getInstance() {
        if(instance == null)
            instance = new Catalog();
        return instance;
    }

    public void accountantRead(String name, int number, int value)
    {
        System.out.println("Accountant " + name + " counted " + number + " gemstones, worth of " + value + ".");
    }

    public void kingParties(String name, int number, int value)
    {
        System.out.println("His majesty, King" + name + ", throws a party! " + number + " gemstones taken, worth of " + value + ".");
    }

    public void taxCollecterAdds(String name, int number, int value)
    {
        System.out.println("Tax collecter " + name + " added " + number + " gems, worth of " + value + ".");
    }

    public void kingCancels(int neededValue, int value, String name)
    {
        System.out.println("King " + name + " regrets to announce that the party is cancelled due to lack of resources. Needed value: " + neededValue + ", owned value: " + value + ".");
    }

    public void partyAnnouncement(String name)
    {
        System.out.println("His majesty, King " + name + ", announces an upcoming party!");
    }
}
