package navy.warspite.minecraft.redshot.commands

import navy.warspite.minecraft.redshot.LoadWeapons
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

object TabComplete : TabCompleter {
    private val commands = CommandRegister.commands.keys
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {
        return when {
            args.size > 2 -> {
                when (args[0]) {
                    "get" -> LoadWeapons.weaponJson.keys.toMutableList()
                    "give" -> LoadWeapons.weaponJson.keys.toMutableList()
                    else -> mutableListOf()
                }
            }
            args.size > 1 -> {
                when (args[0]) {
                    "get" -> LoadWeapons.weaponJson.keys.toMutableList()
                    "give" -> Bukkit.getOnlinePlayers().map { it.name }.toMutableList()
                    else -> mutableListOf()
                }
            }
            args.isNotEmpty() -> {
                this.commands.toMutableList()
            }
            else -> null
        }
    }
}