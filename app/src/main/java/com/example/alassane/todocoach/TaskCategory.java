package com.example.alassane.todocoach;

import java.util.ArrayList;

public class TaskCategory {
    String name;
    int period;
    String position;
    ArrayList list = new ArrayList<Task>();

    TaskCategory() {

    }

    TaskCategory(String name, String period) {
        this.name = name;
        if (period == "Matin")
            this.period = 1;
        if (period == "Midi")
            this.period = 2;
        if (period == "Après-midi")
            this.period = 3;
        if (period == "Soir")
            this.period = 4;
        if (period == "Journée")
            this.period = 5;
    }

    String getName()
    {
        return name;
    }

}
