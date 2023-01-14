package com.phonebook.controller;

import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.Contact;
import com.phonebook.props.AppProps;
import com.phonebook.service.ContactServiceI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ContactController {
	
	
	
	@Autowired
	private ContactServiceI contactServiceI;
	@Autowired
	private AppProps aps;

// save	
	@PostMapping(value = "/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
		boolean saveContact = contactServiceI.saveContact(contact);
		Map<String, String> messages = aps.getMessages();
		System.out.println(messages);
		
		if (saveContact) {
			String msg = messages.get("saveSucess");
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(messages.get("saveFail"), HttpStatus.CREATED);

		}
	}

// update	
	@PostMapping(value = "/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
		boolean saveContact = contactServiceI.saveContact(contact);
		if (saveContact) {
			String msg = "Contact Update Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not v Successfully", HttpStatus.CREATED);

		}
	}
// delete

	@DeleteMapping(value = "/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer contactId) {
		boolean deleteContact = contactServiceI.deleteContactById(contactId);

		if (deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.CREATED);

		}

	}

// get Contact By id
	@GetMapping(value = "/getContactById/{contactId}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId) {

		Contact contactById = contactServiceI.getContactById(contactId);
		log.info("Contact Getting Successfully.....");
		return new ResponseEntity<Contact>(contactById, HttpStatus.OK);
	}

// get ALL Contact
	@GetMapping(value = "getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> allContact = contactServiceI.getAllContact();
		Stream<Contact> stream = allContact.stream();
		Stream<Contact> filter = stream.filter((contact) -> contact.getActiveSwitch()=='Y');
		List<Contact> list = filter.collect(Collectors.toList());
		return new ResponseEntity<List<Contact>>(allContact, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteContactsoft/{contactId}")
	public ResponseEntity<String> deleteContactSoft(@PathVariable Integer contactId) {
		boolean deleteContact = contactServiceI.deleteConatctSoft(contactId);

		if (deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.CREATED);

		}

	}

}
