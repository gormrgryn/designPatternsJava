class ChainExample {
	interface Handler {
		void handleHelp();
		void ShowHelp();
	}
	static abstract class HelpHandler implements Handler {
		public boolean hasHelp;
		public HelpHandler successor;

		public void handleHelp() {
			if (hasHelp) ShowHelp();
			else if (successor != null) {
				successor.handleHelp();
			}
		}

		public HelpHandler(boolean h, HelpHandler s) {
			hasHelp = h;
			successor = s;
		}
	}

	static class HandlerA extends HelpHandler {
		public HandlerA(boolean h, HelpHandler s) { super(h, s); }

		public void ShowHelp() {
			System.out.println("HandlerA shows help");
		}
	}
	static class HandlerB extends HelpHandler {
		public HandlerB(boolean h, HelpHandler s) { super(h, s); }

		public void ShowHelp() {
			System.out.println("HandlerB shows help");
		}
	}
	static class HandlerC extends HelpHandler {
		public HandlerC(boolean h, HelpHandler s) { super(h, s); }

		public void ShowHelp() {
			System.out.println("HandlerC shows help");
		}
	}

	public static void main(String[] args) {
		HelpHandler handlerC = new HandlerC(true, null);
		HelpHandler handlerB = new HandlerB(false, handlerC);
		HelpHandler handlerA = new HandlerA(false, handlerB);

		handlerA.handleHelp();
	}
}