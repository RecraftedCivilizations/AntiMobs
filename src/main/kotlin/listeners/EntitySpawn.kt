package com.github.DarkVanityOfLight.AntiMobs.listeners

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class EntitySpawn : Listener{

    @EventHandler
    fun onEntitySpawn(event: EntitySpawnEvent){
        if (event.entity is LivingEntity && event.entity !is  Player){
            //TODO Check if entity is in faction area
        }
    }
}