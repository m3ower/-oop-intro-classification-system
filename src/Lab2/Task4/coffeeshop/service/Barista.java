package Lab2.Task4.coffeeshop;

import Lab2.Task4.coffeeshop.core.Coffee;
import Lab2.Task4.coffeeshop.core.Intensity;
import Lab2.Task4.coffeeshop.core.SyrupType;
import Lab2.Task4.coffeeshop.core.SyrupCappuccino;
import Lab2.Task4.coffeeshop.core.Cappuccino;
import Lab2.Task4.coffeeshop.core.Americano;
import Lab2.Task4.coffeeshop.core.PumpkinSpiceLatte;

import java.util.Scanner;

public class Barista {
    private String name;

    public Barista(String name) {
        this.name = name;
    }

            System.out.println("Hi!!! (✿◕‿◕✿) Welcome to the coffee shop! What do you want me to make you?");

    // Choose coffee type
        System.out.println("Types of coffee we serve:");
        System.out.println("1. Americano");
        System.out.println("2. Cappuccino");
        System.out.println("3. Syrup Cappuccino");
        System.out.println("4. Pumpkin Spice Latte");
        System.out.print("Enter the number of your choice: ");

    int coffeeChoice = Integer.parseInt(scanner.nextLine());
    Coffee drink = null;

        switch (coffeeChoice) {
        case 1:
            drink = makeAmericano();
            break;
        case 2:
            drink = makeCappuccino();
            break;
        case 3:
            drink = makeSyrupCappuccino();
            break;
        case 4:
            drink = makePumpkinSpiceLatte();
            break;
        default:
            System.out.println("Invalid choice! Please try again.");
            return null; // Return null if invalid choice
    }

        return drink;
}

private Coffee makeAmericano() {
    Intensity intensity = askIntensity();
    int water = askMls("water");
    return Americano.makeAmericano(intensity, water);
}

private Coffee makeCappuccino() {
    Intensity intensity = askIntensity();
    int milk = askMls("milk");
    return Cappuccino.makeCappuccino(intensity, milk);
}

private Coffee makeSyrupCappuccino() {
    Intensity intensity = askIntensity();
    int milk = askMls("milk");
    SyrupType syrup = askSyrupType();
    return SyrupCappuccino.makeSyrupCappuccino(intensity, milk, syrup);
}

private Coffee makePumpkinSpiceLatte() {
    Intensity intensity = askIntensity();
    int milk = askMls("milk");
    int spice = askMls("pumpkin spice");
    return PumpkinSpiceLatte.makePumpkinSpiceLatte(intensity, milk, spice);
}
    private int askMls(String material) {
        int mlsOfSmth = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            System.out.printf("How much of %s do you want( •̀ ω •́ )✧? (in mls)%n", material);
            String input = scanner.nextLine();
            if (input.isBlank() || !input.matches("\\d+") || (mlsOfSmth = Integer.parseInt(input)) < 0) {
                System.out.println("Please enter a positive number (￣﹏￣；)");
            } else {
                validInput = true;
            }
        }
        return mlsOfSmth;
    }

    private Intensity askIntensity() {
        int intensityNumberInteger;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("How intense do you want me to make it(✿◡‿◡)?\n1. Light\n2. Normal\n3. Strong");
            String intensityNumber = scanner.nextLine();
            if (intensityNumber.matches("\\d+") && (intensityNumberInteger = Integer.parseInt(intensityNumber)) >= 1 && intensityNumberInteger <= 3) {
                switch (intensityNumberInteger) {
                    case 1:
                        return Intensity.LIGHT;
                    case 2:
                        return Intensity.NORMAL;
                    case 3:
                        return Intensity.STRONG;
                }
            } else {
                System.out.println("Please choose an intensity ＞﹏＜");
            }
        }
    }

    private SyrupType askSyrupType() {
        int syrupNumberInteger;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What type of syrup do you want me to add ヾ(≧▽≦*)o?\n1. Macadamia\n2. Vanilla\n3. Coconut\n4. Caramel\n5. Chocolate\n6. Popcorn");
            String syrupNumber = scanner.nextLine();
            if (syrupNumber.matches("\\d+") && (syrupNumberInteger = Integer.parseInt(syrupNumber)) >= 1 && syrupNumberInteger <= 6) {
                switch (syrupNumberInteger) {
                    case 1:
                        return SyrupType.MACADAMIA;
                    case 2:
                        return SyrupType.VANILLA;
                    case 3:
                        return SyrupType.COCONUT;
                    case 4:
                        return SyrupType.CARAMEL;
                    case 5:
                        return SyrupType.CHOCOLATE;
                    case 6:
                        return SyrupType.POPCORN;
                }
            } else {
                System.out.println("Please choose a valid syrup <(＿　＿)>");
            }
        }
    }
}
