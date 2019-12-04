package a8;

abstract public class LifeViewEvent {
	public boolean isRandomEvent() {
		return false;
	}

	public boolean isRunEvent() {
		return false;
	}
	
	public boolean isClearEvent() {
		return false;
	}

	public boolean isTorusEvent() {
		return false;
	}
	
	public boolean isHeightSlideEvent() {
		return false;
	}
	
	public boolean isWidthSlideEvent() {
		return false;
	}
	
	public boolean isLowSurviveSlideEvent() {
		return false;
	}
	
	public boolean isHighSurviveSlideEvent() {
		return false;
	}
	
	public boolean isLowBirthSlideEvent() {
		return false;
	}
	
	public boolean isHighBirthSlideEvent() {
		return false;
	}
}

class RandomEvent extends LifeViewEvent {
	private String s;
	
	public RandomEvent(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isRandomEvent() {
		return true;
	}
}

class RunEvent extends LifeViewEvent {
	
	private String s;
	
	public RunEvent(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isRunEvent() {
		return true;
	}
}

class ClearEvent extends LifeViewEvent {
	
	private String s;
	
	public ClearEvent(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isClearEvent() {
		return true;
	}
}

class TorusEvent extends LifeViewEvent {
	
	private String s;
	
	public TorusEvent(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isTorusEvent() {
		return true;
	}
}

class HeightSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public HeightSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isHeightSlideEvent() {
		return true;
	}
}

class WidthSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public WidthSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isWidthSlideEvent() {
		return true;
	}
}

class LowSurviveSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public LowSurviveSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isLowSurviveSlideEvent() {
		return true;
	}
}

class HighSurviveSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public HighSurviveSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isHighSurviveSlideEvent() {
		return true;
	}
}

class LowBirthSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public LowBirthSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isLowBirthSlideEvent() {
		return true;
	}
}

class HighBirthSlideEvent extends LifeViewEvent {
	
	private String s;
	
	public HighBirthSlideEvent() {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public boolean isHighBirthSlideEvent() {
		return true;
	}
}

