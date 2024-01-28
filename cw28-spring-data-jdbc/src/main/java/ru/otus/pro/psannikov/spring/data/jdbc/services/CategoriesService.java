package ru.otus.pro.psannikov.spring.data.jdbc.services;

import ru.otus.pro.psannikov.spring.data.jdbc.dtos.CreateOrUpdateCategoryDtoRq;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Category;

import java.util.List;

public interface CategoriesService {
    public List<Category> findAll();

    public Category findById(Long id);

    public void createNewCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq);

    public void updateCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq);

    public void deleteById(Long id);

    public Category findByTitle(String title);

    public List<Category> findAllByTitleLike(String title);
}
