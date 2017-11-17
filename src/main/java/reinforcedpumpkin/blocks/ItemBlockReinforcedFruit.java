package reinforcedpumpkin.blocks;

import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import reinforcedpumpkin.ModConfig;

public class ItemBlockReinforcedFruit extends ItemBlock {
	public static String uuid = "dbfb18a3-81d7-4711-8882-6292c2f4bea4";
	
	public String type;
	public boolean isJackOLantern;
	
	public ItemBlockReinforcedFruit(Block block, String type, boolean isJackOLantern) {
		super(block);
		this.type = type;
		this.isJackOLantern = isJackOLantern;
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}

	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        int defence = 0;
        if (type == "iron") {
        	defence = 2;
        } else if (type == "gold") {
        	defence = 2;
        } else if (type == "diamond") {
        	defence = 3;
        }
        
        if (equipmentSlot == EntityEquipmentSlot.HEAD) {
        	
        	if (type == "diamond") {
        		multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(UUID.fromString(uuid),"Armor Toughness", 2, 0));
        	}
        	multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(UUID.fromString(uuid),"Armor modifier", defence, 0));
        }
        return multimap;
    	
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (isJackOLantern && ModConfig.lanternsProvideNightVision) {
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 5));
	
		}
	}
}
