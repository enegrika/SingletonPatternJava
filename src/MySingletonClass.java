public class MySingletonClass {

    ///в СТАТИЧЕСКОЙ переменной здесь будет хранится единственный экземпляр класса

    private static MySingletonClass instance;

    // делаем конструктор класса ПРИВАТНЫМ, чтобы пользователь
    // не смог создать экземпляр класса с помощью оператора new
    
    private MySingletonClass(String name) {
        this.name = name;
    }


    // с помощью ПУБЛИЧНОГО СТАТИЧЕСКОГО МЕТОДА МЫ получаем наш Единственный объект
    // add SYNCHRONIZED word to ALLOW ONLY ONE THREAD to execute at any given time
    public static synchronized MySingletonClass getInstance(String name) {
        
        // создаем впервые объект , если он еще не создан
        if (instance == null) {
            instance = new MySingletonClass(name);
        }
        // все остальные вызовы метода возвращают один и тот же объект!!!
        return instance;
    }

    private String name;

    public String getName() {
        return name;
    }


}


// ТЕСТИРУЕМ :

class Test {
    public static void main(String[] args) {
        MySingletonClass m1 = MySingletonClass.getInstance("Привет");
        MySingletonClass m2 = MySingletonClass.getInstance("Пока");


        // возвращает true при сравнении ссылок
        System.out.println(m1 == m2);

        //возвращает Привет для обоих объектов
        System.out.println(m1.getName());
        System.out.println(m2.getName());


    }
}
