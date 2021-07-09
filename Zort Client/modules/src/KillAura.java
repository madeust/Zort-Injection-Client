//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

import org.lwjgl.input.Keyboard;

public class KillAura extends Module {

	public static boolean state = false;
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_R);
	}
	
	   public static boolean getStat() {
		      return state;
		   }

	@Override
	public void onToggled() {
		state = !state;
	}
}
