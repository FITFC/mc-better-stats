package thecsdev.betterstats.client.gui.panel.stats;

import java.util.function.Predicate;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import thecsdev.betterstats.util.StatUtils.StatUtilsMobStat;
import thecsdev.betterstats.util.StatUtils.StatUtilsStat;
import thecsdev.tcdcommons.api.client.gui.panel.TPanelElement;

public class BSStatPanel_MonsterHunter extends BSStatPanel_Mobs
{
	// ==================================================
	public BSStatPanel_MonsterHunter(int x, int y, int width, int height) { super(x, y, width, height); }
	public BSStatPanel_MonsterHunter(TPanelElement parentToFill) { super(parentToFill); }
	// ==================================================
	public @Override Predicate<StatUtilsStat> getStatPredicate()
	{
		return super.getStatPredicate().and(stat ->
		{
			//check the hunter stat for mob type,
			//and make sure it is a monster
			StatUtilsMobStat mobStat = (StatUtilsMobStat)stat;
			return mobStat.entityType.getSpawnGroup() == SpawnGroup.MONSTER &&
					mobStat.entityType != EntityType.GIANT &&
					mobStat.entityType != EntityType.ILLUSIONER;
		});
	}
	// ==================================================
	protected BSStatWidget_Mob createStatWidget(StatUtilsMobStat stat, int x, int y, int size)
	{
		return new BSStatWidget_MonsterHunter(stat, x, y, size);
	}
	// ==================================================
	protected class BSStatWidget_MonsterHunter extends BSStatWidget_Mob
	{
		public BSStatWidget_MonsterHunter(StatUtilsMobStat stat, int x, int y, int size) { super(stat, x, y, size); }
		public @Override void postRender(MatrixStack matrices, int mouseX, int mouseY, float deltaTime)
		{
			if(stat.killed > 0) drawOutline(matrices, COLOR_GOLD_FOCUSED);
			else if(isFocused())
				drawOutline(matrices, COLOR_NORMAL_FOCUSED);
			else if(isHovered() || (!stat.isEmpty() && stat.killed < 1))
				drawOutline(matrices, COLOR_NORMAL_HOVERED);
		}
	}
	// ==================================================
}