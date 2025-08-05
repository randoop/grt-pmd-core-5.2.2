/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.dcd.graph;

import org.checkerframework.dataflow.qual.Impure;
import java.util.List;

/**
 * Adapter class for easy implementation of a NodeVisitor.  Subclasses
 * need only override methods to add behavior, and call <code>super</code> to
 * continue the visitation.
 */
public class NodeVisitorAdapter implements NodeVisitor {

	@Impure
	public Object visit(UsageGraph usageGraph, Object data) {
		return usageGraph.accept(this, data);
	}

	@Impure
	public Object visit(ClassNode classNode, Object data) {
		return classNode.accept(this, data);
	}

	@Impure
	public Object visitFields(ClassNode classNode, Object data) {
		for (FieldNode fieldNode : classNode.getFieldNodes()) {
			visit(fieldNode, data);
		}
		return data;
	}

	@Impure
	public Object visit(FieldNode fieldNode, Object data) {
		return fieldNode.accept(this, data);
	}

	@Impure
	public Object visitConstructors(ClassNode classNode, Object data) {
		for (ConstructorNode constructorNode : classNode.getConstructorNodes()) {
			visit(constructorNode, data);
		}
		return data;
	}

	@Impure
	public Object visit(ConstructorNode constructorNode, Object data) {
		return constructorNode.accept(this, data);
	}

	@Impure
	public Object visitMethods(ClassNode classNode, Object data) {
		for (MethodNode methodNode : classNode.getMethodNodes()) {
			visit(methodNode, data);
		}
		return data;
	}

	@Impure
	public Object visit(MethodNode methodNode, Object data) {
		return methodNode.accept(this, data);
	}

	@Impure
	public Object visitUses(MemberNode memberNode, Object data) {
		for (MemberNode use : (List<MemberNode>)memberNode.getUses()) {
			this.visitUse(use, data);
		}
		return data;
	}

	@Impure
	public Object visitUse(MemberNode memberNode, Object data) {
		return data;
	}

	@Impure
	public Object visitUsers(MemberNode memberNode, Object data) {
		for (MemberNode user : (List<MemberNode>)memberNode.getUsers()) {
			this.visitUser(user, data);
		}
		return data;
	}

	@Impure
	public Object visitUser(MemberNode memberNode, Object data) {
		return data;
	}
}
