/*
 * SkinsRestorer
 *
 * Copyright (C) 2022 SkinsRestorer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package net.skinsrestorer.bukkit.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.skinsrestorer.api.SkinVariant;
import net.skinsrestorer.bukkit.SkinsRestorer;
import net.skinsrestorer.shared.commands.ISkinCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.skinsrestorer.bukkit.utils.WrapperBukkit.wrapCommandSender;
import static net.skinsrestorer.bukkit.utils.WrapperBukkit.wrapPlayer;

@RequiredArgsConstructor
@CommandAlias("skin")
@CommandPermission("%skin")
@SuppressWarnings({"unused"})
public class SkinCommand extends BaseCommand implements ISkinCommand {
    @Getter
    private final SkinsRestorer plugin;

    @Default
    public void onDefault(CommandSender sender) {
        onDefault(wrapCommandSender(sender));
    }

    @Default
    @CommandPermission("%skinSet")
    @Description("%helpSkinSet")
    @Syntax("%SyntaxDefaultCommand")
    public void onSkinSetShort(Player player, @Single String skin) {
        onSkinSetShort(wrapPlayer(player), skin);
    }

    @HelpCommand
    @Syntax("%helpHelpCommand")
    public void onHelp(CommandSender sender, CommandHelp help) {
        onHelp(wrapCommandSender(sender), help);
    }

    @Subcommand("clear")
    @CommandPermission("%skinClear")
    @Description("%helpSkinClear")
    public void onSkinClear(Player player) {
        onSkinClear(wrapPlayer(player));
    }

    @Subcommand("clear")
    @CommandPermission("%skinClearOther")
    @CommandCompletion("@players")
    @Syntax("%SyntaxSkinClearOther")
    @Description("%helpSkinClearOther")
    public void onSkinClearOther(CommandSender sender, @Single OnlinePlayer target) {
        onSkinClearOther(wrapCommandSender(sender), wrapPlayer(target.getPlayer()));
    }

    @Subcommand("search")
    @CommandPermission("%skinSearch")
    @Description("%helpSkinSearch")
    @Syntax("%SyntaxSkinSearch")
    public void onSkinSearch(CommandSender sender, String search) {
        onSkinSearch(wrapCommandSender(sender), search);
    }

    @Subcommand("update")
    @CommandPermission("%skinUpdate")
    @Description("%helpSkinUpdate")
    public void onSkinUpdate(Player player) {
        onSkinUpdate(wrapPlayer(player));
    }

    @Subcommand("update")
    @CommandPermission("%skinUpdateOther")
    @CommandCompletion("@players")
    @Description("%helpSkinUpdateOther")
    @Syntax("%SyntaxSkinUpdateOther")
    public void onSkinUpdateOther(CommandSender sender, @Single OnlinePlayer target) {
        onSkinUpdateOther(wrapCommandSender(sender), wrapPlayer(target.getPlayer()));
    }

    @Subcommand("set")
    @CommandPermission("%skinSet")
    @CommandCompletion("@skin")
    @Description("%helpSkinSet")
    @Syntax("%SyntaxSkinSet")
    public void onSkinSet(Player player, String[] skin) {
        onSkinSet(wrapPlayer(player), skin);
    }

    @Subcommand("set")
    @CommandPermission("%skinSetOther")
    @CommandCompletion("@players @skin")
    @Description("%helpSkinSetOther")
    @Syntax("%SyntaxSkinSetOther")
    public void onSkinSetOther(CommandSender sender, OnlinePlayer target, String skin, @Optional SkinVariant skinVariant) {
        onSkinSetOther(wrapCommandSender(sender), wrapPlayer(target.getPlayer()), skin, skinVariant);
    }

    @Subcommand("url")
    @CommandPermission("%skinSetUrl")
    @CommandCompletion("@skinUrl")
    @Description("%helpSkinSetUrl")
    @Syntax("%SyntaxSkinUrl")
    public void onSkinSetUrl(Player player, String url, @Optional SkinVariant skinVariant) {
        onSkinSetUrl(wrapPlayer(player), url, skinVariant);
    }
}
