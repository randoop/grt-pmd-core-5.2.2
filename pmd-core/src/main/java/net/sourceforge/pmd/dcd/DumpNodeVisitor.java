/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.dcd;

import org.checkerframework.dataflow.qual.Impure;
import net.sourceforge.pmd.dcd.graph.ClassNode;
import net.sourceforge.pmd.dcd.graph.ConstructorNode;
import net.sourceforge.pmd.dcd.graph.FieldNode;
import net.sourceforge.pmd.dcd.graph.MemberNode;
import net.sourceforge.pmd.dcd.graph.MethodNode;
import net.sourceforge.pmd.dcd.graph.NodeVisitorAdapter;
import net.sourceforge.pmd.dcd.graph.UsageGraph;

/**
 * Dump a UsageGraph to System.out.
 */
public class DumpNodeVisitor extends NodeVisitorAdapter {

	@Impure
	@Override
	public Object visit(UsageGraph usageGraph, Object data) {
		System.out.println("----------------------------------------");
		super.visit(usageGraph, data);
		System.out.println("----------------------------------------");
		return data;
	}

	@Impure
	@Override
	public Object visit(ClassNode classNode, Object data) {
		System.out.println("Class: " + ClassLoaderUtil.fromInternalForm(classNode.getName()));
		return super.visit(classNode, data);
	}

	@Impure
	@Override
	public Object visitFields(ClassNode classNode, Object data) {
		System.out.println("\tFields (" + classNode.getFieldNodes().size() + "):");
		return super.visitFields(classNode, data);
	}

	@Impure
	@Override
	public Object visit(FieldNode fieldNode, Object data) {
		printMember(fieldNode);
		return super.visit(fieldNode, data);
	}

	@Impure
	@Override
	public Object visitConstructors(ClassNode classNode, Object data) {
		System.out.println("\tConstructors (" + classNode.getConstructorNodes().size() + "):");
		return super.visitConstructors(classNode, data);
	}

	@Impure
	@Override
	public Object visit(ConstructorNode constructorNode, Object data) {
		printMember(constructorNode);
		return super.visit(constructorNode, data);
	}

	@Impure
	@Override
	public Object visitMethods(ClassNode classNode, Object data) {
		System.out.println("\tMethods (" + classNode.getMethodNodes().size() + "):");
		return super.visitMethods(classNode, data);
	}

	@Impure
	@Override
	public Object visit(MethodNode methodNode, Object data) {
		printMember(methodNode);
		return super.visit(methodNode, data);
	}

	@Impure
	@Override
	public Object visitUses(MemberNode memberNode, Object data) {
		if (Boolean.TRUE == data && !memberNode.getUses().isEmpty()) {
			System.out.println("\t\t\tUses:");
		}
		return super.visitUses(memberNode, data);
	}

	@Impure
	@Override
	public Object visitUse(MemberNode use, Object data) {
		if (Boolean.TRUE == data) {
			System.out.println("\t\t\t\t" + use.toStringLong());
		}
		return super.visitUse(use, data);
	}

	@Impure
	@Override
	public Object visitUsers(MemberNode memberNode, Object data) {
		if (Boolean.TRUE == data && !memberNode.getUsers().isEmpty()) {
			System.out.println("\t\t\tUsers:");
		}
		return super.visitUsers(memberNode, data);
	}

	@Impure
	@Override
	public Object visitUser(MemberNode user, Object data) {
		if (Boolean.TRUE == data) {
			System.out.println("\t\t\t\t" + user.toStringLong());
		}
		return super.visitUser(user, data);
	}

	@Impure
	protected void printMember(MemberNode memberNode) {
		System.out.println("\t\t(" + memberNode.getUses().size() + ", " + memberNode.getUsers().size() + ") "
				+ memberNode.toStringLong());
	}
}
