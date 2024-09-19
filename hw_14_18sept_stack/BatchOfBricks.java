package de.telran.hw_14_18sept_stack;

public class BatchOfBricks {
    // создадим класс Партия кирпича ( допустим Партия - это какое то количество пачек, произведенных за день работы цеха)
    public String data; // дата изготовления партии
    public int countOfPackages; // кол-во пачек в партии
    public String controllerName; // имя контролёра

    public BatchOfBricks(String data, int countOfPackages, String controllerName) {
        this.data = data;
        this.countOfPackages = countOfPackages;
        this.controllerName = controllerName;
    }
}
