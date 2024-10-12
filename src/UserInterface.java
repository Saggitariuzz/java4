import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private Scanner _in = new Scanner(System.in);

    public UserInterface(){}

    public void printInfo(){
        System.out.println("Лабораторная работа 4");
        System.out.println("Выполнили ст. гр. 23ВП2: Андреев Е.Е., Костиневич А.В.");
        System.out.println("Задание:");
        System.out.println("Создать вектор на основе переданных программе аргументов\n" +
                "командной строки. Провести сортировку элементов. Массив должен\n" +
                "работать с элементами типа double. Программа должна выводить на\n" +
                "экран начальный вектор элементов, сортированный вектор, медианное\n" +
                "значение, среднее значение. Результаты сохранить в файл. Создать\n" +
                "итератор для коллекции.");
    }

    public void processData(String[] args){
        if(args.length == 0){
            System.out.println("Вы не передали аргументов командной строки");
            return;
        }
        try {
            String path = "";
            while (true){
                System.out.println("Введите название файла (пример: test.txt):");
                path = _in.nextLine();
                if(path.matches("^[a-zA-Z0-9_-]+\\.[a-zA-Z0-9]+$")){
                    break;
                }else {
                    System.out.println("Вы ввели неверное имя файла");
                }
            }
            DoubleVector dvconsole = new DoubleVector();
            DoubleVector dvfile = new DoubleVector();
            for(String i: args){
                dvconsole.add(Double.parseDouble(i));
                dvfile.add(Double.parseDouble(i));
            }
            FileForVector fv = new FileForVector(path, dvfile);
            fv.writetofile();
            System.out.println("Изначальный вектор");
            for(Double i : dvconsole.getvector()){
                System.out.print(i.toString() + " ");
            }
            System.out.println("\nОтсортированный вектор");
            dvconsole.sort();
            for(Double i : dvconsole.getvector()){
                System.out.print(i.toString() + " ");
            }
            System.out.println("\nСреднее значение элементов вектора");
            System.out.println(dvconsole.average());
            System.out.println("Медианное значение элементов вектора");
            System.out.println(dvconsole.median());
        }catch (NumberFormatException ex){
            System.out.println("Аргумент, переданный через командную строку, нельзя привести к типу double");
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            System.out.println("Не удалось открыть файл");
        }
    }

    public void run(String[] args){
        printInfo();
        processData(args);
    }
}
