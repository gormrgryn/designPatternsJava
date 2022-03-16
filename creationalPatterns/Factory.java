class Factory {
	static abstract class Character {
		String name;
		Character(String n) { name = n; }
	}
	static abstract class CharacterFactory {
		abstract Character FactoryMethod(String n);
	}

	static class Man extends Character {
		Man(String n) { super(n); }
	}
	static class ManFactory extends CharacterFactory {
		@Override
		Character FactoryMethod(String n) { return new Man(n); }
	}
	static class ZombieMan extends Character {
		ZombieMan(String n) { super(n); }
	}
	static class ZombieManFactory extends CharacterFactory {
		@Override
		Character FactoryMethod(String n) { return new ZombieMan(n); }
	}
}