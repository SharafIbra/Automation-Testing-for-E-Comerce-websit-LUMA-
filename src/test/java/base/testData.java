package base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class testData {

    private final int userNumber = 3;
    private final int addressNumber = 2;

    {
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {
            object = jsonParser.parse(new FileReader("D:\\St\\Testing\\Projects\\1-LUMA\\src\\main\\resources\\testData\\testData.json"));
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
        String MenProduct_jacket = (String) jasonO_AllData.get("MenProduct_jacket");
        String MenProduct_pant = (String) jasonO_AllData.get("MenProduct_pant");


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
        setMenProduct_jacket(MenProduct_jacket);
        setMenProduct_pant(MenProduct_pant);
    }

    private String getFirstname() {
        return firstname;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String getLastname() {
        return lastname;
    }    protected String firstname = getFirstname();

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }    protected String lastname = getLastname();

    private String getEmail() {
        return email;
    }    protected String email = getEmail();

    public void setEmail(String email) {
        this.email = email;
    }

    private String getPassword() {
        return password;
    }    protected String password = getPassword();

    private void setPassword(String password) {
        this.password = password;
    }

    private String getConfirm_password() {
        return confirm_password;
    }    protected String confirm_password = getConfirm_password();

    private void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    private String getCompany() {
        return company;
    }    protected String company = getCompany();

    private void setCompany(String company) {
        this.company = company;
    }

    private String getPhone_number() {
        return phone_number;
    }    protected String phone_number = getPhone_number();

    private void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    private String getAddress1() {
        return address1;
    }    protected String address1 = getAddress1();

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    private String getAddress2() {
        return address2;
    }    protected String address2 = getAddress2();

    private void setAddress2(String address2) {
        this.address2 = address2;
    }

    private String getAddress3() {
        return address3;
    }    protected String address3 = getAddress3();

    private void setAddress3(String address3) {
        this.address3 = address3;
    }

    private String getCity() {
        return city;
    }    protected String city = getCity();

    private void setCity(String city) {
        this.city = city;
    }

    private String getState() {
        return state;
    }    protected String state = getState();

    private void setState(String state) {
        this.state = state;
    }

    private String getPostalcode() {
        return postalcode;
    }    protected String postalcode = getPostalcode();

    private void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    private String getCountry() {
        return country;
    }    protected String country = getCountry();

    private void setCountry(String country) {
        this.country = country;
    }

    public String getWomenProduct() {
        return WomenProduct;
    }    protected String WomenProduct = getWomenProduct();

    private void setWomenProduct(String WomenProduct) {
        this.WomenProduct = WomenProduct;
    }

    public String getMenProduct_jacket() {
        return MenProduct_jacket;
    }    protected String MenProduct_jacket = getMenProduct_jacket();

    private void setMenProduct_jacket(String menProduct_jacket) {
        this.MenProduct_jacket = menProduct_jacket;
    }    protected String MenProduct_pant = getMenProduct_pant();

    public String getMenProduct_pant() {
        return MenProduct_pant;
    }

    private void setMenProduct_pant(String menProduct_pant) {
        this.MenProduct_pant = MenProduct_pant;
    }



}
