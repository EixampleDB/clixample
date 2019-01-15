package model;

import model.OperationType;
import java.util.List;


public class OperationDTO {

    private String key;

    private OperationType type;

    private String value;

    private List<String> parameters;
    
    
    public OperationDTO(String key, OperationType type, String value, List<String> parameters) {
    	this.key = key;
    	this.type = type;
    	this.value = value;
    	this.parameters = parameters;
    }
}