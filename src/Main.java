//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //separate odd and even numbers
        List<Integer> numbers = Arrays.asList(2,3,55,67,32,4);
        Map<Boolean, List<Integer>> partitionNum = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(partitionNum.get(true));
        System.out.println(partitionNum.get(false));

        //Remove duplicate from list
        List<Integer> nums = Arrays.asList(22,3,6,6,7,3,5,7);
        List<Integer> distinctNums = nums.stream().distinct().toList();
        System.out.println(distinctNums);

        //Frequency of each character in a string
        String s = "ravitejaYadlapalli";
        Map<String, Long> freqChar = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqChar);

        //sort the list in reverse order
        List<Integer> reverseSorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverseSorted);

        //join the strings with prefix, suffix, delimitter
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        String prefix = "[";
        String suffix = "]";
        String delimiter = ", ";
        String result = strings.stream()
                .collect(Collectors.joining(delimiter, prefix, suffix));
        System.out.println(result);

        //print multiple of 5 from list
        List<Integer> multiples = numbers.stream().filter(i -> i % 5 == 0).toList();
        System.out.println(multiples);

        //Max and min in a list
        Integer maxNum = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxNum);
        Integer minNum = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(minNum);

        //merge two unsorted array to sorted array
        int[] a = {2,5,8,3};
        int[] b = {4,7,6,9};
        List<Integer> sortedList = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().toList();
        System.out.println(sortedList);

        //Sum of all digits of a number
        int numDigit = 23435;
        int sumNum = String.valueOf(numDigit).chars().map(Character::getNumericValue).sum();
        System.out.println(sumNum);

        //sort list of string in increasing order of their length
        List<String> alpha = Arrays.asList("ravi", "yadlapalli", "tejart","suresh");
        List<String> sortedStrings = alpha.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(sortedStrings);

        //common elements from two arrays
        List<Integer> a1 = Arrays.asList(1,2,5,7);
        List<Integer> b1 = Arrays.asList(3,12,5,7);
        List<Integer> commonEle = a1.stream().filter(b1::contains).toList();
        System.out.println(commonEle);

        //sum and average of all element in a array
        int[] a2 = {1,4,5,6};
        int sumOfA2 = Arrays.stream(a2).sum();
        System.out.println(sumOfA2);
        double avgDouble = Arrays.stream(a2).average().getAsDouble();
        System.out.println(avgDouble);

        //Reverse each word of a string
        String s1 = "ravi teja yadlapalli";
        String singleString = Arrays.stream(s1.split("")).map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(singleString);

        //Reverse an integer array
        int[] arr = {2,4,6,7,9};
        int[] revArray = IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length - i]).toArray();
        System.out.println(Arrays.toString(revArray));

        //sum of first 10 natural numbers
        int naturalSum = IntStream.rangeClosed(1, 11).sum();
        System.out.println(naturalSum);

        //find strings which starts with number
        List<String> numString = Arrays.asList("0erts","2teja", "yrt");
        List<String> numwithString = numString.stream().filter(i -> Character.isDigit(i.charAt(0))).toList();
        System.out.println(numwithString);

        //Last element in an array
        int asInt = Arrays.stream(arr).skip(arr.length - 1).findFirst().getAsInt();
        System.out.println(asInt);

        //find duplicates from an array
        List<Integer> dupliInt = Arrays.asList(22,4,4,5,6,5,8,1,1);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> setDupli = dupliInt.stream().filter(i -> !set1.add(i)).collect(Collectors.toSet());
        System.out.println(setDupli);

        List<Integer> list = dupliInt.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(list);


    }
}