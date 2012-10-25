package herbstJennrichLehmannRitter.engine.utils;


public abstract class MagicUtils {

	private MagicUtils() {
		// Utils should never be instanciated
	}	
	
	public static void addValueToStringBuilder(Object key, Number value, StringBuilder stringBuilder, boolean displayPlus) {
		if (value == null
			|| value.doubleValue() == 0d ) {
			return;
		}
		
		String valueStr = (displayPlus && value.doubleValue() > 0d ) ? "+" : "";
		valueStr += value.toString();
		String keyStr = key.toString();
		
		if (valueStr.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(", ");
			}
			
			stringBuilder.append(valueStr);
			stringBuilder.append(' ');
			stringBuilder.append(keyStr);
		}
	}
	
	public static void addValueToStringBuilder(Object key, Number value, StringBuilder stringBuilder) {
		addValueToStringBuilder(key, value, stringBuilder, false);
	}
}
