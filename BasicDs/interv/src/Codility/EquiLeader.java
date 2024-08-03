package Codility;

public class EquiLeader {
    /*  If the leader is contained in more than n/2 elements,
        we can remove pairs of different elements from the array
        and the leader will be left in the array. I.e. in worst case
        the leader element will pair with each of other elements and
        only one leader element will be left behind.
        We could use a stack structure to keep the elements are left
        behind, but since we know that in this stack all the elements
        will be the same value (candidate for the leader), we don't
        actually need to create a stack, we just keep the value of
        the candidate for the leader and number of theese elements in
        our stack.
        With the second iteration through the array we count number
        of occurences of our left behind value
        With the 3rd iteration we count number of leader element as
        we go through, it will be number of leaders in the left part
        and total leaders minus right side leaders will be left side
        leaders. For a equi leader each side number of leaders should
        be greater than i/2 or (n-i)/2 accordingly.	*/
    public static int solution(int[] A){
        int size = 0, n = A.length, value =0;
        for(int i =0; i<n; i++){
            if(size == 0){
                size++;
                value = A[i];
            }else {
                size+= (value == A[i]) ? 1 : -1;
            }
        }
        if(size<0){
            return 0;
        }
        int counter =0, leader = 0;
        for(int i =0; i< n; i++){
            if(value == A[i]){
                counter++;
            }
        }
        if(n-counter>= counter){
            return 0;
        }else{
            leader = value;
        }
        int leaderInLeftPart =0, result =0;
        for(int i =0; i< n; i++){
            if(A[i] == leader){
                leaderInLeftPart++;
            }
            int leaderInRightPart = counter-leaderInLeftPart;
            if(leaderInLeftPart > (i+1)/2 && leaderInRightPart > (n-(i+1))/2){
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] A = {4,3,4,4,4,2};
        System.out.println(solution(A));
    }
}
