class VisitorExample {
	static interface Element {
		void accept(Visitor visitor);
	}
	static interface Visitor {
		void visitOffice();
		void visitHouse();
		void visitBank();
	}
	static class Office implements Element {
		public void accept(Visitor visitor) {
			visitor.visitOffice();
		}
	}
	static class House implements Element {
		public void accept(Visitor visitor) {
			visitor.visitHouse();
		}
	}
	static class Bank implements Element {
		public void accept(Visitor visitor) {
			visitor.visitBank();
		}
	}
	static class ConcreteVisitor implements Visitor {
		public void visitOffice() {
			System.out.println("visited office");
		}
		public void visitHouse() {
			System.out.println("visited house");
		}
		public void visitBank() {
			System.out.println("visited bank");
		}
	}
	public static void main(String[] args) {
		Element[] elemArr = new Element[] {
			new Office(),
			new House(),
			new Bank()
		};
		Visitor visitor = new ConcreteVisitor();

		for (Element e : elemArr) {
			e.accept(visitor);
		}
	}
}