package Actors;

import Catalog.Catalog;
import tr.TreasureRoom;

import java.util.ArrayList;
import java.util.Random;

public class Accountant implements Runnable{
    private TreasureRoom tr;
    private Catalog log;
    private String name;

    public Accountant(String name) {
        tr = TreasureRoom.getInstance();
        log = Catalog.getInstance();
        this.name = name;
    }

    @Override
    public void run() {
        Random r = new Random();
        int newOne = 0;

        while(true)
        {
            tr.acquireRead();
            newOne = tr.doRead();
            log.accountantRead(name, newOne, tr.getTotalValue());
            tr.releaseRead();
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
