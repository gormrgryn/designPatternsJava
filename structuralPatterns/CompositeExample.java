import java.util.ArrayList;
import java.util.Iterator;

class CompositeExample {
	static abstract class Graphic {
		String name;
		abstract void Draw();
		Graphic AddChild(Graphic g) { return null; }
		Graphic RemoveChild(Graphic g) { return null; }

		Graphic(String n) { name = n; }
	}

	static class Line extends Graphic {
		@Override
		void Draw() { System.out.println(name); }

		Line(String n) { super(n); }
	}
	static class Cycle extends Graphic {
		@Override
		void Draw() { System.out.println("Cycle"); }

		Cycle(String n) { super(n); }
	}

	static class Panel extends Graphic {
		ArrayList<Graphic> children;
		Panel(String n) {
			super(n);
			children = new ArrayList<Graphic>();
		}
		@Override
		void Draw() {
			System.out.println(name + "\n");

			Iterator<Graphic> iter = children.iterator();
	        while (iter.hasNext()) {
	            System.out.println(iter.next().name);
	        }
		}
		@Override
		Graphic AddChild(Graphic g) {
			children.add(g);
			return this;
		}
		@Override
		Graphic RemoveChild(Graphic g) {
			children.remove(g);
			return this;
		}
	}

	public static void main(String[] args) {
		Graphic panel = new Panel("Panel Main");

		panel
			.AddChild(new Line("Line 1"))
			.AddChild(new Cycle("Cycle 1"))
			.AddChild(new Line("Line 2"));

		panel.Draw();
	}
}