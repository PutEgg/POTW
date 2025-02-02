package org.totemcraft.pow.block.type;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;
import org.totemcraft.pow.block.BlockDefinition;

import java.util.List;

public class PVineBlock extends VineBlock {
    private BlockDefinition definition;

    public PVineBlock(Properties properties, BlockDefinition definition) {
        super(properties);
        this.definition = definition;
    }

    @Override
    public MutableComponent getName() {
        var name = definition.getDisplayName().getSingleString();
        if (name == null) return super.getName();
        return Component.literal(name);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter level, List<Component> components, TooltipFlag flag) {
        if (definition.getLores() != null) {
            for (String currentString : definition.getLores().getCurrentStrings()) {
                components.add(Component.literal(currentString));
            }
        }
    }
}
