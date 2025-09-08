package net.micbear.michaelsfarming.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class GrapeHoeItem extends Item {
    public static final Map<Block, Block> GRAPEHOE_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.COARSE_DIRT
            );

    public GrapeHoeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (GRAPEHOE_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GRAPEHOE_MAP.get(clickedBlock).getDefaultState());
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> {
                            assert context.getPlayer() != null;
                            context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND);
                        });

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_HOE_TILL, SoundCategory.MASTER);
            }
        }

        return ActionResult.SUCCESS;
    }
}
