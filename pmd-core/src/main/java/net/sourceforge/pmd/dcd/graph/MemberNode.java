/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.dcd.graph;

import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Class Member in a UsageGraph.
 */
public abstract class MemberNode<S extends MemberNode<S, T>, T extends Member> implements NodeVisitorAcceptor,
		Comparable<S> {
	protected final ClassNode classNode;

	protected final String name;

	protected final String desc;

	private List<MemberNode> uses;

	private List<MemberNode> users;

	private Object decoration;

	@SideEffectFree
	public MemberNode(ClassNode classNode, String name, String desc) {
		this.classNode = classNode;
		this.name = name;
		this.desc = desc;
	}

	@Impure
	public Object accept(NodeVisitor visitor, Object data) {
		visitor.visitUses(this, data);
		visitor.visitUsers(this, data);
		return data;
	}

	@Pure
	public ClassNode getClassNode() {
		return classNode;
	}

	@Pure
	public String getName() {
		return name;
	}

	@Pure
	public String getDesc() {
		return desc;
	}

	@Impure
	public abstract T getMember();

	@Impure
	public void addUse(MemberNode use) {
		if (uses == null) {
			uses = new ArrayList<MemberNode>(1);
		}
		if (!uses.contains(use)) {
			uses.add(use);
		}
	}

	@SideEffectFree
	public List<MemberNode> getUses() {
		return uses != null ? uses : Collections.<MemberNode> emptyList();
	}

	@Impure
	public void addUser(MemberNode user) {
		if (users == null) {
			users = new ArrayList<MemberNode>(1);
		}
		if (!users.contains(user)) {
			users.add(user);
		}
	}

	@SideEffectFree
	public List<MemberNode> getUsers() {
		return users != null ? users : Collections.<MemberNode> emptyList();
	}

	@Pure
	public String toString() {
		return name + " " + desc;
	}

	@Impure
	public String toStringLong() {
		return getMember().toString();
	}

	@Pure
	@Impure
	public abstract boolean equals(Object that);

	@Pure
	@Impure
	@SuppressWarnings("PMD.SuspiciousEqualsMethodName")
	public boolean equals(S that) {
		return equals(that.name, that.desc);
	}

	@Pure
	public boolean equals(String name, String desc) {
		return this.name.equals(name) && this.desc.equals(desc);
	}

	@Pure
	public int hashCode() {
		return name.hashCode() + desc.hashCode();
	}
}
