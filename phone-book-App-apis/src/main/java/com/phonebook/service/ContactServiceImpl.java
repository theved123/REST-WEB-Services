package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactServiceI {
	@Autowired
	private ContactRepo contactRepo;

//save
	@Override
	public boolean saveContact(Contact contact) {
		Contact contact2 = contactRepo.save(contact);
		if (contact2 != null) {
			return true;
		} else {
			return false;
		}
	}
// update
	@Override
	public boolean updateContact(Contact contact) {
		Contact contact2 = contactRepo.save(contact);
		if(contact2!=null) {
			return true;
		}else {
			
			return false;
		}
		
	}

// get All Contact
	@Override
	public List<Contact> getAllContact() {
		List<Contact> list = contactRepo.findAll();

		return list;
	}

//get Contact by Id
	@Override
	public Contact getContactById(Integer contactId) {
		Contact contactId2 = contactRepo.findById(contactId).get();

		return contactId2;

	}

//delete
	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean existsById = contactRepo.existsById(contactId);
		if (existsById) {
			contactRepo.deleteById(contactId);
			return true;
		} else {
			return false;
		}
	}
	@Override
	public boolean deleteConatctSoft(Integer id) {
		
		Contact contact = contactRepo.findById(id).get();
		if(contact !=null) {
		
			contact.setActiveSwitch('N');//
			contactRepo.save(contact);
			return true;
		}else
		
		return false;
	}

}
