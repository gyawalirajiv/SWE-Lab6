package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class MyStudentRecordsMgmtApp
{
    public static void main( String[] args )
    {
        List<Student> list = new ArrayList<>();
        list.add(new Student(110001L, "Dave", LocalDate.of(1951, 11, 18)));
        list.add(new Student(110002L, "Anna", LocalDate.of(1990, 12, 7)));
        list.add(new Student(110003L, "Erica", LocalDate.of(1974, 1, 31)));
        list.add(new Student(110004L, "Carlos", LocalDate.of(2009, 8, 22)));
        list.add(new Student(110005L, "Bob", LocalDate.of(1990, 3, 5)));

        list.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).forEach(s -> System.out.println(s));

        System.out.println("=========");
        getListOfPlatinumAlumniStudents(list).stream().forEach(System.out::println);

        System.out.println("===========");
        printHelloWorld(new int[]{35, 10, 14});

        System.out.println("===========");
        System.out.println(findSecondBiggest(new int[]{7, 6, 9, 4 , 3 , 14}));
    }

    public static List<Student> getListOfPlatinumAlumniStudents(List<Student> list){
        return list.stream()
                .filter(s -> s.getDateOfAdmission().isBefore(LocalDate.now().minus(30, ChronoUnit.YEARS)))
                .sorted((s1, s2) -> s1.getDateOfAdmission().compareTo(s2.getDateOfAdmission()))
                .collect(Collectors.toList());
    }

    public static void printHelloWorld(int[] nums){
        for(int i: nums){
            if(i % 5 == 0 && i % 7 == 0) System.out.println("HelloWorld");
            else if(i % 5 == 0) System.out.println("Hello");
            else if(i % 7 == 0) System.out.println("World");
        }
    }

    public static int findSecondBiggest(int[] nums){
        if(nums.length < 2) return -1;

        int first;
        int second;
        if(nums[0] > nums[1]){
            first = nums[0];
            second = nums[1];
        } else {
            first = nums[1];
            second = nums[0];
        }
        for (int i = 2; i < nums.length; i++){
            int num = nums[i];
            if(num > first){
                second = first;
                first = num;
            } else if(num > second){
                second = num;
            }
        }
        return second;
    }
}
