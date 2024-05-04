package org.dawnoftime.armoreddoggo.registry;

import java.util.ArrayList;
import java.util.List;

import org.dawnoftime.armoreddoggo.set.ArmorSet;
import org.dawnoftime.armoreddoggo.set.CenturionArmorSet;

public class DWArmorSetsRegistry {

    public static List<ArmorSet> REGISTRY = new ArrayList<>();
    public static CenturionArmorSet CENTURION_ARMOR;

    public static void register() {
        CENTURION_ARMOR = register(new CenturionArmorSet("centurion_armor"));
    }

    public static <T extends ArmorSet> T register(T set) {
        REGISTRY.add(set);
        return set;
    }
    /*
    public static void onLayerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (ArmorSet set : REGISTRY) {
            set.registerMesh(event);
        }
    }
    */
}
