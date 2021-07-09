//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

import org.lwjgl.input.Keyboard;

public class Strafe extends Module {

	public static boolean state = false;
	
	public Strafe() {
		super("Strafe", Keyboard.KEY_X);
	}
	
	   public static boolean getStat() {
		      return state;
		   }

	@Override
	public void onToggled() {
		state = !state;
	}
}
