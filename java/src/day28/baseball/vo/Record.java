package day28.baseball.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record implements Serializable {

	private static final long serialVersionUID = 6486184302583315138L;
	private String name;
	private int count;
	
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
	
	
}
