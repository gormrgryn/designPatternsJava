class CommandExample {
	static abstract class Invoker {
		public Receiver receiver;
		public abstract void handleEvent();

		public Invoker(Receiver r) { receiver = r; }
	}
	static class Button extends Invoker {
		public Button(Receiver r) { super(r); }

		@Override
		public void handleEvent() {
			new TextLabelCommand(receiver).Execute();
		}
	}
	static abstract class Command {
		public Receiver receiver;

		public void Execute() {
			if (receiver != null) receiver.Operation();
		}

		public Command(Receiver r) {
			receiver = r;
		}
	}
	static class TextLabelCommand extends Command {
		public TextLabelCommand(Receiver r) {
			super(r);
		}
	}
	static interface Receiver {
		void Operation();
	}
	static class TextLabel implements Receiver {
		public boolean state;

		@Override
		public void Operation() {
			state = !state;
		}
		public TextLabel(boolean s) { state = s; }
	}

	public static void main(String[] args) {
		Receiver label = new TextLabel(false);
		Invoker button = new Button(label);
		button.handleEvent();
	}
}