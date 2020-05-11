import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "сапог сарай арбуз болт бокс биржа";
        String[] strArray = str.split("\\s");
        HashMap<Character, ArrayList<String>> map = method(strArray);
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).filter(characterArrayListEntry -> characterArrayListEntry.getValue().size() > 1).forEach(System.out::println);
    }
    static HashMap<Character, ArrayList<String>> method(String[] array) {
        HashMap<Character, ArrayList<String>> result = new HashMap<>();
        for (String str : array) {
            ArrayList<String> list = result.get(str.charAt(0));
            if (list != null) {
                list.add(str);
                list= list.stream().sorted((o1, o2) -> o1.length() != o2.length() ?-Integer.compare(o1.length(),o2.length()):o1.compareTo(o2)).collect(Collectors.toCollection(ArrayList::new));
                result.put(str.charAt(0), list);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                result.put(str.charAt(0), value);
            }
        }

        return result;


    }
}
