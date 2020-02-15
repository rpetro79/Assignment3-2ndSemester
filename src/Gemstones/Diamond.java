package Gemstones;

public class Diamond implements Valuables {

    @Override
    public String getName() {
        return "Gemstones.Diamond";
    }

    @Override
    public int getValue() {
        return 25;
    }
}
