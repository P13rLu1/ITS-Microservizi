package it.apuliadigital.esercizio06mongoexample.mapper;

import it.apuliadigital.esercizio06mongoexample.document.GroceryItem;
import it.apuliadigital.esercizio06mongoexample.model.GroceryItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroceryMapper {

    GroceryItem toGroceryItem(GroceryItemDTO groceryItemDTO);

    GroceryItemDTO toGroceryItemDTO(GroceryItem groceryItem);

    List<GroceryItem> toGroceryItemList(List<GroceryItemDTO> groceryItemDTO);

    List<GroceryItemDTO> toGroceryItemDTOList(List<GroceryItem> groceryItem);
}
