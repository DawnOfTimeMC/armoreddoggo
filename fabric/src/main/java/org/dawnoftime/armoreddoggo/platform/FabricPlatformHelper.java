package org.dawnoftime.armoreddoggo.platform;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEnchantmentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import org.dawnoftime.armoreddoggo.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
