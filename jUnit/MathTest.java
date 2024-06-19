package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.MyMath;

class MathTest {
	MyMath myMath = new MyMath();

	@Test
	void testCheckCalc() {

		// 加算のテスト
		assertEquals(5, myMath.calc(1, 2, 3));
		assertEquals(-1, myMath.calc(1, -2, 1));

		// 減算のテスト
		assertEquals(1, myMath.calc(2, 3, 2));
		assertEquals(-3, myMath.calc(2, -1, 2));

		// 乗算のテスト
		assertEquals(6, myMath.calc(3, 2, 3));
		assertEquals(-2, myMath.calc(3, -1, 2));

		// 除算のテスト
		assertEquals(2, myMath.calc(4, 6, 3));
		assertEquals(0, myMath.calc(4, 1, 2));

		// 剰余のテスト
		assertEquals(1, myMath.calc(5, 7, 3));
		assertEquals(-1, myMath.calc(5, -4, 3));

		//第一引数が0,6のとき
		assertEquals(0, myMath.calc(0, 2, 3));
		assertEquals(0, myMath.calc(6, 2, 3));
	}

	@Test
	public void testCheckCalc2() {
		// 加算のテスト
		assertEquals(6, myMath.calc2(1, 1, 2, 3));
		assertEquals(0, myMath.calc2(1, -1, 1));

		// 平均のテスト
		assertEquals(2, myMath.calc2(2, 1, 2, 3));
		assertEquals(0, myMath.calc2(2, -1, 1));

		// 最大値のテスト
		assertEquals(3, myMath.calc2(3, 1, 2, 3));
		assertEquals(1, myMath.calc2(3, -1, 1));

		// 最小値のテスト
		assertEquals(1, myMath.calc2(4, 1, 2, 3));
		assertEquals(-1, myMath.calc2(4, -1, 1));

		// 引数が一つ
		assertEquals(0, myMath.calc2(7));
	}
	
	@Test
	public void testRound4() {
		assertEquals(3, myMath.round4(3.3)); 
        assertEquals(-4, myMath.round4(-3.7));
        assertEquals(4, myMath.round4(3.4));
        assertEquals(4, myMath.round4(3.5));
        assertEquals(-4, myMath.round4(-3.4));
        assertEquals(-3, myMath.round4(-3.3));
        assertEquals(3, myMath.round4(3.3999999999));
        assertEquals(-3, myMath.round4(-3.3999999999));
        assertEquals(-4, myMath.round4(-3.5));

	}
	
	public void testRound6() {
		assertEquals(3, myMath.round4(3.5)); 
        assertEquals(-4, myMath.round4(-3.9));
        assertEquals(4, myMath.round4(3.6));
        assertEquals(4, myMath.round4(3.7));
        assertEquals(-4, myMath.round4(-3.6));
        assertEquals(-3, myMath.round4(-3.5));
        assertEquals(3, myMath.round4(3.5999999999));
        assertEquals(-3, myMath.round4(-3.5999999999));
        assertEquals(-4, myMath.round4(-3.7));
	}

}
