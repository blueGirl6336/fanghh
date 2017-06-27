package hitwh.fanghh.manage.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dc)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = jp.getText();
		if(date == null || date.trim().equals("")) return null;
		try {
			return format.parse(date);
		} catch (ParseException e) {
			format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			try {
				return format.parse(date);
			} catch (ParseException e1) {
				throw new RuntimeException(e1);
			}
		}
	}
	
}
