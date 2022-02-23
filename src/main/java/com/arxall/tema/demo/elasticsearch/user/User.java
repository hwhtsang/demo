package com.arxall.tema.demo.elasticsearch.user;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "userindex")
public class User {
	@Id
	private long id;
	private String userName;
	private String sex;
	//@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Field(type = FieldType.Date, format = DateFormat.epoch_millis)
	private Date dateOfBirth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
/*
class CustomDateDeserializer extends StdDeserializer<LocalDate> {
	private static final long serialVersionUID = 1L;

	public CustomDateDeserializer() { 
		this(null); 
	}

	public CustomDateDeserializer(Class<?> vc) { 
	    super(vc); 
	}

	@Override
	public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        long dateInMilli = jsonparser.getLongValue();
        return Instant.ofEpochMilli(dateInMilli).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
*/
