class StateExample {
	static class Context {
		ContextState state;

		void request() {
			state.handle();
		}

		Context(ContextState s) {
			changeState(s);
		}

		void changeState(ContextState s) {
			state = s;
		}
	}
	static interface ContextState {
		void handle();
	}
	static class ContextHappy implements ContextState {
		public void handle() {
			System.out.println("I'm happy");
		}
	}
	static class ContextAngry implements ContextState {
		public void handle() {
			System.out.println("I'm angry");
		}	
	}
	public static void main(String[] args) {
		Context context = new Context(new ContextHappy());
		context.request();
		context.changeState(new ContextAngry());
		context.request();
	}
}