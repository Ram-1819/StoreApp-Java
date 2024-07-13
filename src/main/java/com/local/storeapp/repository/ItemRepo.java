package com.local.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.storeapp.entity.ItemEntity;

public interface ItemRepo extends JpaRepository<ItemEntity, Long>  {

}
