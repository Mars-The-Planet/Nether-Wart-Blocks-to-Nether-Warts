package com.mars.netherwartblock.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.URI;

import static com.mars.netherwartblock.NetherWartConfig.show_wishful_recipes_message;

@Mixin(PlayerList.class)
public class PlayerListMixin {
    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    private void placeNewPlayer(Connection connection, ServerPlayer player, CommonListenerCookie cookie, CallbackInfo ci) {
        if (!show_wishful_recipes_message) return;

        Component msg = Component.literal("")
                .append(
                        Component.literal("Nether Wart Blocks to Nether Warts")
                                .withStyle(ChatFormatting.GREEN)
                                .withStyle(style -> style
                                        .withClickEvent(new ClickEvent.OpenUrl(URI.create("https://www.curseforge.com/minecraft/mc-mods/nether-wart-block-to-nether-warts")))
                                        .withHoverEvent(new HoverEvent.ShowText(Component.literal("The mod you are currently running")))
                                )
                )
                .append(
                        Component.literal(" is being deprecated and replaced by ")
                )
                .append(
                        Component.literal("Wishful Recipes")
                                .withStyle(ChatFormatting.GREEN)
                                .withStyle(style -> style
                                        .withClickEvent(new ClickEvent.OpenUrl(URI.create("https://www.curseforge.com/minecraft/mc-mods/wishful-recipes")))
                                        .withHoverEvent(new HoverEvent.ShowText(Component.literal("The mod you should definitely switch to :)")))                                )
                )
                .append(
                        Component.literal(". Wishful Recipes unifies all of my crafting mods into a single one, " +
                                "and dynamically adds recipes without you having to add each new recipe into its config. " +
                                "Please consider checking it out and switching to it here:\n")
                )
                .append(
                        Component.literal("[CurseForge]")
                                .withStyle(style -> style
                                        .withColor(0xFF6A00)
                                        .withUnderlined(true)
                                        .withBold(true)
                                        .withClickEvent(new ClickEvent.OpenUrl(URI.create("https://www.curseforge.com/minecraft/mc-mods/better-stairs-recipe")))
                                        .withHoverEvent(new HoverEvent.ShowText(Component.literal("https://www.curseforge.com/minecraft/mc-mods/wishful-recipes")
                                                .withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.UNDERLINE)))
                                )
                )
                .append(
                        Component.literal(" ")
                )
                .append(
                        Component.literal("[Modrinth]")
                                .withStyle(style -> style
                                        .withColor(0x119F36)
                                        .withUnderlined(true)
                                        .withBold(true)
                                        .withClickEvent(new ClickEvent.OpenUrl(URI.create("https://modrinth.com/mod/wishful-recipes")))
                                        .withHoverEvent(new HoverEvent.ShowText(Component.literal("https://modrinth.com/mod/wishful-recipes")
                                                .withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.UNDERLINE)))
                                )
                )
                .append(
                        Component.literal("\n(You can disable this message in this mod's config)")
                                .withStyle(ChatFormatting.GRAY)
                );

        player.sendSystemMessage(msg);
    }
}
