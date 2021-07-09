//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

package zort.agent;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;

public abstract class Injector implements ClassFileTransformer, Opcodes {

	public static boolean initialized = true;

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
		if (initialized && className.equals("net/minecraft/client/iN")) {
			initialized = false;
			File folder = new File(System.getProperty("user.home") + "\\Desktop\\clientfiles");
			File[] listOfFiles = folder.listFiles();
			assert listOfFiles != null;
			for (File file : listOfFiles) {
				if (file.getName().contains("Module.class")) {
					CtClass cc;
					ClassPool pool = ClassPool.getDefault();
					pool.appendClassPath(new LoaderClassPath(loader));
					try {
						byte[] array = FileUtils.readFileToByteArray(file);
						cc = pool.makeClass(new ByteArrayInputStream(array));
						cc.setName(file.getName().replace(".class", ""));
						cc.toClass(loader, protectionDomain);
					}
					catch (IOException | RuntimeException | CannotCompileException e1) {
						e1.printStackTrace();
					}
				}
			}

			for (File file : listOfFiles) {
				if (file.isFile() && file.getAbsolutePath().endsWith(".class") && !file.getName().contains("Module.class")) {
					CtClass cc = null;
					ClassPool pool = ClassPool.getDefault();
					pool.appendClassPath(new LoaderClassPath(loader));
					try {
						byte[] array = FileUtils.readFileToByteArray(file);

						try {
							ClassReader classReader = new ClassReader(array);
							ClassNode classNode = new ClassNode();
							classReader.accept(classNode, 0);
							this.inject(classReader, classNode);
							ClassWriter classWriter = new ClassWriter(0);
							classNode.accept(classWriter);
							array = classWriter.toByteArray();
						} catch (Exception e) {
							e.printStackTrace();
						}

						cc = pool.makeClass(new ByteArrayInputStream(array));
						cc.setName(file.getName().replace(".class", ""));
						cc.toClass(loader, protectionDomain);
					}
					catch (IOException | RuntimeException | CannotCompileException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		if (className.equals("net/minecraft/client/cv") || className.equals("net/minecraft/o9") || className.equals("net/minecraft/r3") || className.equals("net/minecraft/rb") || className.equals("fI") || className.equals("iZ") || className.equals("net/minecraft/client/iW")|| className.equals("net/minecraft/client/iN") || className.equals("Hook")) {
			try {
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		return new byte[0];
	}

	public abstract void inject(final ClassReader p0, final ClassNode p1);
}