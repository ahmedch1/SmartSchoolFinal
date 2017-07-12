package ahmedchtn.smartschool;

/**
 * Created by Ahmed Chouihi on 29-06-2017.
 */

public class MarkItem {

    private String subject;
    private String name;
    private String value;
    private String markUrl;

    public MarkItem(String subject, String name,String value, String markUrl) {
        this.subject = subject;
        this.name = name;
        this.value=value;
        this.markUrl = markUrl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    // get the user name

    public String getName() {
        return name;
    }

    //set the user name

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMarkUrl() {
        return markUrl;
    }

    public void setMarkUrl(String markUrl) {
        this.markUrl = markUrl;
    }
}

