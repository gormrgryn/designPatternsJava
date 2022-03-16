class DecoratorExample {
	interface VisualComponent {
		void Draw();
	}
	static class Decorator implements VisualComponent {
		VisualComponent component;

		Decorator(VisualComponent c) {
			component = c;
		}

		public void Draw() {
			component.Draw();
		}
	}

	static class TextView implements VisualComponent {
		public void Draw() {
			System.out.println("Text View");
		}
	}
	static class ScrollDecorator extends Decorator {
		void Scroll() { System.out.println("Scrolling . . ."); }

		ScrollDecorator(VisualComponent c) { super(c); }
	}

	public static void main(String[] args) {
		TextView textview = new TextView();

		ScrollDecorator decorator = new ScrollDecorator(textview);

		textview.Draw();
		System.out.println();
		decorator.Draw();
		decorator.Scroll();
	}
}