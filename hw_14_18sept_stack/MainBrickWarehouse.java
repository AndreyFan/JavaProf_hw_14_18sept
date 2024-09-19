package de.telran.hw_14_18sept_stack;

import java.util.Scanner;
import java.util.Stack;

public class MainBrickWarehouse {
//    1) Вы работаете на складе, который продает один вид продукции,
//    не имеющий сроков хранения, например кирпич. У вас всего одни двери на складе,
//    через которые вы загружаете новый товар и отгружаете заказчикам тоже через эту же дверь.
//    Как бы вы построили рабочий процесс на Вашем складе,
//    какую бы коллекцию использовали для имитации процесса работы?
//    Напишите программу, которая бы имитировала работу.
//
    public static void main(String[] args) {
        // Изготовим 5 партий кирпича (предыдущая рабочая неделя)
        BatchOfBricks batchOfBricks1 = new BatchOfBricks("09-09-2024", 12, "Игорь Угольников");
        BatchOfBricks batchOfBricks2 = new BatchOfBricks("10-09-2024", 14, "Петя Зайцев");
        BatchOfBricks batchOfBricks3 = new BatchOfBricks("11-09-2024", 10, "Игорь Угольников");
        BatchOfBricks batchOfBricks4 = new BatchOfBricks("12-09-2024", 11, "Петя Зайцев");
        BatchOfBricks batchOfBricks5 = new BatchOfBricks("13-09-2024", 12, "Катя Григорьева");

        // Создадим наш склад с одними воротами в виде стека
        Stack<BatchOfBricks> warehouse = new Stack<>();

        // Загрузим партии за прошлую неделю на склад ( так как кирпич не имеет срока годности, порядок не важен)

        warehouse.push(batchOfBricks1);
        warehouse.push(batchOfBricks2);
        warehouse.push(batchOfBricks3);
        warehouse.push(batchOfBricks4);
        warehouse.push(batchOfBricks5);

        // Организуем выдачу товара со склада

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество пачек кирпича, которые нужно взять со склада  ");
        int count = scanner.nextInt();

        int countCurrent = warehouse.peek().countOfPackages; // смотрим сколько пачек кирпича в партии которая стоит у дверей

        while (count > countCurrent) {

            System.out.println("Со склада полностью отгрузили партию за  " + warehouse.peek().data);
            count = count - warehouse.pop().countOfPackages;
        }
        if (count == countCurrent) {
            System.out.println("Со склада отгрузили партию за  " + warehouse.peek().data + "и следующую не доставали");
            warehouse.pop();
        } else if (count < countCurrent) {
            BatchOfBricks countT = warehouse.pop();
            countT.countOfPackages = countT.countOfPackages - count;
            System.out.println("в пачке от " + countT.data + " взяли " + count + " пачек  и осталось " + countT.countOfPackages + " пачек");
            warehouse.push(countT);
        }

    }

}


