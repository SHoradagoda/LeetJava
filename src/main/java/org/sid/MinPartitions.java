package org.sid;

public class MinPartitions {
    public int minPartitions(String n) {
        int largestNumber = 0;
        for ( int i=0;i<n.length();i++) {
            int number = n.charAt(i) - '0';
            if ( number > largestNumber ) {
                largestNumber = number;
            }
        }
        return largestNumber;
    }

    public static void main(String[] args) {
        new MinPartitions().minPartitions("41");
    }
}
