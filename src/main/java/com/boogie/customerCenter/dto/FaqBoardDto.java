package com.boogie.customerCenter.dto;

public class FaqBoardDto {
	private int question_code;
	private String question_type;
	
	private int board_number;
	private String question;
	private String answer;
	
	public FaqBoardDto() {}

	public int getQuestion_code() {
		return question_code;
	}

	public void setQuestion_code(int question_code) {
		this.question_code = question_code;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public int getBoard_number() {
		return board_number;
	}

	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "FaqBoardDto [question_code=" + question_code + ", question_type=" + question_type + ", board_number="
				+ board_number + ", question=" + question + ", answer=" + answer + "]";
	}

	
}
