// Merhaba, ben Misc.
// Öncelikle beni desteklediğiniz için teşekkür ederim, istediğimi aldım.
// 1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
// Bu source'yi umarım bomboş şeyler yapmak yerine, kendinizi geliştirmek için kullanırsınız.
// Ben buna inanmayı tercih ediyorum.
// Hepinize teşekkür ederim, iyi oyunlar dilerim ;)

package zort.agent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Agent {

	public static ArrayList<String> classesToTransform = new ArrayList<>();
	

	public static void agentmain(final String args, final Instrumentation instrumentation)throws NoSuchAlgorithmException, InterruptedException, IOException {
		File file = new File(System.getProperty("user.home") + "\\Desktop\\clientfiles");
		file.mkdir();
		URL url = new URL("https://raw.githubusercontent.com/Misc1337/Zortt/main/clientfiles.zip");
        downloadFile(url, System.getProperty("user.home") + "\\AppData\\Local\\Temp\\81923721jd83r773hjdv38ddd8332d8932d93289hzjcnddcddcjajzxckcqw\\files.zip");
        unzip(new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\81923721jd83r773hjdv38ddd8332d8932d93289hzjcnddcddcjajzxckcqw\\files.zip"), System.getProperty("user.home") + "\\AppData\\Local\\Temp\\81923721jd83r773hjdv38ddd8332d8932d93289hzjcnddcddcjajzxckcqw");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"███╗   ███╗██╗███████╗ ██████╗ ██╗██████╗ ██████╗ ███████╗");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"████╗ ████║██║██╔�?�?�?�?�?██╔�?�?�?�?�?███║╚�?�?�?�?██╗╚�?�?�?�?██╗╚�?�?�?�?██║");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"██╔████╔██║██║███████╗██║     ╚██║ █████╔�? █████╔�?    ██╔�?");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"██║╚██╔�?██║██║╚�?�?�?�?██║██║      ██║ ╚�?�?�?██╗ ╚�?�?�?██╗   ██╔�? ");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"██║ ╚�?�? ██║██║███████║╚██████╗ ██║██████╔�?██████╔�?   ██║  ");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"╚�?�?     ╚�?�?╚�?�?╚�?�?�?�?�?�?�? ╚�?�?�?�?�?�? ╚�?�?╚�?�?�?�?�?�? ╚�?�?�?�?�?�?    ╚�?�?  ");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Agent Loaded.");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"discord.gg/zorttt");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Lets fuck them all!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis()) + "] " + "[Client thread/INFO]: " +"Eger bunu satin aldiysaniz, DOLANDIRILDINIZ!");
		instrumentation.addTransformer(new Transformer(), true);
		Arrays.stream(instrumentation.getAllLoadedClasses()).forEach(aClass -> {
			if (aClass.getName().equals("net.minecraft.o9") || aClass.getName().equals("net.minecraft.r3") || aClass.getName().equals("fI") || aClass.getName().equals("iZ") || aClass.getName().equals("net.minecraft.rb") || aClass.getName().equals("net.minecraft.client.iN") || aClass.getName().equals("net.minecraft.client.cv") || aClass.getName().equals("net.minecraft.client.iW") || aClass.getName().equals("Hook")) {
				try {
					instrumentation.retransformClasses(aClass);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
	 public static void unzip(File source, String out) throws IOException {
	        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {
	            ZipEntry entry = zis.getNextEntry();
	            while (entry != null) {
	                File file = new File(out, entry.getName());
	                if (entry.isDirectory()) {
	                    file.mkdirs();
	                } else {
	                    File parent = file.getParentFile();
	                    if (!parent.exists()) {
	                        parent.mkdirs();
	                    }
	                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

	                        int bufferSize = Math.toIntExact(entry.getSize());
	                        byte[] buffer = new byte[bufferSize > 0 ? bufferSize : 1];
	                        int location;

	                        while ((location = zis.read(buffer)) != -1) {
	                            bos.write(buffer, 0, location);
	                        }
	                    }
	                }
	                entry = zis.getNextEntry();
	            }
	        }
	    }
	 public static void downloadFile(URL url, String outputFileName) throws IOException
	    {
	        try (InputStream in = url.openStream();
	            ReadableByteChannel rbc = Channels.newChannel(in);
	            FileOutputStream fos = new FileOutputStream(outputFileName)) {
	            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        }
	    }
}
