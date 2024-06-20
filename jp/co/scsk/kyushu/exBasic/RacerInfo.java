package jp.co.scsk.kyushu.exBasic;

public class RacerInfo {
	String runner;
	int order;
	int rank;
	Double time;
	
	 public RacerInfo(String runner, int order, int rank, Double time) {
	        this.runner = runner;
	        this.order = order;
	        this.rank = rank;
	        this.time = time;
	    }

	public String getRunner() {
		return runner;
	}

	public void setRunner(String runner) {
		this.runner = runner;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}
}
