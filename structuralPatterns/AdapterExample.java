class AdapterExample {
	interface TextView {
		void printText(String s);
	}
	class TextLib {
		void showText(String s) {
			System.out.println(s);
		}
	}

	class ClassAdapter extends TextLib implements TextView {
		void printText(String s) { showText(); }
	}

	class ObjectAdapter implements TextView {
		TextLib lib;
		Adapter() { lib = new TextLib(); }
		void printText(String s) { lib.showText(); }
	}
}