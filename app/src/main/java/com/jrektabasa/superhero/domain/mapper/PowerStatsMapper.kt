package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.PowerStatsResponse
import com.jrektabasa.superhero.domain.model.PowerStats
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PowerStatsMapper @Inject constructor() {

    fun mapToDomain(response: PowerStatsResponse): PowerStats {
        return PowerStats(
            response.combat,
            response.durability,
            response.intelligence,
            response.power,
            response.speed,
            response.strength,
        )
    }
}