package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("CATEGORIES_WITHOUT_AUTOGENERATED_ID")
public class CategoryWithoutAutogeneratedId implements Persistable<Long> {
    @Id
    private Long id;
    private String title;
    @Transient
    private boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @PersistenceCreator
    public CategoryWithoutAutogeneratedId(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
