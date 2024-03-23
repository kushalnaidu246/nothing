package com.kushal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;

    // Getter for questionId
    public Integer getQuestionId() {
        return questionId;
    }

    // Setter for questionId
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }

    // Repeat the same pattern for other fields...
    // Getters and setters for other fields

    // Getter for difficultyLevel
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    // Setter for difficultyLevel
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // Repeat the same pattern for option1, option2, option3, option4, questionTitle, and rightAnswer...
    // Getters and setters for other fields

    
    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", category='" + category + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        // Check for equality of all fields
        if (!questionId.equals(question.questionId)) return false;
        if (!category.equals(question.category)) return false;
        if (!difficultyLevel.equals(question.difficultyLevel)) return false;
        if (!option1.equals(question.option1)) return false;
        if (!option2.equals(question.option2)) return false;
        if (!option3.equals(question.option3)) return false;
        if (!option4.equals(question.option4)) return false;
        if (!questionTitle.equals(question.questionTitle)) return false;
        return rightAnswer.equals(question.rightAnswer);
    }

    @Override
    public int hashCode() {
        // Hash code based on all fields
        int result = questionId.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + difficultyLevel.hashCode();
        result = 31 * result + option1.hashCode();
        result = 31 * result + option2.hashCode();
        result = 31 * result + option3.hashCode();
        result = 31 * result + option4.hashCode();
        result = 31 * result + questionTitle.hashCode();
        result = 31 * result + rightAnswer.hashCode();
        return result;
    }

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
}
