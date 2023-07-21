package com.example.sellerproject.dao;

import com.example.sellerproject.models.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SellerDao {
    public NamedParameterJdbcTemplate template;

//    public Long createNewSeller(Seller seller) {
//      String sql = "INSERT INTO sellers (seller_name, email, phone_number) VALUES (:seller_name, :email, :phone_number) RETURNING ID";
//      Map<String, Object> map = new HashMap<>();
//      map.put("seller_name", seller.getSeller_name());
//      map.put("email", seller.getEmail());
//      map.put("phone_number", seller.getPhoneNumber());
//     return template.queryForObject(sql, map, Long.class);
//    }

    public Long createNewSeller(Seller seller) {
        String sql = "INSERT INTO sellers (seller_name, email, phone_number) VALUES (:seller_name, :email, :phone_number) RETURNING ID";
        SqlParameterSource source = new MapSqlParameterSource()
                .addValue("seller_name", seller.getSeller_name())
                .addValue("email", seller.getEmail())
                .addValue("phone_number", seller.getPhoneNumber());
        return template.queryForObject(sql, source, Long.class);
    }

    public Seller getDaoSellerById(Long id) {
        String sql = "SELECT * FROM sellers WHERE sellers.id = :id";
        SqlParameterSource source = new MapSqlParameterSource("id", id);
        Seller seller = new Seller();
        return template.queryForObject(sql, source, (rs, rowNum) -> {
            seller.setId(rs.getLong("id"));
            seller.setSeller_name(rs.getString("seller_name"));
            seller.setEmail(rs.getString("email"));
            seller.setId( rs.getLong("phone_number"));
            return seller;
        });
    }
}
