package com.rvg.unittesting.unit_testing.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvg.unittesting.unit_testing.model.Item;

public interface ItemRespository extends JpaRepository<Item, Integer> {

}
