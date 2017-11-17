package reinforcedpumpkin.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import reinforcedpumpkin.ReinforcedPumpkin;

@Mod.EventBusSubscriber
@ObjectHolder(ReinforcedPumpkin.MODID)
public class ModBlocks {
	public static Block reinforcedPumpkin = new BlockReinforcedFruit().setRegistryName("reinforced_pumpkin").setUnlocalizedName("reinforced_pumpkin");
	public static Block reinforcedPumpkinGold = new BlockReinforcedFruit().setRegistryName("reinforced_pumpkin_gold").setUnlocalizedName("reinforced_pumpkin_gold");
	public static Block reinforcedPumpkinDiamond = new BlockReinforcedFruit().setRegistryName("reinforced_pumpkin_diamond").setUnlocalizedName("reinforced_pumpkin_diamond");
	
	public static Block reinforcedLantern = new BlockReinforcedFruit().setRegistryName("reinforced_lantern").setUnlocalizedName("reinforced_lantern");
	public static Block reinforcedLanternGold = new BlockReinforcedFruit().setRegistryName("reinforced_lantern_gold").setUnlocalizedName("reinforced_lantern_gold");
	public static Block reinforcedLanternDiamond = new BlockReinforcedFruit().setRegistryName("reinforced_lantern_diamond").setUnlocalizedName("reinforced_lantern_diamond");
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) { 
		init();
		
		IForgeRegistry<Block> registry = event.getRegistry();
		
		registry.register(reinforcedPumpkin);
		registry.register(reinforcedPumpkinGold);
		registry.register(reinforcedPumpkinDiamond);
		
		registry.register(reinforcedLantern);
		registry.register(reinforcedLanternGold);
		registry.register(reinforcedLanternDiamond);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) { 
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(new ItemBlockReinforcedFruit(reinforcedPumpkin, "iron", false).setRegistryName("reinforced_pumpkin").setUnlocalizedName("reinforced_pumpkin"));
		registry.register(new ItemBlockReinforcedFruit(reinforcedPumpkinGold, "gold", false).setRegistryName("reinforced_pumpkin_gold").setUnlocalizedName("reinforced_pumpkin_gold"));
		registry.register(new ItemBlockReinforcedFruit(reinforcedPumpkinDiamond, "diamond", false).setRegistryName("reinforced_pumpkin_diamond").setUnlocalizedName("reinforced_pumpkin_diamond"));
		
		registry.register(new ItemBlockReinforcedFruit(reinforcedLantern, "iron", true).setRegistryName("reinforced_lantern").setUnlocalizedName("reinforced_lantern"));
		registry.register(new ItemBlockReinforcedFruit(reinforcedLanternGold, "gold", true).setRegistryName("reinforced_lantern_gold").setUnlocalizedName("reinforced_lantern_gold"));
		registry.register(new ItemBlockReinforcedFruit(reinforcedLanternDiamond, "diamond", true).setRegistryName("reinforced_lantern_diamond").setUnlocalizedName("reinforced_lantern_diamond"));
		
		initOreDict();
	}
	
	public static void init() {
		
	}
	
	public static void initOreDict() {
		
	}
	
	public static void registerRenderers() {
		registerRenderer(reinforcedPumpkin);
		registerRenderer(reinforcedPumpkinGold);
		registerRenderer(reinforcedPumpkinDiamond);
		
		registerRenderer(reinforcedLantern);
		registerRenderer(reinforcedLanternGold);
		registerRenderer(reinforcedLanternDiamond);
	}
	
	public static void registerRenderer(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
