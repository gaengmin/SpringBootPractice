package org.gaeng.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private long no;
	private String name;
	private String title;
	private String content;
	private Date regdate;
	private int readcount;
	private String password;

}
