package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.Price;

class PriceTest {
	Price price = new Price();

	@Test
	void testPrice1() {
		// 年齢による基本料金の区分
		assertEquals(0, price.price1(6));
		assertEquals(500, price.price1(7));
		assertEquals(500, price.price1(17));
		assertEquals(1000, price.price1(18));
		assertEquals(1000, price.price1(59));
		assertEquals(700, price.price1(60));

		// 60歳未満の4の倍数の割引
		assertEquals(0, price.price1(4));
		assertEquals(480, price.price1(16));
		assertEquals(960, price.price1(24));

		// 60歳未満の5の倍数の割引
		assertEquals(0, price.price1(5));
		assertEquals(475, price.price1(10));
		assertEquals(950, price.price1(25));

		// 60歳未満の4と5の倍数の両方の割引
		assertEquals(912, price.price1(20));
	}

	@Test
	void testPrice2() {
		assertEquals(400, price.price2(4, 100));
		assertEquals(400, price.price2(5, 100));
		assertEquals(500, price.price2(6, 100));
		assertEquals(800, price.price2(9, 100));
		assertEquals(800, price.price2(10, 100));
		assertEquals(900, price.price2(11, 100));
		assertEquals(520, price.price2(5, 130));
		assertEquals(650, price.price2(6, 130));
	}

}
