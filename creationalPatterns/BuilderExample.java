class BuilderExample {
	interface Builder {
		void buildHouse();
		void buildTrees();
		void buildPool();
		String[] getResult();
	}
	class ConcreteBuilder implements Builder {
		String[] built;
		private int builtCount;

		ConcreteBuilder() {
			built = new String[3];
			builtCount = 0;
		}

		void buildHouse() {
			built[builtCount++] = "House";
		}
		void buildTrees() {
			built[builtCount++] = "Trees";
		}
		void buildPool() {
			built[builtCount++] = "Pool";
		}
		String[] getResult() { return built; }
	}
	interface Director {
		void build();
	}
	class DirectorWithTrees implements Director {
		Builder builder;

		DirectorWithTrees() {
			builder = new Builder();
		}

		void build() {
			builder.buildHouse();
			builder.buildTrees();
		}
		void getResult() {
			String[] res = builder.getResult();
			for (String i : res) {
				System.out.println(i);
			}
		}
	}
}