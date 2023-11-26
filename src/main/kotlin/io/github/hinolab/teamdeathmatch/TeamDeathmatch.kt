package io.github.hinolab.teamdeathmatch

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import io.github.hinolab.teamdeathmatch.config.MainConfig
import hazae41.minecraft.kutils.bukkit.init

class TeamDeathmatch : AbstractTeamDeathmatch()
{
    companion object
    {
        lateinit var plugin: TeamDeathmatch
    }

    override fun onLoad()
    {
        plugin = this

        CommandAPI.onLoad(CommandAPIBukkitConfig(plugin).verboseOutput(true))
    }

    override fun onEnable()
    {
        init(MainConfig)
        MainConfig.autoSave = true

        CommandAPI.onEnable()
    }

    override fun onDisable()
    {
        CommandAPI.onDisable()
    }
}
