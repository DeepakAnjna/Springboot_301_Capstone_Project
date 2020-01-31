package com.eatza.restaurantsearch.kafka.consumer;

public class MessageData {
	
	private static final long SerialVersionUID = 10l; 
	private long id;
	private String name;
	private String message;

	public MessageData(int id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
	public MessageData() {
		// TODO Auto-generated constructor stub
	}
}
