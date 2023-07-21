package com.example.sellerproject.mappers.daoMapper;

import com.example.sellerproject.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoMapper implements RowMapper<ProductDTO> {

    private final String TITLE = "title";
    private final String DESCRIPTION = "description";
    private final int PRICE = Integer.parseInt("price");


    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        //todo нужен ли Id в сущностях для явного назначения из ResultSet?
    ProductDTO productDTO = ProductDTO.builder()
            .title(rs.getString(TITLE))
            .description(rs.getString(DESCRIPTION))
            .price(rs.getInt(PRICE))
            .build();
    return productDTO;
    }
}
