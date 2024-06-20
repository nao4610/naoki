package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.Blood;
import jp.co.scsk.kyushu.exBasic.Human;
import jp.co.scsk.kyushu.exBasic.Marriage;
import jp.co.scsk.kyushu.exBasic.Sex;

class MarriageTest {
	Marriage marriage = new Marriage();

	@Test
	void testMarriage() {
		Human human1 = new Human(18, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human2 = new Human(16, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human3 = new Human(17, "山田こう太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human4 = new Human(15, "山田なおちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human5 = new Human(18, "山田君", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human6 = new Human(17, "山田こう君", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human7 = new Human(16, "山田かーちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human8 = new Human(15, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertTrue(marriage.checkMarriage(human1, human2));
		assertFalse(marriage.checkMarriage(human3, human2));
		assertFalse(marriage.checkMarriage(human3, human4));
		assertFalse(marriage.checkMarriage(human1, human4));
		assertFalse(marriage.checkMarriage(human1, human5));
		assertFalse(marriage.checkMarriage(human3, human1));
		assertFalse(marriage.checkMarriage(human3, human6));
		assertFalse(marriage.checkMarriage(human2, human7));
		assertFalse(marriage.checkMarriage(human4, human2));
		assertFalse(marriage.checkMarriage(human8, human4));
	}

}
