package com.github.DarkVanityOfLight.AntiMobs

import com.github.DarkVanityOfLight.AntiMobs.listeners.EntitySpawn
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(){

    override fun onEnable() {

        Bukkit.getPluginManager().registerEvents(EntitySpawn(), this)
    }
}