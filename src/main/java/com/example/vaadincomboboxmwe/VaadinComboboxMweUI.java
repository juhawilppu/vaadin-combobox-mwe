package com.example.vaadincomboboxmwe;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringUI;

@SpringUI
@Theme("VaadinComboboxMwe")
public class VaadinComboboxMweUI extends UI{
	
	private static final long serialVersionUID = 8278873224498144772L;

	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout layout = new VerticalLayout();
		
		FormLayout form = new FormLayout();
		layout.addComponent(form);

		Binder<Person> binder = new Binder<Person>();		

		TextField name = new TextField("Name");
		binder.forField(name).bind(Person::getName, Person::setName);
		form.addComponent(name);

		ComboBox<Dog> dog = new ComboBox<Dog>("Dog");
		dog.setItemCaptionGenerator(Dog::getName);
		List<Dog> items = new ArrayList<Dog>();
		items.add(new Dog(0, "Sissi"));
		items.add(new Dog(1, "Stella"));
		items.add(new Dog(2, "Snappi"));
		dog.setItems(items);
		binder.forField(dog)
				.withConverter(new ComboBoxDogToIdConverter(items))
				.bind(Person::getDog, Person::setDog);
		
		form.addComponent(dog);
		
		setContent(layout);
	}
}
