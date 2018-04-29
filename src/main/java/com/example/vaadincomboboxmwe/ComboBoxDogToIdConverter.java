package com.example.vaadincomboboxmwe;

import java.util.List;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;

public class ComboBoxDogToIdConverter implements Converter<Dog, Integer> {

	private static final long serialVersionUID = 1470235722530093222L;

	private List<Dog> items;

	public ComboBoxDogToIdConverter(List<Dog> items) {
		this.items = items;
	}

	@Override
	public Result<Integer> convertToModel(Dog value, ValueContext context) {
		return Result.ok(value.getId());
	}

	@Override
	public Dog convertToPresentation(Integer value, ValueContext context) {
		return items.stream().filter(i->i.getId() == value).findFirst().get();
	}

}
