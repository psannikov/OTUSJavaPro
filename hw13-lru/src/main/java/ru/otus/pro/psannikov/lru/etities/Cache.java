package ru.otus.pro.psannikov.lru.etities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_lru")
public class Cache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cache_key")
    private String key;
    private String cacheValue;

    public Cache(String cacheKey, String cacheValue) {
        this.key = cacheKey;
        this.cacheValue = cacheValue;
    }
}
