package com.agmis.api.repository;

import com.agmis.api.entity.Item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("Select p from Item p where p.name like concat('%', :keyword, '%') OR p.description like concat('%', :keyword, '%')")
    public Collection<Item> findByKeyword(@Param("keyword") String keyword);
}