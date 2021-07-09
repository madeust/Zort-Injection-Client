// Merhaba, ben Misc.
// Öncelikle beni desteklediğiniz için teşekkür ederim, istediğimi aldım.
// 1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
// Bu source'yi umarım bomboş şeyler yapmak yerine, kendinizi geliştirmek için kullanırsınız.
// Ben buna inanmayı tercih ediyorum.
// Hepinize teşekkür ederim, iyi oyunlar dilerim ;)

package zort;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import zort.agent.AttachUtil;

public class Main {

    
    public static void main(String[] args) {
        try {
            String launcherBatPath = System.getProperty("java.io.tmpdir") + "/soLauncher.bat";
            FileWriter batchWriter = new FileWriter(new File(launcherBatPath), false);
            File soLauncherJar = new File(System.getenv("appdata") + "\\.sonoyuncu\\launcher.jar");
            batchWriter.write("color b\r\n"+ "title discord.gg/zorttt\r\n"+ "echo off\r\n"+ "cls\r\n"+ "java -noverify -Dfile.encoding=UTF-8 -jar " + soLauncherJar.getAbsolutePath() + " -95452474040\r\n"+ "pause");
            batchWriter.close();
            Desktop.getDesktop().open(new File(launcherBatPath));
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        AttachUtil.attach(AttachUtil.getProcesses().get(0), file);
    }
}