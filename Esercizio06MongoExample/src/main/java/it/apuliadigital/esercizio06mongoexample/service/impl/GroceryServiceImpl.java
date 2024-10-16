package it.apuliadigital.esercizio06mongoexample.service.impl;

import it.apuliadigital.esercizio06mongoexample.document.GroceryItem;
import it.apuliadigital.esercizio06mongoexample.mapper.GroceryMapper;
import it.apuliadigital.esercizio06mongoexample.model.GroceryItemDTO;
import it.apuliadigital.esercizio06mongoexample.repository.GroceryRepository;
import it.apuliadigital.esercizio06mongoexample.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    @Autowired
    private GroceryMapper groceryMapper;

    @Override
    public GroceryItemDTO creaProdotto(GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = groceryMapper.toGroceryItem(groceryItemDTO);
        groceryItem = groceryRepository.save(groceryItem);
        return groceryMapper.toGroceryItemDTO(groceryItem);
    }

    @Override
    public GroceryItemDTO getItemById(String id) {
        Optional<GroceryItem> groceryItem = groceryRepository.findById(id);
        return groceryItem.map(item -> groceryMapper.toGroceryItemDTO(item)).orElse(null);
    }

    @Override
    public List<GroceryItemDTO> getItems() {
        List<GroceryItem> groceryItems = groceryRepository.findAll();
        List<GroceryItemDTO> groceryItemDTOs = new ArrayList<>();
        for(GroceryItem groceryItem : groceryItems){
            groceryItemDTOs.add(groceryMapper.toGroceryItemDTO(groceryItem));
        }
        return groceryItemDTOs;
    }

    @Override
    public GroceryItemDTO deleteItem(String id) {
        Optional<GroceryItem> groceryItem = groceryRepository.findById(id);
        if(groceryItem.isEmpty()){
            return null;
        }
        groceryRepository.deleteById(id);
        return groceryMapper.toGroceryItemDTO(groceryItem.get());
    }

    @Override
    public GroceryItemDTO updateItem(GroceryItemDTO groceryItemDTO, String id) {
        Optional<GroceryItem> groceryItem = groceryRepository.findById(id);
        if(groceryItem.isEmpty()){
            return null;
        }

        GroceryItem itemToUpdate = groceryMapper.toGroceryItem(groceryItemDTO);
        itemToUpdate.setId(id);
        itemToUpdate = groceryRepository.save(itemToUpdate);
        return groceryMapper.toGroceryItemDTO(itemToUpdate);
    }
}
