package challenge.entities.enums;

public enum Level {
	
	ERROR (1),
	WARNIG (2),
	INFO (3);

	private int code;	
	
	private Level(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Level valueOf(int code) {
		for (Level value : Level.values()) {
			if(value.getCode() ==  code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status Code");
	}
}
