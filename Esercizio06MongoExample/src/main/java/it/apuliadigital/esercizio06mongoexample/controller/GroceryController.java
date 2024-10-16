package it.apuliadigital.esercizio06mongoexample.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio06mongoexample.api.GroceryitemApi;
import it.apuliadigital.esercizio06mongoexample.model.GroceryItemDTO;
import it.apuliadigital.esercizio06mongoexample.service.GroceryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroceryController implements GroceryitemApi {

    Logger logger = LoggerFactory.getLogger(GroceryController.class);

    @Autowired
    private GroceryService groceryService;

    @Override
    public ResponseEntity<GroceryItemDTO> creaItem(@Parameter(name = "GroceryItemDTO", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO) {
        GroceryItemDTO groceryItem = groceryService.creaProdotto(groceryItemDTO);

        logger.info("Item creato con successo");

        return new ResponseEntity<>(groceryItem, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GroceryItemDTO> getItem(@Parameter(name = "idItem", description = "L'ID dell'item", required = true, in = ParameterIn.PATH) @PathVariable("idItem") String idItem) {
        GroceryItemDTO groceryItem = groceryService.getItemById(idItem);

        logger.info("Item recuperato con successo");

        return new ResponseEntity<>(groceryItem, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GroceryItemDTO>> listaItem() {
        List<GroceryItemDTO> groceryItems = groceryService.getItems();

        logger.info("Lista item recuperata con successo");

        return new ResponseEntity<>(groceryItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GroceryItemDTO> eliminaItem(@Parameter(name = "idItem", description = "L'ID dell'item", required = true, in = ParameterIn.PATH) @PathVariable("idItem") String idItem) {
        GroceryItemDTO groceryItem = groceryService.deleteItem(idItem);

        logger.info("Item eliminato con successo");

        return new ResponseEntity<>(groceryItem, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GroceryItemDTO> modificaItem(@Parameter(name = "idItem", description = "L'ID dell'item", required = true, in = ParameterIn.PATH) @PathVariable("idItem") String idItem, @Parameter(name = "GroceryItemDTO", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO) {
        GroceryItemDTO groceryItem = groceryService.updateItem(groceryItemDTO, idItem);

        logger.info("Item modificato con successo");

        return new ResponseEntity<>(groceryItem, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GroceryItemDTO>> getItemByCategory(@Parameter(name = "category", description = "La categoria dell'item", required = true, in = ParameterIn.PATH) @PathVariable("category") String category) {
        List<GroceryItemDTO> groceryItems = groceryService.findByCategory(category);

        logger.info("Lista item in base alla categoria recuperata con successo");

        return new ResponseEntity<>(groceryItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GroceryItemDTO> getItemByName(@Parameter(name = "name", description = "Il nome dell'item", required = true, in = ParameterIn.PATH) @PathVariable("name") String name) {
        GroceryItemDTO groceryItem = groceryService.findByName(name);

        logger.info("Item tramite nome recuperato con successo");

        return new ResponseEntity<>(groceryItem, HttpStatus.OK);
    }
}
