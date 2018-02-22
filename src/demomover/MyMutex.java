package demomover;

public class MyMutex {
	private int whoGoes;
	private int howMany;

	public MyMutex(int first, int max) {
		whoGoes = first;
		howMany = max;
	}

	public synchronized int getWhoGoes() {
		return whoGoes;
	}

	public synchronized void switchTurns() {
		whoGoes = (whoGoes + 1) % howMany;
		notifyAll();
	}

	public synchronized void waitForMyTurn(int id) throws InterruptedException {
		while (whoGoes != id) {
			wait();
		}
	}
}
