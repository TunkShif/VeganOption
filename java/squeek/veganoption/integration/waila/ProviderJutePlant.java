package squeek.veganoption.integration.waila;

import java.util.List;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import squeek.veganoption.blocks.BlockJutePlant;

public class ProviderJutePlant implements IWailaDataProvider
{
	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		if (config.getConfig("general.showcrop"))
		{
			float growthValue = ((BlockJutePlant) accessor.getBlock()).getGrowthPercent(accessor.getWorld(), accessor.getPosition(), accessor.getBlockState()) * 100.0F;
			if (growthValue < 100)
				toolTip.add(String.format("%s : %.0f %%", I18n.format("hud.msg.growth"), growthValue));
			else
				toolTip.add(String.format("%s : %s", I18n.format("hud.msg.growth"), I18n.format("hud.msg.mature")));
		}

		return toolTip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos)
	{
		return null;
	}
}
