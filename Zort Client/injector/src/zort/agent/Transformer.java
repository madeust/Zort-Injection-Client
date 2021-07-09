//Merhaba, ben Misc.
//Öncelikle beni desteklediðiniz için teþekkür ederim, istediðimi aldým.
//1k abone oldum ve küçük ama güzel kitleli bir sunucum oldu.
//Bu source'yi umarým bomboþ þeyler yapmak yerine, kendinizi geliþtirmek için kullanýrsýnýz.
//Ben buna inanmayý tercih ediyorum.
//Hepinize teþekkür ederim, iyi oyunlar dilerim ;)

package zort.agent;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class Transformer extends Injector
{
	public void inject(final ClassReader reader, final ClassNode classNode) {
		if (classNode.name.equals("net/minecraft/o9")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("<init>") && methodNode.desc.equals("(ILjava/lang/String;ILnet/minecraft/yh;)V")) {
					final InsnList insn = new InsnList();
					insn.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
					insn.add(new VarInsnNode(ALOAD, 2));
					insn.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("run") && methodNode.desc.equals("()V")) {
					final InsnList insn = new InsnList();
					insn.add(new InsnNode(RETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("b") && methodNode.desc.equals("()V")) {
					final InsnList insn = new InsnList();
					insn.add(new InsnNode(RETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("c") && methodNode.desc.equals("()V") && methodNode.access == ACC_PRIVATE) {
					final InsnList insn = new InsnList();
					insn.add(new InsnNode(RETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("()V")) {
					final InsnList insn = new InsnList();
					insn.add(new InsnNode(RETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("(Ljava/lang/Runnable;Z)V")) {
					final InsnList insn = new InsnList();
					insn.add(new InsnNode(RETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("(Ljava/lang/String;)Ljava/lang/String;")) {
					final InsnList insn = new InsnList();
					insn.add(new LdcInsnNode(" "));
					insn.add(new InsnNode(ARETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("fI")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("c") && methodNode.desc.equals("()Ljava/lang/String;")) {
					final InsnList insn = new InsnList();
					insn.add(new LdcInsnNode(" "));
					insn.add(new InsnNode(ARETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("()(Ljava/lang/String;)Ljava/lang/String;")) {
					final InsnList insn = new InsnList();
					insn.add(new LdcInsnNode(" "));
					insn.add(new InsnNode(ARETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("b") && methodNode.desc.equals("()Ljava/lang/String;")) {
					final InsnList insn = new InsnList();
					insn.add(new LdcInsnNode(" "));
					insn.add(new InsnNode(ARETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("iZ")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("()Ljava/lang/String;")) {
					final InsnList insn = new InsnList();
					insn.add(new LdcInsnNode(" "));
					insn.add(new InsnNode(ARETURN));
					methodNode.instructions.insert(insn);
				}
			}
		}
		
		if (classNode.name.equals("net/minecraft/client/iW")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("X") && methodNode.desc.equals("()V")) {
					AbstractInsnNode target = null;
					for (final AbstractInsnNode abs : methodNode.instructions.toArray()) {
						if (abs.getOpcode() == 184) {
							target = abs;
							break;
						}
					}
					final InsnList insn = new InsnList();
					insn.add(new MethodInsnNode(184, "Hook", "onMotionUpdate", "()V", false));
					methodNode.instructions.insert(target, insn);
				}
			}
		}
		
		if (classNode.name.equals("Hook")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("instance") && methodNode.desc.equals("()Lnet/minecraft/client/iN;")) {
					AbstractInsnNode target = null;
					for (final AbstractInsnNode abs4 : methodNode.instructions.toArray()) {
						if (abs4.getOpcode() == 1) {
							target = abs4.getNext();
							break;
						}
					}
					methodNode.instructions.remove(target.getPrevious());
					final InsnList insn = new InsnList();
					insn.add(new MethodInsnNode(184, "net/minecraft/client/iN", "a", "()Lnet/minecraft/client/iN;", false));
					methodNode.instructions.insertBefore(target, insn);
				}
			}
		}


		if (classNode.name.equals("net/minecraft/client/cv")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("a") && methodNode.desc.equals("(F)V")) {
					AbstractInsnNode target = null;
					for (final AbstractInsnNode abs4 : methodNode.instructions.toArray()) {
						if (abs4 instanceof FieldInsnNode && ((FieldInsnNode)abs4).name.equals("i") && ((FieldInsnNode)abs4).owner.equals("net/minecraft/client/cv")) {
							target = abs4.getNext().getNext().getNext();
							break;
						}
					}
					final InsnList insnList2 = new InsnList();
					insnList2.add(new VarInsnNode(21, 5));
					insnList2.add(new VarInsnNode(21, 6));
					insnList2.add(new MethodInsnNode(184, "Hook", "onRender2D", "(II)V", false));
					methodNode.instructions.insert(target, insnList2);
				}
			}
		}


		if (classNode.name.equals("net/minecraft/client/iN")) {
			for (final MethodNode methodNode : classNode.methods) {
				if (methodNode.name.equals("j") && methodNode.desc.equals("()V")) {
					AbstractInsnNode target = null;
					int count = 0;
					for (final AbstractInsnNode abs : methodNode.instructions.toArray()) {
						if (abs instanceof MethodInsnNode && ((MethodInsnNode)abs).name.equals("getEventKeyState") && ++count == 2) {
							target = abs.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext();
						}	}
					final InsnList insnList3 = new InsnList();
					insnList3.add(new VarInsnNode(21, 2));
					insnList3.add(new MethodInsnNode(184, "ModuleManager", "listenKey", "(I)V", false));
					methodNode.instructions.insert(target, insnList3);
				}
			}
		}
	}
}
