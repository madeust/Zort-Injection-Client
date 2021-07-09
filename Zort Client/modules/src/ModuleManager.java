//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;

public class ModuleManager {
	
   public static List<Module> modules = new ArrayList<Module>();
   public static boolean initialized = false;
   
   public static void listenKey(int key)  {
	   initialize();
	   int key1 = Keyboard.getEventKey();
	   for (Module mod : modules) {
		   if(mod.moduleKey == key1) {
			   mod.toggle();
		   }
	   }
   }

   public static void initialize() {
       if(!initialized) {
    	   modules.add(new KillAura());
    	   modules.add(new Strafe());
           initialized = true;
       }
   }

public static Module getModule(String moduleName) {
      if (moduleName != null) {
         Iterator<Module> var2 = getModules().iterator();
         while(var2.hasNext()) {
            Module mod = (Module)var2.next();
            if (mod.moduleName.toString().contains(moduleName)) {
               return mod;
            }
         }
      }
      return null;
   }

   public static Module getModule(Class<?> clazz) {
      if (clazz != null) {
         Iterator<?> var2 = getModules().iterator();

         while(var2.hasNext()) {
            Module mod = (Module)var2.next();
            if (mod.getClass() == clazz) {
               return mod;
            }
         }
      }
      return null;
   }

   public static List<Module> getModules() {
      return modules;
   }
}
