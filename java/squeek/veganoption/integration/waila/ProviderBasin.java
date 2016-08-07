package squeek.veganoption.integration.waila;

import java.util.List;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTankInfo;
import squeek.veganoption.blocks.tiles.TileEntityBasin;
import squeek.veganoption.helpers.LangHelper;

public class ProviderBasin implements IWailaDataProvider
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
		TileEntityBasin basin = (TileEntityBasin) accessor.getTileEntity();
		toolTip.add(LangHelper.translate(basin.isPowered() ? "waila.basin.open" : "waila.basin.closed"));

		FluidTankInfo tankInfo = basin.getTankInfo(EnumFacing.NORTH)[0];
		if (tankInfo.fluid != null && tankInfo.fluid.amount > 0)
		{
			toolTip.add(tankInfo.fluid.getLocalizedName() + " : " + tankInfo.fluid.amount + "mB");
		}
		else
			toolTip.add(LangHelper.translate("waila.basin.empty"));

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
