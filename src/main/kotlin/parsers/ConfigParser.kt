package com.github.DarkVanityOfLight.AntiMobs.parsers

import com.github.DarkVanityOfLight.AntiMobs.Main
import com.massivecraft.factions.Faction
import org.bukkit.configuration.file.FileConfiguration


class ConfigParser(private val main: Main, private val config : FileConfiguration) {
    val enabledSpawnFactions : Set<String> = emptySet<String>().toMutableSet()
    var spawnInWilderness : Boolean = true
    var debug : Boolean = false

    init {
        main.saveDefaultConfig()
        main.reloadConfig()
    }

    fun reload(){
        enabledSpawnFactions.plus(config.getStringList("enabledSpawnFactions").toSet())
        spawnInWilderness = config.getBoolean("spawnInWilderness")
        debug = config.getBoolean("debug")
    }
}