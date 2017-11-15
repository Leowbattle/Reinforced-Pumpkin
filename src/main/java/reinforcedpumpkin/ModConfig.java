package reinforcedpumpkin;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ReinforcedPumpkin.MODID)
public class ModConfig {
	@Config.Comment("")
	public static boolean willGenerateMiteNests = true;
	@Config.RangeInt()
	public static int miteNestSpawnChanes = 32;
	@Config.RangeInt()
	public static int miteNestMinMitesSpawned = 2;
	@Config.RangeInt()
	public static int miteNestMaxMitesSpawned = 5;
	
	@Config.Comment("")
	public static boolean elytraAreEnabled = true;
	
	//In the future I will probably add this back in, but it is casuing wierd problems at the moment
	/*@Config.Comment("")
	public static boolean elytraAreRepairedWithLeather = false;*/
	
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
