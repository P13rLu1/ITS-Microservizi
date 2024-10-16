package it.apuliadigital.esercizio06mongoexample.service;

import it.apuliadigital.esercizio06mongoexample.model.GroceryItemDTO;

import java.util.List;

public interface GroceryService {

    GroceryItemDTO creaProdotto(GroceryItemDTO groceryItemDTO);

    GroceryItemDTO getItemById(String id);

    List<GroceryItemDTO> getItems();

    GroceryItemDTO deleteItem(String id);

    GroceryItemDTO updateItem(GroceryItemDTO groceryItemDTO, String id);

    List<GroceryItemDTO> findByCategory(String category);

    GroceryItemDTO findByName(String name);
}
