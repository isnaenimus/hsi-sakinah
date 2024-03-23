package com.dicoding.hsisakinah.data

import com.dicoding.hsisakinah.model.Partner

class Datasource() {
    fun loadPartners(): List<Partner> {
        return listOf(
            Partner("HTS0001", "Aisyah", 18, "Pekalongan"),
            Partner("HTS0002", "Adinda", 21, "Jakarta"),
            Partner("HTS0003", "Indriani", 19, "Gorontalo"),
            Partner("HTS0004", "Chandra", 25, "Jambi"),
            Partner("HTS0005", "Ummu Sualim", 27, "Pekalongan"),
            Partner("HTS0006", "Adinda", 21, "Jakarta"),
            Partner("HTS0007", "Windriani", 19, "Gorontalo"),
            Partner("HTS0008", "Zainab", 25, "Jambi"),
        )
    }
}