package com.napier.mlsServices.dto;
import com.napier.mlsServices.entity.Screen;

public class ScreenDTO {
   
	private Screen screen;

	public ScreenDTO() {
		super();
	}

	public ScreenDTO(Screen screen) {
		super();
		this.screen = screen;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Request [screen=" + screen + "]";
	}
	
}
