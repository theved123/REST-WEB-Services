package com.phonebook.service;

import java.util.List;

import com.phonebook.entity.Contact;

public interface ContactServiceI {
	
	boolean saveContact(Contact contact);
	List<Contact> getAllContact();
	Contact getContactById(Integer contactId);
	public abstract boolean updateContact(Contact contact);
	boolean deleteContactById(Integer contactId);
	public abstract boolean deleteConatctSoft(Integer id);
}
