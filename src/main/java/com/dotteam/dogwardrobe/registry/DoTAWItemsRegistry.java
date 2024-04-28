package com.dotteam.dogwardrobe.registry;

import java.util.function.Supplier;
import com.dotteam.dogwardrobe.DogWardrobe;
import com.dotteam.dogwardrobe.item.HatItem;
import com.dotteam.dogwardrobe.item.HumanoidArmorItem;
import com.dotteam.dogwardrobe.item.ItemDoTAW;
import com.dotteam.dogwardrobe.util.DoTBMaterials.DoTArmorMaterial;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DoTAWItemsRegistry {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DogWardrobe.MOD_ID);


	public static final RegistryObject<Item> GENERAL = DoTAWItemsRegistry.reg("general", () -> new ItemDoTAW(true));
	public static final RegistryObject<Item> BAMBOO_HAT = DoTAWItemsRegistry.reg("bamboo_hat", HatItem::new);

	public static final RegistryObject<HumanoidArmorItem> JAPANESE_LIGHT_ARMOR_HEAD = DoTAWItemsRegistry.ITEMS.register(
			"japanese_light_armor_head",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.JAPANESE_LIGHT_ARMOR, DoTArmorMaterial.JAPANESE_LIGHT, Type.HELMET));

	public static final RegistryObject<HumanoidArmorItem> JAPANESE_LIGHT_ARMOR_CHEST = DoTAWItemsRegistry.ITEMS.register(
			"japanese_light_armor_chest",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.JAPANESE_LIGHT_ARMOR, DoTArmorMaterial.JAPANESE_LIGHT, Type.CHESTPLATE));

	public static final RegistryObject<HumanoidArmorItem> CENTURION_ARMOR_HEAD = DoTAWItemsRegistry.ITEMS.register("centurion_armor_head",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.CENTURION_ARMOR, DoTArmorMaterial.CENTURION, Type.HELMET));

	public static final RegistryObject<HumanoidArmorItem> CENTURION_ARMOR_CHEST = DoTAWItemsRegistry.ITEMS.register("centurion_armor_chest",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.CENTURION_ARMOR, DoTArmorMaterial.CENTURION, Type.CHESTPLATE));

	public static final RegistryObject<HumanoidArmorItem> CENTURION_ARMOR_LEGS = DoTAWItemsRegistry.ITEMS.register("centurion_armor_legs",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.CENTURION_ARMOR, DoTArmorMaterial.CENTURION, Type.LEGGINGS));

	public static final RegistryObject<HumanoidArmorItem> CENTURION_ARMOR_FEET = DoTAWItemsRegistry.ITEMS.register("centurion_armor_feet",
			() -> new HumanoidArmorItem(DoTAWArmorSetsRegistry.CENTURION_ARMOR, DoTArmorMaterial.CENTURION, Type.BOOTS));

	// public static final ArmorSetRegistryObject ANUBIS_ARMOR_SET = new ArmorSetRegistryObject("anubis_armor", RAIJIN, () ->
	// AnubisModel::new);
	// public static final ArmorSetRegistryObject CENTURION_ARMOR_SET = new ArmorSetRegistryObject("centurion_armor", CENTURION, () ->
	// CenturionArmorModel::new);
	// public static final ArmorSetRegistryObject IRON_PLATE_ARMOR_SET = new ArmorSetRegistryObject("iron_plate_armor", IRON_PLATE, () ->
	// IronPlateArmorModel::new);
	// public static final ArmorSetRegistryObject HOLY_ARMOR_SET = new ArmorSetRegistryObject("holy_armor", HOLY, () ->
	// HolyArmorModel::new);
	// public static final ArmorSetRegistryObject PHARAOH_ARMOR_SET = new ArmorSetRegistryObject("pharaoh_armor", PHARAOH, () ->
	// PharaohArmorModel::new);
	// public static final ArmorSetRegistryObject JAPANESE_LIGHT_ARMOR_SET = new ArmorSetRegistryObject(JAPANESE_LIGHT_NAME, JAPANESE_LIGHT,
	// () -> JapaneseLightArmorModel::new);
	// public static final ArmorSetRegistryObject O_YOROI_ARMOR_SET = new ArmorSetRegistryObject("o_yoroi_armor", O_YOROI, () ->
	// OYoroiArmorModel::new);
	// public static final ArmorSetRegistryObject QUETZALCOATL_ARMOR_SET = new ArmorSetRegistryObject("quetzalcoatl_armor", RAIJIN, () ->
	// QuetzalcoatlModel::new);
	// public static final ArmorSetRegistryObject RAIJIN_ARMOR_SET = new ArmorSetRegistryObject("raijin_armor", RAIJIN, () ->
	// RaijinArmorModel::new);

	private static <T extends Item> RegistryObject<T> reg(String name, Supplier<T> item) { return ITEMS.register(name, item); }

	public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }

}
