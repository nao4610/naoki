package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.co.scsk.kyushu.exBasic.RacerInfo;
import jp.co.scsk.kyushu.exBasic.Races;

class RacesTest {
	private Races races;
	private Map<Integer, Map<Integer, RacerInfo>> result;

	@BeforeEach
	void setUp() {
		races = new Races();
		ArrayList<RacerInfo> info = new ArrayList<>();
		info.add(new RacerInfo("nao", 1, 1, 10.2));
		info.add(new RacerInfo("ryo", 1, 3, 11.7));
		info.add(new RacerInfo("hiro", 1, 2, 11.0));
		info.add(new RacerInfo("taba", 2, 2, 12.0));
		info.add(new RacerInfo("syu", 2, 1, 11.3));
		info.add(new RacerInfo("okamoto", 2, 3, 13.0));
		info.add(new RacerInfo("ino", 3, 1, 10.6));
		info.add(new RacerInfo("yossi", 3, 4, 13.6));
		info.add(new RacerInfo("yossidayo", 3, 2, 11.6));
		info.add(new RacerInfo("yosida", 3, 3, 12.6));
		result = races.createReceResult(info);
	}

	@Test
	void testCreateReceResult() {
		assertEquals("nao", result.get(1).get(1).getRunner());
		assertEquals("hiro", result.get(1).get(2).getRunner());
		assertEquals("ryo", result.get(1).get(3).getRunner());
		assertEquals("syu", result.get(2).get(1).getRunner());
		assertEquals("taba", result.get(2).get(2).getRunner());
		assertEquals("okamoto", result.get(2).get(3).getRunner());
		assertEquals("ino", result.get(3).get(1).getRunner());
		assertEquals("yossidayo", result.get(3).get(2).getRunner());
		assertEquals("yosida", result.get(3).get(3).getRunner());
		assertEquals("yossi", result.get(3).get(4).getRunner());
	}

	@Test
	void testSortRaceResult() {
		Map<Integer, Map<Integer, RacerInfo>> raceResult = races.createReceResult(new ArrayList<>(List.of(
				new RacerInfo("nao", 1, 1, 10.2),
				new RacerInfo("hiro", 1, 2, 11.0),
				new RacerInfo("ryo", 1, 3, 11.7),
				new RacerInfo("syu", 2, 1, 11.3),
				new RacerInfo("taba", 2, 2, 12.0),
				new RacerInfo("okamoto", 2, 3, 13.0))));

		// レース1の結果
		Map<Double, String> expectedRace1 = Map.of(
				10.2, "nao",
				11.0, "hiro",
				11.7, "ryo");
		assertEquals(expectedRace1, races.sortRaceResult(raceResult, 1));

		// レース2の結果
		Map<Double, String> expectedRace2 = Map.of(
				11.3, "syu",
				12.0, "taba",
				13.0, "okamoto");
		assertEquals(expectedRace2, races.sortRaceResult(raceResult, 2));
	}

	@Test
	void testBestRacerInfoOfRace() {
		List<String> expectedOutput = List.of("nao", "syu", "ino");
		assertEquals(expectedOutput, races.bestRacerInfoOfRace(result));
	}

	@Test
	void testBestRacerInfoOfAll() {
		RacerInfo bestRacer = races.bestRacerInfoOfAll(result);
		RacerInfo expectedBestRacer = new RacerInfo("nao", 1, 1, 10.2);
		assertEquals(expectedBestRacer.getRunner(), bestRacer.getRunner());
		assertEquals(expectedBestRacer.getTime(), bestRacer.getTime());
	}

	@Test
	void testWorstRacerInfoOfAll() {
		RacerInfo worstRacer = races.worstRacerInfoOfAll(result);
		RacerInfo expectedWorstRacer = new RacerInfo("yossi", 3, 4, 13.6);
		assertEquals(expectedWorstRacer.getRunner(), worstRacer.getRunner());
		assertEquals(expectedWorstRacer.getTime(), worstRacer.getTime());
	}

	@Test
	void testWinnerRacerInfo() {
		List<String> winners = races.winnerRacerInfo(result);
		List<String> expectedWinners = List.of("nao", "hiro", "syu", "taba", "ino", "yossidayo");
		assertEquals(expectedWinners, winners);
	}

	@Test
	void testTop10RacerInfo() {
		// 標準出力をキャプチャする
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// メソッドを呼び出す
		races.top10RacerInfo(result);

		// 期待される出力
		String expectedOutput = "nao:10.2:1\n" +
				"ino:10.6:3\n" +
				"hiro:11.0:1\n" +
				"syu:11.3:2\n" +
				"yossidayo:11.6:3\n" +
				"ryo:11.7:1\n" +
				"taba:12.0:2\n" +
				"yosida:12.6:3\n" +
				"okamoto:13.0:2\n" +
				"yossi:13.6:3\n";

		// 出力を検証する
		assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
	}
}