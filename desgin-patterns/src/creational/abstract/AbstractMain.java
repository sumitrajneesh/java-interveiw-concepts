public class AbstractMain {
    private Button button;
    private Checkbox checkbox;

    public AbstractMain(UIFactory uiFactory) {
        button = uiFactory.createButton();
        checkbox = uiFactory.createCheckbox();

    }


    public void renderUI() {
        button.render();
        checkbox.select();
    }

    public static void main(String[] args) {
        UIFactory uiFactory = new DarkUIFactory();
        AbstractMain app = new AbstractMain(uiFactory);

        app.renderUI();
    }
}
