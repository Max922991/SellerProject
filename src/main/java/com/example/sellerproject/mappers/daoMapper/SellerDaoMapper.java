package com.example.sellerproject.mappers.daoMapper;

import com.example.sellerproject.dto.SellerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDaoMapper implements RowMapper<SellerDTO> {

    private final String SELLER_ID = "seller_id";
    private final String SELLER_NAME = "name";
    private final String EMAIL = "email";
    private final String PHONE_NUMBER = "phone_number";

    @Override
    public SellerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        //todo нужен ли Id в сущностях для явного назначения из ResultSet?
        SellerDTO sellerDTO = SellerDTO.builder()
                .name(rs.getString(SELLER_NAME))
                .email(rs.getString(EMAIL))
                .phoneNumber(rs.getString(PHONE_NUMBER))
                .build();
        return sellerDTO;
    }
}
