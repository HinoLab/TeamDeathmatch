package io.github.hinolab.teamdeathmatch

import io.github.hinolab.teamdeathmatch.config.MainConfig
import hazae41.minecraft.kutils.bukkit.init

class TeamDeathmatch : AbstractTeamDeathmatch()
{
    companion object
    {
        lateinit var plugin: TeamDeathmatch
    }

    override fun onEnable()
    {
        plugin = this

        init(MainConfig)
        MainConfig.autoSave = true
    }

    override fun onDisable()
    {
    }
}
