package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.RacerInfo;
import jp.co.scsk.kyushu.exBasic.Races;

class RacesTest {
	Races races = new Races();

	@Test
	void test() {
		ArrayList<RacerInfo> info = new ArrayList<>();
        info.add(new RacerInfo("nao", 1, 1, 10.2));
        info.add(new RacerInfo("ryo", 1, 3, 11.7));
        info.add(new RacerInfo("hiro", 1, 2, 11.0));
        info.add(new RacerInfo("taba", 2, 2, 12.0));
        info.add(new RacerInfo("syu", 2, 1, 11.3));
        info.add(new RacerInfo("okamoto", 2, 3, 13.0));
        info.add(new RacerInfo("ino", 3, 1, 10.6));
        info.add(new RacerInfo("yossi", 3, 3, 13.6));
        info.add(new RacerInfo("yossidayo", 3, 2, 11.6));

        Map<Integer, Map<Integer, RacerInfo>> result = races.createReceResult(info);

        assertEquals("nao", result.get(1).get(1).getRunner());
        assertEquals("hiro", result.get(1).get(2).getRunner());
        assertEquals("ryo", result.get(1).get(3).getRunner());
        assertEquals("syu", result.get(2).get(1).getRunner());
        assertEquals("taba", result.get(2).get(2).getRunner());
        assertEquals("okamoto", result.get(2).get(3).getRunner());
        assertEquals("ino", result.get(3).get(1).getRunner());
        assertEquals("yossidayo", result.get(3).get(2).getRunner());
        assertEquals("yossi", result.get(3).get(3).getRunner());
	}

}
