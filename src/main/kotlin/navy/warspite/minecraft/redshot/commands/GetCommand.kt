package navy.warspite.minecraft.redshot.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object GetCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            Messages.playersCommand(sender)
            return false
        }
        return when {
            args.size > 1 -> {
                for (arg in args.copyOfRange(1, args.size)) {
                    GiveWeapon.give(sender, arg)
                }
                true
            }
            else -> {
                Messages.notEnteredWeapon(sender)
                false
            }
        }
    }
}