package reinforcedpumpkin.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import reinforcedpumpkin.ReinforcedPumpkin;
import reinforcedpumpkin.blocks.ModBlocks;

@Mod.EventBusSubscriber
@ObjectHolder(ReinforcedPumpkin.MODID)
public class ModItems {
	public static void init() {
		
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		init();
		
		IForgeRegistry<Item> registry = event.getRegistry();
		
		initOreDict();
	}
	
	public static void registerRenderers() {
	}
	
	private static void registerRenderer(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void initOreDict() {

	}
}
