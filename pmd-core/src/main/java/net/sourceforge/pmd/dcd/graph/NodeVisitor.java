/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.dcd.graph;
import org.checkerframework.dataflow.qual.Impure;

/**
 * Visitor for nodes in a UsageGraph.
 */
public interface NodeVisitor {

	@Impure
	Object visit(UsageGraph usageGraph, Object data);

	@Impure
	Object visit(ClassNode classNode, Object data);

	@Impure
	Object visitFields(ClassNode classNode, Object data);

	@Impure
	Object visit(FieldNode fieldNode, Object data);

	@Impure
	Object visitConstructors(ClassNode classNode, Object data);

	@Impure
	Object visit(ConstructorNode constructorNode, Object data);

	@Impure
	Object visitMethods(ClassNode classNode, Object data);

	@Impure
	Object visit(MethodNode methodNode, Object data);

	@Impure
	Object visitUses(MemberNode memberNode, Object data);

	@Impure
	Object visitUse(MemberNode use, Object data);

	@Impure
	Object visitUsers(MemberNode memberNode, Object data);

	@Impure
	Object visitUser(MemberNode user, Object data);
}
