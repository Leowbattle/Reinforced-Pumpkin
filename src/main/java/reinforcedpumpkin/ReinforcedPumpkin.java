package reinforcedpumpkin;

import java.lang.reflect.Array;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import reinforcedpumpkin.proxies.ClientProxy;
import reinforcedpumpkin.worldgen.ModWorldGen;

@Mod(modid = ReinforcedPumpkin.MODID, version = ReinforcedPumpkin.VERSION)
public class ReinforcedPumpkin {
    public static final String MODID = "reinforcedpumpkin";
    public static final String name = "Reinforced Pumpkin";
    public static final String VERSION = "1.0";
    
    @SidedProxy(serverSide = "reinforcedpumpkin.proxies.ServerProxy", clientSide = "reinforcedpumpkin.proxies.ClientProxy")
	public static ClientProxy proxy;
	
	@Mod.Instance(MODID)
	public static ReinforcedPumpkin instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {    	
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) { 	
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}
