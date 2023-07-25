package OOP.S5;

import OOP.S5.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStuden("Яков","Яковлев","А.");
        controller.createStuden("Алексей","Романов","В.");
        controller.createStuden("Влад","Баранов","М.");
        controller.getAllStudent();
    }
}
