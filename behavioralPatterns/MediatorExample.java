class MediatorExample {
	static interface Mediator {
		void widgetChanged(Widget widget);
		void createWidgets();
	}
	static abstract class Widget {
		Mediator mediator;
		void changed() {
			mediator.widgetChanged(this);
		}
		Widget(Mediator m) {
			mediator = m;
		}
	}

	static class Button extends Widget {
		Button(Mediator m) { super(m); }
		void click() {
			changed();
		}
	}
	static class ListBox extends Widget {
		String[] list;
		String selected;
		ListBox(Mediator m) {
			super(m);
			list = new String[] { "font1", "font2", "font3" };
			selected = list[0];
		}

		void select(int n) {
			if (n > list.length - 1) return;

			selected = list[n];
			changed();
		}
	}
	static class FontNameField extends Widget {
		String field;
		FontNameField(Mediator m) {
			super(m);
		}
		void write(String f) {
			field = f;
			changed();
		}
	}

	static class FontDialogDirector implements Mediator {
		Button okButton;
		Button cancelButton;
		ListBox listBox;
		FontNameField fontNameField;

		public void createWidgets() {
			okButton = new Button(this);
			cancelButton = new Button(this);
			listBox = new ListBox(this);
			fontNameField = new FontNameField(this);
		}
		public void widgetChanged(Widget widget) {
			if (widget == okButton) {
				System.out.println("font is choosen");
			}
			else if (widget == cancelButton) {
				System.out.println("opertaion is canceled");
			}
			else if (widget == fontNameField) {
				listBox.selected = fontNameField.field;
				System.out.println(listBox.selected);
			}
			else if (widget == listBox) {
				fontNameField.field = listBox.selected;
				System.out.println(fontNameField.field);
			}
		}
	}
	public static void main(String[] args) {
		FontDialogDirector dialog = new FontDialogDirector();
		dialog.createWidgets();
		dialog.listBox.select(2);
		dialog.fontNameField.write("font4");
		dialog.okButton.click();
		dialog.cancelButton.click();
	}
}