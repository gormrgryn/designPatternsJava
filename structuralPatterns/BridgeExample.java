class BridgeExample {
	abstract class Stationery {
		String name;
		Color color;
		Stationery(Color c, String n) { color = c; name = n; }
	}
	abstract class Color {
		String colorName;
		Color(String c) { colorName = c; }
	}
	class RedColor extends Color {
		Color() { super("Red"); }
	}
	class BlueColor extends Color {
		Color() { super("Blue"); }
	}
	
	class Pen extends Stationery {
		Pen(Color c, String n) { super(c, n); }
	}

	public static void main(String[] args) {
		Pen pen = new Pen(new RedColor(), "Red Pen");
	}
}