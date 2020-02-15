package tr;

import Gemstones.ValuableFactory;
import Gemstones.Valuables;

import java.util.ArrayList;

public class TreasureRoom {
    private ArrayList<Valuables> gems;
    private int activeReaders, waitingReaders, writers;
    private int previousSize;
    private static TreasureRoom instance;

    private TreasureRoom() {
        gems = new ArrayList<Valuables>();
        waitingReaders = 0;
        writers = 0;
        activeReaders = 0;
    }

    public static TreasureRoom getInstance()
    {
        if(instance == null)
            instance = new TreasureRoom();
        return instance;
    }

    public synchronized void acquireRead()
    {
        waitingReaders++;
        while(writers > 0)
        {
            try{
                wait();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        waitingReaders--;
        activeReaders++;
    }

    public synchronized void releaseRead()
    {
        activeReaders--;
        if(activeReaders == 0) notifyAll();
    }

    public synchronized void acquireWrite()
    {
        while(activeReaders > 0 || writers > 0 || waitingReaders > 0)
        {
            try {
                wait();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        writers++;
    }

    public synchronized void releaseWrite()
    {
        writers--;
        notifyAll();
    }

    public int doRead()
    {
        return gems.size();
    }

    public int get(int k)
    {
        previousSize = gems.size();
        int x = getTotalValue();
        if(x < k)
        {
            return x;
        }

        else{
            int value = 0;
            while(value < k)
            {
                value += gems.get(gems.size()-1).getValue();
                gems.remove(gems.size()-1);
            }
            return value;
        }
    }

    public int getNumberOfTakenGemstones()
    {
        return previousSize - gems.size();
    }

    public int getTotalValue()
    {
        int value = 0;
        for(int i = 0; i < gems.size(); ++i)
        {
            value += gems.get(i).getValue();
        }
        return value;
    }

    public void add(ArrayList<Valuables> newGems)
    {
        for(int i = 0; i < newGems.size(); ++i)
        {
            gems.add(newGems.get(i));
        }
    }
}
