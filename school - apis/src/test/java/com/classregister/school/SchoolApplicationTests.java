package com.classregister.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SchoolApplicationTests {
Calculator calculator = new Calculator();

	@Test
	void add() {
		int a =6;
		int b = 6;
		int result = calculator.add(a,b);

		assertThat(result).isEqualTo(12);
	}

	class Calculator {

		int add (int a ,int b){
			return a+b;
		}
	}

}
