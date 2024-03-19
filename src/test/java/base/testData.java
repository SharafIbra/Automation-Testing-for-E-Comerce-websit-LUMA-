package base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class testData {

    private final int userNumber = 1;
    private final int addressNumber = 1;

    {
        JSONParser jsonParser = new JSONParser();
        Object object = null;

        try {
            object = jsonParser.parse(new FileReader("D:\\St\\Projects\\LUMA\\src\\main\\resources\\testData.json"));
        } catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }

        JSONObject jasonO_AllData = (JSONObject) object;


        JSONArray array_user = (JSONArray) jasonO_AllData.get("SignUp Information");
        JSONObject jsonObject_user = (JSONObject) array_user.get(userNumber - 1);

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
        String WomenProduct = (String) jasonO_AllData.get("WomenProduct");
        String MenProduct = (String) jasonO_AllData.get("MenProduct");


        JSONArray array_address = (JSONArray) jasonO_AllData.get("Addresses");
        JSONObject jsonObject_address = (JSONObject) array_address.get(addressNumber - 1);

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
        setWomenProduct(WomenProduct);
        setMenProduct(MenProduct);
    }    protected String firstname = getFirstname();

    private String getFirstname() {
        return firstname;
    }    protected String lastname = getLastname();

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }    protected String email = getEmail();

    private String getLastname() {
        return lastname;
    }    protected String password = getPassword();

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }    protected String confirm_password = getConfirm_password();

    private String getEmail() {
        return email;
    }    protected String company = getCompany();

    public void setEmail(String email) {
        this.email = email;
    }    protected String phone_number = getPhone_number();

    private String getPassword() {
        return password;
    }    protected String address1 = getAddress1();

    private void setPassword(String password) {
        this.password = password;
    }    protected String address2 = getAddress2();

    private String getConfirm_password() {
        return confirm_password;
    }    protected String address3 = getAddress3();

    private void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }    protected String city = getCity();

    private String getCompany() {
        return company;
    }    protected String state = getState();

    private void setCompany(String company) {
        this.company = company;
    }    protected String postalcode = getPostalcode();

    private String getPhone_number() {
        return phone_number;
    }    protected String country = getCountry();

    private void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }    protected String WomenProduct = getWomenProduct();

    private String getAddress1() {
        return address1;
    }    protected String MenProduct = getMenProduct();

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    private String getAddress2() {
        return address2;
    }

    private void setAddress2(String address2) {
        this.address2 = address2;
    }

    private String getAddress3() {
        return address3;
    }

    private void setAddress3(String address3) {
        this.address3 = address3;
    }
    /*JSONArray subjects = (JSONArray)userjasonobj.get("Subjects");*/

    private String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private String getState() {
        return state;
    }

    private void setState(String state) {
        this.state = state;
    }

    private String getPostalcode() {
        return postalcode;
    }

    private void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    private String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    public String getWomenProduct() {
        return WomenProduct;
    }

    private void setWomenProduct(String WomenProduct) {
        this.WomenProduct = WomenProduct;
    }

    public String getMenProduct() {
        return MenProduct;
    }

    private void setMenProduct(String menProduct) {
        MenProduct = menProduct;
    }

































}
