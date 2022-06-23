package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItem(){

        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseUtil(200,"OK",allItems);
    }

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return new ResponseUtil(200,"Item Saved",null);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(@RequestParam String code){
        itemService.deleteItem(code);
        return new ResponseUtil(200,"Item Deleted",null);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        itemService.updateItem(dto);
        return new ResponseUtil(200,"Item Updated...",null);

    }

}
