/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTJspDirectiveAttribute.java */

package net.sourceforge.pmd.lang.jsp.ast;

public class ASTJspDirectiveAttribute extends AbstractJspNode {

    /* BEGIN CUSTOM CODE */
    private String name;
    private String value;

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }
/* END CUSTOM CODE */

    public ASTJspDirectiveAttribute(int id) {
        super(id);
    }

    public ASTJspDirectiveAttribute(JspParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JspParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
