package reinforcedpumpkin.proxies;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import reinforcedpumpkin.blocks.ModBlocks;
import reinforcedpumpkin.items.ModItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements CommonProxy {
	@Override
	public void init() {
	}
	
	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.registerRenderers();
        ModItems.registerRenderers();
    }
}
