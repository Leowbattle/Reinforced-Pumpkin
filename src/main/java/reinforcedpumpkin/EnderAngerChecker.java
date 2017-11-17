package reinforcedpumpkin;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import reinforcedpumpkin.blocks.ModBlocks;

@Mod.EventBusSubscriber
public class EnderAngerChecker {
	@SubscribeEvent
	public static void enderAnger(LivingSetAttackTargetEvent event) {
		if (!ModConfig.reinforcedPumpkinsWorkLikeNormalPumpkins) {return;}
		
		if (event.getEntity() instanceof EntityEnderman) {
			if (event.getTarget() instanceof EntityPlayer) {
				for (ItemStack stack: ((EntityPlayer)event.getTarget()).getArmorInventoryList() ) {
					if (stack.getItem().getUnlocalizedName().contains("reinforced_pumpkin")) {
						((EntityEnderman)event.getEntity()).setAttackTarget(null);					}
				}
			}
		}
	}
}
