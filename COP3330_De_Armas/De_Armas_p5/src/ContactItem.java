public class ContactItem {
    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;

    public ContactItem(String inFirstName, String inLastName, String inPhoneNumber, String inEmailAddress){
        if (inFirstName.length()==0&&inLastName.length()==0&&inPhoneNumber.length()==0&&inEmailAddress.length()==0){
            throw new IllegalArgumentException("WARNING: At least one value must be entered; task not created");
        }

        this.firstName = inFirstName;
        this.lastName = inLastName;

        if(inPhoneNumber.length()!=0) {
            if (inPhoneNumber.length() != 12) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(0)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(1)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(2)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(4)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(5)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(6)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(8)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(9)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(10)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else if (Character.isDigit(inPhoneNumber.charAt(11)) != true) {
                throw new IllegalArgumentException("WARNING: invalid Phone Number; task not created");
            } else {
                this.phoneNumber = inPhoneNumber;
            }
        }else{
            this.phoneNumber = inPhoneNumber;
        }

        if(inEmailAddress.length()!=0) {
            if (inEmailAddress.contains("@") && inEmailAddress.contains(".")) {
                this.emailAddress = inEmailAddress;
            } else {
                throw new IllegalArgumentException("WARNING: invalid Email Address; task not created");
            }
        }else{
            this.emailAddress = inEmailAddress;
        }

    }
}
