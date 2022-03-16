import java.util.HashMap;

class FlyWeightExample { // GameOfLife

	public interface FlyWeight {}

	static class CellIntrinsicState implements FlyWeight { // UnsharedConcreteFlyWeight
		String texture;
		CellIntrinsicState(String t) { texture = t; }
	}

	static abstract class Cell implements FlyWeight { // ConcreteFlyWeight CellExtrinsicState
		int x;
		int y;
		int energy;
		CellIntrinsicState intrinsicState;

		Cell(int x_, int y_, int e, CellIntrinsicState i) {
			x = x_;
			y = y_;
			energy = e;
			intrinsicState = i;
		}
	}

	static class GrassCell extends Cell {
		GrassCell(int x, int y, int e, CellIntrinsicState i) {
			super(x, y, e, i);
		}
	}
	static class PredatorCell extends Cell {
		PredatorCell(int x, int y, int e, CellIntrinsicState i) {
			super(x, y, e, i);
		}
	}

	static class CellFactory {
		HashMap<String, CellIntrinsicState> cells;

		CellFactory() {
			cells = new HashMap<String, CellIntrinsicState>();
		}

		protected CellIntrinsicState GetOrCreateCellType(String s) {
			CellIntrinsicState c = cells.get(s);
			if (c == null) {
				switch (s) {
					case "Grass":
						c = new CellIntrinsicState("Green Grass Texture");
						System.out.println("Creating type Green Grass Texture");
						break;
					case "Predator":
						c = new CellIntrinsicState("Red Predator Texture");
						System.out.println("Creating type Red Predator Texture");
						break;
				}
				cells.put(s, c);
			}
			return c;
		}
		public Cell CreateGrassCell(int x, int y, int e, String s) {
			return new GrassCell(x, y, e, GetOrCreateCellType(s));
		}
		public Cell PredatorCell(int x, int y, int e, String s) {
			return new PredatorCell(x, y, e, GetOrCreateCellType(s));
		}
	}
	public static void main(String[] args) {
		CellFactory factory = new CellFactory();
		GrassCell cell1 = (GrassCell) factory.CreateGrassCell(0, 0, 5, "Grass");
		PredatorCell cell2 = (PredatorCell) factory.PredatorCell(34, 10, 18, "Predator");
		GrassCell cell3 = (GrassCell) factory.CreateGrassCell(0, 0, 5, "Grass");
		PredatorCell cell4 = (PredatorCell) factory.PredatorCell(34, 10, 18, "Predator");
		System.out.println("Grass");
		System.out.println(cell1.x + ", " + cell1.y + ", " + cell1.energy + ", " + cell1.intrinsicState.texture);
		System.out.println("Predator");
		System.out.println(cell2.x + ", " + cell2.y + ", " + cell2.energy + ", " + cell2.intrinsicState.texture);

		System.out.println("Grass");
		System.out.println(cell3.x + ", " + cell3.y + ", " + cell3.energy + ", " + cell3.intrinsicState.texture);
		System.out.println("Predator");
		System.out.println(cell4.x + ", " + cell4.y + ", " + cell4.energy + ", " + cell4.intrinsicState.texture);
	}
}