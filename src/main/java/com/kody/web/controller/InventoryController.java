package com.kody.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kody.web.businessservices.InventoryBusinessService;
import com.kody.web.dto.Inventory;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryBusinessService inventoryBusinessSrvc;

	
	@GetMapping("/all")
	public @ResponseBody List getCustomers() {
		return null;
	}

	@GetMapping("/items/{id}")
	public ResponseEntity getInventory(@PathVariable("id") Long id) {

		Inventory customer = inventoryBusinessSrvc.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/items")
	public ResponseEntity<Inventory> createItem(@RequestBody Inventory item) {

		inventoryBusinessSrvc.create(item);

		return new ResponseEntity<Inventory>(item, HttpStatus.OK);
	}

	@DeleteMapping(value="/items/{id}",headers="Accept=application/json", produces={"application/json"})
	public ResponseEntity<String> deleteItem(@PathVariable Long id) {

		if (null == inventoryBusinessSrvc.delete(id)) {
			return new ResponseEntity<String>("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(id.toString(), HttpStatus.OK);

	}

	@PutMapping("/items/{id}")
	//@RequestMapping(value = "/items/{id}", method = RequestMethod.PUT, produces={"application/json"})
	public ResponseEntity<Inventory> updateItem(@PathVariable Long id, @RequestBody Inventory item) {

		/*item = inventoryBusinessSrvc.update(id, item);

		if (null == item) {
			item = new Inventory();
			item.setId(id);
			item.setItemName("Not Found");
			return new ResponseEntity<Inventory>(item, HttpStatus.NOT_FOUND);
		}*/

		return new ResponseEntity<Inventory>(item, HttpStatus.OK);
	}
	
}
