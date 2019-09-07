package com.example.alassane.todocoach

import java.util.*

class OldTaskCategory(name : String, period: String)
{
    var categoryName = name
    var categoryPeriod = period
    var period: Int = 1
    var position = 0
    var list: MutableList<Task> = ArrayList()

    init {
        if (categoryPeriod == "Matin")
            this.period = 1
        if (categoryPeriod == "Midi")
            this.period = 2
        if (categoryPeriod == "Après-midi")
            this.period = 3
        if (categoryPeriod == "Soir")
            this.period = 4
        if (categoryPeriod == "Journée")
            this.period = 5
    }
}