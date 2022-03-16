import java.util.Stack;

class MementoExample {
	static interface Originator {
		void setMemento(Memento memento);
		Memento createMemento();
	}
	static interface Memento {
		void setState(String text);
		String getState();
	}
	static class Editor implements Originator {
		String text;

		Editor(String t) {
			text = t;
		}

		public void setMemento(Memento m) {
			text = m.getState();
		}
		public Memento createMemento() {
			return new EditorMemento(text);
		}
	}
	static class EditorMemento implements Memento {
		String state;

		public void setState(String text) {
			state = text;
		}
		public String getState() {
			return state;
		}

		EditorMemento(String s) {
			state = s;
		}
	}
	static class Caretaker {
		Stack<Memento> stack;
		Originator originator;

		Caretaker(Originator o) {
			stack = new Stack<Memento>();
			originator = o;
		}

		void backup() {
			stack.push(originator.createMemento());
		}
		void undo() {
			if (stack.empty()) return;
			originator.setMemento(stack.pop());
		}
	}
	public static void main(String[] args) {
		Editor editor = new Editor("TEXT");
		Caretaker caretaker = new Caretaker(editor);

		System.out.println(editor.text);

		caretaker.backup();
		editor.text = "text";

		System.out.println(editor.text);

		caretaker.undo();

		System.out.println(editor.text);
		caretaker.backup();
		
		caretaker.undo();
		caretaker.undo();
	}
}