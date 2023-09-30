package base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class testData {

    private int userNumber = 4;
    private int addressNumber = 1;





    protected String firstname = getFirstname();
    protected String lastname = getLastname();
    protected String email = getEmail();
    protected String password = getPassword();
    protected String confirm_password = getConfirm_password();
    protected String company = getCompany();
    protected String phone_number = getPhone_number();
    protected String address1 = getAddress1();
    protected String address2 = getAddress2();
    protected String address3 = getAddress3();

    protected String city = getCity();
    protected String state = getState();
    protected String postalcode = getPostalcode();
    protected String country = getCountry();

    {
        JSONParser jsonParser = new JSONParser();
        Object object = null;

        try {
            object = jsonParser.parse(new FileReader("src/test/java/testData.json"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        JSONObject jasonO_AllData = (JSONObject) object;


        JSONArray array_user = (JSONArray) jasonO_AllData.get("SignUp Information");
        JSONObject jsonObject_user = (JSONObject) array_user.get(userNumber-1);

        String firstname = (String) jsonObject_user.get("firstname");
        String lastname = (String) jsonObject_user.get("lastname");
        String email = (String) jsonObject_user.get("email");
        String password = (String) jsonObject_user.get("password");
        String confirm_password = (String) jsonObject_user.get("confirm_password");

        String company = (String) jasonO_AllData.get("Company");
        String phone_number = (String) jasonO_AllData.get("phone_number");
        String city = (String) jasonO_AllData.get("city");
        String state = (String) jasonO_AllData.get("state");
        String postalcode = (String) jasonO_AllData.get("postalcode");
        String country = (String) jasonO_AllData.get("country");

        JSONArray array_address = (JSONArray) jasonO_AllData.get("Addresses");
        JSONObject jsonObject_address = (JSONObject) array_address.get(addressNumber-1);

        String address1 = (String) jsonObject_address.get("address1");
        String address2 = (String) jsonObject_address.get("address2");
        String address3 = (String) jsonObject_address.get("address3");



        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setPassword(password);
        setConfirm_password(confirm_password);
        setCompany(company);
        setPhone_number(phone_number);
        setAddress1(address1);
        setAddress2(address2);
        setAddress3(address3);
        setCity(city);
        setState(state);
        setPostalcode(postalcode);
        setCountry(country);
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    private void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private void setPassword(String password) {
        this.password = password;
    }
    /*JSONArray subjects = (JSONArray)userjasonobj.get("Subjects");*/

    private void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    private void setCompany(String company) {
        this.company = company;
    }
    private void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    private void setAddress2(String address2) {
        this.address2 = address2;
    }

    private void setAddress3(String address3) {
        this.address3 = address3;
    }

    private void setCity(String city) {
        this.city = city;
    }
    private void setState(String state) {
        this.state = state;
    }
    private void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    private void setCountry(String country) {
        this.country = country;
    }









    private String getFirstname() {
        return firstname;
    }
    private String getLastname() {
        return lastname;
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
    }
    private String getConfirm_password() {
        return confirm_password;
    }
    private String getCompany() {
        return company;
    }
    private String getPhone_number() {
        return phone_number;
    }
    private String getAddress1() {
        return address1;
    }

    private String getAddress2() {
        return address2;
    }

    private String getAddress3() {
        return address3;
    }

    private String getCity() {
        return city;
    }
    private String getState() {
        return state;
    }
    private String getPostalcode() {
        return postalcode;
    }
    private String getCountry() {
        return country;
    }

}
