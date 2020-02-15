package Actors;

import Catalog.Catalog;
import tr.TreasureRoom;

import java.util.Random;

public class King implements Runnable {
    private TreasureRoom tr;
    private Catalog log;
    private String name;

    public King(String name) {
        this.tr = TreasureRoom.getInstance();
        log = Catalog.getInstance();
        this.name = name;
    }

    @Override
    public void run() {
        Random r = new Random();
        int got;
        int price;
        while(true)
        {
            price = r.nextInt(1501) + 1000;
            log.partyAnnouncement(name);
            tr.acquireWrite();
            got = tr.get(price);
            tr.releaseWrite();

            if(got >= price)
                log.kingParties(name, tr.getNumberOfTakenGemstones(), got);
            else {
                log.kingCancels(price, got, name);
                try {
                    Thread.sleep(r.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(r.nextInt(1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
