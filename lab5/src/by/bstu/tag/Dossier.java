package by.bstu.tag;

import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";

    @Override
    public int doStartTag() {

        try {
            pageContext.getOut().write(String.format("<form method = 'post' action= '%s'>", this.action));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() {
        String in = "</form>";

        try {
            pageContext.getOut().write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_PAGE;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
