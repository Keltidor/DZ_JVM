package DZ_JVM;

// Подгрузка классов через ClassLoader. Подргужаем  JvmComprehension, Integer, Object, String, System.
public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 Stack Memory. Создается фрейм
        Object o = new Object();        // 2 Stack Memory + heap. Объект в heap, ссылка на объект в SM
        Integer ii = 2;                 // 3 Stack Memory + heap. Объект в heap, ссылка на объект в SM
        printAll(o, i, ii);             // 4 Происходит создание фрейма в SM для функции printAll и далее начинается его заполнение.
        System.out.println("finished"); // 7  Строка "finished" сохранится в heap в String Pool и будет удалена из памяти,
        // при последующей работе сборщиком мусора
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 Stack Memory + heap. Объект в heap, ссылка на объект в SM
        System.out.println(o.toString() + i + ii);  // 6 Создается новый фрейм в SM под вызов println.
        // Перед этим будет создана строка в String Pool.
        // Так как не будет ссылок на этот объект, то сборщик мусора удалит его из памяти

    }
}

