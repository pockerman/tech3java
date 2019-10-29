package applications.algorithms;

import java.util.ArrayList;

/**
  *Category: Algorithms
  *ID: FindMinimumTwoSortedSubArrays
  *Description: Find the minimum element between two increasingly sorted sub-arrays
  *            comming from a rotation of the main array
  *Taken From: Code from the book: Coding Interviews: Questions, Analysis & Solutions
  *
  *Details:
  *
  *The algorithm utilizes two pointers P1 and P2
  *
  *P1->first element in the array
  *P2->last element in the array
  *
  *Compare then the number in the middle with the numbers pointed to by P1 and P2:
  *
  *- if the middle number is in the first increasingly sorted sub-array it is greater
  *than or equal to the number pointed to by P1
  *Thus, the minimal number is behind the middle number in the array. Hence we should move P1 to the middle and continue to
  *search numbers between P1 and P2 recursively.
  *
  *- If the middle number is in the second sub-array, it is less than or equal to the number pointed to by P2
  *The minimal number is before the middle number in the array in such cases so it moves P2 to the middle.
  *We continue to search recursively because P1 points to a number in the first sub-array and P2 points to a number in the
  *second sub-array
  *
  *
  *No matter if it moves P1 or P2 for the next round of search, half of the array is excluded. It stops
  *searching when P1 points to the last number of the first sub-array and P2 points to the first number of the
  *second sub-array, which is also the minimum of the array.
*/

public class FindMinimumTwoSortedSubArrays {

    public static Integer findMin(ArrayList<Integer> data){

        Integer p1 = 0;
        Integer p2 = data.size()-1;
        Integer idx_middle = p1;

        while(data.get(p1) >= data.get(p2)) {
            if (p2 - p1 == 1) {
                idx_middle = p2;
                break;
            }

            idx_middle = (p1 + p2) / 2;

            if((data.get(p1) == data.get(p2)) && (data.get(idx_middle) == data.get(idx_middle))) {

                System.out.println("\tCannot find minimum sequential scan is needed");
                idx_middle = null;
                break;

            }

            if(data.get(idx_middle) >= data.get(p1)) {
                p1 = idx_middle;
            }
            else if(data.get(idx_middle) <= data.get(p2)) {
                p2 = idx_middle;
            }
        }

        if(idx_middle != null) {
            return data.get(idx_middle);
        }

        return null;

    }

    public static  void main(String[] args){

        FindMinimumTwoSortedSubArrays obj = new FindMinimumTwoSortedSubArrays();
        System.out.println("Running Example algorithms/"+obj.getClass().getName());
        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(1);
        data.add(2);

        Integer rslt = FindMinimumTwoSortedSubArrays.findMin(data);

        if (rslt != null){
            System.out.println("Min element is " + rslt);
        }
    }
}
