/*
** 2016 März 15
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.TheRPGAdventurer.ROTD.server.entity.ai;

import static net.minecraft.entity.SharedMonsterAttributes.FOLLOW_RANGE;

import java.util.Random;

import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.ROTD.util.math.MathX;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public abstract class EntityAIDragonBase extends EntityAIBase {
    
    protected EntityTameableDragon dragon;
    protected World world;
    protected Random random;

    public EntityAIDragonBase(EntityTameableDragon dragon) {
        this.dragon = dragon;
        this.world = dragon.world;
        this.random = dragon.getRNG(); 
    }
    
    protected boolean tryMoveToBlockPos(BlockPos pos, double speed) {
        return dragon.getNavigator().tryMoveToXYZ(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, speed);
    }
    
    protected boolean tryToCircleBlockPos(BlockPos midPoint, double speed) {
    	dragon.setFlying(true);
		return dragon.getNavigator().tryMoveToXYZ(midPoint.getX() + 0.5 * Math.PI, midPoint.getY() + 10, midPoint.getZ() + 0.5 * Math.PI, speed);
    	
    }
    
    protected double getFollowRange() {
        return dragon.getAttributeMap().getAttributeInstance(FOLLOW_RANGE).getAttributeValue();
    }
}
