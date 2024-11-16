package org.example;

import org.hibernate.Transaction;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

//chạy query này trong SQL trước r mới chạy code
//CREATE TABLE sequence_table (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY
//        );

public class CustomID implements IdentifierGenerator {
    private static final String PREFIX = "HS";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        session.createNativeQuery("INSERT INTO sequence_table () VALUES ()").executeUpdate();

        // Fetch the last inserted ID
        Long sequenceValue = ((Number) session.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).longValue();

        // Combine prefix and sequence value
        return PREFIX + String.format("%06d", sequenceValue); // Adjust formatting as needed
    }
}
