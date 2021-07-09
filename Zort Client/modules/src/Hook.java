//Merhaba, ben Misc.
//Öncelikle beni desteklediğiniz için teşekkür ederim, istediğimi aldım.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarım bomboş şeyler yapmak yerine, kendinizi geliştirmek için kullanırsınız.
//Ben buna inanmayı tercih ediyorum.
//Hepinize teşekkür ederim, iyi oyunlar dilerim ;)

import java.awt.Color;
import java.util.Iterator;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import net.minecraft.l1;
import net.minecraft.pB;
import net.minecraft.tS;

public class Hook {

	private static Timer KillAuraTimer = new Timer();

	public static net.minecraft.client.iN instance() {
		return null;
	}
		    
	public static void onMotionUpdate() {
	    
		Display.setTitle((String) "Minecraft 1.8.9 - Zort Client");
		if (Strafe.state) {
			if (!isMoving())
				return;
			strafe(getSpeed() * 1.0F);
		}
		if (KillAura.state && KillAuraTimer.delay(500.0) && Hook.instance().ah != null && Hook.instance().ad != null
				&& Hook.instance().ad.d != null && !Hook.instance().ad.d.isEmpty()) {
			int a = 0;
			while (a < Hook.instance().ad.d.size()) {
				if (Hook.instance().ad.d.size() <= a) {
					a = 0;
				}
				pB ent = (pB) Hook.instance().ad.d.get(a);
				if (ent != null && ent != Hook.instance().ah
						&& Hook.getDistanceToEntity(Hook.instance().ah, ent) <= 5.0f) {
					Hook.instance().ah.cF.a(new l1(ent, tS.ATTACK));
				}
				++a;
			}
		}
	}

	private static void rotateToEntity(int i, pB ent) {
		
	}

	public static float getDistanceToEntity(net.minecraft.client.iW entityMe, net.minecraft.pB entityIn) {
		float f = (float) (entityMe.at - entityIn.at);
		float f1 = (float) (entityMe.Y - entityIn.Y);
		float f2 = (float) (entityMe.O - entityIn.O);
		return (float) Math.sqrt((double) (f * f + f1 * f1 + f2 * f2));
	}

	public static void onRender2D(int SRwidth, int SRheight) {
		   int y = 36;
		   Iterator<Module> var9 = ModuleManager.getModules().iterator();
		while (var9.hasNext()) {
			Module mod = (Module) var9.next();
			if (mod.moduleState) {
				instance().ap.b(mod.moduleName, 8, y, (getRainbow((int) -2000, 15 * 1)), true);
		         y += 10;
			}
			pushMatrix();
			scale(2.0f, 2.0f, 2.0f);
			instance().ap.b("Zort Client", (int) 4, (int) 4, (getRainbow((int) -2000, 15 * 1)), true);
			popMatrix();
			
			pushMatrix();
			scale(1.0f, 1.0f, 1.0f);
			instance().ap.b("discord.gg/zorttt", 8, 26, (getRainbow((int) -2000, 15 * 1)), true);
			popMatrix();

		}
	}
	
	public static void strafe(final float speed) {

		final double yaw = getDirection();
		instance().ah.A = -Math.sin(yaw) * speed;
		instance().ah.au = Math.cos(yaw) * speed;
	}

	public static float getSpeed() {
		return (float) Math.sqrt(instance().ah.A * instance().ah.A + instance().ah.au * instance().ah.au);
	}

	public static boolean isMoving() {
		return instance().ah != null && (instance().ah.cy.b != 0F || instance().ah.cy.d != 0F);
	}

	public static double getDirection() {
		float rotationYaw = instance().ah.ay;

		if (instance().ah.bv < 0F)
			rotationYaw += 180F;

		float forward = 1F;
		if (instance().ah.bv < 0F)
			forward = -0.5F;
		else if (instance().ah.bv > 0F)
			forward = 0.5F;

		if (instance().ah.bj > 0F)
			rotationYaw -= 90F * forward;

		if (instance().ah.bj < 0F)
			rotationYaw += 90F * forward;

		return Math.toRadians(rotationYaw);
	}


	public static void pushMatrix() {
		GL11.glPushMatrix();
	}

	public static void popMatrix() {
		GL11.glPopMatrix();
	}

	public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		GL11.glScalef(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	private static int getRainbow(int speed, int offset) {
		float hue = (System.currentTimeMillis() + (long) offset) % (long) speed;
		return Color.getHSBColor(hue /= (float) speed, 0.9f, 1.0f).getRGB();
	}

}