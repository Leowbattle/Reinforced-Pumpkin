package reinforcedpumpkin.blocks;

import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockReinforcedFruit extends ItemBlock {
	public static String uuid = "dbfb18a3-81d7-4711-8882-6292c2f4bea4";
	
	public String type;
	
	
	public ItemBlockReinforcedFruit(Block block, String type) {
		super(block);
		this.type = type;
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
}
