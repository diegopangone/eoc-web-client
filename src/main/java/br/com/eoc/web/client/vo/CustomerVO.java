/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eoc.web.client.vo;

import br.com.eoc.web.client.enums.PersonType;
import br.com.eoc.web.client.enums.Sex;

import java.util.Date;
import java.util.List;

public class CustomerVO extends AbstractVO {

    private Integer idCustomer;
    private Integer idCity;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    private Sex sex;
    private String zipCode;
    private String address;
    private String addressNumber;
    private String complement;
    private String district;
    private Date dtBirth;
    private PersonType personType;
    private String cpfCnpj;
    private String phone1;
    private String phone2;
    private boolean isToSendNewsletter;
    private Float percentRateDelivery;
    private boolean isCardboardBoxDelivery;
    private Float debitCredit;
    private Date dtRegister;
    private String observation;
    private Integer amountAccess;
    private Date dtLastAccess;
    private Integer cdVersion;
    private boolean isDataPending;
    private boolean isActive;
    private List<RouteVO> listRoutes;

    @Override
    public Integer getId() {
        return this.idCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(Date dtBirth) {
        this.dtBirth = dtBirth;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public boolean isToSendNewsletter() {
        return isToSendNewsletter;
    }

    public void setToSendNewsletter(boolean toSendNewsletter) {
        isToSendNewsletter = toSendNewsletter;
    }

    public Float getPercentRateDelivery() {
        return percentRateDelivery;
    }

    public void setPercentRateDelivery(Float percentRateDelivery) {
        this.percentRateDelivery = percentRateDelivery;
    }

    public boolean isCardboardBoxDelivery() {
        return isCardboardBoxDelivery;
    }

    public void setCardboardBoxDelivery(boolean cardboardBoxDelivery) {
        isCardboardBoxDelivery = cardboardBoxDelivery;
    }

    public Float getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(Float debitCredit) {
        this.debitCredit = debitCredit;
    }

    public Date getDtRegister() {
        return dtRegister;
    }

    public void setDtRegister(Date dtRegister) {
        this.dtRegister = dtRegister;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Integer getAmountAccess() {
        return amountAccess;
    }

    public void setAmountAccess(Integer amountAccess) {
        this.amountAccess = amountAccess;
    }

    public Date getDtLastAccess() {
        return dtLastAccess;
    }

    public void setDtLastAccess(Date dtLastAccess) {
        this.dtLastAccess = dtLastAccess;
    }

    public Integer getCdVersion() {
        return cdVersion;
    }

    public void setCdVersion(Integer cdVersion) {
        this.cdVersion = cdVersion;
    }

    public boolean isDataPending() {
        return isDataPending;
    }

    public void setDataPending(boolean dataPending) {
        isDataPending = dataPending;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<RouteVO> getListRoutes() {
        return listRoutes;
    }

    public void setListRoutes(List<RouteVO> listRoutes) {
        this.listRoutes = listRoutes;
    }
}
