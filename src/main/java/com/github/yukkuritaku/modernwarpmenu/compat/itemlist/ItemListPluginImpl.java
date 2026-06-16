package com.github.yukkuritaku.modernwarpmenu.compat.itemlist;

import com.github.yukkuritaku.modernwarpmenu.ModernWarpMenu;
import com.github.yukkuritaku.modernwarpmenu.state.ModernWarpMenuState;
import com.operationpotato.itemlist.api.ExcludedScreensManager;
import com.operationpotato.itemlist.api.Plugin;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;

import java.util.Optional;

public class ItemListPluginImpl implements Plugin
{
    private static final String MOD_NAME = FabricLoader.getInstance()
        .getModContainer(ModernWarpMenu.MOD_ID)
        .orElseThrow()
        .getMetadata()
        .getName();
    
    @Override
    public void registerExcludedScreens(ExcludedScreensManager excludedScreensManager) {
        excludedScreensManager.addProvider(ContainerScreen.class, _ ->
            ModernWarpMenuState.isModernWarpMenuOpen() ? Optional.of(MOD_NAME) : Optional.empty());
    }
}
