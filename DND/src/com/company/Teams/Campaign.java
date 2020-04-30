package com.company.Teams;

import com.company.Creatures.Ranger;
import com.company.Creatures.Warrior;
import com.company.Creatures.Wizard;
import com.company.Events.DataExtractor;
import com.company.Events.Map;

public class Campaign extends Group {
    public Campaign(int x,int y) {
        DataExtractor csvScanner = DataExtractor.getInstance();
        nr_member = csvScanner.getCompanionCount();
        for (int i = 0; i < nr_member; i++) {
            String companion_name = csvScanner.getCompanionInfo(i, "Name");
            String companion_race = csvScanner.getCompanionInfo(i, "Race");
            if (companion_race.equals("Ranger")) members.add(new Ranger(companion_name));
            if (companion_race.equals("Warrior")) members.add(new Warrior(companion_name));
            if (companion_race.equals("Wizard")) members.add(new Wizard(companion_name));
        }
        this.setPoz(x, y);
        Map.setCampaign(this);
    }
}
