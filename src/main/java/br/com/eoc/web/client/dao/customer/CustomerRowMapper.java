package br.com.eoc.web.client.dao.customer;

import br.com.eoc.web.client.enums.PersonType;
import br.com.eoc.web.client.enums.Sex;
import br.com.eoc.web.client.vo.CustomerVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<CustomerVO> {

    @Override
    public CustomerVO mapRow(ResultSet rs, int i) throws SQLException {

        CustomerVO vo = new CustomerVO();
        vo.setIdCustomer(rs.getInt("ID_CUSTOMER"));
        vo.setIdCity(rs.getInt("ID_CITY"));
        vo.setFirstName(rs.getString("FIRST_NAME"));
        vo.setLastName(rs.getString("LAST_NAME"));
        vo.setSex(Sex.fromValue(rs.getString("SEX")));
        vo.setZipCode(rs.getString("ZIP_CODE"));
        vo.setAddress(rs.getString("ADDRESS"));
        vo.setAddressNumber(rs.getString("ADDRESS_NUMBER"));
        vo.setComplement(rs.getString("COMPLEMENT"));
        vo.setDistrict(rs.getString("DISTRICT"));
        vo.setDtBirth(rs.getDate("DT_BIRTH"));
        vo.setPersonType(PersonType.fromValue(rs.getString("PERSON_TYPE")));
        vo.setCpfCnpj(rs.getString("CPF_CNPJ"));
        vo.setPassword(rs.getString("PASSWORD"));
        vo.setEmail(rs.getString("EMAIL"));
        vo.setPhone1(rs.getString("PHONE_1"));
        vo.setPhone2(rs.getString("PHONE_2"));
        vo.setToSendNewsletter(rs.getBoolean("IS_TO_SEND_NEWSLETTER"));
        vo.setPercentRateDelivery(rs.getFloat("PERCENT_RATE_DELIVERY"));
        vo.setCardboardBoxDelivery(rs.getBoolean("IS_CARDBOARD_BOX_DELIVERY"));
        vo.setDebitCredit(rs.getFloat("DEBIT_CREDIT"));
        vo.setDtRegister(rs.getTimestamp("DT_REGISTER"));
        vo.setObservation(rs.getString("OBSERVATION"));
        vo.setAmountAccess(rs.getInt("AMOUNT_ACCESS"));
        vo.setDtLastAccess(rs.getTimestamp("DT_LAST_ACCESS"));
        vo.setCdVersion(rs.getInt("CD_VERSION"));
        vo.setDataPending(rs.getBoolean("IS_DATA_PENDING"));
        vo.setActive(rs.getBoolean("IS_ACTIVE"));


        return vo;
    }
}
