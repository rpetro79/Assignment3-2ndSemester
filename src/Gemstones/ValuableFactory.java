package Gemstones;

import java.util.HashMap;

public class ValuableFactory {
    private static HashMap<String, Valuables> gems = new HashMap<>();

    public static Valuables getGem(String name)
    {
        Valuables gem = gems.get(name);

        if(gem == null)
        {
            switch(name)
            {
                case "Diamond": {
                    gem = new Diamond();
                    break;
                }
                case "Emerald": {
                    gem = new Emerald();
                    break;
                }
                case "Ruby": {
                    gem = new Ruby();
                    break;
                }
                case "Sapphire": {
                    gem = new Sapphire();
                    break;
                }
            }
            gems.put(name, gem);
        }
        return gem;
    }
}
