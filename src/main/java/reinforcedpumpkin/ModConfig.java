package reinforcedpumpkin;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ReinforcedPumpkin.MODID)
public class ModConfig {
	@Config.Comment("")
	public static boolean reinforcedPumpkinsWorkLikeNormalPumpkins = true;
	
	@Config.Comment("")
	public static boolean lanternsProvideNightVision = true;
	
	@Config.Comment("")
	public static boolean reinforcedPumpkinsplodesBlowUpVillagers = true;
	
	@Mod.EventBusSubscriber(modid = ReinforcedPumpkin.MODID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(ReinforcedPumpkin.MODID)) {
				ConfigManager.sync(ReinforcedPumpkin.MODID, Config.Type.INSTANCE);
			}
		}
	}
}
