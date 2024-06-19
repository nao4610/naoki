package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.MyString;

class MyStringTest {
	MyString myString = new MyString();

	@Test
	void testBranch() {
		assertEquals("おはようございます", myString.branch(1));
		assertEquals("こんにちは", myString.branch(2));
		assertEquals("こんばんは", myString.branch(3));
		assertEquals("おやすみなさい", myString.branch(4));
		assertEquals("また明日", myString.branch(5));
		assertEquals("さようなら", myString.branch(0));
		assertEquals("さようなら", myString.branch(6));
	}
}