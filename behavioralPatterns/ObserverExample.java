import java.util.ArrayList;
import java.util.Iterator;

class ObserverExample {
	static interface Subject {
		void attachObserver(Observer o);
		void detachObserver(Observer o);
		void notifyObservers();
		String getState();
		void setState(String s);
	}
	static abstract class Observer {
		Subject subject;

		Observer(Subject s) {
			subject = s;
			subject.attachObserver(this);
		}

		abstract void update();
	}

	static class Data implements Subject {
		ArrayList<Observer> observers;
		String subjectState;

		Data(String s) {
			subjectState = s;
			observers = new ArrayList<Observer>();
		}
		public void setState(String s) {
			subjectState = s;
			notifyObservers();
		}
		public String getState() { return subjectState; }

		public void attachObserver(Observer o) {
			observers.add(o);
		}
		public void detachObserver(Observer o) {
			observers.remove(o);
		}
		public void notifyObservers() {
			Iterator<Observer> o = observers.iterator();

			while(o.hasNext()) {
				o.next().update();
			}
		}
	}
	static class CycleDiagram extends Observer {
		String observerState;

		CycleDiagram(Subject sub) {
			super(sub);
			update();
		}

		public void update() {
			System.out.print(observerState + " -> ");
			observerState = subject.getState();
			System.out.print(observerState);
			System.out.println();
		}
	}

	// class TableDiagram implements Observer {}
	// class NumberDiagram implements Observer {}

	public static void main(String[] args) {
		Data subject = new Data("data state");
		CycleDiagram o = new CycleDiagram(subject);
		CycleDiagram o1 = new CycleDiagram(subject);
		CycleDiagram o2 = new CycleDiagram(subject);
		
		subject.setState("another data state");
		subject.setState("state");
	}
}