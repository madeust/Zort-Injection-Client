//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

package zort.agent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import org.apache.commons.io.IOUtils;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

public class AttachUtil {

	public static void attach(String pid, File input) {
		System.setProperty("java.library.path", System.getProperty("java.home").replace("jre", "jdk")+ "\\jre\\bin");
		try {
		Field field = ClassLoader.class.getDeclaredField("sys_paths");
		field.setAccessible(true);
		field.set(null, null);
		} catch(NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			return;
		}
		File agentFile = new File(System.getProperty("java.io.tmpdir")+"/","tmp_"+System.currentTimeMillis()+".jar");
		agentFile.deleteOnExit();
		buildAgentJar(input, agentFile);
		try {
			VirtualMachine virtualMachine = VirtualMachine.attach(pid);
			virtualMachine.loadAgent(agentFile.getAbsolutePath());
			virtualMachine.detach();
			} catch (AttachNotSupportedException | IOException | AgentLoadException | AgentInitializationException e) {
		}
	}
	
	public static void buildAgentJar(File input, File output) {
		try {
			JarFile jarFile = new JarFile(input);
			Manifest manifest = new Manifest(jarFile.getManifest());
			manifest.getMainAttributes().putValue("Agent-Class", Agent.class.getName());
			manifest.getMainAttributes().putValue("Can-Retransform-Classes", "true");
			manifest.getMainAttributes().putValue("Can-Redifine-Classes", "true");
			manifest.getMainAttributes().putValue("Can-Set-Native-Prefix", "true");
			JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(output), manifest);
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry jarEntry = entries.nextElement();
				if (!jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
					jarOutputStream.putNextEntry(jarEntry);
					if (!jarEntry.isDirectory()) {
						jarOutputStream.write(IOUtils.toByteArray(jarFile.getInputStream(jarEntry)));
					}
					jarOutputStream.closeEntry();
				}
			}
			jarFile.close();
			jarOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getProcesses() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			MonitoredHost monitoredHost = MonitoredHost.getMonitoredHost("localhost");
			for (int id : monitoredHost.activeVms()) {
				MonitoredVm monitoredVm = monitoredHost.getMonitoredVm(new VmIdentifier("//" + id));
				String main = MonitoredVmUtil.mainClass(monitoredVm, true);
				if (!main.isEmpty()) {
					if(main.contains("launcher.jar")) {
					list.add(id+"");
					}
				}
			}
		} catch (MonitorException | URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
}
