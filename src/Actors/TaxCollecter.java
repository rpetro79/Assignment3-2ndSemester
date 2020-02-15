package Actors;

import Catalog.Catalog;
import Gemstones.ValuableFactory;
import Gemstones.Valuables;
import tr.TreasureRoom;

import java.util.ArrayList;
import java.util.Random;

public class TaxCollecter implements Runnable{
    private ArrayList<String> gems;
    private TreasureRoom tr;
    private ValuableFactory factory;
    private Catalog log;
    private String name;

    public TaxCollecter(String name) {
        tr = TreasureRoom.getInstance();
        gems = new ArrayList<String>();
        gems.add("Diamond");
        gems.add("Emerald");
        gems.add("Ruby");
        gems.add("Sapphire");
        factory = new ValuableFactory();
        log = Catalog.getInstance();
        this.name = name;
    }

    @Override
    public void run() {
        ArrayList<Valuables> val = new ArrayList<Valuables>();
        int target, collected = 0;
        Random r = new Random();
        Valuables v;
        while(true)
        {
            val = new ArrayList<Valuables>();
            target = r.nextInt(751) + 50;
            while(collected < target)
            {
                v = factory.getGem(gems.get(r.nextInt(4)));

                val.add(v);
                collected += v.getValue();
                try {
                    Thread.sleep(r.nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            tr.acquireWrite();
            tr.add(val);
            tr.releaseWrite();

            log.taxCollecterAdds(name, val.size(), collected);

            collected = 0;
            try {
                Thread.sleep(r.nextInt(1000) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
