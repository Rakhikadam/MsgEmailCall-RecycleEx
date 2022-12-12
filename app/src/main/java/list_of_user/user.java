package list_of_user;

public class user {
    String name;
    String contact_number;
    String email_id;

    public user(String name, String contact_number, String email_id) {
        this.name = name;
        this.contact_number = contact_number;
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
