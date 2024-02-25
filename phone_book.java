import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонов
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        // Входная структура с повторяющимися именами и разными телефонами
        String[][] input = {{"Иван", "123456"}, {"Петр", "654321"}, {"Иван", "987654"}};

        // Перебираем входную структуру и добавляем имена и телефоны в HashMap
        for (String[] contact : input) {
            String name = contact[0];
            String phone = contact[1];

            // Если имя уже есть в phoneBook, добавляем телефон в существующий список
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            }
            // В противном случае добавляем новую запись в phoneBook с именем и списком, содержащим только один телефон
            else {
                ArrayList<String> phoneList = new ArrayList<>();
                phoneList.add(phone);
                phoneBook.put(name, phoneList);
            }
        }

        // Создаем список, чтобы отсортировать его по убыванию числа телефонов
        ArrayList<Map.Entry<String, ArrayList<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedList, (a, b) -> b.getValue().size() - a.getValue().size());

        // Выводим результат
        for (Map.Entry<String, ArrayList<String>> entry : sortedList) {
            System.out.println("Имя: " + entry.getKey() + ", Телефоны: " + entry.getValue());
        }
    }
}
