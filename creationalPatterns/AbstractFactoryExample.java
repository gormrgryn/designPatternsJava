class AbstractFactoryExample {
	static abstract class AbstractFactory {
		abstract Man createMan(String n);
		abstract Dog createDog(String n);
	}
	static abstract class Man {
		String name;
		Man(String n) { name = n; }
	}
	static abstract class Dog {
		String name;
		Dog(String n) { name = n; }
	}

	static class AliveMan extends Man {
		AliveMan(String n) { super(n); }
	}
	static class AliveDog extends Dog {
		AliveMan(String n) { super(n); }
	}
	static class ZombieMan extends Man {
		ZombieMan(String n) { super(n); }
	}
	static class ZombieDog extends Dog {
		ZombieMan(String n) { super(n); }
	}
	static class AliveFactory extends AbstractFactory {
		@Override
		Man createMan(String n) { return new AliveMan(n); }

		@Override
		Dog createDog(String n) { return new AliveDog(n); }
	}
	static class ZombieFactory extends AbstractFactory {
		@Override
		Man createMan(String n) { return new ZombieMan(n); }

		@Override
		Dog createDog(String n) { return new ZombieDog(n); }
	}
}