package transfer;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Катерина on 23.02.2015.
 */
public class Contact extends TransferObject
{
    String firstName;
    String secondName;
    String nameByFather;
    DateTime dateOfBirth;
    Sex sex;
    String sitizenship;
    String webSite;
    String email;
    String company;
    String photoUrl;
    Integer addressId;

    //  Списки присоединений, адрес, телефоны
    Address address;
    ArrayList<Telephone> telephones;
    ArrayList<Attachment> attachments;

    public Contact(){
        super();
        telephones = new ArrayList<Telephone>();
        attachments = new ArrayList<Attachment>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(firstName);
        sb.append(" ");
        sb.append(secondName);
        if(StringUtils.isNotEmpty(nameByFather)){
            sb.append(" ");
            sb.append(nameByFather);
        }
        if(dateOfBirth != null){
            sb.append(", ");
            sb.append(getFormattedDateOfBirth());
        }
        if(sex != null){
            sb.append(", ");
            sb.append(sex);
        }
        if(StringUtils.isNotEmpty(sitizenship)){
            sb.append(", ");
            sb.append(sitizenship);
        }
        if(StringUtils.isNotEmpty(webSite)){
            sb.append(", ");
            sb.append(webSite);
        }
        if(StringUtils.isNotEmpty(email)){
            sb.append(", ");
            sb.append(email);
        }
        if(StringUtils.isNotEmpty(company)){
            sb.append(", ");
            sb.append(company);
        }
        if(StringUtils.isNotEmpty(photoUrl)){
            sb.append(", ");
            sb.append(photoUrl);
        }
        return sb.toString();
    }

    public Contact(Integer id, String firstName, String secondName, String nameByFather, DateTime dateOfBirth, Sex sex, String sitizenship, String webSite, String email, String company, String photoUrl, Integer addressId) {
        super(id);
        telephones = new ArrayList<Telephone>();
        attachments = new ArrayList<Attachment>();
        this.firstName = firstName;
        this.secondName = secondName;
        this.nameByFather = nameByFather;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.sitizenship = sitizenship;
        this.webSite = webSite;
        this.email = email;
        this.company = company;
        this.photoUrl = photoUrl;
        this.addressId = addressId;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> _attachments) {
        attachments = _attachments;
    }

    public ArrayList<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(ArrayList<Telephone> _telephones) {
        telephones = _telephones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address _address) {
        address = _address;
    }

    public String getFirstName()
    {
        return  firstName;
    }

    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public  void setSecondName(String _secondName)
    {
        secondName = _secondName;
    }

    public String getNameByFather() {
        return nameByFather;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFormattedDateOfBirth() {
        if (dateOfBirth == null) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.YYYY");
        return dateTimeFormatter.print(dateOfBirth);
    }

    public Integer getDay(){
        if(dateOfBirth == null){
            return null;
        }
        return dateOfBirth.getDayOfMonth();
    }

    public Integer getMonth(){
        if(dateOfBirth == null){
            return null;
        }
        return dateOfBirth.getMonthOfYear();
    }

    public Integer getYear(){
        if(dateOfBirth == null){
            return null;
        }
        return  dateOfBirth.getYear();
    }

    public Sex getSex() {
        return sex;
    }

    public String getSitizenship() {
        return sitizenship;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setNameByFather(String _nameByFather) {
        nameByFather = _nameByFather;
    }

    public void setDateOfBirth(DateTime _dateOfBirth) {
        dateOfBirth = _dateOfBirth;
    }

    public void setSex(Sex _sex) {
        sex = _sex;
    }

    public void setSitizenship(String _sitizenship) {
        sitizenship = _sitizenship;
    }

    public void setWebSite(String _webSite) {
        webSite = _webSite;
    }

    public void setEmail(String _email) {
        email = _email;
    }

    public void setCompany(String _company) {
        company = _company;
    }

    public void setPhotoUrl(String _photoUrl) {
        photoUrl = _photoUrl;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getIfMale(){
        if(sex != null){
            return sex == Sex.m ? "checked" : null;
        }
        return null;
    }

    public String getIfFemale(){
        if(sex != null){
            return sex == Sex.f ? "checked" : null;
        }
        return null;
    }

    public boolean getHasAvatar(){
        return StringUtils.isNotEmpty(photoUrl);
    }
}
