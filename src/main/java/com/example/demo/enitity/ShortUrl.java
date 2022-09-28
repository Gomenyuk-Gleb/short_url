package com.example.demo.enitity;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "short_name")
@Data
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originalUrl;
    private String shortUrl = create();
    @Column(insertable = false, name = "create_at")
    private Date createAt;

    private String create() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
