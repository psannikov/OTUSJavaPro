package ru.otus.pro.psannikov.spring.data.jdbc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.CreateOrUpdateCategoryDtoRq;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Category;
import ru.otus.pro.psannikov.spring.data.jdbc.repositories.CategoriesRepository;
import ru.otus.pro.psannikov.spring.data.jdbc.services.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

    public Category findById(Long id) {
        return categoriesRepository.findById(id).get();
    }

    public void createNewCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Category newCategory = new Category(createOrUpdateCategoryDtoRq.getId(), createOrUpdateCategoryDtoRq.getTitle());
        categoriesRepository.save(newCategory);
    }

    public void updateCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Category updatedCategory = new Category(createOrUpdateCategoryDtoRq.getId(), createOrUpdateCategoryDtoRq.getTitle());
        categoriesRepository.save(updatedCategory);
    }

    public void deleteById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public Category findByTitle(String title) {
        return categoriesRepository.findByTitle(title).get();
    }

    public List<Category> findAllByTitleLike(String title) {
        return categoriesRepository.findAllByTitleLike(title);
    }
}
