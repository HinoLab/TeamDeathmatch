package io.github.hinolab.teamdeathmatch

class TeamDeathmatch : AbstractTeamDeathmatch()
{
    companion object
    {
        lateinit var plugin: TeamDeathmatch
    }

    override fun onEnable()
    {
        plugin = this
    }

    override fun onDisable()
    {
    }
}
