package com.github.DarkVanityOfLight.AntiMobs.listeners

import com.github.DarkVanityOfLight.AntiMobs.Main
import com.github.DarkVanityOfLight.AntiMobs.parsers.ConfigParser
import com.massivecraft.factions.Board
import com.massivecraft.factions.FLocation
import com.massivecraft.factions.Faction
import org.bukkit.entity.Monster
import org.bukkit.entity.Slime
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class EntitySpawn(private val configParser: ConfigParser) : Listener {

    @EventHandler(ignoreCancelled = true)
    fun onEntitySpawn(event: EntitySpawnEvent) {
        if (event.entity is Monster || event.entity is Slime) {
            val board: Board = Board.getInstance()
            val faction: Faction = board.getFactionAt(FLocation(event.entity.location))
            if ((faction.tag !in configParser.enabledSpawnFactions && !faction.isWilderness) ||
                (faction.isWilderness && !configParser.spawnInWilderness)) {
                event.isCancelled = true

                if (configParser.debug) {
                    Main.debugLog("Cancelled mob spawning")
                }
            }
        }
    }
}