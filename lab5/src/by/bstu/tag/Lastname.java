package by.bstu.tag;

import jakarta.servlet.jsp.tagext.TagSupport;

public class Lastname extends TagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write(String.format("<input type='text' name='%s'/>", this.name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return SKIP_BODY;
    }
}
