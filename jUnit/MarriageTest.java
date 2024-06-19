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
		assertTrue(marriage.checkMarriage(human1, human2));

		Human human3 = new Human(17, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human4 = new Human(16, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human3, human4));

		Human human5 = new Human(17, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human6 = new Human(15, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human5, human6));

		Human human7 = new Human(18, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human8 = new Human(15, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human7, human8));

		Human human9 = new Human(18, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human10 = new Human(18, "山田君", new Sex(Sex.Man), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human9, human10));

		Human human11 = new Human(17, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human12 = new Human(18, "山田君", new Sex(Sex.Man), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human11, human12));

		Human human13 = new Human(17, "山田太郎", new Sex(Sex.Man), new Blood("A"), 150, 50);
		Human human14 = new Human(17, "山田君", new Sex(Sex.Man), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human13, human14));

		Human human15 = new Human(16, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human16 = new Human(16, "山田かー", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human15, human16));

		Human human17 = new Human(15, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human18 = new Human(16, "山田かー", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human17, human18));

		Human human19 = new Human(15, "山田ちゃん", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		Human human20 = new Human(15, "山田かー", new Sex(Sex.Woman), new Blood("A"), 150, 50);
		assertFalse(marriage.checkMarriage(human19, human20));
	}

}
